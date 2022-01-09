package com.telia.oneservice.service;

import org.springframework.stereotype.Component;

import com.telia.oneservice.model.OneService;

@Component
public class OneServiceService{
	
	private OneService catalog = null;
	public OneServiceService() {
		
	}
	

public OneService getGreeting() {
	return new OneService("OneService");
}

	
}