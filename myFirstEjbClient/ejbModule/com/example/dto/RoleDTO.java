package com.example.dto;

import java.io.Serializable;

public class RoleDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private int roleId;
	private String roleName;
	private String roleDescription;

	public RoleDTO() {
		super();
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int id) {
		this.roleId = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String name) {
		this.roleName = name;
	}

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String description) {
		this.roleDescription = description;
	}

	public RoleDTO(String roleName, String roleDescription) {
		super();
		this.roleName = roleName;
		this.roleDescription = roleDescription;
	}

	@Override
	public String toString() {
		return "RoleDTO [roleId=" + roleId + ", roleName=" + roleName + ", roleDescription=" + roleDescription + "]";
	}

}
