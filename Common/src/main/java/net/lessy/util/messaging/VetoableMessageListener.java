package net.lessy.util.messaging;

/**
 * Every object that would like to receive vetoable messages sent to a channel,
 * has to implement this interface and register at the channel.
 * <p>
 * If the listener wants to raise veto against a message, it must throw
 * a MessageVetoException in the method checkVetoableMessage().
 *
 * @see Channel
 * @see MessageVetoException
 *
 * @author Tim Wellhausen
 */
public interface VetoableMessageListener extends MessageListener {

   void checkVetoableMessage(Message message) throws MessageVetoException;
}
