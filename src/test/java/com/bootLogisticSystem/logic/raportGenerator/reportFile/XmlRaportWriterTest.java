package com.bootLogisticSystem.logic.raportGenerator.reportFile;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bootLogisticSystem.entity.Request;
import com.bootLogisticSystem.exception.ImputFileEmpetyException;
import com.bootLogisticSystem.logic.dataReader.SingleFileReader;
import com.bootLogisticSystem.logic.mapper.MapperGenerator;
import com.bootLogisticSystem.logic.raportGenerator.raportFile.XmlRaportWriter;
import com.bootLogisticSystem.utils.RandomRequest;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class XmlRaportWriterTest {

	private static XmlRaportWriter xmlRaportWriter;
	
	@Autowired
	SingleFileReader singleFileReader;

	@BeforeClass
	public static void setUp() {
		xmlRaportWriter = new XmlRaportWriter(new MapperGenerator().xmlMapper());
	}

	@Test
	public void saveRaport() throws JsonGenerationException, JsonMappingException, IOException, ImputFileEmpetyException {

		File file = new File("src/test/testResources/testOutputFolder/out.xml");
		List<Request> requests = RandomRequest.generate(3);

		xmlRaportWriter.writeList(file, requests);
		
		List<Request> requestsFromFile = singleFileReader.parse(file, Request.class);
		
		assertThat(requests, is(equalTo(requestsFromFile)));
	}
}
