package com.example.dto;

import java.io.Serializable;

public class ResourceDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private int resourceId;
	private String accessKey;
	private String token;
	private String url;

	public ResourceDTO() {
		super();
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

	public ResourceDTO(String accessKey, String token, String url) {
		super();
		this.accessKey = accessKey;
		this.token = token;
		this.url = url;
	}

	@Override
	public String toString() {
		return "ResourceDTO [resourceId=" + resourceId + ", accessKey=" + accessKey + ", token=" + token + ", url=" + url + "]";
	}

}
