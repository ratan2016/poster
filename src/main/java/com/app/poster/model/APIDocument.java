package com.app.poster.model;

import java.io.StringWriter;

import com.mysql.jdbc.Clob;

public class APIDocument {

	private Integer id;
	private String documentName;
	private String documentDescription;
	private String documentContent;
	private Documentation documentation;
	private Integer bundleId;

	public Integer getBundleId() {
		return bundleId;
	}

	public void setBundleId(Integer bundleId) {
		this.bundleId = bundleId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public String getDocumentDescription() {
		return documentDescription;
	}

	public void setDocumentDescription(String documentDescription) {
		this.documentDescription = documentDescription;
	}

	public String getDocumentContent() {
		return documentContent;
	}

	public void setDocumentContent(String string) {
		this.documentContent = string;
	}

	public Documentation getDocumentation() {
		return documentation;
	}

	public void setDocumentation(Documentation documentation) {
		this.documentation = documentation;
	}

}
