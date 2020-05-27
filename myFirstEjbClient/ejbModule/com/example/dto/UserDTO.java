package com.example.dto;

import java.io.Serializable;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String username;
	private String password;
    private int identityId;
    
	public UserDTO() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getIdentityId() {
		return identityId;
	}

	public void setIdentityId(int id) {
		this.identityId = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public UserDTO(String username, String password, int identityId) {
		super();
		this.username = username;
		this.password = password;
		this.identityId = identityId;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", username=" + username + ", password=" + password + "]";
	}

}
