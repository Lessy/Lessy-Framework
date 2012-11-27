package net.lessy.util;

/**
 * Checks for several purposes like parameters for methods etc.
 *
 * @author Hans Lesmeister
 */
public class Reject
{

   /**
    * Throws an exception if the passed object is null
    * @param object parameter to check
    * @param message The message to pass on to the exception
    * @throws IllegalArgumentException if the passed object is null
    */
   public static void ifNull(Object object, String message) {
      if (object == null) {
         throw new IllegalArgumentException(message);
      }
   }
}
