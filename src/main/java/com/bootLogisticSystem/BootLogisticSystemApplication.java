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
import com.bootLogisticSystem.repository.RequestRepository;
import com.bootLogisticSystem.utils.CommandLine;
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
//		orderRepository.save(request);
//		Set<ConstraintViolation<Request>> requestsValidate = validator.validate(request);
//		requestsValidate.stream().forEach(e -> System.out.println(e));
		
		try {		

//		List<Request> requests = requestXmlParser.getRequests(new FileInputStream(new File("src/test/testResources/coreImput.xml")));
//		requests = requestCsvParser.getRequests(new FileInputStream(new File("src/test/testResources/coreImput.csv")));
////		requests.forEach(e -> System.out.println(e));	
//		
		System.out.println("parse args:");
		CommandLine.parseArgsAsFilePath(args);
			
//			Request requestBad1 = new Request("2123123as asdas", -5, "kleke",-5, 0.2);
//			Request requestBad2 = new Request("212 3123as asdas", -3, "kleke",-5, 0.2);
//			Request requestBad3 = new Request(null, -3, "kleke",-5, 0.2);
//			Request requestOk = new Request("heh", 2, "kleke",2, 0.2);
//			
//			List<Request> requests = new ArrayList<>();
//			requests.add(requestBad1);
//			requests.add(requestBad2);
//			requests.add(requestOk);
//			requests.add(requestBad3);
			
			
//			ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//			Validator validator = factory.getValidator();	
//			
//			List<String> validatorLog = new ArrayList<String>();
//			List<Request> parsed = requests.parallelStream().filter(request -> {
//				validatorLog.addAll(validator.validate(request).stream()
//						.map(constraintViolation -> String.format("Error in client id:'%s' request id:'%s'. Wrong value:'%s' = '%s' because: '%s'", 
//								((Request)constraintViolation.getRootBean()).getClientId(), 
//								((Request)constraintViolation.getRootBean()).getRequestId(),
//				        		constraintViolation.getPropertyPath(),
//				                constraintViolation.getInvalidValue(), 
//				                constraintViolation.getMessage()
//				        		))
//				        .collect(Collectors.toList()));
//				return validator.validate(request).isEmpty();
//			}).collect(Collectors.toList());
					
					
//			parsed.forEach(e -> System.out.println(e));
			
//			for(Request request: requests) {
//				try {
//					orderRepository.save(request);
//				} catch (javax.validation.ConstraintViolationException e) {
//					Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
//					Set<String> messages = new HashSet<>(constraintViolations.size());
//					messages.addAll(constraintViolations.stream()
//							.map(constraintViolation -> String.format("Error in client id:'%s' request id:'%s'. Wrong value:'%s' = '%s' because: '%s'", 
//									((Request)constraintViolation.getRootBean()).getClientId(), 
//									((Request)constraintViolation.getRootBean()).getRequestId(),
//					        		constraintViolation.getPropertyPath(),
//					                constraintViolation.getInvalidValue(), 
//					                constraintViolation.getMessage()
//					        		))
//					        .collect(Collectors.toList()));
//					
//					messages.forEach(k-> System.out.println(k));
//				}
//				
//			}

//			orderRepository.findAll().forEach(e -> System.out.println(e));
			
			
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}

		System.out.println("End program");
	}

}
