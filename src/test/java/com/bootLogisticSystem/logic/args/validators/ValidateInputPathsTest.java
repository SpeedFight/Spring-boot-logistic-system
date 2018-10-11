package com.bootLogisticSystem.logic.args.validators;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ValidateInputPathsTest {
	
	private static ValidateInputPaths validateInputPaths;
	
	@BeforeClass
	public static void setUp() {
		validateInputPaths = new ValidateInputPaths();
	}
	
	@Test
	public void oneCorrectInputFile() {
		
	}
	
	@Test
	public void twoCorrectInputFiles() {
		
	}
	
	@Test
	public void threeCorrectInputFiles() {
		
	}
	
	@Test
	public void manyCorrectInputFiles() {
		
	}
	
	@Test
	public void oneWrongFile() {
		
	}
	
	@Test
	public void twoWrongFiles() {
		
	}
	
	@Test
	public void threeWrongFiles() {
		
	}
	
	@Test
	public void manyWrongFiles() {
		
	}
	
	@Test
	public void oneGoodAndWrongFile() {
		
	}
	
	@Test
	public void twoGoodAndOneWrongFile() {
		
	}
	
	@Test
	public void oneGoodAndTwoWrongFile() {
		
	}
	
	@Test
	public void twoGoodAndManyWrongFile() {
		
	}
	
	@Test
	public void manyGoodAndOneWrongFile() {
		
	}
	
	@Test
	public void oneGoodAndManyWrongFile() {
		
	}
	
	@Test
	public void manyGoodAndManyWrongFile() {
		
	}

}
