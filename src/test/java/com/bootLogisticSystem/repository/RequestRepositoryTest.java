package com.bootLogisticSystem.repository;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bootLogisticSystem.entity.Request;
import com.bootLogisticSystem.utils.RandomRequest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RequestRepositoryTest {
	
	@Autowired
	private RequestRepository orderRepository;

	@After
	public void afterTest() {
		orderRepository.deleteAll();
	}

	
	@Test
	public void getAverageOrderPrice() {
		
		List<Request> requests = RandomRequest.generate(100);	
		
		double average = requests.stream()
				.mapToDouble(Request::getPrice)
				.average()
				.orElse(Double.NaN);
			
		orderRepository.saveAll(requests);
		
		assertEquals(average, orderRepository.getAverageOrderPrice(), 1e-6);
	}
	
	
	@Test
	public void getAverageOrderPriceFromClient() {
		
		List<Request> requests = RandomRequest.generate(100);	
		String clientId = requests.get(0).getClientId();
		
		//get first client id and calculate average value of his orders
		double average = requests.stream()
				.filter(e -> e.getClientId().equals(clientId))
				.mapToDouble(Request::getPrice)
				.average()
				.orElse(Double.NaN);
		
		orderRepository.saveAll(requests);
		
//		System.out.println("");
//		System.out.println(average);
//		System.out.println(orderRepository.getAverageOrderPriceFromClient(clientId));
		
		assertEquals(average, orderRepository.getAverageOrderPriceFromClient(clientId), 0.01);
	}
	
	@Test
	public void count() {
		int amount = 100;
		List<Request> requests = RandomRequest.generate(amount);	
		orderRepository.saveAll(requests);
		
		assertEquals(amount, orderRepository.count());
	}

}
