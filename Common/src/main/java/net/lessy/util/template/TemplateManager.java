package net.lessy.util.template;

import java.io.Writer;

/**
 * @author Hans Lesmeister
 */
public interface TemplateManager
{

   /**
    * Processes a template and writes the result to the Writer
    * @param templateName Name of the Template.
    * @param encoding Encoding
    * @param context that contains all data needed to process the Template
    * @param output Output to receive the result of the Template-Processing
    */
   void process(String templateName, String encoding, TemplateContext context, Writer output);

   /**
    * Create a Context that suits the Manager-Implementation.
    * @return Instance of a context
    */
   TemplateContext createContext();
}
