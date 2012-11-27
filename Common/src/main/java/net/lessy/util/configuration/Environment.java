package net.lessy.util.configuration;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.lessy.util.logging.Logger;

/**
 * Global Environment initializes the Spring-Beans factory acts as a factory for those Beans
 * @author Hans Lesmeister
 * @deprecated What was meant to be convenience, turns out to be pain in the butt
 */
public class Environment implements ApplicationContextAware, Environmentable
{
   /**
    * Logger instance
    */
   private static final Logger log = Logger.getLogger(Environment.class);

   /** Holds the Spring Context */
   private ApplicationContext applicationContext;

   /** Singleton */
   private static volatile Environment instance;

   /** Spring Flag, prevents the Spring-configuration getting initialized more then once */
   private static volatile boolean springFlag = false;

   /**
    * Initializes the Environment. In a web-environment this is best done
    * in the Context-Listener (i.e. at the start of the application). This method is intended to run
    * exactly once and there fore it is <strong>not</strong> synchronized
    */
   public static void initialize()
   {
      if (!springFlag) {
         // Load the Spring Context
         ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
         Environment.getInstance().afterInitialize(appContext);
         springFlag = true;
      }


      // Start the polling manager
//      Environment.getInstance().getPollingManager().startPolling();
   }

   /**
    * Gets the singleton instance of the environment
    * @return Environment-Instance
    */
   public static Environment getInstance()
   {
      if (instance  == null) {
         throw new IllegalStateException("Environment is not initialized");
      }

      return instance;
   }

   /**
    * Default Constructor.
    * @throws IllegalStateException if the constructor is called more then once. Only call it once because it is
    *   a singleton
    */
   public Environment()
   {
      if (instance != null) {
         log.warn("Environment is a singleton. The Constructor should be called only once");
      }

      instance = this;
   }

   /**
    * De-Initializes the Environment, i.e. at the end of the Application. In a web-environment this is best done
    * in the Context-Listener. You can override this method to add application specific clean-work.<br>
    * Do not forget to call super.
    */
   public void shutDown() {
      applicationContext = null;
      instance = null;
      springFlag = false;
   }

   /**
    * Is called after the default context has been loaded. Can be explicitly be overridden
    * by implementors.
    * @param applicationContext
    */
   protected void afterInitialize(ApplicationContext applicationContext) {
      // Do nothing, to be overloaded
   }

   /**
    * Setter for the spring application context called by Spring
    * @param applicationContext
    * @throws BeansException
    */
   public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
   {
      this.applicationContext = applicationContext;
   }

   /**
    * Gets the Application Context
    * @return Application Context
    */
   public ApplicationContext getApplicationContext() {
      return applicationContext;
   }

}
