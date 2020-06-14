package com.bestdb.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the right database table.
 * 
 */
@Entity
@NamedQuery(name="Right.findAll", query="SELECT r FROM Right r")
public class Right implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int rightId;

	private String rightDescription;

	private String rightName;

	//bi-directional many-to-many association to Role
	@ManyToMany
	@JoinTable(
		name="right_role"
		, joinColumns={
			@JoinColumn(name="rightId")
			}
		, inverseJoinColumns={
			@JoinColumn(name="roleId")
			}
		)
	private List<Role> roles;

	public Right() {
	}
	
	public Right(String rightName, String rightDescription) {
		this.rightName = rightName;
		this.rightDescription = rightDescription;
	}

	public int getRightId() {
		return this.rightId;
	}

	public void setRightId(int rightId) {
		this.rightId = rightId;
	}

	public String getRightDescription() {
		return this.rightDescription;
	}

	public void setRightDescription(String rightDescription) {
		this.rightDescription = rightDescription;
	}

	public String getRightName() {
		return this.rightName;
	}

	public void setRightName(String rightName) {
		this.rightName = rightName;
	}

	public List<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}