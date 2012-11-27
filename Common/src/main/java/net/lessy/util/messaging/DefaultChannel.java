package net.lessy.util.messaging;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hans Lesmeister
 */
public class DefaultChannel implements Channel {

   private List<MessageListener> messageListeners;
   private List<VetoableMessageListener> vetoListeners;
   private String channelName;

   public DefaultChannel() {
      this(null);
   }

   /**
    * Defaultimplementation for a message channel
    */
   public DefaultChannel(String channelName) {
      this.channelName = channelName;
      messageListeners = new ArrayList<MessageListener>();
      vetoListeners = new ArrayList<VetoableMessageListener>();
   }

   /**
    * {@inheritDoc}
    */
   public void unregisterMessageListener(MessageListener messageListener) {
      messageListeners.remove(messageListener);

      if (messageListener instanceof VetoableMessageListener) {
         vetoListeners.remove(messageListener);
      }
   }

   /**
    * {@inheritDoc}
    */
   public void registerMessageListener(MessageListener messageListener) {
      if (!messageListeners.contains(messageListener)) {
         messageListeners.add(messageListener);

         if (messageListener instanceof VetoableMessageListener) {
            vetoListeners.add((VetoableMessageListener) messageListener);
         }
      }
   }

   /**
    * {@inheritDoc}
    */
   public void sendMessage(Message message) {
      doSendMessage(message, messageListeners);
   }

   /**
    * {@inheritDoc}
    */
   public void sendVetoableMessage(Message message) throws MessageVetoException {
      for (VetoableMessageListener listener : vetoListeners) {
         listener.checkVetoableMessage(message);
      }

      // If no Veto is thrown then send the message to all listeners
      doSendMessage(message, vetoListeners);
   }

   private void doSendMessage(Message message, List<? extends MessageListener> listeners) {
      for (MessageListener listener : listeners) {
         listener.receiveMessage(message);
      }
   }

   /**
    * Prints the name of the channel
    */
   public String toString() {
      return "Channel: " + channelName;
   }

   public void setChannelName(String channelName) {
      this.channelName = channelName;
   }

   public String getChannelName() {
      return channelName;
   }
}
