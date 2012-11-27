package net.lessy.util;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import net.lessy.util.type.Money;

/**
 * @author Hans Lesmeister
 */
public class NumberUtilTest {

   @Test
   public void testConvertToLong() {
      Number n = new Integer(5);
      assertEquals(new Long(5), NumberUtil.convertToLong(n));
      Long l = new Long(5);
      assertEquals(new Long(5), NumberUtil.convertToLong(l));
      assertEquals(null, NumberUtil.convertToLong(null));
   }


   @Test
   public void testConvertToInt() {
      assertEquals(-1, NumberUtil.convertToInt(null, -1));
      assertEquals(0, NumberUtil.convertToInt(null, 0));
      assertEquals(0, NumberUtil.convertToInt(new Integer(0), -1));
      assertEquals(20, NumberUtil.convertToInt(new Integer(20), 21));
   }

   @Test
   public void testConvertToNumber() {
      Money m = new Money(50.25);
      Number n = NumberUtil.convertToNumber(m);
      assertEquals(n, m.getValue());
   }
}
