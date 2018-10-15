/*
 * Copyright (c) 2018 Karol Łukasiewicz
 *
 * @author Karol Łukasiewicz
 * @date 15 Oct 2018
 * 
 */
package com.bootLogisticSystem.logic.raportGenerator.reportFile;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bootLogisticSystem.exception.SaveOutputFileException;
import com.bootLogisticSystem.logic.raportGenerator.RaportFileGenerator;
import com.bootLogisticSystem.model.InputArgument;
import com.bootLogisticSystem.model.RaportType;
import com.bootLogisticSystem.model.ReasultsContainer;
import com.bootLogisticSystem.model.raportTemplates.OneValueReport;
import com.bootLogisticSystem.utils.ReadSingle;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RaportFileGeneratorTest {

	@Autowired
	private RaportFileGenerator raportFileGenerator;
	
	@Autowired
	private CsvMapper csvMapper;
	
	@Autowired
	private XmlMapper xmlMapper;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	private void saveReasult(File outFile, ReasultsContainer reasult) throws SaveOutputFileException {
		List<File> inputFiles = new ArrayList<>();
		inputFiles.add(new File("src/test/testResources/coreImput.xml"));
		inputFiles.add(new File("src/test/testResources/coreImput.csv"));	
		File outputFile = outFile;	
		RaportType raportType = RaportType.A;
		String clientId = "";
		
		InputArgument inputArgument = new InputArgument(inputFiles, outputFile, raportType, clientId);	
		raportFileGenerator.save(inputArgument, reasult);
	}

	@Test
	public void outputListXmlTest() throws SaveOutputFileException, JsonParseException, JsonMappingException, IOException {
	
		File outputFile = new File("src/test/testResources/testOutputFolder/out.xml");
		ReasultsContainer reasult = new ReasultsContainer(new OneValueReport("test", "123"));
		
		saveReasult(outputFile, reasult);	
		
		OneValueReport output = new ReadSingle(xmlMapper).parseOneValueXml(outputFile);
		
		assertEquals(reasult.getOneValueReport(), output);
	}
	
	@Test
	public void outputListCsvTest() throws SaveOutputFileException, JsonParseException, JsonMappingException, IOException {
	
		File outputFile = new File("src/test/testResources/testOutputFolder/out.csv");
		ReasultsContainer reasult = new ReasultsContainer(new OneValueReport("test", "123"));
		
		saveReasult(outputFile, reasult);	
		
		OneValueReport output = new ReadSingle(csvMapper).parseOneValueCsv(outputFile);
		
		assertEquals(reasult.getOneValueReport(), output);
	}

}
