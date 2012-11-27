package net.lessy.util.exception;

import net.lessy.util.MessageHolder;

/**
 * @author hl
 */
public class PracticalException extends CommonException implements MessageHolder
{

   private Object[] insets;

   /**
    * Constructs a new runtime exception with <code>null</code> as its
    * detail message.  The cause is not initialized, and may subsequently be
    * initialized by a call to {@link #initCause}.
    */
   public PracticalException() {
   }

   /**
    * Constructs a new runtime exception with the specified cause and a
    * detail message of <tt>(cause==null ? null : cause.toString())</tt>
    * (which typically contains the class and detail message of
    * <tt>cause</tt>).  This constructor is useful for runtime exceptions
    * that are little more than wrappers for other throwables.
    *
    * @param cause the cause (which is saved for later retrieval by the
    *              {@link #getCause()} method).  (A <tt>null</tt> value is
    *              permitted, and indicates that the cause is nonexistent or
    *              unknown.)
    * @since 1.4
    */
   public PracticalException(Throwable cause) {
      super(cause);
   }

   /**
    * Constructs a new runtime exception with the specified detail message.
    * The cause is not initialized, and may subsequently be initialized by a
    * call to {@link #initCause}.
    *
    * @param message the detail message. The detail message is saved for
    *                later retrieval by the {@link #getMessage()} method.
    */
   public PracticalException(String message, Object...insets) {
      super(message);
      this.insets = insets;
   }

   /**
    * Constructs a new runtime exception with the specified detail message and
    * cause.  <p>Note that the detail message associated with
    * <code>cause</code> is <i>not</i> automatically incorporated in
    * this runtime exception's detail message.
    *
    * @param message the detail message (which is saved for later retrieval
    *                by the {@link #getMessage()} method).
    * @param cause   the cause (which is saved for later retrieval by the
    *                {@link #getCause()} method).  (A <tt>null</tt> value is
    *                permitted, and indicates that the cause is nonexistent or
    *                unknown.)
    * @since 1.4
    */
   public PracticalException(String message, Throwable cause, Object...insets) {
      super(message, cause);
      this.insets = insets;
   }

   @Override
   public String getKey() {
      return getMessage();
   }

   /**
    * Getter
    * @return insets
    */
   public Object[] getInsets() {
      return insets;
   }
}