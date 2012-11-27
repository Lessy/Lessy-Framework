package net.lessy.util.logging;

import junit.framework.TestCase;

/**
 * @author Hans Lesmeister
 */
public class LoggerTest extends TestCase {

   /**
    * Logger instance
    */
   private static final Logger log = Logger.getLogger(LoggerTest.class);

   public void testLogger() {
      log.debug("a", "b", "c");
   }
}
