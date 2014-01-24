package net.lessy.util.optional.hibernate.type;

import org.hibernate.HibernateException;

import net.lessy.util.type.Money;

/**
 * @author Hans Lesmeister
 */
public class MoneyType extends AbstractAmountType
{
   public Object fromStringValue(String xml) throws HibernateException
   {
      return new Money(xml);
   }

   public Class getReturnedClass()
   {
      return Money.class;
   }

   public String getName()
   {
      return "money";
   }

}
