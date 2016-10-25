package com.github.vogelb.cdi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
	
	@Bean
	public ConstantsProvider constantsProvider() {
		return new ConstantsProviderBean();
	}
	
	@Bean
	public Service service() {
		ServiceBean result = new ServiceBean();
		result.setConstants(constantsProvider());
		return result;
	}
}
