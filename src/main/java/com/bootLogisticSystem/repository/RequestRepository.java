/*
 * Copyright (c) 2018 Karol Łukasiewicz
 *
 * @author Karol Łukasiewicz
 * @date 15 Oct 2018
 * 
 */
package com.bootLogisticSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bootLogisticSystem.entity.Request;

@Repository
public interface RequestRepository extends CrudRepository<Request, Integer> {

	List<Request> findByClientId(String clientId);
	
	int countByClientId(String clientId);
	
	@Query("SELECT SUM(price) FROM Request")
	double getSumOfTotalOrderPrice();
	
	@Query("SELECT SUM(price) FROM Request WHERE clientId=?1")
	double getSumOfOrderPriceFromClient(String clientId);
	
	@Query("SELECT AVG(price) FROM Request")
	double getTotalAverageOrderPrice();
	
	@Query("SELECT AVG(price) FROM Request WHERE clientId=?1")
	double getAverageOrderPriceFromClient(String clientId);
	
	boolean existsByClientId(String clientId);
}
