package net.lessy.util;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Hans Lesmeister
 */
public class StreamUtil {

   public static void close(Closeable closable) {
      if (closable == null) {
         return;
      }

      try {
         closable.close();
      }
      catch (IOException ignore) {
         //
      }
   }

   public static InputStream createInputStream(Object object, String name) {
      if ((object == null) || (StringUtil.isEmpty(name))) {
         return null;
      }

      return object.getClass().getResourceAsStream(name);
   }
}
