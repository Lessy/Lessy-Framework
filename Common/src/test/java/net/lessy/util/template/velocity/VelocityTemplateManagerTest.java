package net.lessy.util.template.velocity;

import java.io.StringWriter;
import java.io.Writer;
import java.util.Properties;

import junit.framework.TestCase;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.lessy.util.template.TemplateContext;
import net.lessy.util.template.TemplateManager;

/**
 * @author Hans Lesmeister
 */
public class VelocityTemplateManagerTest extends TestCase
{
   public void testTemplate() throws Exception
   {

      Properties props = new Properties();
      props.setProperty("resource.loader", "class");
      props.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");

      VelocityEngine engine = new VelocityEngine(props);
//      engine.init(props);

      VelocityTemplateManager velocityTemplateManager = new VelocityTemplateManager();
      velocityTemplateManager.setVelocityEngine(engine);

      // Use Interface
      TemplateContext context = velocityTemplateManager.createContext();

      context.put("name", "Hans");
      Writer output = new StringWriter();
      velocityTemplateManager.process("net/lessy/util/template/velocity/testTemplate.vm", null, context, output);
      assertEquals("Hi, Hans", output.toString());
   }

   public void testTemplateSpring() {
      ApplicationContext springContext = new ClassPathXmlApplicationContext("net/lessy/util/template/velocity/velocitySpring.xml");
      TemplateManager templateManager = (TemplateManager) springContext.getBean("templateManager");
      assertNotNull(templateManager);
      TemplateContext context = templateManager.createContext();
      context.put("name", "Hans");
      Writer output = new StringWriter();
      templateManager.process("net/lessy/util/template/velocity/testTemplate.vm", null, context, output);
      assertEquals("Hi, Hans", output.toString());
   }

}
