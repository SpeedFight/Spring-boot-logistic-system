package com.bootLogisticSystem.logic.args.validators;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bootLogisticSystem.exception.InvalidParameterException;
import com.bootLogisticSystem.model.RaportType;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ValidateRaportTypeTest {

	private static ValidateRaportType validateRaportType;
	
	@BeforeClass
	public static void setUp() {
		validateRaportType = new ValidateRaportType();
	}
	
	@Test
	public void detectValidReportType() throws InvalidParameterException {
		for (RaportType raportType : RaportType.values()) {
			RaportType testRaportType = validateRaportType.validate(raportType.getCode());
			
			assertTrue(raportType.getCode().compareTo(testRaportType.getCode()) == 0);
		}
	}
	
	@Test
	public void detectValidReportTypeWhenUpperCase() throws InvalidParameterException {
		for (RaportType raportType : RaportType.values()) {
			RaportType testRaportType = validateRaportType.validate(raportType.getCode().toUpperCase());
			
			assertTrue(raportType.getCode().compareTo(testRaportType.getCode()) == 0);
		}
	}
	
	@Test(expected = InvalidParameterException.class)
	public void  wrongReportTypeByX() throws InvalidParameterException {
		for (RaportType raportType : RaportType.values()) {
			RaportType testRaportType = validateRaportType.validate("x");
			
			assertTrue(raportType.getCode().compareTo(testRaportType.getCode()) == 0);
		}
	}
	
	@Test(expected = InvalidParameterException.class)
	public void  wrongReportTypeByRandomString() throws InvalidParameterException {
		for (RaportType raportType : RaportType.values()) {
			RaportType testRaportType = validateRaportType.validate("test");
			
			assertTrue(raportType.getCode().compareTo(testRaportType.getCode()) == 0);
		}
	}
}
