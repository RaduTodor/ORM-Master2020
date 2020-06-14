package com.example.dao;

import javax.ejb.Remote;

import com.example.dto.ResourceDTO;
import com.example.exception.NewResourceException;

@Remote
public interface ResourceDAORemote extends GenericDAO<ResourceDTO> {

	ResourceDTO addNewResource(ResourceDTO resourceDTO) throws NewResourceException;
}
