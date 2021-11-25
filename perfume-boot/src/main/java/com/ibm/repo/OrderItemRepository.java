package com.ibm.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.entity.OrderItem;

@Repository("OrderItemRepository")
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {

	
	List<OrderItem> findOrderItemByItemId(int orderId);

//    OrderItem findOrderItemByOrderIdAndProductId(int orderId, int id);

}

