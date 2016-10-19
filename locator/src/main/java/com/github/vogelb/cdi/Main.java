package com.github.vogelb.cdi;

import org.slf4j.LoggerFactory;

public class Main {
	
	public static void main(String[] args) {
  	   	// Start locator service
		BeanLocator.createContext("beans.xml");
  	   	
  	   	// Get managed bean instance
  	   	Service main = BeanLocator.getInstance(Service.class);
		LoggerFactory.getLogger(Main.class).info("VERSION = " + main.getVersion());
		
	}
}
