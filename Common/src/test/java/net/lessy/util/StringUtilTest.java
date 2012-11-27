package net.lessy.util;

import junit.framework.TestCase;

/**
 * Tests around StringUtil
 * @author Hans Lesmeister
 */
public class StringUtilTest extends TestCase
{
   public void testToUpperLower() {
      assertEquals(null, StringUtil.toUpperLower(null));
      assertEquals("", StringUtil.toUpperLower(""));
      assertEquals("A", StringUtil.toUpperLower("A"));
      assertEquals("A", StringUtil.toUpperLower("a"));
      assertEquals("Abc", StringUtil.toUpperLower("abc"));
      assertEquals("Abc", StringUtil.toUpperLower("ABC"));
      assertEquals("Abc", StringUtil.toUpperLower("aBc"));
      assertEquals("Abc", StringUtil.toUpperLower("AbC"));
   }

   /**
    * Test for StringUtil.trim()
    */
   public void testTrim() {
      assertNull(StringUtil.trim(null));
      assertEquals("", StringUtil.trim(""));
      assertEquals("", StringUtil.trim("   "));
      assertEquals("Test", StringUtil.trim("Test   "));
   }

   /**
    * Test for StringUtil.concatenate()
    */
   public void testConcatenate() {
      String a, b, c;
      a = "a"; b = "b"; c = "c";
      assertEquals("abc", StringUtil.concatenate(a, b, c).toString());

      b = null;
      assertEquals("anullc", StringUtil.concatenate(a, b, c).toString());
   }

   public void testConcatenateNotEmpty() {
      String a, b;
      a = null;
      b = "2";
      assertEquals("2", StringUtil.concatenateNotEmpty(a, b));

      a = null;
      b = null;
      assertEquals("", StringUtil.concatenateNotEmpty(a, b));

      a = "1";
      b = "2";
      assertEquals("1 2", StringUtil.concatenateNotEmpty(a, b));

      a = "1";
      b = null;
      assertEquals("1", StringUtil.concatenateNotEmpty(a, b));

      a = "1";
      b = "2";
      assertEquals("1;2", StringUtil.concatenateNotEmpty(";", a, b));

   }

   public void testObjectToString() {
      String s1 = null;
      String s2 = "blabla";
      assertNull(StringUtil.objectToString(s1));
      assertEquals("blabla", StringUtil.objectToString(s2));

      Integer i1 = null;
      Integer i2 = new Integer(42);
      assertNull(StringUtil.objectToString(i1));
      assertEquals("42", StringUtil.objectToString(i2));

      String s3 = null;
      String s4 = null;
      assertNull(StringUtil.objectToString(s3, null));
      assertEquals("blabla", StringUtil.objectToString(s4, "blabla"));

   }
}
