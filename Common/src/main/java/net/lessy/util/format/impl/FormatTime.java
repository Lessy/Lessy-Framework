package net.lessy.util.format.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * @author hl
 */
public class FormatTime extends FormatDate {

   @Override
   public DateFormat getDateFormatter(Locale locale) {
      return new SimpleDateFormat("HH:mm", locale);
   }
}