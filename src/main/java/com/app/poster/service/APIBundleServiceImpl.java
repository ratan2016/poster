package com.app.poster.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.poster.dao.IAPIBundleDAO;
import com.app.poster.model.APIBundle;

@Component("apiBundleService")
public class APIBundleServiceImpl implements IAPIBundleService {

	@Autowired
	private IAPIBundleDAO apiBundleDAO;

	public IAPIBundleDAO getApiBundleDAOImpl() {
		return apiBundleDAO;
	}

	public void setApiBundleDAOImpl(IAPIBundleDAO apiBundleDAOImpl) {
		this.apiBundleDAO = apiBundleDAOImpl;
	}

	@Override
	public void create(APIBundle apiBundle) {
		apiBundleDAO.create(apiBundle);

	}

	@Override
	public void modify(APIBundle apiBundle) {
		apiBundleDAO.modify(apiBundle);

	}

	@Override
	public void delete(APIBundle apiBundle) {
		apiBundleDAO.delete(apiBundle.getId());

	}

	@Override
	public APIBundle read(APIBundle apiBundle) {
		return apiBundleDAO.read(apiBundle.getId());
	}

	@Override
	public List<APIBundle> readAll() {
		return apiBundleDAO.readAll();

	}

}
