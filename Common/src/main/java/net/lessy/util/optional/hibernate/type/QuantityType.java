package net.lessy.util.optional.hibernate.type;

import org.hibernate.HibernateException;

import net.lessy.util.type.Quantity;

/**
 * @author Hans Lesmeister
 */
public class QuantityType extends AbstractAmountType
{
   public Class getReturnedClass()
   {
      return Quantity.class;
   }

   public String getName()
   {
      return "quantity";
   }

//   public Object get(ResultSet rs, String name) throws HibernateException, SQLException
//   {
//      return null;
//   }

   public Object fromStringValue(String xml) throws HibernateException
   {
      return new Quantity(xml);
   }
}