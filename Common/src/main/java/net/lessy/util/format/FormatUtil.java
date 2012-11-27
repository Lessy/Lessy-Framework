package net.lessy.util.format;

import java.util.Hashtable;
import java.util.Locale;
import java.util.Properties;

import net.lessy.util.StringUtil;
import net.lessy.util.format.impl.FormatCurrency;
import net.lessy.util.format.impl.FormatDate;
import net.lessy.util.format.impl.FormatFloat;
import net.lessy.util.format.impl.FormatTime;

/**
 * Helper class around custom formatting of a value. Basic formatters for float, currency and date are pre-registered.
 * Custom formatters can be registered as additionally or the default formatters can be overwritten.
 *
 * @author hl
 */
public class FormatUtil {

   /** Constant for the float-formatter */
   public static final String FLOAT    = "float";

   /** Constant for the currency-formatter */
   public static final String CURRENCY = "currency";

   /** Constant for the date-formatter */
   public static final String DATE     = "date";

   /** Constant for the time-formatter */
   public static final String TIME     = "time";

   /** Holds a list of registered formatters */
   private static Hashtable<String, FormatIF> aFormatter = createFormatterList();

   /**
    * Wrapper method for formatting a value.
    *
    * @param pValue Value to be formatted
    * @param pFormat Name of the formatter to be used to format the value
    * @param pDefault If the passed value is null, then this is used as the value to format
    * @param pLocale Locale to be passed to the formatter
    * @param pProps Properties to be passed to the formatter (properties implementation dependant)
    *
    * @return The formatted value or null if the value could not be formatted
    */
   public static String format(Object pValue, String pFormat, Object pDefault, Locale pLocale, Properties pProps) {

      String   tRet = null;
      FormatIF tFormatter;

      if (pValue == null)
         pValue = pDefault;

      if (pValue != null) {
         tFormatter = getFormatter(pFormat);

         if (tFormatter != null) {
            tRet = tFormatter.format(pValue, pLocale, pProps);
         }
      }

      if (tRet == null)
         tRet = StringUtil.objectToString(pValue);

      return tRet;
   }

   /**
    * Gets a registered formatter.
    * @param pFormat Name of the formatter
    * @return Instance of the registered formatter
    */
   private static FormatIF getFormatter(String pFormat) {

      FormatIF tRet = null;

      if (pFormat != null)
         tRet = aFormatter.get(pFormat);

      return tRet;
   }

   /**
    * Creates initial formatter list with all predefined formatters already registered. Used internally.
    * @return List of registered formatters
    */
   private static Hashtable<String, FormatIF> createFormatterList() {

      Hashtable<String, FormatIF> tRet = new Hashtable<String, FormatIF>();

      tRet.put(FLOAT, new FormatFloat());
      tRet.put(CURRENCY, new FormatCurrency());
      tRet.put(DATE, new FormatDate());
      tRet.put(TIME, new FormatTime());

      return tRet;
   }

   /**
    * Registers  a new formatter.
    * @param pName Name of the formatter. With this name, the formatter is retrieved on use. If a formatter was already
    *    registered with this name, then it will be overwritten.
    * @param pFormatter Instance of the formatter
    */
   public static synchronized void addFormatter(String pName, FormatIF pFormatter) {

      if ((pName != null) && (pFormatter != null)) {
         aFormatter.put(pName, pFormatter);
      }
   }
}
