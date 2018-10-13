package com.bootLogisticSystem.logic.raportGenerator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bootLogisticSystem.dto.RequestDtoJacksonXml;
import com.bootLogisticSystem.entity.GenerateAble;
import com.bootLogisticSystem.entity.Request;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 * Class provide save report as xml file functionality.
 * @author Karol Łukasiewicz
 *
 */
@Component
public class XmlRaportWriter implements RaportWriter {
	
	@Autowired
	private XmlMapper xmlMapper;

	@Override
	public <T extends GenerateAble> void write(File file, List<T> data) throws JsonGenerationException, JsonMappingException, IOException {			
			xmlMapper.writeValue(file, data);			
	}

}