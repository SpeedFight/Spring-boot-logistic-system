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

import com.bootLogisticSystem.component.DataParser;
import com.bootLogisticSystem.entity.Request;
import com.bootLogisticSystem.repository.RequestRepository;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
//		 app.setLogStartupInfo(false);
		app.run(args);
	}

	@Override
	public void run(String... args) throws Exception {

//		Validator validator;
//		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//		validator = factory.getValidator();	
//		
//		Request request = new Request("2123123as asdas", -5, "kleke",-5, 0.2);
//		Set<ConstraintViolation<Request>> requestsValidate = validator.validate(request);
//		requestsValidate.stream().forEach(e -> System.out.println(e));
		
		try {

		List<Request> requests = requestXmlParser.getRequests(new FileInputStream(new File("src/test/testResources/coreImput.xml")));
		requests = requestCsvParser.getRequests(new FileInputStream(new File("src/test/testResources/coreImput.csv")));
		requests.forEach(e -> System.out.println(e));	
			
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}

		System.out.println("End program");
	}

}
