package com.telia.uniservice.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class UniServiceServiceTest {

	
	
	@Test
	public void testGetGreeting() {
	final UniServiceService uniserviceService = new UniServiceService();
	assertNotNull(uniserviceService);
	assertEquals(uniserviceService.getGreeting().getGreeting(), "UniService");
	}
	
	
}
