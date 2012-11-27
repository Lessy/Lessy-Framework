package net.lessy.util;

import java.util.Calendar;
import java.util.Date;

/**
 * Utility-Methods around Date and Time
 * @author Hans Lesmeister
 */
public class DateUtil {

   /**
    * Creates a date specified with the passed values
    * @param year Year
    * @param month Month (1-based, so 1 = Jan., 2 = Feb.)
    * @param day Day of the month
    * @return Date-Instance
    */
   public static Date createDate(int year, int month, int day) {
      Calendar cal = Calendar.getInstance();
      cal.set(year, month - 1, day);
      return cal.getTime();
   }

   /**
    * Creates a date based on the actual date but without time-settings, so the
    * time part of this date is 00:00:00.000
    * @return Date-Instance
    */
   public static Date createDate() {
      Calendar calendar = Calendar.getInstance();
      resetTimePart(calendar);
      return calendar.getTime();
   }

   /**
    * Sets the time part in a calendar to zero (Hours, Minutes, Seconds, Milliseconds)
    * @param calendar Calendar
    * @throws NullPointerException if calendar is null
    */
   public static void resetTimePart(Calendar calendar) {
      setTimePart(calendar, 0, 0, 0, 0);
   }

   private static void setTimePart(Calendar calendar, int hours, int minutes, int seconds, int milliseconds) {
      calendar.set(Calendar.HOUR_OF_DAY, hours);
      calendar.set(Calendar.MINUTE, minutes);
      calendar.set(Calendar.SECOND, seconds);
      calendar.set(Calendar.MILLISECOND, milliseconds);
   }

   /**
    * Sets the time part to the last second of the day. This is used for queries with something like
    * "date <= :someDate" and the date values in the table could have a time-part.
    * @param date Date. If null the the actual date will be taken
    * @return date with the time-part set to 23:59:59 999
    */
   public static Date setTimeToEndOfDay(Date date) {
      Calendar calendar = getCalendar(date);
      setTimePart(calendar, 23, 59, 59, 999);
      return calendar.getTime();
   }

   /**
    * Sets the time part of a date to zero
    * @param date Date
    * @return new Date with time part set to zero
    */
   public static Date resetTimePart(Date date) {
      Calendar calendar = getCalendar(date);
      resetTimePart(calendar);
      return calendar.getTime();
   }

   /**
    * Get a calendar
    * @param date a date or null
    * @return calendar with the passe date set. If date is null then calendar represants the actual date
    */
   public static Calendar getCalendar(Date date) {
      Calendar cal = Calendar.getInstance();

      if (date != null) {
         cal.setTime(date);
      }

      return cal;
   }

   public static Date addDays(Date date, int days) {
      Calendar c = getCalendar(date);
      c.add(Calendar.DATE, days);

      return c.getTime();
   }

   /**
    * Gets the Year-Part from a date
    * @param date Date to extract the year from. If null, then the actual year is returned
    * @return The year, extracted from the date
    */
   public static int getYear(Date date) {
      Calendar c = getCalendar(date);
      return c.get(Calendar.YEAR);
   }
   


}
