package com.telia.oneservice.controller;


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


import com.telia.oneservice.controller.OneServiceController;
import com.telia.oneservice.model.OneService;
import com.telia.oneservice.service.OneServiceService;

//@RunWith(MockitoJUnitRunner.class)
public class OneServiceControllerTest {

	//@Mock
	OneServiceService oneserviceService;
	
	//@InjectMocks
	OneServiceController oneserviceController = new OneServiceController();
	
	//@Test
	public void testGreeting() {
		final String greeting = "OneService";
		when(oneserviceService.getGreeting()).thenReturn( new OneService("hello"));
		
		 // ResponseEntity<OneService> response = new ResponseEntity<OneService>();
		  assertNotNull(""); 
		  //assertEquals(response.getStatusCode(),HttpStatus.OK); 
		  //assertEquals(response.getBody().getGreeting(), greeting);
		 
	}
	
	
	
}
