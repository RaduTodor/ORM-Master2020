package com.example.util;

import com.example.dto.IdentityDTO;
import com.example.dto.OrganizationDTO;
import com.example.dto.UserDTO;
import com.bestdb.models.Identity;
import com.bestdb.models.Organisation;
import com.bestdb.models.User;

public class EntityToDTO {

	public UserDTO convertUser(User user) {
		UserDTO globalUserDTO = new UserDTO(user.getUsername(), user.getPassword());

		globalUserDTO.setId(user.getUserId());
		return globalUserDTO;

	}
	
	public OrganizationDTO convertOrganization(Organisation organization) {
		OrganizationDTO orgDTO = new OrganizationDTO(organization.getOrganisationName(), organization.getCui());

		orgDTO.setId(organization.getOrganisationId());
		return orgDTO;

	}
	
	public IdentityDTO convertIdentity(Identity identity) {
		IdentityDTO identityDTO = new IdentityDTO(identity.getFirstname(), identity.getLastname(), identity.getOrganisation().getOrganisationId());

		identityDTO.setId(identity.getIdentityId());
		return identityDTO;

	}

}
