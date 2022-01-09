package com.telia.oneservice.util;

import java.security.MessageDigest;

import org.springframework.stereotype.Component;

@Component
public class OneKeyGenerator {

	public static String getOneKey(String nationalId) {
		
		try {
			//Thread.sleep(2000);
	        final MessageDigest digest = MessageDigest.getInstance("md5");
	        digest.update(nationalId.getBytes());
	        final byte[] bytes = digest.digest();
	        final StringBuilder sb = new StringBuilder();
	        for (int i = 0; i < bytes.length; i++) {
	            sb.append(String.format("%02X", bytes[i]));
	        }
	        System.out.println(sb.toString().toLowerCase()); 
		return sb.toString().toLowerCase();	
		} catch (Exception exc) {
	    	exc.printStackTrace();
	        return null;
	    }
		
	}
	
}
