package com.schmeedy.pdt.service.registry;

public class ServiceUnavailableException extends ServiceRegistryException {

	private static final long serialVersionUID = 1L;

	public ServiceUnavailableException() {
		super();
	}

	public ServiceUnavailableException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceUnavailableException(String message) {
		super(message);
	}

	public ServiceUnavailableException(Throwable cause) {
		super(cause);
	}
	
}
