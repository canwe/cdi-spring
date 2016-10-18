package com.github.vogelb.cdi;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

@Component
public class ServiceBean implements Service {
	@Inject
	ConstantsProvider constants;
	
	public String getVersion() {
		return constants.getVersion();
	}
}
