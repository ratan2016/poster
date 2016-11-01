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

import com.app.poster.model.APIDocument;

@Repository("apiDocumentDAO")
public class APIDocumentDAOImpl implements IAPIDocumentDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void create(APIDocument apiDocument) {
		em.persist(apiDocument);
		em.flush();

	}

	@Override
	@Transactional
	public void modify(APIDocument apiDocument) {
		em.merge(apiDocument);

	}

	@Override
	@Transactional
	public void modifyWithContent(APIDocument apiDocument) {
		em.merge(apiDocument);

	}

	@Override
	@Transactional
	public void delete(Integer id) {
		APIDocument apiDocument = em.find(APIDocument.class, id);
		em.remove(apiDocument);

	}

	@Override
	public APIDocument read(Integer id) {
		return em.find(APIDocument.class, id);

	}

	@Override
	public List<APIDocument> readAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<APIDocument> cq = cb.createQuery(APIDocument.class);
		Root<APIDocument> rootEntry = cq.from(APIDocument.class);
		CriteriaQuery<APIDocument> all = cq.select(rootEntry);
		TypedQuery<APIDocument> allQuery = em.createQuery(all);
		return allQuery.getResultList();
	}

	@Override
	public List<APIDocument> readPerApplication(Integer apiBundleId) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<APIDocument> query = cb.createQuery(APIDocument.class);
		Root<APIDocument> rootEntry = query.from(APIDocument.class);
		query.where(cb.equal(rootEntry.get("API_BOX_ID"), apiBundleId));
		TypedQuery<APIDocument> allQuery = em.createQuery(query);
		return allQuery.getResultList();
	}

}
