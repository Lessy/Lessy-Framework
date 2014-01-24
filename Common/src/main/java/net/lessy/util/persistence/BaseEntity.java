package net.lessy.util.persistence;

import java.io.Serializable;

/**
 * Base Entity-Class
 * @author hl
 */
public abstract class BaseEntity implements Identifyable, Serializable
{
   // Constants can be used in Queries
   public static final String ID      = "id";
   public static final String VERSION = "version";

   /**  Base-Attribute id */
   private Serializable id = null;

   /**  Base-Attribute Version */
   private Long version = null;

   /**
    * {@inheritDoc}
    */
   public Serializable getId()
   {
      return id;
   }

   /**
    * Sets the id
    * @param id Id
    */
   protected void setId(Serializable id)
   {
      this.id = id;
   }

   /**
    * Gets the version
    * @return Version
    */
   public Long getVersion()
   {
      return version;
   }

   /**
    * Sets the new version. Has to be greater or equal to the old version.
    * @param version Version
    */
   protected void setVersion(Long version)
   {
      this.version = version;
   }

   /**
    * {@inheritDoc}
    */
   public boolean isPersistent()
   {
      return (getId() != null);
   }

   /**
    * {@inheritDoc}
    */
   public boolean hasValidId() {
      if (!isPersistent()) {
         return false;
      }

      if (getId() instanceof Number) {
         return ((Number) getId()).longValue() > 0;
      }

      return true;
   }
}
