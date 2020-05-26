package com.example.dao;

import javax.ejb.Remote;

import com.example.dto.OrganizationDTO;
import com.example.exception.OrganizationException;

@Remote
public interface OrganizationDAORemote extends GenericDAO<OrganizationDTO> {

	OrganizationDTO addNewOrganization(OrganizationDTO organizationDTO) throws OrganizationException;
}
