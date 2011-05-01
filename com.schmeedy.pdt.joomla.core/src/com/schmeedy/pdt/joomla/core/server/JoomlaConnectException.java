package com.schmeedy.pdt.joomla.core.server;

public class JoomlaConnectException extends HttpSessionException {

	private static final long serialVersionUID = 1L;

	public JoomlaConnectException(String message, Throwable cause) {
		super(message, cause);
	}

	public JoomlaConnectException(String message) {
		super(message);
	}

	public JoomlaConnectException(Throwable cause) {
		super(cause);
	}
	
}
