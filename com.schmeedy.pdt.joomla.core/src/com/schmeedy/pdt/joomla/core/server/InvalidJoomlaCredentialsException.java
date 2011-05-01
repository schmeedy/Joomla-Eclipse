package com.schmeedy.pdt.joomla.core.server;

public class InvalidJoomlaCredentialsException extends HttpSessionException {

	private static final long serialVersionUID = 1L;

	public InvalidJoomlaCredentialsException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidJoomlaCredentialsException(String message) {
		super(message);
	}

	public InvalidJoomlaCredentialsException(Throwable cause) {
		super(cause);
	}

}
