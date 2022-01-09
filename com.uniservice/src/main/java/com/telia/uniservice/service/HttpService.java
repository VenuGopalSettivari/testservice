package com.telia.uniservice.service;

import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.telia.uniservice.config.AppConfig;
import com.telia.uniservice.constants.ConstantErrorMessages;
import com.telia.uniservice.constants.Constants;
import com.telia.uniservice.constants.RegEx;
import com.telia.uniservice.controller.UniServiceController;
import com.telia.uniservice.exception.EmptyInputException;
import com.telia.uniservice.model.JWT;
import com.telia.uniservice.model.UniService;

@Service
public class HttpService {

	Logger logger = LoggerFactory.getLogger(HttpService.class);

	@Autowired
	private AppConfig appConfig;
	
	
	
	public <T> ResponseEntity<T> oneKeyService(String nationalId){
		

		logger.debug("customer service start..!",nationalId);
		if((null ==nationalId && nationalId.isEmpty() || nationalId.length()<10))
			throw new EmptyInputException();
		ResponseEntity<UniService> response = null;
		ResponseEntity<JWT> jwtResponse = null;
		if(Pattern.compile(RegEx.SwedenNationalIDRegEx).matcher(nationalId).find()) {
			logger.debug("sweden identity",nationalId);
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity request = new HttpEntity<>(null, headers);
			RestTemplate restTemplate = appConfig.customRestTemplate();
			UriComponents uriBuilder = UriComponentsBuilder.fromHttpUrl(Constants.SwedenNationalIDURI).queryParam(Constants.nationalId, nationalId).build();
			try {
			response =	restTemplate.exchange(uriBuilder.toString(), HttpMethod.POST, request,  UniService.class);
			}catch (ResourceAccessException e) {
				return (ResponseEntity<T>) new ResponseEntity<String>(ConstantErrorMessages.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
			}catch (HttpClientErrorException e) {
				return (ResponseEntity<T>) new ResponseEntity<String>(ConstantErrorMessages.BAD_REQUEST, HttpStatus.BAD_REQUEST);
			}catch (HttpServerErrorException e) {
				return (ResponseEntity<T>) new ResponseEntity<String>(ConstantErrorMessages.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			if(null !=response && null !=response.getBody().getGreeting() && !response.getBody().getGreeting().isEmpty()) {
				ResponseEntity<JWT> responseEntity2;
				uriBuilder = UriComponentsBuilder.fromHttpUrl(Constants.SwedenJWT).queryParam(Constants.oneKey, response.getBody().getGreeting()).build();
				logger.debug(response.getBody().getGreeting());
				logger.debug(uriBuilder.toString());
				try {
				 jwtResponse =	restTemplate.exchange(uriBuilder.toString(), HttpMethod.GET, request, JWT.class);
				}catch (ResourceAccessException e) {
					return (ResponseEntity<T>) new ResponseEntity<String>(ConstantErrorMessages.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
				}catch (HttpClientErrorException e) {
					return (ResponseEntity<T>) new ResponseEntity<String>(ConstantErrorMessages.BAD_REQUEST, HttpStatus.BAD_REQUEST);
				}catch (HttpServerErrorException e) {
					return (ResponseEntity<T>) new ResponseEntity<String>(ConstantErrorMessages.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
				}
				responseEntity2 = new ResponseEntity<JWT>(jwtResponse.getBody(), HttpStatus.OK);
				return (ResponseEntity<T>) responseEntity2;	
		}
		

		}else if(Pattern.compile(RegEx.FinlandNationalIDRegEx).matcher(nationalId).find()) {
			logger.debug("Finland service runs..!");
		}else {
			logger.debug("no national identity number found");
			return  (ResponseEntity<T>) new ResponseEntity<String>("Invalid Identity Number ", HttpStatus.BAD_REQUEST);
		}
		
		return null;
	
	}
	
	
	}
	
	
	

