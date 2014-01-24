package net.lessy.common.util;

/**
 * Utilities around Objects
 * @deprecated This is only a wrapper for backward compatibilty. This class has been moved to net.lessy.util
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
      return net.lessy.util.ObjectUtil.secureEquals(a, b);
   }
}
