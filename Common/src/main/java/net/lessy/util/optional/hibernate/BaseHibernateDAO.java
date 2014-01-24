package net.lessy.util.optional.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import net.lessy.util.persistence.BaseDAO;
import net.lessy.util.persistence.BaseEntity;

/**
 * Base-Hibernate-Functionality for a DAO. Implements the methods from BaseDAO and provides
 * a session.
 * <p>
 * You will have to set the sessionfactory, otherwise NPE's will be thrown.
 * @author Hans Lesmeister
 */
public class BaseHibernateDAO extends BaseDAO
{
   private SessionFactory sessionFactory;

   /**
    * Setter for the HibernateSessionFactory
    * @param hibernateSessionFactory Hibernate SessionFactory
    */
   public void setSessionFactory(SessionFactory hibernateSessionFactory)
   {
      this.sessionFactory = hibernateSessionFactory;
   }

   /**
    * Getter for the actual HibernateSession
    *
    * @return HibernateSession
    * @deprecated Use getSessiion instead
    */
   protected Session getCurrentHibernateSession()
   {
      return sessionFactory.getCurrentSession();
   }

   /**
    * Getter for the actual HibernateSession
    * @return HibernateSession
    */
   protected Session getSession() {
      return sessionFactory.getCurrentSession();
   }

   /**
    * {@inheritDoc}
    */
   protected BaseEntity getObjectById(Class clazz, long id) {
      if (clazz == null) {
         return null;
      }

      return getObjectById(clazz, new Long(id));
   }

   /**
    * Convenient method which takes a Long as Id. If Id is null, then null is returned.
    * @see #getObjectById(Class, long)
    */
   protected BaseEntity getObjectById(Class clazz, Long id) {
      if (id == null) {
         return null;
      }

      return (BaseEntity) getSession().get(clazz, id);
   }

   /**
    * {@inheritDoc}
    */
   protected void deleteEntity(BaseEntity toDelete) {
      if (toDelete == null) {
         return;
      }

      if (toDelete.getId() != null) {
         // If no Id, there is nothing to delete
         getSession().delete(toDelete);
      }
      else {
         // No id => remove from Cache
         getSession().evict(toDelete);
      }
   }

   /**
    * {@inheritDoc}
    */
   protected void saveEntity(BaseEntity toSave) {
      if (toSave == null) {
         return;
      }

      getSession().saveOrUpdate(toSave);
   }
}
