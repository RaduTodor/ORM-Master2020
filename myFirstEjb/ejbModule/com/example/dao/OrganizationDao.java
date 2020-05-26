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

import com.example.dto.OrganizationDTO;
import com.example.exception.OrganizationException;
import com.example.util.DtoToEntity;
import com.example.util.EntityToDTO;
import com.bestdb.models.Organisation;

/**
 * Session Bean implementation class OrganizationDAO
 */
@Stateless
@LocalBean
public class OrganizationDao implements OrganizationDAORemote {

	static final Logger LOGGER = Logger.getLogger(OrganizationDao.class.getName());

	@PersistenceContext
	private EntityManager entityManager;

	public OrganizationDao() {

	}

	private EntityToDTO entityToDTO = new EntityToDTO();

	private DtoToEntity dtoToEntity = new DtoToEntity();

	@Override
	public List<OrganizationDTO> findAll() {
		Query query = entityManager.createQuery("SELECT o FROM Organisation o");
		@SuppressWarnings("unchecked")
		List<Organisation> organizations = query.getResultList();
		System.out.println(organizations.toString());
		List<OrganizationDTO> dtoOrganizations = new ArrayList<>();
		for (Organisation org : organizations) {
			dtoOrganizations.add(entityToDTO.convertOrganization(org));
		}
		return dtoOrganizations;
	}

	@Override
	public OrganizationDTO findById(int id) {
		Organisation organization = entityManager.find(Organisation.class, id);
		OrganizationDTO organizationDTO = entityToDTO.convertOrganization(organization);
		return organizationDTO;
	}

	@Override
	public OrganizationDTO create(OrganizationDTO entity) {
		Organisation org = dtoToEntity.convertOrganization(entity);
		entityManager.persist(org);
		entityManager.flush();
		entity.setId(org.getOrganisationId());
		return entity;
	}

	@Override
	public OrganizationDTO update(OrganizationDTO entity) {
		Organisation org = dtoToEntity.convertOrganization(entity);
		org.setOrganisationId(entity.getId());
		org = entityManager.merge(org);
		return entity;
	}

	@Override
	public OrganizationDTO addNewOrganization(OrganizationDTO organizationDTO) throws OrganizationException {
		entityManager.persist(new Organisation(organizationDTO.getName(), organizationDTO.getCui()));
		return organizationDTO;	
	}

	@Override
	public void delete(int id) {
		Organisation org = entityManager.find(Organisation.class, id);
		entityManager.remove(org);
	}

}
