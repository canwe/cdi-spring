package com.github.vogelb.cdi;

import org.springframework.stereotype.Component;

@Component
public class ConstantsProviderBean implements ConstantsProvider {

	public String getVersion() {
		return Constants.VERSION;
	}

}
