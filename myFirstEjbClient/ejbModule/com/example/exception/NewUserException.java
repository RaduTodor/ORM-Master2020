package com.example.exception;

import javax.ejb.EJBException;

public class NewUserException extends EJBException {

	private static final long serialVersionUID = -674710415064895L;

	private String message;

	public NewUserException(String message) {
		super(message);
		this.message = message;
	}

	public String message() {
		return this.message;
	}
}
