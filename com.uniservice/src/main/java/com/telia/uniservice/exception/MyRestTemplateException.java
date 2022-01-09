package com.telia.uniservice.exception;

import org.springframework.http.HttpStatus;

public class MyRestTemplateException extends RuntimeException {

	  private DownstreamApi api;
	  private HttpStatus statusCode;
	  private String error;

	  public MyRestTemplateException(DownstreamApi api, HttpStatus statusCode, String error) {
	    super(error);
	    this.api = api;
	    this.statusCode = statusCode;
	    this.error = error;
	  }

	public DownstreamApi getApi() {
		return api;
	}

	public void setApi(DownstreamApi api) {
		this.api = api;
	}

	public HttpStatus getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "MyRestTemplateException [api=" + api + ", statusCode=" + statusCode + ", error=" + error + "]";
	}
	  
	  
}