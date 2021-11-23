/**
* This class describes entity of Order_Item. Creating Table and mentioning Column names.
*Getters and Setters are taken.
*@author K.Vihitha, T.M.Yasaswini
*@version 1.8.0_311
**/

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
	private int SKU;
	
	public int getSKU() {
		return SKU;
	}

	public void setSKU(int sKU) {
		SKU = sKU;
	}

	@Column
	private long price;
	
	@Column
	private int quantity;
	
	@Column(length=25)
	private String addToCart;
	
	@Column
	private int priceRange;
	
	public int getPriceRange() {
		return priceRange;
	}

	public void setPriceRange(int priceRange) {
		this.priceRange = priceRange;
	}


	public String getAddToCart() {
		return addToCart;
	}

	public void setAddToCart(String addToCart) {
		this.addToCart = addToCart;
	}

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
	public void setPrice() {
		this.price = price * quantity;			//Updates the price in cart when items are added or removed
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
