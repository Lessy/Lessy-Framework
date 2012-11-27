package net.lessy.util.format.impl;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Properties;

import net.lessy.util.NumberUtil;
import net.lessy.util.StringUtil;
import net.lessy.util.format.FormatIF;

/**
 * Implementation of a float formatter. The values are formatted with interpunctuation (thousands-separator) and with a maximum
 * of 2 decimal digits.
 *
 * @author hl
 */
public class FormatFloat implements FormatIF {

   /**
    * Formats the value (impl.method)
    * @param pValue Value to be formatted. This can be any type as long toString() delivers a float formattable value
    * @param locale Locale to be used. If null then the default locale is used
    * @param pProps Not used in this formatter.
    * @return A Formatted float string
    */
   public String format(Object pValue, Locale locale, Properties pProps) {

      BigDecimal tNumD = NumberUtil.checkNumber(StringUtil.objectToString(pValue));

      if (tNumD == null) {
         return null;
      }

      float tNum = tNumD.floatValue();

      if (locale == null) {
         locale = Locale.getDefault();
      }

      NumberFormat nf = NumberFormat.getNumberInstance(locale);
      nf.setMaximumFractionDigits(getMaxDecimals());
      nf.setMinimumFractionDigits(getMinDecimals());
      nf.setGroupingUsed(true);

      return nf.format(tNum);
   }

   /**
    * Returns the minimal number of decimal places (zero)
    */
   protected int getMinDecimals() {
      return 0;
   }

   /**
    * Returns the maximal number of decimal places (two)
    */
   protected int getMaxDecimals() {
      return 2;
   }
}
