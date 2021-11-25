/**
* This class describes entity of User. Creating Table and mentioning Column names.
* Getters and Setters are taken.
* @author K.Vihitha, T.M.Yasaswini
* @version 1.8.0_311
**/

package com.ibm.entity;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name="users")
public class User {//give trigger of sku from products table 
	@Id @GeneratedValue @Column(name="user_id")
	private int userId;
	
	//each user can give MORE THAN 1 reviews
	@OneToMany(mappedBy = "user") //on line "12" in orderItem java program
	private List<ProductReview> revUid;
//	
//	//each user is associated with many orderItems
	@OneToMany(mappedBy = "user") //on line "12" in orderItem java program
	private List<OrderItem> itemUid;
	
	@Column(length=30)
	private String fullName;
	
	@Column(length=30)
	private String emailId;
	
	@Column(length=30)
	private String passwd;
	
	@Column
	private long phoneNumber;
	
	@Column(length=50)
	private String lineOne;
	
	@Column(length=50)
	private String lineTwo;
	
	@Column(length=30)
	private String city;
	
	@Column(length=30)
	private String state;
	
	@Column
	private double pincode;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<ProductReview> getRevUid() {
		return revUid;
	}

	public void setRevUid(List<ProductReview> revUid) {
		this.revUid = revUid;
	}

	public List<OrderItem> getItemUid() {
		return itemUid;
	}

	public void setItemUid(List<OrderItem> itemUid) {
		this.itemUid = itemUid;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNo) {
		this.phoneNumber = phoneNo;
	}

	public String getLineOne() {
		return lineOne;
	}

	public void setLineOne(String lineOne) {
		this.lineOne = lineOne;
	}

	public String getLineTwo() {
		return lineTwo;
	}

	public void setLineTwo(String lineTwo) {
		this.lineTwo = lineTwo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public double getPincode() {
		return pincode;
	}

	public void setPincode(double pincode) {
		this.pincode = pincode;
	}
	
	
}
	
	
