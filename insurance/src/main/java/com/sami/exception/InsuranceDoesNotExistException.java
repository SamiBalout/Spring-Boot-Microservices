package com.cgi.exception;

public class InsuranceDoesNotExistException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public InsuranceDoesNotExistException(String msg) {
		super(msg);
	}

}
