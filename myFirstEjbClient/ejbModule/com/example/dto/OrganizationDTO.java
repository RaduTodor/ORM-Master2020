package com.example.dto;

import java.io.Serializable;

public class OrganizationDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String cui;

	public OrganizationDTO() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCui() {
		return cui;
	}

	public void setCui(String cui) {
		this.cui = cui;
	}

	public OrganizationDTO(String name, String cui) {
		super();
		this.name = name;
		this.cui = cui;
	}

	@Override
	public String toString() {
		return "OrganizationDTO [id=" + id + ", name=" + name + ", cui=" + cui + "]";
	}

}
