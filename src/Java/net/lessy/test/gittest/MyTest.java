package net.lessy.test.gittest;

/**
 * @author Hans Lesmeister
 */
public class MyTest {

   private void hi(String s) {
      System.out.println(s);
   }

   public static void main(String[] args) {
      new MyTest().hi("Hi");
   }

}
