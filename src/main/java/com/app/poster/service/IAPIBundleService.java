package com.app.poster.service;

import java.util.List;

import com.app.poster.model.APIBundle;

public interface IAPIBundleService {

	void create(APIBundle apiBundle);

	void modify(APIBundle apiBundle);

	void delete(APIBundle apiBundle);

	APIBundle read(APIBundle apiBundle);

	List<APIBundle> readAll();
}
