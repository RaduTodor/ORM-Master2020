package com.bestdb.models;

import java.io.Serializable;
import javax.persistence.*;

import com.example.dao.OrganizationDao;
import com.example.util.DtoToEntity;

import java.util.List;


/**
 * The persistent class for the identity database table.
 * 
 */
@Entity
@NamedQuery(name="Identity.findAll", query="SELECT i FROM Identity i")
public class Identity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int identityId;

	private String firstname;

	private String lastname;

	//bi-directional many-to-one association to Organisation
	@ManyToOne
	@JoinColumn(name="organisationId")
	private Organisation organisation;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="identity")
	private List<User> users;

	public Identity() {
	}
	
	public Identity(String firstname, String lastname, int organisationId) {
		this.firstname = firstname;
		this.lastname = lastname;
		Organisation org = new Organisation();
		org.setOrganisationId(organisationId);
		this.organisation = org;
	}

	public int getIdentityId() {
		return this.identityId;
	}

	public void setIdentityId(int identityId) {
		this.identityId = identityId;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Organisation getOrganisation() {
		return this.organisation;
	}

	public void setOrganisation(Organisation organisation) {
		this.organisation = organisation;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setIdentity(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setIdentity(null);

		return user;
	}

}