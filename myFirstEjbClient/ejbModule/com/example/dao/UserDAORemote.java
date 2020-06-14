package com.example.dao;

import java.util.List;

import javax.ejb.Remote;

import com.example.dto.ChangePasswordDTO;
import com.example.dto.LoginDTO;
import com.example.dto.UserDTO;
import com.example.exception.ChangePasswordException;
import com.example.exception.LoginException;
import com.example.exception.NewUserException;

@Remote
public interface UserDAORemote extends GenericDAO<UserDTO> {

	UserDTO loginUser(LoginDTO loginDTO) throws LoginException;

	UserDTO addNewUser(UserDTO userDTO) throws NewUserException;
	
	Boolean updatePassword(ChangePasswordDTO changePasswordDTO) throws ChangePasswordException;

	List<UserDTO> findAllWithDetails();
}
