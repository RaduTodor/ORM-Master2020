package com.example.dto;

import java.io.Serializable;

public class UserRoleResourceDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private int userId;
	private int roleId;
	private String roleName;
	private int resourceId;
	private String url;

	public UserRoleResourceDTO() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int id) {
		this.userId = id;
	}

	public int getRoleId() {
		return roleId;
	}
	
	public void setRoleId(int id) {
		this.roleId = id;
	}

	public int getResourceId() {
		return resourceId;
	}
	
	public void setResourceId(int id) {
		this.resourceId = id;
	}
	
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String name) {
		this.roleName = name;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public UserRoleResourceDTO(int userId, int roleId, int resourceId) {
		super();
		this.userId = userId;
		this.roleId = roleId;
		this.resourceId = resourceId;
	}
	
	public UserRoleResourceDTO(int userId, int roleId, int resourceId, String roleName, String url) {
		super();
		this.userId = userId;
		this.roleId = roleId;
		this.resourceId = resourceId;
		this.roleName = roleName;
		this.url = url;
	}


	@Override
	public String toString() {
		return "UserRoleResourceDTO [userId=" + userId + ", roleId=" + roleId + ", resourceId=" + resourceId + "]";
	}

}
