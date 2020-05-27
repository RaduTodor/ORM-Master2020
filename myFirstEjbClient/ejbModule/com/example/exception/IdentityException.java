package com.example.exception;

import javax.ejb.EJBException;

public class IdentityException extends EJBException {

	private static final long serialVersionUID = -66415064895L;

	private String message;

	public IdentityException(String message) {
		super(message);
		this.message = message;
	}

	public String message() {
		return this.message;
	}
}
