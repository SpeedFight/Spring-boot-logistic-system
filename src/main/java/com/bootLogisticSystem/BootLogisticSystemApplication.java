package com.bootLogisticSystem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import com.bootLogisticSystem.component.dataParser.DataParser;
import com.bootLogisticSystem.entity.Request;
import com.bootLogisticSystem.exception.InvalidParameterException;
import com.bootLogisticSystem.repository.RequestRepository;
import com.bootLogisticSystem.utils.InputArgumentParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.Reader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.Banner;

@SpringBootApplication
@EnableJpaRepositories("com.bootLogisticSystem.repository")
@EntityScan("com.bootLogisticSystem.entity")
@ComponentScan("com.bootLogisticSystem")
public class BootLogisticSystemApplication implements CommandLineRunner {

	@Autowired
	private RequestRepository orderRepository;

	@Autowired
	private DataParser requestXmlParser;

	@Autowired
	private DataParser requestCsvParser;

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(BootLogisticSystemApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}

	@Override
	public void run(String... args) throws Exception {

		try {

			System.out.println("parse args:");
			new InputArgumentParser().parseArgsAsFilePath(args);

		} catch (InvalidParameterException e) {
			/*
			 * heh I was almost forced to face the fact that my argument validation was bad,
			 * but I see here that you made a typo hahaha, tough luck pal.
			 */
		} catch (Exception e) {
			/*
			 * It is my fault now.
			 */
			e.printStackTrace();
		}

		System.out.println("End program");
	}

}
