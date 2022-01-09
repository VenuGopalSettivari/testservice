package com.telia.uniservice.constants;

public class Constants {

	public static final String SwedenNationalIDURI = "http://localhost:8086/auth/start";
	public static final String SwedenJWT = "http://localhost:8086/auth/poll";
	public static final String FinlandNationalIDURI = "";
	public static final String FinlandJWT = "";
	public static final String nationalId = "nationalId";
	public static final String oneKey = "onekey";
	
	public static final int HTTP_CONNECTION_TIMEOUT = 60000;
	
	private final String name;
	private Constants(String name) {
		this.name = name;
	}
}
