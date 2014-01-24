package net.lessy.util.optional.hibernate.type;

import org.hibernate.HibernateException;

import net.lessy.util.type.Money4;

/**
 * @author Hans Lesmeister
 */
public class Money4Type extends AbstractAmountType
{
   public Object fromStringValue(String xml) throws HibernateException
   {
      return new Money4(xml);
   }

   public Class getReturnedClass()
   {
      return Money4.class;
   }

   public String getName()
   {
      return "money4";
   }
}