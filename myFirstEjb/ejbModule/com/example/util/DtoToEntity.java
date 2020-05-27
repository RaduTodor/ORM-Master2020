package com.example.util;

import com.example.dto.IdentityDTO;
import com.example.dto.OrganizationDTO;
import com.example.dto.UserDTO;
import com.bestdb.models.Identity;
import com.bestdb.models.Organisation;
import com.bestdb.models.User;

public class DtoToEntity {

	// all classes doesn't take primary key in account

	public User convertUser(UserDTO userDTO) {
		User user = new User(userDTO.getUsername(), userDTO.getPassword());

		return user;
	}

	public Organisation convertOrganization(OrganizationDTO orgDTO) {
		Organisation organisation = new Organisation(orgDTO.getName(), orgDTO.getCui());

		return organisation;
	}
	
	public Identity convertIdentity(IdentityDTO identityDTO) {
		Identity identity = new Identity(identityDTO.getFirstname(), identityDTO.getLastname(), identityDTO.getOrganisationId());

		return identity;
	}
}
