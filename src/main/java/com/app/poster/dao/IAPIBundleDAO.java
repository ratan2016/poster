package com.app.poster.dao;

import java.util.List;

import com.app.poster.model.APIBundle;

public interface IAPIBundleDAO {
	void create(APIBundle apiBundle);

	void modify(APIBundle apiBundle);

	void delete(Integer id);

	APIBundle read(Integer id);

	List<APIBundle> readAll();
}
