package com.bootLogisticSystem.logic.dataReader;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bootLogisticSystem.entity.GenerateAble;
import com.bootLogisticSystem.entity.Request;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 * Parse xml file to obtain specific data.
 * @author Karol Łukasiewicz
 *
 */
public class XmlDataParser implements DataParser {

	private XmlMapper xmlMapper;
	
	/**
	 * Constructor
	 * @param xmlMapper
	 */
	public XmlDataParser(XmlMapper xmlMapper) {
		super();
		this.xmlMapper = xmlMapper;
	}

	@Override
	public <T extends GenerateAble> List<T> parse(File fileToParse)
			throws JsonParseException, JsonMappingException, IOException {
		
		return xmlMapper.readValue(fileToParse,
				new TypeReference<List<Request>>() {
				});
	}

}
