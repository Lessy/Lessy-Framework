package net.lessy.util.resource;

/**
 * Interface to get a string by it's message key. Used by the ResourceManager
 * @author Hans Lesmeister
 */
public interface MessageResolver {

   /**
    * Gets a String by it's key
    * @param key Key of the resource string
    * @param insets optional insets
    * @return String from the resource. If the string can not be determined, then the key as such is returned
    */
   String getString(String key, Object[] insets);
}
