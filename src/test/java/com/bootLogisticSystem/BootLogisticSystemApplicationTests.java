/*
 * Copyright (c) 2018 Karol Łukasiewicz
 *
 * @author Karol Łukasiewicz
 * @date 15 Oct 2018
 * 
 */
package com.bootLogisticSystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootLogisticSystemApplicationTests {

	@Configuration
	@EnableJpaRepositories("com.bootLogisticSystem.repository")
	@EntityScan("com.bootLogisticSystem.entity")
	@ComponentScan("com.bootLogisticSystem")
	static class ContextConfiguration {

		@Primary // may omit this if this is the only SomeBean defined/visible
	    public static void main(String[] args) {
	        SpringApplication.run(BootLogisticSystemApplicationTests.class, args);
	    }
	}

	@Test
	public void contextLoads() {
	}

}
