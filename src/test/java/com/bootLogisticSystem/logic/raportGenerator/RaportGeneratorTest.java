package com.bootLogisticSystem.logic.raportGenerator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bootLogisticSystem.exception.InvalidParameterException;
import com.bootLogisticSystem.exception.NoValidRaportDataGeneratorFoundException;
import com.bootLogisticSystem.model.InputArgument;
import com.bootLogisticSystem.model.RaportType;
import com.bootLogisticSystem.repository.RequestRepository;
import com.bootLogisticSystem.utils.RandomRequest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RaportGeneratorTest {
	
	@Autowired
	private RaportGenerator raportGenerator;
	
	@Autowired
	private static RequestRepository orderRepository;
	
	@BeforeClass
	public static void setUp() {
		orderRepository.saveAll(RandomRequest.generate(100));
	}
	
	@AfterClass
	public static void after() {
		orderRepository.deleteAll();
	}
	
	
	private InputArgument generateInputArgument(RaportType raportType) {
		List<File> inputFiles = new ArrayList<>();
		inputFiles.add(new File("src/test/testResources/coreImput.xml"));
		inputFiles.add(new File("src/test/testResources/coreImput.csv"));	
		File outputFile = new File("src/test/testResources/testOutputFolder/out.xml");	
		String clientId = "";
		
		return new InputArgument(inputFiles, outputFile, raportType, clientId);	
	}
	
	@Test(expected = InvalidParameterException.class)
	public void noUserIdRaportB() throws NoValidRaportDataGeneratorFoundException, InvalidParameterException {
		
		raportGenerator.generateRaport(generateInputArgument(RaportType.B));		
	}
	
	@Test(expected = InvalidParameterException.class)
	public void noUserIdRaportD() throws NoValidRaportDataGeneratorFoundException, InvalidParameterException {
		
		raportGenerator.generateRaport(generateInputArgument(RaportType.D));		
	}
	
	@Test(expected = InvalidParameterException.class)
	public void noUserIdRaportF() throws NoValidRaportDataGeneratorFoundException, InvalidParameterException {
		
		raportGenerator.generateRaport(generateInputArgument(RaportType.F));		
	}
	
	@Test(expected = InvalidParameterException.class)
	public void noUserIdRaportH() throws NoValidRaportDataGeneratorFoundException, InvalidParameterException {
		
		raportGenerator.generateRaport(generateInputArgument(RaportType.H));		
	}
	
	

}
