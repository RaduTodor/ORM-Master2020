package com.bestdb.models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user_role_resource database table.
 * 
 */
@Entity
@Table(name="user_role_resource")
@NamedQuery(name="UserRoleResource.findAll", query="SELECT u FROM UserRoleResource u")
public class UserRoleResource implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	//bi-directional many-to-one association to Resource
	@ManyToOne
	@JoinColumn(name="resourceId")
	private Resource resource;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="roleId")
	private Role role;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;

	public UserRoleResource() {
	}
	
	public UserRoleResource(int userId, int roleId, int resourceId) {
		User user = new User();
		user.setUserId(userId);
		Role role = new Role();
		role.setRoleId(roleId);
		Resource res = new Resource();
		res.setResourceId(resourceId);
		this.user = user;
		this.role = role;
		this.resource = res;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Resource getResource() {
		return this.resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}