package com.bestdb.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the resource database table.
 * 
 */
@Entity
@NamedQuery(name="Resource.findAll", query="SELECT r FROM Resource r")
public class Resource implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int resourceId;

	private String accessKey;

	private String token;

	private String url;

	//bi-directional many-to-one association to UserRoleResource
	@OneToMany(mappedBy="resource")
	private List<UserRoleResource> userRoleResources;

	public Resource() {
	}
	
	public Resource(String accessKey, String token, String url) {
		this.accessKey = accessKey;
		this.token = token;
		this.url = url;
	}

	public int getResourceId() {
		return this.resourceId;
	}

	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}

	public String getAccessKey() {
		return this.accessKey;
	}

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<UserRoleResource> getUserRoleResources() {
		return this.userRoleResources;
	}

	public void setUserRoleResources(List<UserRoleResource> userRoleResources) {
		this.userRoleResources = userRoleResources;
	}

	public UserRoleResource addUserRoleResource(UserRoleResource userRoleResource) {
		getUserRoleResources().add(userRoleResource);
		userRoleResource.setResource(this);

		return userRoleResource;
	}

	public UserRoleResource removeUserRoleResource(UserRoleResource userRoleResource) {
		getUserRoleResources().remove(userRoleResource);
		userRoleResource.setResource(null);

		return userRoleResource;
	}

}