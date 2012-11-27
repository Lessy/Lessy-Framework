package net.lessy.util.type;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * @author Hans Lesmeister
 */
public class AmountTest
{
   @Test
   public void testAmountCreateInstance() throws Exception {

      BigDecimal value = new BigDecimal("1.23");
      Quantity qty = new Quantity(value);
      Quantity sub = new Quantity("0.11");
      Quantity result = qty.subtract(sub);

      assertEquals(new Quantity("1.12"), result);
      assertEquals(new BigDecimal("1.12"), result.getValue());

   }
}
