package com.example.util;

import com.example.dto.IdentityDTO;
import com.example.dto.OrganizationDTO;
import com.example.dto.ResourceDTO;
import com.example.dto.RightDTO;
import com.example.dto.RoleDTO;
import com.example.dto.UserDTO;
import com.example.dto.UserRoleResourceDTO;
import com.bestdb.models.Identity;
import com.bestdb.models.Organisation;
import com.bestdb.models.Resource;
import com.bestdb.models.Drept;
import com.bestdb.models.Role;
import com.bestdb.models.User;
import com.bestdb.models.UserRoleResource;

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
	
	public Drept convertRight(RightDTO rightDTO) {
		Drept right = new Drept(rightDTO.getRightName(), rightDTO.getRightDescription());

		return right;
	}
	
	public Role convertRole(RoleDTO roleDTO) {
		Role role = new Role(roleDTO.getRoleName(), roleDTO.getRoleDescription());

		return role;
	}
	
	public Resource convertResource(ResourceDTO resourceDTO) {
		Resource resource = new Resource(resourceDTO.getAccessKey(), resourceDTO.getToken(), resourceDTO.getUrl());

		return resource;
	}
	
	public UserRoleResource convertUserRoleResource(UserRoleResourceDTO userRoleResourceDTO) {
		UserRoleResource userRoleResource = new UserRoleResource(userRoleResourceDTO.getUserId(), userRoleResourceDTO.getRoleId(), userRoleResourceDTO.getResourceId());

		return userRoleResource;
	}
}
