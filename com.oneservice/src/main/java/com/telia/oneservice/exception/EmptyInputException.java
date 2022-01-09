package com.telia.oneservice.exception;

import org.springframework.stereotype.Component;

@Component
public class EmptyInputException  extends RuntimeException{

	private static final long serialVersionUID=1L;
	private String errorCode;
	private String errorMessage;
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	@Override
	public String toString() {
		return "EmptyInputException [errorCode=" + errorCode + ", errorMessage=" + errorMessage + "]";
	}
	
	public EmptyInputException() {
		// TODO Auto-generated constructor stub
	}
}