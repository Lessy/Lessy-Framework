package net.lessy.util;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * @author Hans Lesmeister
 */
public class RejectTest {

   @Test
   public void testIfNullIfNotNull() throws Exception {
      Reject.ifNull("Test", "Msg");
   }

   @Test
   public void testIfNullIfNull() throws Exception {
      try {
         Reject.ifNull(null, "Msg");
      }
      catch (IllegalArgumentException e) {
         assertEquals("Msg", e.getMessage());
      }
   }

   @Test
   public void testIfNullIfNullAndMsgIsNull() throws Exception {
      try {
         Reject.ifNull(null, null);
      }
      catch (IllegalArgumentException e) {
         assertEquals(null, e.getMessage());
      }
   }
}
