package com.example.exception;

import javax.ejb.EJBException;

public class NewRightException extends EJBException {

	private static final long serialVersionUID = -674710415023195L;

	private String message;

	public NewRightException(String message) {
		super(message);
		this.message = message;
	}

	public String message() {
		return this.message;
	}
}
