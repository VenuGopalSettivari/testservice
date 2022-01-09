package com.telia.oneservice.model;

import org.springframework.stereotype.Component;


@Component
public class OneService {
	private String greeting;
	
	
	public OneService(){
		
	}

public OneService(String greeting){
		this.greeting = greeting;
	}

public String getGreeting() {
	return greeting;
}

}