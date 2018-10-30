package com.rentvalley.exception;

public class EmailActivationLinkFailedException extends RentValleyException {

	private static final long serialVersionUID = 1L;

	public EmailActivationLinkFailedException() {
		super();
	}

	public EmailActivationLinkFailedException(String message) {
		super(message);
	}
	
}
