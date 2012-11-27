package net.lessy.util.type;

import java.math.BigDecimal;

/**
 * Represents a Quantity amount
 * @author Hans Lesmeister
 */
public class Quantity extends Amount<Quantity>
{
   private static final int DECIMAL_PLACES = 2;

   public Quantity()
   {
      super(null, DECIMAL_PLACES);
   }

   public Quantity(String value)
   {
      super(new BigDecimal(value), DECIMAL_PLACES);
   }

   public Quantity(double value)
   {
      super(new BigDecimal(value), DECIMAL_PLACES);
   }

   public Quantity(BigDecimal amount)
   {
      super(amount, DECIMAL_PLACES);
   }

//   public Quantity createInstance(BigDecimal amount)
//   {
//      return new Quantity(amount);
//   }
}
