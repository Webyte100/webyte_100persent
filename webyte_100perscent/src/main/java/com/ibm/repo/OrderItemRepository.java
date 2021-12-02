/**
* This class describes the repository of Order Item.
* @author K.Vihitha, T.M.Yasaswini
* @version 1.8.0_311
**/

package com.ibm.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.model.entities.OrderItemModel;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItemModel, Integer>{
}
