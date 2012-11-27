package net.lessy.util.persistence;

import java.io.Serializable;

/**
 * @author hl
 */
public interface Identifyable
{
   /**
    * Gets the id
    * @return id
    */
   Serializable getId();

   /**
    * Is there an Id at all?
    * @return true, if id not null
    */
   boolean isPersistent();

   /**
    * Is the Id valid?
    * @return true if valid, i.e. not null and positiv, false if null, zero or negativ
    */
   boolean hasValidId();
}
