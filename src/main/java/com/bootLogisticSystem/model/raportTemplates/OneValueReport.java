package com.bootLogisticSystem.model.raportTemplates;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.bootLogisticSystem.entity.GenerateAble;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonPropertyOrder({"description", "value"})
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class OneValueReport extends GenerateAble{
	
	private String description;
	private String value;

	public OneValueReport() {}

	public OneValueReport(String description, String value) {
		super();
		this.description = description;
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	@JsonSetter("description")
	public void setDescription(String description) {
		this.description = description;
	}

	public String getValue() {
		return value;
	}

	@JsonSetter("value")
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		OneValueReport other = (OneValueReport) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OneValueReport [description=" + description + ", value=" + value + "]";
	}
}
