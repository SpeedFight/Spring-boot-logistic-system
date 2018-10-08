package com.bootLogisticSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootLogisticSystem.entity.Request;

@Repository
public interface OrderRepository extends JpaRepository<Request, Integer> {

}
