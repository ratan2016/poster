package com.app.poster.service;

import java.util.List;

import com.app.poster.model.APIBundle;
import com.app.poster.model.APIDocument;

public interface IAPIDocumentService {

	void create(APIDocument apiDocument);

	void modify(APIDocument apiDocument);

	void modifyWithContent(APIDocument apiDocument);

	void delete(APIDocument apiDocument);

	APIDocument read(APIDocument apiDocument);

	List<APIDocument> readAll();

	List<APIDocument> readPerApplication(APIBundle apiBundle);
}
