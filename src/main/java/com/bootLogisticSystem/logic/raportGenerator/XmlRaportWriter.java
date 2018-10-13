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

	@SuppressWarnings("unchecked")
	@Override
	public <T extends GenerateAble> void write(File file, List<T> data) {
			
		try {
			
			if (data.get(0) instanceof Request) {	
				//bad looking work around because otherwise xml will have elements like
				//<arrayList> <item> ... not <requests> <request> ...
				xmlMapper.writeValue(file, RequestDtoJacksonXml.toDto((List<Request>) data));		
			} else {				
				xmlMapper.writeValue(file, data);			
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}