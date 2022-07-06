package com.cgi.exception;

public class InsuranceAlreadyExistException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public InsuranceAlreadyExistException(String msg) {
		super(msg);
	}

}
