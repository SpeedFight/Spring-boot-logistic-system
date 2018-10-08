package com.bootLogisticSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bootLogisticSystem.entity.Request;

@Repository
public interface RequestRepository extends CrudRepository<Request, Integer> {

	List<Request> findByClientId(String clientId);
	
	@Query("SELECT AVG(price) FROM Request")
	double getAverageOrderPrice();
	
	@Query("SELECT AVG(price) FROM Request WHERE clientId='clientId'")
	double getAverageOrderPriceFromClient(String clientId);
}
