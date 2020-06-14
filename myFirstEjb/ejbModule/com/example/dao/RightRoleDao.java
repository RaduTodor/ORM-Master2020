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

import com.example.dao.UserDAORemote;
import com.example.dto.ChangePasswordDTO;
import com.example.dto.LoginDTO;
import com.example.dto.RightDTO;
import com.example.dto.RoleDTO;
import com.example.dto.UserDTO;
import com.example.exception.ChangePasswordException;
import com.example.exception.LoginException;
import com.example.exception.NewRightException;
import com.example.exception.NewUserException;
import com.example.util.DtoToEntity;
import com.example.util.EntityToDTO;
import com.bestdb.models.Organisation;
import com.bestdb.models.Drept;
import com.bestdb.models.Role;
import com.bestdb.models.User;

/**
 * Session Bean implementation class UserDAO
 */
@Stateless
@LocalBean
public class RightRoleDao implements RightRoleDAORemote {

	static final Logger LOGGER = Logger.getLogger(RightRoleDao.class.getName());

	@PersistenceContext
	private EntityManager entityManager;

	public RightRoleDao() {

	}

	private EntityToDTO entityToDTO = new EntityToDTO();

	private DtoToEntity dtoToEntity = new DtoToEntity();

	@Override
	public List<RightDTO> getAllRights() {
		Query query = entityManager.createQuery("SELECT r FROM Drept r");
		@SuppressWarnings("unchecked")
		List<Drept> Rights = query.getResultList();
		System.out.println(Rights.toString());
		List<RightDTO> dtoRights = new ArrayList<>();
		for (Drept Right : Rights) {
			dtoRights.add(entityToDTO.convertRight(Right));
		}
		return dtoRights;
	}
	
	@Override
	public List<RoleDTO> getAllRoles() {
		Query query = entityManager.createQuery("SELECT r FROM Role r");
		@SuppressWarnings("unchecked")
		List<Role> Roles = query.getResultList();
		System.out.println(Roles.toString());
		List<RoleDTO> dtoRoles = new ArrayList<>();
		for (Role Role : Roles) {
			dtoRoles.add(entityToDTO.convertRole(Role));
		}
		return dtoRoles;
	}

	@Override
	public void addNewRightRoleRelation(int rightId, int roleId) throws NewRightException {
		entityManager.createNativeQuery("INSERT INTO Right_Role (roleId, rightId) VALUES (?,?)")
				.setParameter(1, roleId)
			    .setParameter(2, rightId)
			    .executeUpdate();
	}
	
	@Override
	public List<RoleDTO> getAllUnusedRoles() {
		Query query = entityManager.createQuery("SELECT r FROM Role r where r.roleId not in (SELECT rr.roleId from Right_Role rr)"); 
		@SuppressWarnings("unchecked")
		List<Role> Roles = query.getResultList();
		System.out.println(Roles.toString());
		List<RoleDTO> dtoRoles = new ArrayList<>();
		for (Role Role : Roles) {
			dtoRoles.add(entityToDTO.convertRole(Role));
		}
		return dtoRoles;
	}
}
