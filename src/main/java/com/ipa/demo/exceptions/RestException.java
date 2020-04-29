package com.ipa.demo.exceptions;

public class RestException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public RestException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public RestException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public RestException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public RestException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
