package com.app.poster.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity(name = "API_DOCUMENT")
public class APIDocument {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Integer id;
	@Column(name = "DOCUMENT_NAME")
	private String documentName;
	@Column(name = "DOCUMENT_DESCRIPTION")
	private String documentDescription;
	@Column(name = "DOCUMENT_CONTENT")
	private String documentContent;
	@Transient
	private Documentation documentation;
	@Column(name = "API_BOX_ID")
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
