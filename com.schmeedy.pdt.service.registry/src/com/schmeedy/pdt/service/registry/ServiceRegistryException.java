package com.schmeedy.pdt.service.registry;

public class ServiceRegistryException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ServiceRegistryException() {
		super();
	}

	public ServiceRegistryException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceRegistryException(String message) {
		super(message);
	}

	public ServiceRegistryException(Throwable cause) {
		super(cause);
	}
	
}
