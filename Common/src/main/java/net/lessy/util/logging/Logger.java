package net.lessy.util.logging;

import org.slf4j.LoggerFactory;

import net.lessy.util.StringUtil;

/**
 * @author Hans Lesmeister
 */
public class Logger {

   private org.slf4j.Logger logger;

   public static Logger getLogger(Class clazz) {
      return new Logger(clazz);
   }

   public Logger(Class clazz) {
      logger = LoggerFactory.getLogger(clazz);
   }

   /**
    * Convenience Debug-Method that takes a variable number of parameters. The parameters are
    * concatenated and then passed to the regular debug()-Method but only if isDebugEnabled() returns
    * true. This prevents expensive expressions to evaluate unnecesary before being passed to the logger.
    * @param objects The objects to log
    */
   public void debug(Object...objects) {
      if (isDebugEnabled()) {
         StringBuilder b = StringUtil.concatenate(objects);
         debug(b);
      }
   }

   /** All following methods are delegating directly to the Commons-Logger **/

   public void debug(Object o) {
      logger.debug("{}", o);
   }

   public void debug(Object o, Throwable throwable) {
      logger.debug(StringUtil.objectToString(o), throwable);
   }

   public void error(Object o) {
      logger.error("{}", o);
   }

   public void error(Object o, Throwable throwable) {
      logger.error(StringUtil.objectToString(o), throwable);
   }

   public void fatal(Object o) {
      logger.error("{}", o);
   }

   public void fatal(Object o, Throwable throwable) {
      logger.error(StringUtil.objectToString(o), throwable);
   }

   public void info(Object o) {
      logger.info("{}", o);
   }

   public void info(Object o, Throwable throwable) {
      logger.info(StringUtil.objectToString(o), throwable);
   }

   public boolean isDebugEnabled() {
      return logger.isDebugEnabled();
   }

   public boolean isErrorEnabled() {
      return logger.isErrorEnabled();
   }

   public boolean isInfoEnabled() {
      return logger.isInfoEnabled();
   }

   public boolean isTraceEnabled() {
      return logger.isTraceEnabled();
   }

   public boolean isWarnEnabled() {
      return logger.isWarnEnabled();
   }

   public void trace(Object o) {
      logger.trace("{}", o);
   }

   public void trace(Object o, Throwable throwable) {
      logger.trace(StringUtil.objectToString(o), throwable);
   }

   public void warn(Object o) {
      logger.warn("{}", o);
   }

   public void warn(Object o, Throwable throwable) {
      logger.warn(StringUtil.objectToString(o), throwable);
   }
}
