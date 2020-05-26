package com.example.exception;

import javax.ejb.EJBException;

public class OrganizationException extends EJBException {

	private static final long serialVersionUID = -66754710415064895L;

	private String message;

	public OrganizationException(String message) {
		super(message);
		this.message = message;
	}

	public String message() {
		return this.message;
	}
}
