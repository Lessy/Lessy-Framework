package net.lessy.util.optional.hibernate.type;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.dialect.Dialect;
import org.hibernate.type.ImmutableType;

import net.lessy.util.type.Amount;


/**
 * General type for an amount,
 * @author Hans Lesmeister
 */
public abstract class AbstractAmountType extends ImmutableType implements Serializable
{
   public Class getPrimitiveClass()
   {
      return double.class;
   }

   public void set(PreparedStatement st, Object value, int index) throws HibernateException, SQLException
   {
      st.setDouble( index, ((Amount) value).getValue().doubleValue());
   }

   public int sqlType()
   {
      return Types.DOUBLE;
   }

   public String objectToSQLString(Object value, Dialect dialect) throws Exception
   {
      return value.toString();
   }

   public String toString(Object value) throws HibernateException
   {
      return value.toString();
   }

   public Object get(ResultSet rs, String name) throws HibernateException, SQLException
   {
      return fromStringValue(String.valueOf(rs.getDouble(name)));
   }

}