package net.lessy.util.resource;

import net.lessy.util.StringUtil;
import net.lessy.util.MessageHolder;

/**
 * @author Hans Lesmeister
 */
public class MessageBean implements MessageHolder {
   private String key;
   private Object[] insets;
   private MessageResolver messageResolver;

   protected MessageBean(MessageResolver messageResolver, String key, Object...insets) {
      this.messageResolver = messageResolver;
      this.key = key;
      this.insets = insets;
   }

   public MessageBean(String key, Object...insets) {
      this.key = key;
      this.insets = insets;
   }

   public String getKey() {
      return key;
   }

   public Object[] getInsets() {
      return insets;
   }

   public String getMessage() {
      if (messageResolver == null) {
         return StringUtil.concatenate(key, insets).toString();
      }

      return messageResolver.getString(key, insets);
   }

}
