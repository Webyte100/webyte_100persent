/**
* This class describes entity of Collection Model of product. Table is created and Column names are mentioned.
* Getters and Setters are taken.
* @author K.Vihitha, T.M.Yasaswini
* @version 1.8.0_311
**/

package com.ibm.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "collection")
public class CollectionModel {
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name = "collection_name")
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}