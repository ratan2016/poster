package com.app.poster.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.poster.model.APIBundle;

@Repository("apiBundleDAO")
public class APIBundleDAOImpl implements IAPIBundleDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void create(APIBundle apiBundle) {
		em.persist(apiBundle);
		em.flush();
	}

	@Override
	@Transactional
	public void modify(APIBundle apiBundle) {
		em.merge(apiBundle);

	}

	@Override
	@Transactional
	public void delete(Integer id) {
		APIBundle apiBundle = em.find(APIBundle.class, id);
		em.remove(apiBundle);

	}

	@Override
	public APIBundle read(Integer id) {
		return em.find(APIBundle.class, id);

	}

	@Override
	public List<APIBundle> readAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<APIBundle> cq = cb.createQuery(APIBundle.class);
		Root<APIBundle> rootEntry = cq.from(APIBundle.class);
		CriteriaQuery<APIBundle> all = cq.select(rootEntry);
		TypedQuery<APIBundle> allQuery = em.createQuery(all);
		return allQuery.getResultList();
	}


}
