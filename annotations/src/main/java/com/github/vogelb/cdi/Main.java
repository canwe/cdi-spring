package com.github.vogelb.cdi;

import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
  	   	// Start container
		ApplicationContext context = 
	    		new ClassPathXmlApplicationContext(new String[] {"Spring-AutoScan.xml"});
  	   	
  	   	// Get managed bean instance
  	   	Service main = context.getBean(Service.class);
		LoggerFactory.getLogger(Main.class).info("VERSION = " + main.getVersion());
		
	}
}
