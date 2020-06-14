package com.example.dao;

import javax.ejb.Remote;

import com.example.dto.UserRoleResourceDTO;
import com.example.exception.NewRoleException;

@Remote
public interface UserRoleResourceDAORemote extends GenericDAO<UserRoleResourceDTO> {

	UserRoleResourceDTO addNewCombination(UserRoleResourceDTO userRoleResourceDTO) throws NewRoleException;
}
