/**
*This class describes Help Service 
*Methods for fetching order Item By Product Id, Model Number & filtering Products.
* @author K.Vihitha, T.M.Yasaswini
* @version 1.8.0_311
**/
package com.ibm.services.common;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ibm.model.entities.OrderItemModel;
import com.ibm.model.entities.OrderModel;

@Service
public class HelpService {

	public Optional<OrderItemModel> getOrderItemByProductId(OrderModel order, Integer productId) {
		if(order == null)
			return Optional.empty();
		
		return order.getOrderItems()
				.stream().filter((orderItem) -> orderItem.getProduct().getProductId() == productId)
				.findFirst();
	}
	public Optional<OrderItemModel> getOrderItemByModelNo(OrderModel order, String modelNo) {
		if(order == null)
			return Optional.empty();
		
		return order.getOrderItems()
				.stream().filter((orderItem) -> orderItem.getProduct().getModelNo().equals(modelNo))
				.findFirst();
	}
}
