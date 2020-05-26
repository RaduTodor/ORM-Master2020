package com.example.util;

import com.example.dto.OrganizationDTO;
import com.example.dto.UserDTO;
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

}
