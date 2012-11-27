package net.lessy.util.type;

import java.math.BigDecimal;

/**
 * Represents a Precentage
 * @author Hans Lesmeister
 */
public class Percentage extends Amount<Percentage>
{
   private static final int DECIMAL_PLACES = 2;

   public Percentage(String value)
   {
      super(new BigDecimal(value), DECIMAL_PLACES);
   }

   public Percentage(double value)
   {
      super(new BigDecimal(value), DECIMAL_PLACES);
   }

   public Percentage(BigDecimal amount)
   {
      super(amount, DECIMAL_PLACES);
   }

//   public Percentage createInstance(BigDecimal amount)
//   {
//      return new Percentage(amount);
//   }
}
