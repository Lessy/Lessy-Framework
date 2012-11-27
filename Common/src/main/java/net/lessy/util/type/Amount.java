package net.lessy.util.type;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * General class to represent a number. Internally a BigDecimal is used.
 * @author Hans Lesmeister
 */
public abstract class Amount<T extends Amount<T>> implements Serializable
{
   private BigDecimal value;

   protected Amount(BigDecimal value, int decimalPlaces)
   {
      if (decimalPlaces < 0) {
         decimalPlaces = 0;
      }

      if (value == null) {
         value = new BigDecimal(0);
      }

      this.value = value;
      this.value = value.setScale(decimalPlaces, RoundingMode.HALF_UP);
   }

   protected Amount(BigDecimal value)
   {
      this(value, 0);
   }

   public BigDecimal getValue()
   {
      return value;
   }

   /**
    * Subtract an amount from this Amount
    * @see java.math.BigDecimal#subtract(java.math.BigDecimal)
    * @param amount Amount to subtract. If null, zero is subtracted
    * @return The new amount
    */
   public T subtract(Amount<T> amount) {

      BigDecimal newValue = value;

      if (amount != null) {
         newValue = value.subtract(amount.getValue());
      }

      return createInstance(newValue);
   }

   /**
    * Add an amount to this Amount
    * @see java.math.BigDecimal#add(java.math.BigDecimal)
    * @param amount Amount to add. If null, zero is added
    * @return The new amount
    */
   public T add(Amount<T> amount)
   {
      BigDecimal newValue = value;

      if (amount != null) {
         newValue = value.add(amount.getValue());
      }

      return createInstance(newValue);
   }


   public T divideBy(Amount<T> amount)
   {
      BigDecimal newValue = value;

      if (amount != null) {
         newValue = value.divide(amount.getValue(), getValue().scale(), BigDecimal.ROUND_HALF_UP);
      }

      return createInstance(newValue);
   }

   public T divideBy(int amount)
   {
      return divideBy(createInstance(new BigDecimal(amount)));
   }

   public T multiplyWith(Amount<T> amount)
   {
      BigDecimal newValue = value;

      if (amount != null) {
         newValue = value.multiply(amount.getValue());
      }

      return createInstance(newValue);
   }

   @SuppressWarnings({"unchecked", "rawtypes"})
   public final T createInstance(BigDecimal amount) {
      try {

         Constructor c = this.getClass().getConstructor(BigDecimal.class);
         T result = (T) c.newInstance(amount);
         return result;
      }
      catch (InstantiationException e) {
         throw new RuntimeException(e);
      }
      catch (IllegalAccessException e) {
         throw new RuntimeException(e);
      }
      catch (NoSuchMethodException e) {
         throw new RuntimeException(e);
      }
      catch (InvocationTargetException e) {
         throw new RuntimeException(e);
      }
   }

   @SuppressWarnings("unchecked")
   public boolean equals(Object o)
   {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }

      Amount<T> amount = (Amount<T>) o;

      return value.equals(amount.value);
   }

   public int hashCode()
   {
      return value.hashCode();
   }

   @Override
   public String toString()
   {
      return value.toString();
   }
}
