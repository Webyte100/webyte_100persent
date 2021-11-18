package com.ibm.entity;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name="products")
public class Product {
	@Id @GeneratedValue @Column(name="prod_id")
	private int prodId;
	
	@Column(length=30)
	private String prodName;
	
	//each product can have MORE THAN 1 reviews
	@OneToMany(mappedBy = "products") //on line "17" in review entity
	private List<ProductReview> revPid;
	
	//each product can be in order items
	@OneToMany(mappedBy = "products") //on line "17" in orderItem entity
	private List<OrderItem> itemPid;
	
	@Column(length=100)
	private String prodDesc;
	
	@Column(length=30)
	private String category; //type
	
	@Column(length=30)
	private int sku;
	
	@Column(length=30)
	private long price;
	
	@Column(length=30)
	private int discount;
	
	@Column(length=30)
	private int quantity;
	
	@Column(length=250)
	private int summary;

	public int getProdId() {
		return prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public List<ProductReview> getRevPid() {
		return revPid;
	}

	public void setRevPid(List<ProductReview> revPid) {
		this.revPid = revPid;
	}

	public List<OrderItem> getItemPid() {
		return itemPid;
	}

	public void setItemPid(List<OrderItem> itemPid) {
		this.itemPid = itemPid;
	}

	public String getProdDesc() {
		return prodDesc;
	}

	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getSku() {
		return sku;
	}

	public void setSku(int sku) {
		this.sku = sku;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getSummary() {
		return summary;
	}

	public void setSummary(int summary) {
		this.summary = summary;
	}
}
