package net.lessy.util;

import java.lang.reflect.InvocationTargetException;

import net.lessy.util.exception.TechnicalException;
import org.apache.commons.beanutils.PropertyUtils;

/**
 * @author Hans Lesmeister
 */
public class BeanUtil
{

   private BeanUtil() {
   }

   /**
    * Wrapper around Spring's BeanUtils.copyProperties();
    *
    * @param source
    * @param target
    */
   public static void copyProperties(Object source, Object target) {
      try {
         PropertyUtils.copyProperties(target, source);
      }
      catch (IllegalAccessException e) {
         throw new TechnicalException(e);
      }
      catch (InvocationTargetException e) {
         throw new TechnicalException(e);
      }
      catch (NoSuchMethodException e) {
         throw new TechnicalException(e);
      }
   }
}
