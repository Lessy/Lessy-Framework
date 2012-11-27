package net.lessy.util.type;

import java.math.BigDecimal;

/**
 * Wrappes an amount to represent a money amount with 4 decimal digits
 * @author Hans Lesmeister
 */
public class Money4 extends Money
{
   private static final int DECIMAL_PLACES = 4;

   public Money4()
   {
      super(null, DECIMAL_PLACES);
   }

   public Money4(String value)
   {
      super(new BigDecimal(value), DECIMAL_PLACES);
   }

   public Money4(double value)
   {
      super(new BigDecimal(value), DECIMAL_PLACES);
   }

   public Money4(BigDecimal amount)
   {
      super(amount, DECIMAL_PLACES);
   }

//   public Money4 createInstance(BigDecimal amount)
//   {
//      return new Money4(amount);
//   }
}