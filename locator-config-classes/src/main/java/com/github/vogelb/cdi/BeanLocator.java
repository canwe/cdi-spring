package com.github.vogelb.cdi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * A simple Spring bean locator.
 * @author bvo
 */
public class BeanLocator {

	private static ApplicationContext context; 
	
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
		context = new ClassPathXmlApplicationContext(contextElements);		
	}
	
	/**
	 * Create the Locator context.
	 * @param contextElements the context elements (config locations)
	 * 
	 * @see ClassPathXmlApplicationContext#ClassPathXmlApplicationContext(String...)
	 */
	public static void createContext(final Class ... contextElements) {
		if (contextElements.length == 0) {
			throw new IllegalArgumentException("Classpath is empty for ");
		}
		context = new AnnotationConfigApplicationContext(contextElements);		
	}
	
	/**
	 * Locate a bean by its interface.
	 * @param beanInterface the bean interface
	 * @return the bean instance
	 */
	public static <T> T getInstance(final Class<T> beanInterface) {
		return context.getBean(beanInterface);
	}
	
}
