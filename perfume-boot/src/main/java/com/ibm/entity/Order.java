/**
* This class describes entity of Order. Creating Table and mentioning Column names.
*Getters and Setters are taken.
*@author K.Vihitha, T.M.Yasaswini
*@version 1.8.0_311
**/

package com.ibm.entity;

import javax.persistence.*;
//CHECKOUT
@Entity
@Table(name="order")
public class Order {
	@Id @GeneratedValue @Column(name="order_id")
	private int orderId;
	
	//One order item will be associate with single order
	@OneToOne
	@JoinColumn(name = "itemId")
	private OrderItem orderItemId;
	
	@Column(length=30)
	private int subTotal; //sub is trigger for (price * quantity) in orderItem entity table
	
	@Column(length=30)
	private int itemDiscount;
	
	@Column(length=30)
	private int ShipCharges;
	
	@Column(length=30)
	private int total;
	
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public OrderItem getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(OrderItem orderItemId) {
		this.orderItemId = orderItemId;
	}

	public int getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(int subTotal) {
		this.subTotal = subTotal;
	}

	public int getItemDiscount() {
		return itemDiscount;
	}

	public void setItemDiscount(int itemDiscount) {
		this.itemDiscount = itemDiscount;
	}

	public int getShipCharges() {
		return ShipCharges;
	}

	public void setShipCharges(int shipCharges) {
		ShipCharges = shipCharges;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal() {
		this.total = (subTotal - itemDiscount) + ShipCharges;
	}

}
