package com.schmeedy.pdt.joomla.core.project.importer;

public class UnsupportedArchiveTypeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UnsupportedArchiveTypeException() {
		super();
	}

	public UnsupportedArchiveTypeException(String message, Throwable cause) {
		super(message, cause);
	}

	public UnsupportedArchiveTypeException(String message) {
		super(message);
	}

	public UnsupportedArchiveTypeException(Throwable cause) {
		super(cause);
	}
	
}
