package com.bestdb.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int roleId;

	private String roleDescription;

	private String roleName;

	//bi-directional many-to-many association to Right
	@ManyToMany(mappedBy="roles")
	private List<Right> rights;

	//bi-directional many-to-one association to UserRoleResource
	@OneToMany(mappedBy="role")
	private List<UserRoleResource> userRoleResources;

	public Role() {
	}

	public int getRoleId() {
		return this.roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleDescription() {
		return this.roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<Right> getRights() {
		return this.rights;
	}

	public void setRights(List<Right> rights) {
		this.rights = rights;
	}

	public List<UserRoleResource> getUserRoleResources() {
		return this.userRoleResources;
	}

	public void setUserRoleResources(List<UserRoleResource> userRoleResources) {
		this.userRoleResources = userRoleResources;
	}

	public UserRoleResource addUserRoleResource(UserRoleResource userRoleResource) {
		getUserRoleResources().add(userRoleResource);
		userRoleResource.setRole(this);

		return userRoleResource;
	}

	public UserRoleResource removeUserRoleResource(UserRoleResource userRoleResource) {
		getUserRoleResources().remove(userRoleResource);
		userRoleResource.setRole(null);

		return userRoleResource;
	}

}