package com.ibm.entity;

import javax.persistence.*;

@Entity
@Table(name="prod_review")
public class ProductReview {
	@Id @GeneratedValue @Column(name="prodreview_id")
	private int prodrevId;
	
	//Each review belongs to a user
	@ManyToOne
	@JoinColumn(name="userId") //joining the userId column (from Users java program) to this table
	private User user;
	
	//Each review is about a single product
	@ManyToOne
	@JoinColumn(name="prodId") //joining the prodId column (from Products java program) to this table
	private Product products;

	@Column(length=30)
	private String title;
	
	@Column
	private int rating;
	
	@Column(length=1000)
	private String revDesc;
	
	//created at timestamp needs to be added
	public int getRevId() {
		return prodrevId;
	}

	public void setRevId(int revId) {
		this.prodrevId = revId;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getRevDesc() {
		return revDesc;
	}

	public void setRevDesc(String revDesc) {
		this.revDesc = revDesc;
	}
}
