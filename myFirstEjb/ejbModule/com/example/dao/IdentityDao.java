package com.example.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.example.dto.IdentityDTO;
import com.example.exception.IdentityException;
import com.example.util.DtoToEntity;
import com.example.util.EntityToDTO;
import com.bestdb.models.Identity;
import com.bestdb.models.Organisation;

/**
 * Session Bean implementation class IdentityDAO
 */
@Stateless
@LocalBean
public class IdentityDao implements IdentityDAORemote {

	static final Logger LOGGER = Logger.getLogger(IdentityDao.class.getName());

	@PersistenceContext
	private EntityManager entityManager;

	public IdentityDao() {

	}

	private EntityToDTO entityToDTO = new EntityToDTO();

	private DtoToEntity dtoToEntity = new DtoToEntity();

	@Override
	public List<IdentityDTO> findAll() {
		Query query = entityManager.createQuery("SELECT i FROM Identity i");
		@SuppressWarnings("unchecked")
		List<Identity> Identitys = query.getResultList();
		System.out.println(Identitys.toString());
		List<IdentityDTO> dtoIdentitys = new ArrayList<>();
		for (Identity identity : Identitys) {
			dtoIdentitys.add(entityToDTO.convertIdentity(identity));
		}
		return dtoIdentitys;
	}

	@Override
	public IdentityDTO findById(int id) {
		Identity Identity = entityManager.find(Identity.class, id);
		IdentityDTO IdentityDTO = entityToDTO.convertIdentity(Identity);
		return IdentityDTO;
	}

	@Override
	public IdentityDTO create(IdentityDTO entity) {
		Identity identity = dtoToEntity.convertIdentity(entity);
		entityManager.persist(identity);
		entityManager.flush();
		entity.setId(identity.getIdentityId());
		return entity;
	}

	@Override
	public IdentityDTO update(IdentityDTO entity) {
		Identity identity = dtoToEntity.convertIdentity(entity);
		identity.setIdentityId(entity.getId());
		identity = entityManager.merge(identity);
		return entity;
	}

	@Override
	public IdentityDTO registerNewIdentity(IdentityDTO IdentityDTO) throws IdentityException {
		entityManager.persist(new Identity(IdentityDTO.getFirstname(), IdentityDTO.getLastname(), IdentityDTO.getOrganisationId()));
		return IdentityDTO;	
	}

	@Override
	public void delete(int id) {
		Identity identity = entityManager.find(Identity.class, id);
		entityManager.remove(identity);
	}

	@Override
	public List<IdentityDTO> findAllNotYetRegistered() throws IdentityException {
		Query query = entityManager.createNativeQuery("call bestdb.get_all_unregistered_identities()");
		@SuppressWarnings("unchecked")
		List<Object> result = (List<Object>) query.getResultList(); 
		Iterator itr = result.iterator();
		List<Identity> Identitys = new ArrayList<Identity>();
		while(itr.hasNext()){
		   Object[] obj = (Object[]) itr.next();
		   Identity newIdentity = new Identity();
		   newIdentity.setFirstname(String.valueOf(obj[2]));
		   newIdentity.setIdentityId(Integer.parseInt(String.valueOf(obj[0])));
		   newIdentity.setLastname(String.valueOf(obj[3]));
		   Organisation org = new Organisation();
		   org.setOrganisationId(Integer.parseInt(String.valueOf(obj[1])));
		   newIdentity.setOrganisation(org);
		   Identitys.add(newIdentity);
		}
		List<IdentityDTO> dtoIdentitys = new ArrayList<>();
		for (Identity identity : Identitys) {
			dtoIdentitys.add(entityToDTO.convertIdentity(identity));
		}
		return dtoIdentitys;
	}

}
