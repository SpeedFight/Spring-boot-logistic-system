package com.bootLogisticSystem.repository;

import static org.junit.Assert.*;
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
		
		assertEquals(average, orderRepository.getTotalAverageOrderPrice(), 1e-6);
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
		
		assertEquals(average, orderRepository.getAverageOrderPriceFromClient(clientId), 1e-6);
	}
	
	@Test
	public void count() {
		int amount = 100;
		List<Request> requests = RandomRequest.generate(amount);	
		orderRepository.saveAll(requests);
		
		assertEquals(amount, orderRepository.count());
	}
	
	@Test
	public void countByClientID() {
		int amount = 100;
		List<Request> requests = RandomRequest.generate(amount);
		String clientId = requests.get(0).getClientId();
		
		orderRepository.saveAll(requests);
		
		int ordersToClient = (int)requests.stream()
				.filter(e -> e.getClientId().equals(clientId))
				.count();	
		
		assertEquals(ordersToClient, orderRepository.countByClientId(clientId));
	}
	
	@Test
	public void getTotalOrderPrice() {
		int amount = 100;
		List<Request> requests = RandomRequest.generate(amount);
		
		orderRepository.saveAll(requests);
		
		double totalOrdersPrice = requests.stream()
				.mapToDouble(Request::getPrice)
				.sum();
		
		assertEquals(totalOrdersPrice, orderRepository.getSumOfTotalOrderPrice(), 1e-6);
	}
	
	@Test
	public void getTotalOrderPriceFromClient() {
		int amount = 100;
		List<Request> requests = RandomRequest.generate(amount);
		String clientId = requests.get(0).getClientId();
		
		orderRepository.saveAll(requests);
		
		double totalOrdersPrice = requests.stream()
				.filter(e -> e.getClientId().equals(clientId))
				.mapToDouble(Request::getPrice)
				.sum();
		
		assertEquals(totalOrdersPrice, orderRepository.getSumOfOrderPriceFromClient(clientId), 1e-6);
	}
}
