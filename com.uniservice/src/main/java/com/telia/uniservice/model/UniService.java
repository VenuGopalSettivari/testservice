package com.telia.uniservice.model;

import org.springframework.stereotype.Component;


@Component
public class UniService {
	private String greeting;
	
	
	public UniService(){
		
	}

public UniService(String greeting){
		this.greeting = greeting;
	}

public String getGreeting() {
	return greeting;
}

}