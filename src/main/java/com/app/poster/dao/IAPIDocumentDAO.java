package com.app.poster.dao;

import java.util.List;

import com.app.poster.model.APIBundle;
import com.app.poster.model.APIDocument;

public interface IAPIDocumentDAO {
	void create(APIDocument apiBundle);

	void modify(APIDocument apiBundle);

	void modifyWithContent(APIDocument apiBundle);

	void delete(APIDocument apiBundle);

	APIDocument read(APIDocument apiDocument);

	List<APIDocument> readAll();

	List<APIDocument> readPerApplication(APIBundle apiBundle);
}
