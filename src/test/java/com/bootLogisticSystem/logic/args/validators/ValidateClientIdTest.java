/*
 * Copyright (c) 2018 Karol Łukasiewicz
 *
 * @author Karol Łukasiewicz
 * @date 15 Oct 2018
 * 
 */
package com.bootLogisticSystem.logic.args.validators;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bootLogisticSystem.exception.InvalidParameterException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ValidateClientIdTest {
	
	private static ValidateClientId validateClientId;

	@BeforeClass
	public static void setUp() {
		validateClientId = new ValidateClientId();
	}
	
	@Test
	public void checkCorrectId() throws InvalidParameterException {
		String clientId = "test";
		String clientIdFromValidate = validateClientId.validate(clientId);
		
		assertTrue(clientId.compareTo(clientIdFromValidate) == 0);
	}
}
