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

import com.example.dto.RightDTO;
import com.example.exception.NewRightException;
import com.example.util.DtoToEntity;
import com.example.util.EntityToDTO;
import com.bestdb.models.Right;

/**
 * Session Bean implementation class RightDAO
 */
@Stateless
@LocalBean
public class RightDao implements RightDAORemote {

	static final Logger LOGGER = Logger.getLogger(RightDao.class.getName());

	@PersistenceContext
	private EntityManager entityManager;

	public RightDao() {

	}

	private EntityToDTO entityToDTO = new EntityToDTO();

	private DtoToEntity dtoToEntity = new DtoToEntity();

	@Override
	public List<RightDTO> findAll() {
		Query query = entityManager.createQuery("SELECT r FROM Right r");
		@SuppressWarnings("unchecked")
		List<Right> Rights = query.getResultList();
		System.out.println(Rights.toString());
		List<RightDTO> dtoRights = new ArrayList<>();
		for (Right Right : Rights) {
			dtoRights.add(entityToDTO.convertRight(Right));
		}
		return dtoRights;
	}

	@Override
	public RightDTO findById(int id) {
		Right Right = entityManager.find(Right.class, id);
		RightDTO RightDTO = entityToDTO.convertRight(Right);
		return RightDTO;
	}

	@Override
	public RightDTO create(RightDTO entity) {
		Right Right = dtoToEntity.convertRight(entity);
		entityManager.persist(Right);
		entityManager.flush();
		entity.setRightId(Right.getRightId());
		return entity;
	}

	@Override
	public RightDTO update(RightDTO entity) {
		Right Right = dtoToEntity.convertRight(entity);
		Right.setRightId(entity.getRightId());
		Right = entityManager.merge(Right);
		return entity;
	}

	@Override
	public RightDTO addNewRight(RightDTO RightDTO) throws NewRightException {
		entityManager.persist(new Right(RightDTO.getRightName(), RightDTO.getRightDescription()));
		return RightDTO;	
	}

	@Override
	public void delete(int id) {
		Right Right = entityManager.find(Right.class, id);
		entityManager.remove(Right);
	}

}
