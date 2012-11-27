package net.lessy.util.messaging;

/**
 * @author Hans Lesmeister
 */
public class DefaultMessage implements Message {
   private String command;
   private Object data;

   /**
    * Default
    */
   public DefaultMessage() {   }

   public DefaultMessage(String command, Object data) {
      this.command = command;
      this.data = data;
   }

   public String getCommand() {
      return command;
   }

   public Object getData() {
      return data;
   }

   public boolean isCommand(String command) {
      if ((command == null) && (this.command == null)) {
         return true;
      }

      if ((command == null) || (this.command == null)) {
         return false;
      }

      return command.equals(this.command);
   }

   @Override
   public String toString() {
      return new StringBuilder()
              .append("command=")
              .append(command)
              .append(", data=")
              .append(data)
              .toString();
   }
}
