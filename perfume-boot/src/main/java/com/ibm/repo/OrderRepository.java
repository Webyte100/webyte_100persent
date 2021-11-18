package com.ibm.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.entity.Order;

@Repository("OrderRepository")
public interface OrderRepository extends JpaRepository<Order, Integer> {

}