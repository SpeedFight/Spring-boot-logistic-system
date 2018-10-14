package com.bootLogisticSystem.model.raportTemplates;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.bootLogisticSystem.entity.GenerateAble;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"description", "value"})
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class OneValueReport implements GenerateAble{
	
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

	public void setDescription(String description) {
		this.description = description;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	};
}
