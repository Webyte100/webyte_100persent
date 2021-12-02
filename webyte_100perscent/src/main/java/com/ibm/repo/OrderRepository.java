/**
* This class describes the repository of Order.
* Methods to find Cart by User name, Order Item by Product Id and all previous orders.
* @author K.Vihitha, T.M.Yasaswini
* @version 1.8.0_311
**/

package com.ibm.repo;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ibm.model.entities.OrderItemModel;
import com.ibm.model.entities.OrderModel;

@Repository
public interface OrderRepository extends JpaRepository<OrderModel, Integer>{
	@Query("SELECT o from OrderModel o WHERE o.user.userName = :username and o.orderStatus = com.ibm.model.entities.enumerations.Status.IN_CART")
	public OrderModel findCartByUserName(@Param(value = "username") String userName);
	
	@Query("SELECT oi from OrderItemModel oi WHERE oi.product.productId = :productId")
	public OrderItemModel findOrderItemByProductId(@Param(value = "productId") Integer productId);
	
	@Query("SELECT o from OrderModel o WHERE o.user.userName = :username and o.orderStatus != com.ibm.model.entities.enumerations.Status.IN_CART")
	public List<OrderModel> findAllPreviousOrders(@Param(value = "username") String userName, Sort sort);
}
