package com.rentvalley.exception;

public class RentValleyException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RentValleyException() {
		super();
	}

	public RentValleyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public RentValleyException(String message, Throwable cause) {
		super(message, cause);
	}

	public RentValleyException(String message) {
		super(message);
	}

	public RentValleyException(Throwable cause) {
		super(cause);
	}
	
}
