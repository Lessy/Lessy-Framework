package net.lessy.util.messaging;

/**
 * A channel is part of the framework's messaging system. It
 * represents a topic to which any object may register and to which
 * any object may send a message. All messages are forwarded to the objects
 * that have registered to the channel.
 * <p>
 * Senders may either send a fire-and-forget message or a vetoable message. In case
 * of the vetoable message, the message is transmitted to the message listeners only
 * if no listeners files a veto against it.
 *
 * @author Tim Wellhausen
 */
public interface Channel {

   /**
    * Registers the given message listener to retrieve all upcoming messages.
    */
   public void registerMessageListener(MessageListener messageListener);

   /**
    * Unregisters the given message listener so that it won't receive any
    * messages any more.
    */
   public void unregisterMessageListener(MessageListener messageListener);

   /**
    * Sends a fire-and-forget message that is forwarded to all message listener.
    */
   public void sendMessage(Message message);

   /**
    * Sends a vetoable message. If any message listener files a veto against the
    * message, a MessageVetoException is thrown by the listener itself. In that case,
    * the message is not forwarded to any listeners. If no veto is filed, the message
    * is forwarded to all listeners.
    * <p>
    * Listeners implement 2 methods: checkVetoableMessage and receiveMessage
    */
   public void sendVetoableMessage(Message message) throws MessageVetoException;

}
