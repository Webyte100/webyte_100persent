package com.ibm.entity;

import javax.persistence.*;
//CART
@Entity
@Table(name="order_item")
public class OrderItem {
	@Id @GeneratedValue @Column(name="item_id")
	private int itemId;
	
	//Each order item belongs to a user
	@ManyToOne
	@JoinColumn(name="userId") //joining the userId column (from Users java program) to this table
	private User user;
		
	//Each order item is related to a product
	@ManyToOne
	@JoinColumn(name="prodId") //joining the prodId column (from Products java program) to this table
	private Product products;
	
	@Column
	private long price;
	
	@Column
	private int quantity;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProducts() {
		return products;
	}

	public void setProducts(Product products) {
		this.products = products;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
