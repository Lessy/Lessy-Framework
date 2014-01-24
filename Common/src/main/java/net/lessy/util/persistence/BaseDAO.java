package net.lessy.util.persistence;

/**
 * Base class with some convenient basic methods to handle entities. 
 * @author Hans Lesmeister
 */
public abstract class BaseDAO {

   /**
    * Finds and returns the objectwith the associated Id.
    * If nothing is found then null is returned.
    * @param clazz Class of the entity
    * @param id Id of the object
    * @return Object-instance or null if it does not exist. If the passed clazz or Id are null, then null is
    *   returned as well
    */
   protected abstract BaseEntity getObjectById(Class clazz, long id);

   /**
    * Saves an Entity.
    * @param entity Entity to save. If null, this method does nothing
    */
   protected abstract void saveEntity(BaseEntity entity);

   /**
    * Delete an entity. If the entity has no id then it is evicted
    * @param  entity Entity to be deleted. If null, this method does nothing
    */
   protected abstract void deleteEntity(BaseEntity entity);
}
