package com.telia.uniservice.service;

import org.springframework.stereotype.Component;

import com.telia.uniservice.model.UniService;

@Component
public class UniServiceService{
	
	private UniService catalog = null;
	public UniServiceService() {
		
	}
	

public UniService getGreeting() {
	return new UniService("UniService");
}

	
}