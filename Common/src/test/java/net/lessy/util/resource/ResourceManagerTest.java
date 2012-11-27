package net.lessy.util.resource;

import junit.framework.TestCase;
import net.lessy.util.resource.MessageBean;
import net.lessy.util.resource.ResourceManager;

/**
 * @author Hans Lesmeister
 */
public class ResourceManagerTest extends TestCase {

   private ResourceManager resourceManager;

   @Override
   protected void setUp() throws Exception {
      super.setUp();
      resourceManager = new ResourceManager("net.lessy.util.resource.ResourceTest");
   }

   public void testGetString() {
      String key = "a.b.c";
      String text = resourceManager.getString(key);
      assertEquals("ABC", text);

      // With insets
      key = "123";
      text = resourceManager.getString(key, "I1", "I2");
      assertEquals("AI1BI2", text);

      // Not existing
      key = "BLA";
      text = resourceManager.getString(key);
      assertEquals(key, text);

      // Not existing with insets
      key = "BB {0}";
      text = resourceManager.getString(key, "HI");
      assertEquals("BB HI", text);

   }


   public void testGetStringFromBean() {
      MessageBean bean = new MessageBean("a.b.c");
      assertEquals("ABC", resourceManager.getString(bean));

      bean = new MessageBean("123", "yes", "no");
      assertEquals("AyesBno", resourceManager.getString(bean));

   }
}
