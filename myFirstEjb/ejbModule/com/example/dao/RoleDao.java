package com.example.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.example.dto.RoleDTO;
import com.example.exception.NewRoleException;
import com.example.util.DtoToEntity;
import com.example.util.EntityToDTO;
import com.bestdb.models.Role;

/**
 * Session Bean implementation class RoleDAO
 */
@Stateless
@LocalBean
public class RoleDao implements RoleDAORemote {

	static final Logger LOGGER = Logger.getLogger(RoleDao.class.getName());

	@PersistenceContext
	private EntityManager entityManager;

	public RoleDao() {

	}

	private EntityToDTO entityToDTO = new EntityToDTO();

	private DtoToEntity dtoToEntity = new DtoToEntity();

	@Override
	public List<RoleDTO> findAll() {
		Query query = entityManager.createQuery("SELECT r FROM Role r");
		@SuppressWarnings("unchecked")
		List<Role> Roles = query.getResultList();
		System.out.println(Roles.toString());
		List<RoleDTO> dtoRoles = new ArrayList<>();
		for (Role role : Roles) {
			dtoRoles.add(entityToDTO.convertRole(role));
		}
		return dtoRoles;
	}

	@Override
	public RoleDTO findById(int id) {
		Role Role = entityManager.find(Role.class, id);
		RoleDTO RoleDTO = entityToDTO.convertRole(Role);
		return RoleDTO;
	}

	@Override
	public RoleDTO create(RoleDTO entity) {
		Role role = dtoToEntity.convertRole(entity);
		entityManager.persist(role);
		entityManager.flush();
		entity.setRoleId(role.getRoleId());
		return entity;
	}

	@Override
	public RoleDTO update(RoleDTO entity) {
		Role role = dtoToEntity.convertRole(entity);
		role.setRoleId(entity.getRoleId());
		role = entityManager.merge(role);
		return entity;
	}

	@Override
	public RoleDTO addNewRole(RoleDTO RoleDTO) throws NewRoleException {
		entityManager.persist(new Role(RoleDTO.getRoleName(), RoleDTO.getRoleDescription()));
		return RoleDTO;	
	}

	@Override
	public void delete(int id) {
		Role role = entityManager.find(Role.class, id);
		entityManager.remove(role);
	}

}
