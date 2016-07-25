package com.app.poster.model;

import java.util.Set;
import java.util.TreeSet;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "documentation")
@XmlType(name = "", propOrder = { "id", "documentName", "sections" })
public class Documentation {

	private Integer id;
	private String documentName;
	private Set<Section> sections = new TreeSet<Section>();

	public Integer getId() {
		return id;
	}

	@XmlElement(name = "id")
	public void setId(Integer id) {
		this.id = id;
	}

	public String getDocumentName() {
		return documentName;
	}

	@XmlElement(name = "documentName")
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public Set<Section> getSections() {

		return sections;
	}

	@XmlElement(name = "section")
	public void setSections(Set<Section> sections) {
		this.sections = sections;
	}

}
