package net.lessy.util.messaging;


/**
 * Interface for the Message Objects.
 * @author Hans Lesmeister
 */
public interface Message {

    /**
     * Returns the message's command.
     */
    public String getCommand();

    /**
     * Returns the optional data. May return null.
     */
    public Object getData();

    /**
     * Compares this message's command string with the given command string and
     * returns true only if they match.
     */
    public boolean isCommand(String command);

}
