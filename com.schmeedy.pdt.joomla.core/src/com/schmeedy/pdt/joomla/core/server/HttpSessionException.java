package com.schmeedy.pdt.joomla.core.server;

public class HttpSessionException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public HttpSessionException(String message, Throwable cause) {
		super(message, cause);
	}

	public HttpSessionException(String message) {
		super(message);
	}

	public HttpSessionException(Throwable cause) {
		super(cause);
	}

}
