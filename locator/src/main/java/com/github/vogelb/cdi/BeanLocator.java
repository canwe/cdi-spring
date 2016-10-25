package com.github.vogelb.cdi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * A simple Spring bean locator.
 * @author bvo
 */
public class BeanLocator {

	private static final Object MUTEX = new Object();
	private static ApplicationContext context;
	
	private BeanLocator() { }
	
	private static void initialize(ApplicationContext theContext) {
		synchronized(MUTEX) {
			if (context != null) {
				throw new IllegalStateException("BeanLocator has already been initialized");
			}
			context = theContext;
		}
	}
	
	private static ApplicationContext getContext() {
		if (context == null) {
			throw new IllegalStateException("BeanLocator has not been initialized");
		}
		return context;
	}
	
	/**
	 * Create the Locator context.
	 * @param contextElements the context elements (config locations)
	 * 
	 * @see ClassPathXmlApplicationContext#ClassPathXmlApplicationContext(String...)
	 */
	public static void createContext(final String ... contextElements) {
		if (contextElements.length == 0) {
			throw new IllegalArgumentException("Classpath is empty for ");
		}
		initialize(new ClassPathXmlApplicationContext(contextElements));		
	}
	
	/**
	 * Locate a bean by its interface.
	 * @param beanInterface the bean interface
	 * @return the bean instance
	 */
	public static <T> T getInstance(final Class<T> beanInterface) {
		return getContext().getBean(beanInterface);
	}
	
}
