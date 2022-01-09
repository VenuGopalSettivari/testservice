package com.telia.uniservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.telia.uniservice.service.HttpService;

@RestController
public class UniServiceController {
	
	Logger logger = LoggerFactory.getLogger(UniServiceController.class);

	
	@Autowired
	private HttpService httpService;
	
	//@Autowired
	//private AppConfig appConfig;
	
	@RequestMapping(value = "/customer/{nationalId}", method = RequestMethod.POST)
	public <T> ResponseEntity<T> customerIdentity(@PathVariable("nationalId") String nationalId){
		return httpService.oneKeyService(nationalId);
	}
		
	
}