package com.ibm.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.entity.OrderItem;

import java.util.List;

@Repository("OrderItemRepository")
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {

//    save
	
//	List<OrderItem> findOrderItemByOrderId(int orderId);

    OrderItem findOrderItemByOrderIdAndProductId(int orderId, int id);

}

