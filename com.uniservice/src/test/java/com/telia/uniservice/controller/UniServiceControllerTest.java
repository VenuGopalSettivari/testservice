package com.telia.uniservice.controller;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;


import com.telia.uniservice.controller.UniServiceController;
import com.telia.uniservice.model.UniService;
import com.telia.uniservice.service.UniServiceService;

//@RunWith(MockitoJUnitRunner.class)
public class UniServiceControllerTest {

	//@Mock
	UniServiceService uniserviceService;
	
	//@InjectMocks
	UniServiceController uniserviceController = new UniServiceController();
	
	//@Test
	public void testGreeting() {
		final String greeting = "UniService";
		when(uniserviceService.getGreeting()).thenReturn( new UniService("hello"));
		/*
		 * ResponseEntity<UniService> response = uniserviceController.getGreeting();
		 * assertNotNull(response.getBody()); assertEquals(response.getStatusCode(),
		 * HttpStatus.OK); assertEquals(response.getBody().getGreeting(), greeting);
		 */
	}
	
	
	
}
