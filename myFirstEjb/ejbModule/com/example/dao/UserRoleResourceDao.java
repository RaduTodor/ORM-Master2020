package com.example.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.example.dao.UserRoleResourceDAORemote;
import com.example.dto.ChangePasswordDTO;
import com.example.dto.LoginDTO;
import com.example.dto.UserRoleResourceDTO;
import com.example.exception.ChangePasswordException;
import com.example.exception.LoginException;
import com.example.exception.NewRightException;
import com.example.exception.NewRoleException;
import com.example.util.DtoToEntity;
import com.example.util.EntityToDTO;
import com.bestdb.models.Organisation;
import com.bestdb.models.UserRoleResource;

/**
 * Session Bean implementation class UserRoleResourceDAO
 */
@Stateless
@LocalBean
public class UserRoleResourceDao implements UserRoleResourceDAORemote {

	static final Logger LOGGER = Logger.getLogger(UserRoleResourceDao.class.getName());

	@PersistenceContext
	private EntityManager entityManager;

	public UserRoleResourceDao() {

	}

	private EntityToDTO entityToDTO = new EntityToDTO();

	private DtoToEntity dtoToEntity = new DtoToEntity();

	@Override
	public UserRoleResourceDTO findById(int id) {
		UserRoleResource user = entityManager.find(UserRoleResource.class, id);
		UserRoleResourceDTO userDTO = entityToDTO.convertUserRoleResource(user);
		return userDTO;
	}

	@Override
	public List<UserRoleResourceDTO> findAll() {
		Query query = entityManager.createQuery("SELECT u FROM UserRoleResource u");
		@SuppressWarnings("unchecked")
		List<UserRoleResource> users = query.getResultList();
		System.out.println(users.toString());
		List<UserRoleResourceDTO> dtoUserRoleResources = new ArrayList<>();
		for (UserRoleResource user : users) {
			dtoUserRoleResources.add(entityToDTO.convertUserRoleResource(user));
		}
		return dtoUserRoleResources;
	}

	@Override
	public UserRoleResourceDTO create(UserRoleResourceDTO userDTO) {
		UserRoleResource user = dtoToEntity.convertUserRoleResource(userDTO);
		entityManager.persist(user);
		entityManager.flush();
		userDTO.setId(user.getId());
		return userDTO;
	}

	@Override
	public UserRoleResourceDTO update(UserRoleResourceDTO userDTO) {
		UserRoleResource user = dtoToEntity.convertUserRoleResource(userDTO);
		user.setId(userDTO.getId());
		user = entityManager.merge(user);
		return userDTO;
	}

	@Override
	public void delete(int id) {
		UserRoleResource user = entityManager.find(UserRoleResource.class, id);
		entityManager.remove(user);

	}

	@Override
	public UserRoleResourceDTO addNewCombination(UserRoleResourceDTO userRoleResourceDTO) throws NewRoleException {
		entityManager.persist(new UserRoleResource(userRoleResourceDTO.getUserId(), userRoleResourceDTO.getRoleId(), userRoleResourceDTO.getResourceId()));
		return userRoleResourceDTO;	
	}

}
