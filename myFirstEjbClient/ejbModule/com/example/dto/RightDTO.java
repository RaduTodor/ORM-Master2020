package com.example.dto;

import java.io.Serializable;
import java.util.List;

public class RightDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private int rightId;
	private String rightName;
	private String rightDescription;
	private List<RoleDTO> roles;

	public RightDTO() {
		super();
	}

	public int getRightId() {
		return rightId;
	}

	public void setRightId(int id) {
		this.rightId = id;
	}

	public String getRightName() {
		return rightName;
	}

	public void setRightName(String name) {
		this.rightName = name;
	}

	public String getRightDescription() {
		return rightDescription;
	}

	public void setRightDescription(String description) {
		this.rightDescription = description;
	}
	
	public List<RoleDTO> getRoles() {
		return this.roles;
	}

	public void setRoles(List<RoleDTO> roles) {
		this.roles = roles;
	}

	public RightDTO(String rightName, String rightDescription) {
		super();
		this.rightName = rightName;
		this.rightDescription = rightDescription;
	}

	@Override
	public String toString() {
		return "RightDTO [rightId=" + rightId + ", rightName=" + rightName + ", rightDescription=" + rightDescription + "]";
	}

}
