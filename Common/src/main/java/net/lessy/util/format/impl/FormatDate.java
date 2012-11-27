package net.lessy.util.format.impl;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;

import net.lessy.util.format.FormatIF;

/**
 * Implementation of a date formatter.
 *
 * @author hl
 */
public class FormatDate implements FormatIF<Date> {

   /**
    * Formats the value as a date. In this version the format is always the short german format dd.mm.yyyy
    * TODO use locale
    *
    * @param value Value to be formatted. This can be any type as long toString() delivers a date formattable value
    * @param locale Locale to be used. If null then the default locale is used (Ignored in this version)
    * @param properties Not used in this formatter.
    * @return A Formatted date
    */
   public String format(Date value, Locale locale, Properties properties) {

      if (value == null) {
         return null;
      }

      if (locale == null) {
         locale = Locale.getDefault();
      }

      DateFormat df = getDateFormatter(locale);

      if (df == null) {
         return null;
      }

      return df.format(value);
   }

   /**
    * Gets a dateformatter. This method can be overwritten by other formatters to format the date
    * in another way.
    * @param locale Locale to be used
    * @return a DateFormatter.
    */
   public DateFormat getDateFormatter(Locale locale) {
      return DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
   }
}
