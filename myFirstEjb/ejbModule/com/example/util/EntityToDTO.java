package com.example.util;

import com.example.dto.IdentityDTO;
import com.example.dto.OrganizationDTO;
import com.example.dto.ResourceDTO;
import com.example.dto.RightDTO;
import com.example.dto.RoleDTO;
import com.example.dto.UserDTO;
import com.example.dto.UserRoleResourceDTO;

import java.util.ArrayList;
import java.util.List;

import com.bestdb.models.Identity;
import com.bestdb.models.Organisation;
import com.bestdb.models.Resource;
import com.bestdb.models.Right;
import com.bestdb.models.Role;
import com.bestdb.models.User;
import com.bestdb.models.UserRoleResource;

public class EntityToDTO {

	public UserDTO convertUser(User user) {
		UserDTO globalUserDTO = new UserDTO(user.getUsername(), user.getPassword());

		globalUserDTO.setId(user.getUserId());
		return globalUserDTO;

	}
	
	public UserDTO convertAllDetailsUser(User user) {
		UserDTO globalUserDTO = new UserDTO(user.getUsername(), user.getPassword());

		globalUserDTO.setId(user.getUserId());
		
		List<UserRoleResourceDTO> urrDTOs = new ArrayList<>();
		for (UserRoleResource urr : user.getUserRoleResources()) {
			urrDTOs.add(new UserRoleResourceDTO(user.getUserId(), urr.getRole().getRoleId(), urr.getResource().getResourceId(), urr.getRole().getRoleName(), urr.getResource().getUrl()));
		}
		
		globalUserDTO.setUserRoleResource(urrDTOs);
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

	public RightDTO convertRight(Right right) {
		RightDTO rightDTO = new RightDTO(right.getRightName(), right.getRightDescription());

		rightDTO.setRightId(right.getRightId());
		return rightDTO;

	}
	
	public RoleDTO convertRole(Role role) {
		RoleDTO roleDTO = new RoleDTO(role.getRoleName(), role.getRoleDescription());

		roleDTO.setRoleId(role.getRoleId());
		return roleDTO;

	}
	
	public ResourceDTO convertResource(Resource resource) {
		ResourceDTO resourceDTO = new ResourceDTO(resource.getAccessKey(), resource.getToken(), resource.getUrl());

		resourceDTO.setResourceId(resource.getResourceId());
		return resourceDTO;

	}
	
	public UserRoleResourceDTO convertUserRoleResource(UserRoleResource urr) {
		UserRoleResourceDTO userRoleResourceDTO = new UserRoleResourceDTO(urr.getUser().getUserId(), urr.getRole().getRoleId(), urr.getResource().getResourceId());

		userRoleResourceDTO.setId(urr.getId());
		return userRoleResourceDTO;

	}
}
