package com.telia.uniservice.model;

public class JWT {

	private String authJwt;
	private String sub;
	
	
	
	public String getAuthJwt() {
		return authJwt;
	}



	public void setAuthJwt(String authJwt) {
		this.authJwt = authJwt;
	}



	public String getSub() {
		return sub;
	}



	public void setSub(String sub) {
		this.sub = sub;
	}



	@Override
	public String toString() {
		return "JWT [authJwt=" + authJwt + ", sub=" + sub + "]";
	}
	
	
	
}
