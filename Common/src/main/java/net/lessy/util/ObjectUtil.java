package net.lessy.util;

/**
 * Utilities around Objects
 * @author Hans Lesmeister
 */
public class ObjectUtil {
   /**
    * Compares 2 Objects on equality, but with null-safety
    *
    * @param  a  1. Object (can be null)
    * @param  b  2. Object (can be null)
    * @return  if both object are null then true, else a normal equals is performed (of course on a non-null object)
    */
   public static final boolean secureEquals(Object a, Object b)
   {
       if ((a != null) && (b != null))
       {
           return a.equals(b);   // Standard equals if both are non-null
       }

       if ((a == null) && (b == null))
       {
           return true;   // They are equal if both are null
       }

       return false;   // if just one is null then they never equals
   }
}
