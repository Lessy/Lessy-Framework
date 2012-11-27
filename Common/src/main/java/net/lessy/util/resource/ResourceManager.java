package net.lessy.util.resource;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import net.lessy.util.MessageHolder;

/**
 * Convenient Manager around a resource bundle.
 * This class is a pseudo singleton. You can create more then one instance but only the last
 * created instance can be retrieved with the getInstance-Method.
 * <p>
 * If you have only one bundle, then call the constructor once and pass the bundlename to it. From there
 * you can always get a reference to the manager with the static getInstance-Method.
 * <p>
 * The manager can be configured through Spring by just adding it as a bean and configuring the
 * bundlename as a constructor parameter.
 * 
 * @author Hans Lesmeister
 */
public class ResourceManager implements MessageResolver {

   private volatile static ResourceManager resourceManager;
   private String bundleName;

   /**
    * Constructor
    * @param bundleName fully qualified resource name, i.e. "net.lessy.res.Resource" (without extension .properties)
    */
   public ResourceManager(String bundleName) {
      this.bundleName = bundleName;
      resourceManager = this;
   }

   /**
    * Get the one and only singleton instance.
    * @return The instance or null if no instance exists
    */
   public static ResourceManager getInstance() {
      return resourceManager;
   }

   public MessageBean createMessageBean(String key, Object...insets) {
      return new MessageBean(this, key, insets);
   }

   /**
    * {@inheritDoc}
    */
   public String getString(String key, Object...insets) {
      String text;
      try {
         ResourceBundle bundle = ResourceBundle.getBundle(bundleName);
         text = bundle.getString(key);
      }
      catch (MissingResourceException e) {
         text = key;
      }

      return MessageFormat.format(text, insets);
   }

   /**
    * Gets a string from the resource bundle. The resource key and insets are taken
    * from the passed bean
    * @param messageBean
    * @return String or null if the bean is null
    */
   public String getString(MessageHolder messageBean) {
      if (messageBean == null) {
         return null;
      }

      return getString(messageBean.getKey(), messageBean.getInsets());
   }

   /**
    * Name of the resource bundle
    * @return Name which was originally passed to the constructor
    */
   public String getBundleName() {
      return bundleName;
   }

   public void setBundleName(String bundleName) {
      this.bundleName = bundleName;
   }
}
