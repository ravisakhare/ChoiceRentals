package com.rentvalley.exception;

public class UserAccountRegistrationFailedException extends RentValleyException {

	private static final long serialVersionUID = 1L;

	public UserAccountRegistrationFailedException() {
		super();
	}

	public UserAccountRegistrationFailedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UserAccountRegistrationFailedException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserAccountRegistrationFailedException(String message) {
		super(message);
	}

	public UserAccountRegistrationFailedException(Throwable cause) {
		super(cause);
	}
	
}
