package com.example.dao;

import javax.ejb.Remote;

import com.example.dto.RightDTO;
import com.example.exception.NewRightException;

@Remote
public interface RightDAORemote extends GenericDAO<RightDTO> {

	RightDTO addNewRight(RightDTO rightDTO) throws NewRightException;
}
