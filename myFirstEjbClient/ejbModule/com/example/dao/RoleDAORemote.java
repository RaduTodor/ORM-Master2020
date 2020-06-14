package com.example.dao;

import javax.ejb.Remote;

import com.example.dto.RoleDTO;
import com.example.exception.NewRoleException;

@Remote
public interface RoleDAORemote extends GenericDAO<RoleDTO> {

	RoleDTO addNewRole(RoleDTO roleDTO) throws NewRoleException;
}
