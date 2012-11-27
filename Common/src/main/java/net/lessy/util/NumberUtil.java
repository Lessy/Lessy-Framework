package net.lessy.util;

import java.math.BigDecimal;

import net.lessy.util.type.Amount;

/**
 * @author Hans Lesmeister
 */
public class NumberUtil {

   /**
    * Converts a Number to (big) Long
    * @param number Nmber to convert
    * @return The Long-Value or null if number is null
    */
   public static Long convertToLong(Number number) {
      if (number == null) {
         return null;
      }

      if (number instanceof Long) {
         return (Long) number;
      }
      else {
         return Long.valueOf(number.longValue());
      }
   };

   /**
    * Converts a (big) Integer to a small int. If the value is null then the defaultvalue is
    * returned
    * @param value The Integer to convert
    * @param defaultValue Return if value is null
    * @return int-Value
    */
   public static int convertToInt(Integer value, int defaultValue) {
      if (value == null) {
         return defaultValue;
      }
      else {
         return value.intValue();
      }
   }

   /**
    * Converts an Amount to its associated Number (usually a BigDecimal)
    * @param amount Amount to convert
    * @return Number-Representation or null if the passed amount is null
    */
   public static Number convertToNumber(Amount amount) {
      return convertToNumber(amount, null);
   }

   /**
    * Converts an Amount to its associated Number (usually a BigDecimal)
    * @param amount Amount to convert
    * @param defaultValue Value to return if the passed amount is null
    * @return Number-Representation or the defaultValue if the passed amount is null
    */
   public static Number convertToNumber(Amount amount, Number defaultValue) {
      if (amount == null) {
         return defaultValue;
      }
      else {
         return amount.getValue();
      }
   }

   /**
    * Checks if the passed value is a number
    *
    * @param value Value to be tested. Can be any type. Tested will be the toString()-result.
    * @return BigInteger if the value is a number, otherwise null (An Exception is never thrown)
    */
   public static BigDecimal checkNumber(Object value) {
      // Try to make it a string first
      String sval = StringUtil.objectToString(value);

      // If the resulting string is empty then it contains no number
      if (StringUtil.isEmpty(sval)) {
         return null;
      }

      // Try to make a Number out of it
      try {
         // Decimal Comma is replaced by decimal dot so something like 123,34 will work and 123.34 will work as well
         return new BigDecimal(sval.trim().replace(',', '.'));
      }
      catch (Exception e) {
         return null;
      }
   }
}
