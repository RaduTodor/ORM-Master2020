package com.example.dto;

import java.io.Serializable;

public class IdentityDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String firstname;
	private String lastname;
	private int organisationId;

	public IdentityDTO() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public int getOrganisationId() {
		return organisationId;
	}

	public void setOrganisationId(int organisationId) {
		this.organisationId = organisationId;
	}

	public IdentityDTO(String firstname, String lastname, int organisationId) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.organisationId = organisationId;
	}

	@Override
	public String toString() {
		return "IdentityDTO [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", organisationId=" + organisationId + "]";
	}

}
