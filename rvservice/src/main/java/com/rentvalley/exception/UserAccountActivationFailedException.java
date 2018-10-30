package com.rentvalley.exception;

public class UserAccountActivationFailedException extends RentValleyException {

	private static final long serialVersionUID = 1L;

	public UserAccountActivationFailedException() {
		super();
	}

	public UserAccountActivationFailedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UserAccountActivationFailedException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserAccountActivationFailedException(String message) {
		super(message);
	}

	public UserAccountActivationFailedException(Throwable cause) {
		super(cause);
	}
	
}
