package net.lessy.util.format.impl;

/**
 * Implementation of a currency formatter. The values are formatted with interpunctuation (thousands-separator) and with exactly
 * 2 decimal digits.
 *
 * @author hl
 */
public class FormatCurrency extends FormatFloat {

   /**
    * Returns the minimal number of decimal places (two)
    */
   protected int getMinDecimals() {

      return 2;
   }

   /**
    * Returns the maximal number of decimal places (two)
    */
   protected int getMaxDecimals() {

      return 2;
   }
}
