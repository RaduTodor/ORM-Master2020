package com.bestdb.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the organisation database table.
 * 
 */
@Entity
@NamedQuery(name="Organisation.findAll", query="SELECT o FROM Organisation o")
public class Organisation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int organisationId;

	private String cui;

	private String organisationName;

	//bi-directional many-to-one association to Identity
	@OneToMany(mappedBy="organisation")
	private List<Identity> identities;

	public Organisation() {
	}
	
	public Organisation(String name, String cui) {
		this.organisationName = name;
		this.cui = cui;
	}

	public int getOrganisationId() {
		return this.organisationId;
	}

	public void setOrganisationId(int organisationId) {
		this.organisationId = organisationId;
	}

	public String getCui() {
		return this.cui;
	}

	public void setCui(String cui) {
		this.cui = cui;
	}

	public String getOrganisationName() {
		return this.organisationName;
	}

	public void setOrganisationName(String organisationName) {
		this.organisationName = organisationName;
	}

	public List<Identity> getIdentities() {
		return this.identities;
	}

	public void setIdentities(List<Identity> identities) {
		this.identities = identities;
	}

	public Identity addIdentity(Identity identity) {
		getIdentities().add(identity);
		identity.setOrganisation(this);

		return identity;
	}

	public Identity removeIdentity(Identity identity) {
		getIdentities().remove(identity);
		identity.setOrganisation(null);

		return identity;
	}

}