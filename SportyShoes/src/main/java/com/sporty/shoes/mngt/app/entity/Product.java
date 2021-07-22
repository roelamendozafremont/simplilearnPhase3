package com.sporty.shoes.mngt.app.entity;

import java.math.BigDecimal;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;

import javax.persistence.Table;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;



@Entity
@Table(name = "product_table")
@DynamicUpdate


@NamedQueries(value = { 
		@NamedQuery(name = "Product.findLikename", query = "SELECT p FROM Product p WHERE p.name LIKE ?1"),
		})

public class Product {

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", length=60,nullable=false)
	private String ID;

	@Column(name = "name",length=60,nullable=false)
	private String name;

	@Column(name = "price",nullable=false)
	private BigDecimal price;

	@Column(name = "date_added",nullable=false)
	private Date dateAdded;

	@Column(name = "category_id", length=60,nullable=false)
	private String categoryId;

	public String getID() {
		return this.ID;
	}

	public String getName() {
		return this.name;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public String getCategoryId() {
		return this.categoryId;
	}

	public Date getDateAdded() {
		return this.dateAdded;
	}

	public void setID(String id) {
		this.ID = id;
	}

	public void setName(String value) {
		this.name = value;
	}

	public void setPrice(BigDecimal value) {
		this.price = value;
	}

	public void setCategoryId(String value) {
		this.categoryId = value;
	}

	public void setDateAdded(Date date) {
		this.dateAdded = date;
	}
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Product(String id, String name, BigDecimal price, String categoryID) {
		super();
		this.setID(id);
		this.setName(name);
		this.setPrice(price);
		this.setCategoryId(categoryID);
		this.setDateAdded(new Date());
	}
	
	public String returnPrintString() {
		return this.getID()+", "+this.getCategoryId()+" "+this.getName()+" "+this.getPrice()+" "+this.getDateAdded();
	}
}
