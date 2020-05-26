package com.bestdb.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
@NamedQuery(name = "findUserByUsername", query = "SELECT u FROM User u WHERE u.username = :username")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;

	private String password;

	private String username;

	//bi-directional many-to-one association to Identity
	@ManyToOne
	@JoinColumn(name="identityId")
	private Identity identity;

	//bi-directional many-to-one association to UserRoleResource
	@OneToMany(mappedBy="user")
	private List<UserRoleResource> userRoleResources;

	public User() {
	}
	
	public User(String name, String password) {
		this.username = name;
		this.password = password;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Identity getIdentity() {
		return this.identity;
	}

	public void setIdentity(Identity identity) {
		this.identity = identity;
	}

	public List<UserRoleResource> getUserRoleResources() {
		return this.userRoleResources;
	}

	public void setUserRoleResources(List<UserRoleResource> userRoleResources) {
		this.userRoleResources = userRoleResources;
	}

	public UserRoleResource addUserRoleResource(UserRoleResource userRoleResource) {
		getUserRoleResources().add(userRoleResource);
		userRoleResource.setUser(this);

		return userRoleResource;
	}

	public UserRoleResource removeUserRoleResource(UserRoleResource userRoleResource) {
		getUserRoleResources().remove(userRoleResource);
		userRoleResource.setUser(null);

		return userRoleResource;
	}

}