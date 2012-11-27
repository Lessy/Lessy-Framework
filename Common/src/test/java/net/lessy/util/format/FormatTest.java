package net.lessy.util.format;

import java.util.Calendar;
import java.util.Date;

import junit.framework.TestCase;
import net.lessy.util.logging.Logger;
import net.lessy.util.DateUtil;
import net.lessy.util.format.impl.FormatDate;
import net.lessy.util.format.impl.FormatTime;
import net.lessy.util.format.impl.FormatCurrency;

/**
 * @author Hans Lesmeister
 */
public class FormatTest extends TestCase {

   /**
    * Logger instance
    */
   private static final Logger log = Logger.getLogger(FormatTest.class);

   public void testDateFormat() {
      Date date = DateUtil.createDate(2009, 10, 16);
      log.debug("Date:", date);
      FormatDate df = new FormatDate();
      String res = df.format(date, null, null);
      assertEquals("16.10.2009", res);
   }

   public void testTimeFormat() {
      Calendar cal = Calendar.getInstance();
      cal.set(Calendar.AM_PM, Calendar.AM);
      cal.set(Calendar.HOUR, 11);
      cal.set(Calendar.MINUTE, 8);
      Date date = cal.getTime();
      log.debug("Date:", date);
      FormatTime df = new FormatTime();
      String res = df.format(date, null, null);
      assertEquals("11:08", res);
   }

   public void testCurrencyFormat() {
      FormatCurrency fc = new FormatCurrency();
      String res = fc.format("123456,78", null, null);
      assertEquals("123.456,78", res);
   }
}
