/*
 * Copyright (c) 2018 Karol Łukasiewicz
 *
 * @author Karol Łukasiewicz
 * @date 15 Oct 2018
 * 
 */
package com.bootLogisticSystem;

import org.pmw.tinylog.Configurator;
import org.pmw.tinylog.Level;
import org.pmw.tinylog.Logger;
import org.pmw.tinylog.writers.ConsoleWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * This is main configuration class to run this program. Purpose of this piece
 * of software is read, parse, push to database and compute all input data by
 * way defined by user. It's all made with use of spring boot, why? Because why
 * not? We get database configuration for "free", data validation almost for
 * "free", IoC for "free". *free -> in matter of time spend to develop and test. <br>
 * 
 * Go to Main.java to see logic
 * 
 * @author Karol Łukasiewicz
 *
 */
@SpringBootApplication
@EnableJpaRepositories("com.bootLogisticSystem.repository")
@EntityScan("com.bootLogisticSystem.entity")
@ComponentScan("com.bootLogisticSystem")
public class BootLogisticSystemApplication implements CommandLineRunner {

	@Autowired
	private Main main;

	public static void main(String[] args) {
		configureLogger();
		
		SpringApplication app = new SpringApplication(BootLogisticSystemApplication.class);
		app.run(args);
	}

	@Override
	public void run(String... args) throws Exception {
		Logger.info("Program start");

		main.main(args);

		Logger.info("Program end");
	}

	private static void configureLogger() {
		Configurator.defaultConfig()
			.writer(new ConsoleWriter())
			.level(Level.INFO)
			.formatPattern("{level}: {message}")
		   .activate();
	}

}
