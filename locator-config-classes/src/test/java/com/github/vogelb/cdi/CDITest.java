package com.github.vogelb.cdi;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { BeanConfig.class })
public class CDITest {
	
	@Inject
	private Service service;
	
	@Test
	public void testInjection() {
		String version = service.getVersion();
		LoggerFactory.getLogger(getClass()).info("VERSION = " + version);
		assertEquals(Constants.VERSION, version);
	}
	
	@Test
	public void testLocator() {
		BeanLocator.createContext(BeanConfig.class);
		Service myService = BeanLocator.getInstance(Service.class);
		String version = myService.getVersion();
		LoggerFactory.getLogger(getClass()).info("VERSION = " + version);
		assertEquals(Constants.VERSION, version);
	}

}
