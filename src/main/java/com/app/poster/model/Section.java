package com.app.poster.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "section")
@XmlType(name = "", propOrder = { "id", "sectionName", "sectionDetail",
		"sectionOrder" })
public class Section implements Comparable<Section>{
	private Integer id;
	private String sectionName;
	private String sectionDetail;
	private Integer sectionOrder;

	public Integer getId() {
		return id;
	}

	@XmlElement(name = "id")
	public void setId(Integer id) {
		this.id = id;
	}

	public String getSectionName() {
		return sectionName;
	}

	@XmlElement(name = "name")
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((sectionDetail == null) ? 0 : sectionDetail.hashCode());
		result = prime * result
				+ ((sectionName == null) ? 0 : sectionName.hashCode());
		result = prime * result
				+ ((sectionOrder == null) ? 0 : sectionOrder.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Section other = (Section) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (sectionDetail == null) {
			if (other.sectionDetail != null)
				return false;
		} else if (!sectionDetail.equals(other.sectionDetail))
			return false;
		if (sectionName == null) {
			if (other.sectionName != null)
				return false;
		} else if (!sectionName.equals(other.sectionName))
			return false;
		if (sectionOrder == null) {
			if (other.sectionOrder != null)
				return false;
		} else if (!sectionOrder.equals(other.sectionOrder))
			return false;
		return true;
	}

	public String getSectionDetail() {
		return sectionDetail;
	}

	@XmlElement(name = "detail")
	public void setSectionDetail(String sectionDetail) {
		this.sectionDetail = sectionDetail;
	}

	public Integer getSectionOrder() {
		return sectionOrder;
	}

	@XmlElement(name = "order")
	public void setSectionOrder(Integer sectionOrder) {
		this.sectionOrder = sectionOrder;
	}

	@Override
	public int compareTo(Section section) {
		return section.getSectionOrder().compareTo(this.getSectionOrder())*-1;
	}

}
