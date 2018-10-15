package com.bootLogisticSystem.logic.raportGenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.context.junit4.SpringRunner;

import com.bootLogisticSystem.entity.Request;
import com.bootLogisticSystem.exception.InvalidParameterException;
import com.bootLogisticSystem.exception.NoValidRaportDataGeneratorFoundException;
import com.bootLogisticSystem.model.InputArgument;
import com.bootLogisticSystem.model.RaportType;
import com.bootLogisticSystem.model.ReasultsContainer;
import com.bootLogisticSystem.model.raportTemplates.OneValueReport;
import com.bootLogisticSystem.repository.RequestRepository;
import com.bootLogisticSystem.utils.Calculations;
import com.bootLogisticSystem.utils.RandomRequest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RaportGeneratorTest {
	
	@Autowired
	private RaportGenerator raportGenerator;
	
	@Autowired
	private RequestRepository orderRepository;
	
	private static List<Request> oryginalRequests;
	private static final int totalCount = 100;
	
	
	@BeforeClass
	public static void setUp() {
		oryginalRequests = RandomRequest.generate(totalCount);
	}
	
	@Before
	public void beforeTest() {
		if(orderRepository.count() == 0) {
			orderRepository.saveAll(oryginalRequests);
		}	
	}
	
	@After
	public void after() {
		if(orderRepository.count() != 0) {
			orderRepository.deleteAll();
		}
	}
	
//	private File getXmlOutFile() {
//		return new File("src/test/testResources/testOutputFolder/out.xml");
//	}
//	
//	private File getCsvOutFile() {
//		return new File("src/test/testResources/testOutputFolder/out.csv");
//	}
	
	private OneValueReport getRaport(RaportType raportType, String value) {
		return new OneValueReport(raportType.getDescription(), value);
	}
	
	private OneValueReport getOneValueReport(InputArgument args) throws NoValidRaportDataGeneratorFoundException, InvalidParameterException {
		return raportGenerator.generateRaport(args).getOneValueReport();
	}
	
	private List<Request> getRequestListReport(InputArgument args) throws NoValidRaportDataGeneratorFoundException, InvalidParameterException {
		return raportGenerator.generateRaport(args).getRequestsReport();
	}
	
	@Test
	public void correctValueReportA() throws NoValidRaportDataGeneratorFoundException, InvalidParameterException {
		
		InputArgument args = generateInputArgument(RaportType.A, "");
		
		OneValueReport reasultReport = getOneValueReport(args);
		
		OneValueReport reasultToCompare = getRaport(
				RaportType.A,
				Integer.toString(totalCount));
		
		assertEquals(reasultToCompare, reasultReport);
		
	}
	
	@Test
	@Repeat(value = 5)
	public void correctValueReportB() throws NoValidRaportDataGeneratorFoundException, InvalidParameterException {
		
		//multiple run
		String randomClientId = RandomRequest.getRandomClientId();
		
		InputArgument args = generateInputArgument(RaportType.B, randomClientId);
		
		OneValueReport reasultReport = getOneValueReport(args);
		
		OneValueReport reasultToCompare = getRaport(
				RaportType.B,
				Long.toString(Calculations.countByClientID(oryginalRequests, randomClientId)));
		
		assertEquals(reasultToCompare, reasultReport);
		
	}
	
	@Test
	public void correctValueReportC() throws NoValidRaportDataGeneratorFoundException, InvalidParameterException {
		
		InputArgument args = generateInputArgument(RaportType.C, "");
		
		OneValueReport reasultReport = getOneValueReport(args);
		
		OneValueReport reasultToCompare = getRaport(
				RaportType.C,
				Double.toString(Calculations.getTotalOrderPrice(oryginalRequests)));
		
		assertEquals(Double.parseDouble(reasultToCompare.getValue()), Double.parseDouble(reasultReport.getValue()), 1e-6);		
	}
	
	@Test
	@Repeat(value = 5)
	public void correctValueReportD() throws NoValidRaportDataGeneratorFoundException, InvalidParameterException {
		
		//multiple run
		String randomClientId = RandomRequest.getRandomClientId();
		
		InputArgument args = generateInputArgument(RaportType.D, randomClientId);
		
		OneValueReport reasultReport = getOneValueReport(args);
		
		OneValueReport reasultToCompare = getRaport(
				RaportType.D,
				Double.toString(Calculations.getTotalOrderPriceFromClient(oryginalRequests, randomClientId)));
		
			
		assertEquals(Double.parseDouble(reasultToCompare.getValue()), Double.parseDouble(reasultReport.getValue()),  1e-6);
	}
	
	@Test
	public void correctValueReportE() throws NoValidRaportDataGeneratorFoundException, InvalidParameterException {
		
		InputArgument args = generateInputArgument(RaportType.E, "");
		
		List<Request> reasultReport = getRequestListReport(args);
		
		assertThat(oryginalRequests, is(reasultReport));
	}
	
	@Test
	@Repeat(value = 5)
	public void correctValueReportF() throws NoValidRaportDataGeneratorFoundException, InvalidParameterException {
		
		String randomClientId = RandomRequest.getRandomClientId();
		
		InputArgument args = generateInputArgument(RaportType.F, randomClientId);
		
		List<Request> reasultReport = getRequestListReport(args);	
		
		assertThat(Calculations.getTAllRequestForClient(oryginalRequests, randomClientId), is(reasultReport));
	}
	
	
	@Test
	public void correctValueReportG() throws NoValidRaportDataGeneratorFoundException, InvalidParameterException {
		
		InputArgument args = generateInputArgument(RaportType.G, "");
		
		OneValueReport reasultReport = getOneValueReport(args);
		
		OneValueReport reasultToCompare = getRaport(
				RaportType.G,
				Double.toString(Calculations.getAverageOrderPrice(oryginalRequests)));
		
		assertEquals(Double.parseDouble(reasultToCompare.getValue()), Double.parseDouble(reasultReport.getValue()), 1e-6);		
	}
	
	@Test
	@Repeat(value = 5)
	public void correctValueReportH() throws NoValidRaportDataGeneratorFoundException, InvalidParameterException {
		
		//multiple run
		String randomClientId = RandomRequest.getRandomClientId();
		
		InputArgument args = generateInputArgument(RaportType.H, randomClientId);
		
		OneValueReport reasultReport = getOneValueReport(args);
		
		OneValueReport reasultToCompare = getRaport(
				RaportType.H,
				Double.toString(Calculations.getAverageOrderPriceFromClient(oryginalRequests, randomClientId)));
		
			
		assertEquals(Double.parseDouble(reasultToCompare.getValue()), Double.parseDouble(reasultReport.getValue()),  1e-6);
	}
	
	
	/*
	 * These test check validation of userId
	 */

	/*
	 * when there's no user
	 */	
	
	@Test(expected = InvalidParameterException.class)
	public void noUserIdRaportB() throws NoValidRaportDataGeneratorFoundException, InvalidParameterException {
		
		raportGenerator.generateRaport(generateInputArgument(RaportType.B, "noUserLikeThis"));		
	}
	
	@Test(expected = InvalidParameterException.class)
	public void noUserIdRaportD() throws NoValidRaportDataGeneratorFoundException, InvalidParameterException {
		
		raportGenerator.generateRaport(generateInputArgument(RaportType.D, "noUserLikeThis"));		
	}
	
	@Test(expected = InvalidParameterException.class)
	public void noUserIdRaportF() throws NoValidRaportDataGeneratorFoundException, InvalidParameterException {
		
		raportGenerator.generateRaport(generateInputArgument(RaportType.F, "noUserLikeThis"));		
	}
	
	@Test(expected = InvalidParameterException.class)
	public void noUserIdRaportH() throws NoValidRaportDataGeneratorFoundException, InvalidParameterException {
		
		raportGenerator.generateRaport(generateInputArgument(RaportType.H, "noUserLikeThis"));		
	}
	
	/*
	 * when user is wrong
	 */	
	
	@Test(expected = InvalidParameterException.class)
	public void wrongUserIdRaportB() throws NoValidRaportDataGeneratorFoundException, InvalidParameterException {
		
		raportGenerator.generateRaport(generateInputArgument(RaportType.B));		
	}
	
	@Test(expected = InvalidParameterException.class)
	public void wrongUserIdRaportD() throws NoValidRaportDataGeneratorFoundException, InvalidParameterException {
		
		raportGenerator.generateRaport(generateInputArgument(RaportType.D));		
	}
	
	@Test(expected = InvalidParameterException.class)
	public void wrongUserIdRaportF() throws NoValidRaportDataGeneratorFoundException, InvalidParameterException {
		
		raportGenerator.generateRaport(generateInputArgument(RaportType.F));		
	}
	
	@Test(expected = InvalidParameterException.class)
	public void wrongUserIdRaportH() throws NoValidRaportDataGeneratorFoundException, InvalidParameterException {
		
		raportGenerator.generateRaport(generateInputArgument(RaportType.H));		
	}	
	
	/*
	 * Helpful functions
	 */
	
	private InputArgument generateInputArgument(File outputFile, RaportType raportType, String clientId) {
		List<File> inputFiles = new ArrayList<>();
		inputFiles.add(new File("src/test/testResources/coreImput.xml"));
		inputFiles.add(new File("src/test/testResources/coreImput.csv"));	
		
		return new InputArgument(inputFiles, outputFile, raportType, clientId);	
	}
	
	
	private InputArgument generateInputArgument(RaportType raportType, String clientId) {
		return generateInputArgument(new File("src/test/testResources/testOutputFolder/out.xml"), 
				raportType, 
				clientId);
	}
	
	private InputArgument generateInputArgument(RaportType raportType) {
		
		return generateInputArgument(raportType, "");	
	}
}
