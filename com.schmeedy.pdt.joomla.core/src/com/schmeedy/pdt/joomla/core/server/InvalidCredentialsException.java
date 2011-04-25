package com.schmeedy.pdt.joomla.core.server;

public class InvalidCredentialsException extends HttpSessionException {

	private static final long serialVersionUID = 1L;

	public InvalidCredentialsException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidCredentialsException(String message) {
		super(message);
	}

	public InvalidCredentialsException(Throwable cause) {
		super(cause);
	}

}
