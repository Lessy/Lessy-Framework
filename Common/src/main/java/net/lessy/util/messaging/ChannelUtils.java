package net.lessy.util.messaging;

/**
 * @author Hans Lesmeister
 */
public class ChannelUtils {

   private ChannelUtils() {   }


   /**
    * Convient method to send a message to a channel. The message is only sent
    * if both channel and message are NOT null. If one of them is null, then the
    * method silently returns, doing nothing.
    *
    * @param channel The Channel
    * @param message The Message
    */
   public static void sendMessage(Channel channel, Message message) {
      if ((channel == null) || (message == null)) {
         return;
      }

      channel.sendMessage(message);
   }
}
