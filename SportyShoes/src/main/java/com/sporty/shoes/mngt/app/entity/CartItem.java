package com.sporty.shoes.mngt.app.entity;

import java.math.BigDecimal;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;

import javax.persistence.Table;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
@Table(name = "cart_item_table")
@DynamicUpdate

@NamedQueries(value = { 
		@NamedQuery(name = "CartIem.findLikename", query = "SELECT p FROM CartItem p WHERE p.name LIKE ?1"),
		})

public class CartItem {

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", length=60,nullable=false)
	private String ID;	

	@Column(name = "productId", length=60,nullable=false)
	private String productId;
	
	@Column(name = "name",length=60,nullable=false)
	private String name;
	
	@Column(name = "rate", nullable=false)
	private BigDecimal rate;
	
	@Column(name = "price", nullable=false)	
	private BigDecimal price;
	
	@Column(name = "qty", nullable=false)
	private int qty;


	
	public String getID() {
		return this.ID;
	}
	
	public String getProductId() {
		return this.productId;
	}

	public String getName() {
		return this.name;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public BigDecimal getRate() {
		return this.rate;
	}

	public int getQty() {
		return this.qty;
	}
	
	public void setID(String id) {
		this.ID = id;
	}

	public void setProductId(String id) {
		this.productId = id;
	}

	public void setName(String value) {
		this.name = value;
	}

	public void setPrice(BigDecimal value) {
		this.price = value;
	}

	public void setRate(BigDecimal value) {
		this.rate = value;
	}

	public void setQty(int value) {
		this.qty = value;
	}
	
	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CartItem(String id, String productid, String name, BigDecimal rate, BigDecimal price, int qty) {
		super();
		this.setID(id);
		this.setProductId(productid);
		this.setName(name);
		this.setRate(rate);
		this.setPrice(price);
		this.setQty(qty);
	}
	
	public String returnPrintString() {
		return this.getID()+", "+this.getProductId()+" "+this.getName()+" "+this.getRate()+" "+this.getPrice()+" "+this.getQty();
	}
	
	
}
