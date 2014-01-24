package net.lessy.util.optional.hibernate.type;

import org.hibernate.HibernateException;

import net.lessy.util.type.Percentage;

/**
 * @author Hans Lesmeister
 */
public class PercentageType extends AbstractAmountType
{
   public Object fromStringValue(String xml) throws HibernateException
   {
      return new Percentage(xml);
   }

   public Class getReturnedClass()
   {
      return Percentage.class;
   }

   public String getName()
   {
      return "percentage";
   }

}