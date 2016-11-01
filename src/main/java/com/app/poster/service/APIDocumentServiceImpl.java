package com.app.poster.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.poster.dao.IAPIDocumentDAO;
import com.app.poster.model.APIBundle;
import com.app.poster.model.APIDocument;

@Component("apiDocumentService")
public class APIDocumentServiceImpl implements IAPIDocumentService {

	@Autowired
	private IAPIDocumentDAO apiDocumentDAO;

	public IAPIDocumentDAO getApiBundleDAOImpl() {
		return apiDocumentDAO;
	}

	public void setApiBundleDAOImpl(IAPIDocumentDAO apiDocumentDAOImpl) {
		this.apiDocumentDAO = apiDocumentDAOImpl;
	}

	@Override
	public void create(APIDocument apiDocument) {
		apiDocumentDAO.create(apiDocument);

	}

	@Override
	public void modifyWithContent(APIDocument apiDocument) {
		
		apiDocumentDAO.modifyWithContent(apiDocument);

	}
	
	@Override
	public void modify(APIDocument apiDocument) {
		apiDocumentDAO.modify(apiDocument);

	}

	@Override
	public void delete(APIDocument apiDocument) {
		apiDocumentDAO.delete(apiDocument.getId());

	}

	@Override
	public APIDocument read(APIDocument apiDocument) {
		return apiDocumentDAO.read(apiDocument.getId());
	}

	@Override
	public List<APIDocument> readAll() {
		return apiDocumentDAO.readAll();

	}

	@Override
	public List<APIDocument> readPerApplication(APIBundle apiBundle) {
		
		return apiDocumentDAO.readPerApplication(apiBundle.getId());
	}

}
