package com.app.poster.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "API_BOX")
public class APIBundle {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Integer id;
	@Column(name = "BUNDLE_NAME")
	private String bundleName;
	@Column(name = "BUNDLE_DESCRIPTION")
	private String bundleDescription;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBundleName() {
		return bundleName;
	}

	public void setBundleName(String bundleName) {
		this.bundleName = bundleName;
	}

	public String getBundleDescription() {
		return bundleDescription;
	}

	public void setBundleDescription(String bundleDescription) {
		this.bundleDescription = bundleDescription;
	}

}
