package com.telia.oneservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telia.oneservice.jwt.JwtUtil;
import com.telia.oneservice.model.JWT;
import com.telia.oneservice.model.OneService;
import com.telia.oneservice.service.OneServiceService;
import com.telia.oneservice.util.OneKeyGenerator;

@RestController
public class OneServiceController {
	
	@Autowired
	private OneServiceService oneserviceService;
	@Autowired
	private OneKeyGenerator oneKeyGenerator;
	
	@Autowired
	private JwtUtil jwtTokenUtil;
	
	
	@RequestMapping(value = "/auth/start", method = RequestMethod.POST)
	public ResponseEntity<OneService> nationalIdentityNumber(@RequestParam("nationalId") String nationalId){
		System.out.println("OneService");
		ResponseEntity<OneService> responseEntity;
		OneService response = new OneService(OneKeyGenerator.getOneKey(nationalId));
		responseEntity = new ResponseEntity<OneService>(response, HttpStatus.OK);
		System.out.println(">>>> "+responseEntity.getBody().toString());
		return responseEntity;
	}
	
	
	@RequestMapping(value = "/auth/poll", method = RequestMethod.GET)
	public ResponseEntity<JWT> jwtToken( @RequestParam("onekey") String onekey){
		System.out.println("jwtGEN");
		String jwtToken = jwtTokenUtil.generateToken(onekey);
		JWT jwt = new JWT();
		jwt.setAuthJwt(jwtToken);
		jwt.setSub(onekey);
		ResponseEntity<JWT> responseEntity;
		responseEntity = new ResponseEntity<JWT>(jwt, HttpStatus.OK);
		System.out.println(responseEntity.getBody().getAuthJwt());
		System.out.println(responseEntity.getBody().getSub());
		return responseEntity;
	}
}