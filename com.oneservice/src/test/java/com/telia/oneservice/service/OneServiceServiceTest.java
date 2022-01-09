package com.telia.oneservice.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class OneServiceServiceTest {

	
	
	@Test
	public void testGetGreeting() {
	final OneServiceService oneserviceService = new OneServiceService();
	assertNotNull(oneserviceService);
	assertEquals(oneserviceService.getGreeting().getGreeting(), "OneService");
	}
	
	
}
