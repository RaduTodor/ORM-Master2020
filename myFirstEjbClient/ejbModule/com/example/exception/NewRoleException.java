package com.example.exception;

import javax.ejb.EJBException;

public class NewRoleException extends EJBException {

	private static final long serialVersionUID = -6675421415064895L;

	private String message;

	public NewRoleException(String message) {
		super(message);
		this.message = message;
	}

	public String message() {
		return this.message;
	}
}
