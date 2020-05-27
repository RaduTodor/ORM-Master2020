package com.example.dao;

import java.util.List;

import javax.ejb.Remote;

import com.example.dto.IdentityDTO;
import com.example.exception.IdentityException;

@Remote
public interface IdentityDAORemote extends GenericDAO<IdentityDTO> {

	IdentityDTO registerNewIdentity(IdentityDTO identityDTO) throws IdentityException;
	
	List<IdentityDTO> findAllNotYetRegistered() throws IdentityException;
}
