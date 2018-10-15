package com.bootLogisticSystem.utils;

import java.util.List;

import com.bootLogisticSystem.entity.Request;

/**
 * Class provide only static methods to validate calculations from database
 * 
 * @author Karol Łukasiewicz
 *
 */
public class Calculations {
	
	public static double getAverageOrderPrice(List<Request> requests) {
		return requests.stream()
				.mapToDouble(Request::getPrice)
				.average()
				.orElse(Double.NaN);
	}

	public static double getAverageOrderPriceFromClient(List<Request> requests, String clientId) {
		return requests.stream()
				.filter(e -> e.getClientId().equals(clientId))
				.mapToDouble(Request::getPrice)
				.average()
				.orElse(Double.NaN);
	}
	
	public static long countByClientID(List<Request> requests, String clientId) {
		return requests.stream()
				.filter(e -> e.getClientId().equals(clientId))
				.count();	
	}
	
	public static double getTotalOrderPrice(List<Request> requests) {
		return requests.stream()
				.mapToDouble(Request::getPrice)
				.sum();
	}
	
	public static double getTotalOrderPriceFromClient(List<Request> requests, String clientId) {
		return requests.stream()
				.filter(e -> e.getClientId().equals(clientId))
				.mapToDouble(Request::getPrice)
				.sum();
	}
	
}
