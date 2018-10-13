package com.bootLogisticSystem.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import com.bootLogisticSystem.entity.GenerateAble;
import com.bootLogisticSystem.entity.Request;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * Data transfer object to serialise object with correct element name.
 * 
 * @author speedfight
 *
 */
@JacksonXmlRootElement(localName = "requests")
public class RequestDtoJacksonXml implements GenerateAble {
	// look at me, now I generate correct elements tag in xml
	
	@JsonProperty
	@JacksonXmlProperty(localName = "request")
	@JacksonXmlElementWrapper(useWrapping = false)
	private List<Request> requests;

	private RequestDtoJacksonXml() {};

	public static RequestDtoJacksonXml toDto(List<Request> oryginalRequests) {
		RequestDtoJacksonXml requestDtoJacksonXml = new RequestDtoJacksonXml();
		requestDtoJacksonXml.requests = oryginalRequests;
		return requestDtoJacksonXml;
	}

	public List<Request> getRequests() {
		return requests;
	}

}