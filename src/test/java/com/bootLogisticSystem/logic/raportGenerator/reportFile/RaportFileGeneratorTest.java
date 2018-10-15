package com.bootLogisticSystem.logic.raportGenerator.reportFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bootLogisticSystem.logic.raportGenerator.RaportFileGenerator;
import com.bootLogisticSystem.model.InputArgument;
import com.bootLogisticSystem.model.RaportType;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RaportFileGeneratorTest {

	@Autowired
	private RaportFileGenerator raportFileGenerator;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void outputListXmlTest() {
	
		List<File> inputFiles = new ArrayList<>();
		inputFiles.add(new File("src/test/testResources/coreImput.xml"));
		inputFiles.add(new File("src/test/testResources/coreImput.csv"));	
		File outputFile = new File("src/test/testResources/testOutputFolder/out.xml");	
		RaportType raportType = RaportType.A;
		String clientId = "";
		
		InputArgument inputArgument = new InputArgument(inputFiles, outputFile, raportType, clientId);
		
		raportFileGenerator.save(inputArgument, reasult);
	}

}
