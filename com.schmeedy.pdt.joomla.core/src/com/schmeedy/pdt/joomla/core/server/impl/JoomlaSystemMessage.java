package com.schmeedy.pdt.joomla.core.server.impl;

public class JoomlaSystemMessage {

	private final String message;
	private final MessageSeverity severity;
	
	public JoomlaSystemMessage(String message, MessageSeverity severity) {
		this.message = message;
		this.severity = severity;
	}

	public String getMessage() {
		return message;
	}
	
	public MessageSeverity getSeverity() {
		return severity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((severity == null) ? 0 : severity.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final JoomlaSystemMessage other = (JoomlaSystemMessage) obj;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (severity != other.severity)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return severity + ": " + message;
	}

	public static enum MessageSeverity {
		INFO, ERROR		
	}
	
}
