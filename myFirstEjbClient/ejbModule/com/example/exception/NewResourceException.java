package com.example.exception;

import javax.ejb.EJBException;

public class NewResourceException extends EJBException {

	private static final long serialVersionUID = -674041115023195L;

	private String message;

	public NewResourceException(String message) {
		super(message);
		this.message = message;
	}

	public String message() {
		return this.message;
	}
}
