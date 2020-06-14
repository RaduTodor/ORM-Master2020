package com.example.dao;

import java.util.List;

import javax.ejb.Remote;

import com.example.dto.ChangePasswordDTO;
import com.example.dto.IdentityDTO;
import com.example.dto.LoginDTO;
import com.example.dto.RightDTO;
import com.example.dto.RoleDTO;
import com.example.dto.UserDTO;
import com.example.exception.ChangePasswordException;
import com.example.exception.IdentityException;
import com.example.exception.LoginException;
import com.example.exception.NewRightException;
import com.example.exception.NewUserException;

@Remote
public interface RightRoleDAORemote{

	List<RightDTO> getAllRights() throws NewRightException;
		
	List<RoleDTO> getAllUnusedRoles() throws NewRightException;
	
	List<RoleDTO> getAllRoles() throws NewRightException;
	
	void addNewRightRoleRelation(int rightId, int roleId) throws NewRightException;
}
