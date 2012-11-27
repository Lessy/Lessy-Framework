package net.lessy.util;

/**
 * All kind of String-Utility Methods
 * @author Hans Lesmeister
 */
public class StringUtil {

   /**
    * Trim with respect of Nullpointer
    * @param value The value to be trimmed
    * @return Trimmed String or null if the passed String was null
    */
   public static String trim(String value) {
      return (value == null) ? null : value.trim();
   }

   /**
    * Concats an array of objects
    * @param objects Objects
    * @return Concatenated
    */
   public static StringBuilder concatenate(Object... objects) {
      StringBuilder b = new StringBuilder();

      for (Object object : objects) {
         b.append(object);
      }

      return b;
   }

   /**
    * Concats 2 objects with an optional separator. Sep. is only inserted if objects are both not null
    * @sep Separator, space if null
    * @return Concatenated string
    */
   public static String concatenateNotEmpty(String sep, String s1, String s2) {
      if (sep == null) {
         sep = " ";
      }
      StringBuilder b = new StringBuilder();

      s1 = trim(s1);
      s2 = trim(s2);

      if (s1 != null) {
         b.append(s1);
      }

      if ((s1 != null) && (s2 != null)) {
         b.append(sep);
      }

      if (s2 != null) {
         b.append(s2);
      }

      return b.toString();
   }

   /**
    * Concats 2 objects separated by a space. Sep. is only inserted if objects are both not null
    * @return Concatenated string
    */
   public static String concatenateNotEmpty(String s1, String s2) {
      return concatenateNotEmpty(null, s1, s2);
   }


   /**
    * Prueft ob uebergebene Zeichenkette null oder ist bzw nur aus white spaces
    * besteht.
    * @return true, wenn Zeichenkette aus mindestens einem nocn-white-space Zeichen
    *               besteht, ansonsten false
    */
   public static boolean isEmpty(String s) {
      return ((s == null) || (s.trim().length() == 0));
   }

   /**
    * Gets the toString-Version of the passed object or null if the object is null
    * @param obj Object
    * @return String-Representation or null
    */
   public static String objectToString(Object obj) {
      return objectToString(obj, null);
   }

   /**
    * Gets the toString-Version of the passed object or the passed default if the object is null
    * @param obj Object
    * @param defValue To be returned if obj is null
    * @return String-Representation or defValue
    */
   public static String objectToString(Object obj, String defValue) {
      if (obj == null) {
         return defValue;
      }

      return obj.toString();
   }

   /**
    * Converts a String to the Format "Xxxxxx".
    */
   public static String toUpperLower(String value) {

      String tRet = null;

      if (value == null) {
         return null;
      }

      if (value.length() == 0) {
         return "";
      }

      if (value.length() == 1) {
         return value.toUpperCase();
      }

      return concatenate(
              value.substring(0, 1).toUpperCase(),
              value.substring(1).toLowerCase()).toString();
   }
}
