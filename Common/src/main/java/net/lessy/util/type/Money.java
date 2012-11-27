package net.lessy.util.type;

import java.math.BigDecimal;

/**
 * Wrappes an amount to represent a money amount
 * @author Hans Lesmeister
 */
public class Money extends Amount<Money>
{
   private static final int DECIMAL_PLACES = 2;

   protected Money(BigDecimal value, int decimalPlaces)
   {
      super(value, decimalPlaces);
   }

   public Money(BigDecimal amount)
   {
      super(amount, DECIMAL_PLACES);
   }

   public Money(double amount)
   {
      super(new BigDecimal(amount), DECIMAL_PLACES);
   }

   public Money(String amount)
   {
      super(new BigDecimal(amount), DECIMAL_PLACES);
   }

//   public Money createInstance(BigDecimal amount)
//   {
//      return new Money(amount);
//   }
}