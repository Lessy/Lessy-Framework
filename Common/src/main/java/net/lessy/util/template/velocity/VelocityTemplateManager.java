package net.lessy.util.template.velocity;

import java.io.Writer;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import net.lessy.util.Constants;
import net.lessy.util.exception.TechnicalException;
import net.lessy.util.template.TemplateContext;
import net.lessy.util.template.TemplateManager;

/**
 * Velocity-Implementation of a Template-Manager
 * @author Hans Lesmeister
 */
public class VelocityTemplateManager implements TemplateManager
{
   private VelocityEngine velocityEngine;
   private String templatePrefix;
   private String templatePostfix;

   /**
    * {@inheritDoc}
    */
   public void process(String templateName, String encoding, TemplateContext context, Writer output)
   {
      try {
         VelocityContext velocityContext;
         if (context instanceof VelocityContext) {
            velocityContext = (VelocityContext) context;
         }
         else {
            velocityContext = createContextFromTemplateContext(context);
         }

         templateName = composeTemplateName(templateName);

         if (encoding == null) {
            velocityEngine.mergeTemplate(templateName, Constants.ENC_UTF8, velocityContext, output);
         }
         else {
            velocityEngine.mergeTemplate(templateName, encoding, velocityContext, output);
         }
      }
      catch (Exception e) {
         throw new TechnicalException(e);
      }
   }

   private String composeTemplateName(String templateName)
   {
      StringBuilder b = new StringBuilder();

      if (templatePrefix != null) {
         b.append(templatePrefix);

         if (!templatePrefix.endsWith("/")) {
            b.append("/");
         }
      }

      b.append(templateName);

      if (templatePostfix != null) {
         b.append(templatePostfix);
      }

      return b.toString();
   }

   /**
    * Moves the contents of the passed in Context to a new VelocityContext.
    * @param context
    * @return Velocity-Context
    */
   private VelocityContext createContextFromTemplateContext(TemplateContext context)
   {
      VelocityContext ret = new VelocityContext();

      if (context != null) {
         for (Object o : context.getKeys()) {
            String key = (String) o;
            ret.put(key, context.get(key));
         }
      }

      return ret;
   }

   /**
    * {@inheritDoc}
    */
   public TemplateContext createContext()
   {
      return new VelocityTemplateContext();
   }

   public void setVelocityEngine(VelocityEngine velocityEngine)
   {
      this.velocityEngine = velocityEngine;
   }

   public void setTemplatePostfix(String templatePostfix)
   {
      this.templatePostfix = templatePostfix;
   }

   public void setTemplatePrefix(String templatePrefix)
   {
      this.templatePrefix = templatePrefix;
   }
}
