package net.lessy.util.format;

import java.util.Properties;
import java.util.Locale;

/**
 * Implement this interface to create custom formatters. Formatters can be registered with a unique name and can
 * be used directly for formatting values or can be used in a JSP-Page with tags supporting the format attribute.
 *
 * @author hl
 */
public interface FormatIF<T> {

   /**
    * Formats the passed value and returns the result as a string
    * @param pValue Value to be formatted
    * @param pLocale Locale which can eventually be used by the formatter
    * @param pProps Additional properties wich the formatter might need. This depends to the implementation
    *
    * @return A formatted string or null if the value could not be formatted
    */
   public String format(T pValue, Locale pLocale, Properties pProps);

}
