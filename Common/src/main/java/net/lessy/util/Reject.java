package net.lessy.util;

/**
 * Checks for several purposes like parameters for methods etc.
 *
 * @author Hans Lesmeister
 */
public class Reject
{

   /**
    * Throws an IllegalStateException if the passed expression is true
    * @param expression to evaluate
    * @param msg The message to pass on to the exception
    */
   public static void ifTrue(boolean expression, String msg) {
      if (expression) {
         throw new IllegalStateException(msg);
      }
   }

   /**
    * Throws an IllegalArgumentException if the passed object is null
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
