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

import com.example.dto.ResourceDTO;
import com.example.exception.NewResourceException;
import com.example.util.DtoToEntity;
import com.example.util.EntityToDTO;
import com.bestdb.models.Resource;

/**
 * Session Bean implementation class ResourceDAO
 */
@Stateless
@LocalBean
public class ResourceDao implements ResourceDAORemote {

	static final Logger LOGGER = Logger.getLogger(ResourceDao.class.getName());

	@PersistenceContext
	private EntityManager entityManager;

	public ResourceDao() {

	}

	private EntityToDTO entityToDTO = new EntityToDTO();

	private DtoToEntity dtoToEntity = new DtoToEntity();

	@Override
	public List<ResourceDTO> findAll() {
		Query query = entityManager.createQuery("SELECT r FROM Resource r");
		@SuppressWarnings("unchecked")
		List<Resource> Resources = query.getResultList();
		System.out.println(Resources.toString());
		List<ResourceDTO> dtoResources = new ArrayList<>();
		for (Resource Resource : Resources) {
			dtoResources.add(entityToDTO.convertResource(Resource));
		}
		return dtoResources;
	}

	@Override
	public ResourceDTO findById(int id) {
		Resource Resource = entityManager.find(Resource.class, id);
		ResourceDTO ResourceDTO = entityToDTO.convertResource(Resource);
		return ResourceDTO;
	}

	@Override
	public ResourceDTO create(ResourceDTO entity) {
		Resource Resource = dtoToEntity.convertResource(entity);
		entityManager.persist(Resource);
		entityManager.flush();
		entity.setResourceId(Resource.getResourceId());
		return entity;
	}

	@Override
	public ResourceDTO update(ResourceDTO entity) {
		Resource Resource = dtoToEntity.convertResource(entity);
		Resource.setResourceId(entity.getResourceId());
		Resource = entityManager.merge(Resource);
		return entity;
	}

	@Override
	public ResourceDTO addNewResource(ResourceDTO resourceDTO) throws NewResourceException {
		entityManager.persist(new Resource(resourceDTO.getAccessKey(), resourceDTO.getToken(), resourceDTO.getUrl()));
		return resourceDTO;	
	}

	@Override
	public void delete(int id) {
		Resource Resource = entityManager.find(Resource.class, id);
		entityManager.remove(Resource);
	}

}
