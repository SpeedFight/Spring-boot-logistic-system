package com.bootLogisticSystem.logic.raportGenerator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.bootLogisticSystem.dto.RequestDtoJacksonXml;
import com.bootLogisticSystem.entity.GenerateAble;
import com.bootLogisticSystem.entity.Request;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

@Component
public class XmlRaportWriter implements RaportWriter {
	

	@Override
	public <T extends GenerateAble> void write(File file, List<T> data) {
		
		
		
		try {
			XmlMapper xmlMapper = new XmlMapper();
//			xmlMapper.writeValue(file, data);
			xmlMapper.writeValue(file, RequestDtoJacksonXml.toDto((List<Request>) data));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}