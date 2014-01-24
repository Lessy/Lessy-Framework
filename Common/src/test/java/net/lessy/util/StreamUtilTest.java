package net.lessy.util;

import java.io.InputStream;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 * @author Hans Lesmeister
 */
public class StreamUtilTest {

   @Test
   public void testCreateInputStream() throws Exception {
      InputStream in = StreamUtil.createInputStream(this, "test.txt");
      assertNotNull(in);
      StreamUtil.close(in);
   }
}
