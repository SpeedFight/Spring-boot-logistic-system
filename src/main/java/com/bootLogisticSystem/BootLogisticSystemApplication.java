package com.bootLogisticSystem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.bootLogisticSystem.entity.Request;
import com.bootLogisticSystem.repository.RequestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;

@SpringBootApplication
@EnableJpaRepositories("com.bootLogisticSystem.repository")
@EntityScan("com.bootLogisticSystem.entity")
@ComponentScan("com.bootLogisticSystem")
public class BootLogisticSystemApplication implements CommandLineRunner {
	
	@Autowired
	RequestRepository orderRepository;

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(BootLogisticSystemApplication.class);
		 app.setBannerMode(Banner.Mode.OFF);
		 app.setLogStartupInfo(false);
	     app.run(args);
	}

	@Override
	public void run(String... args) throws Exception {
		orderRepository.save(new Request("1", 1, "bulka", 5, 7));
		orderRepository.save(new Request("1", 2, "chlep", 15, 17));
		orderRepository.save(new Request("1", 3, "cebula", 522, 27));
		orderRepository.findAll().forEach(e -> System.out.println(e));
		System.out.println("Hello");
	}
}
