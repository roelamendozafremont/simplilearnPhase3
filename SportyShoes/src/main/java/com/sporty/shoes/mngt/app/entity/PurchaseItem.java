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
@Table(name = "purchase_item_tables")
@DynamicUpdate


@NamedQueries(value = {
		@NamedQuery(name = "PurchaseItem.findLikeuserid", query = "SELECT p FROM PurchaseItem p WHERE p.userId LIKE ?1"), })


public class PurchaseItem {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", length=60,nullable=false)
	private String ID;

	@Column(name = "purchase_id", length=60,nullable=false)
	private String purchaseId;

	@Column(name = "product_id", length=60,nullable=false)
	private String productId;

	@Column(name = "user_id", length=60,nullable=false)
	private String userId;

	@Column(name = "rate")
	private BigDecimal rate;

	@Column(name = "qty")
	private int qty;

	@Column(name = "price")
	private BigDecimal price;

	public String getID() {
		return this.ID;
	}

	public String getPurchaseId() {
		return this.purchaseId;
	}

	public String getProductId() {
		return this.productId;
	}

	public String getUserId() {
		return this.userId;
	}

	public BigDecimal getRate() {
		return this.rate;
	}

	public int getQty() {
		return this.qty;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setID(String id) {
		this.ID = id;
	}

	public void setPurchaseId(String value) {
		this.purchaseId = value;
	}

	public void setProductId(String value) {
		this.productId = value;
	}

	public void setUserId(String value) {
		this.userId = value;
	}

	public void setRate(BigDecimal value) {
		this.rate = value;
	}

	public void setQty(int value) {
		this.qty = value;
	}

	public void setPrice(BigDecimal value) {
		this.price = value;
	}

	public PurchaseItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PurchaseItem(String id, String purchaseid, String productid, String userid, int quantity, BigDecimal rate, BigDecimal price) {
		super();
		this.setID(id);
		this.setPurchaseId(purchaseid);
		this.setProductId(productid);
		this.setUserId(userid);
		this.setRate(rate);
		this.setQty(quantity);
		this.setPrice(price);
	}	
	
	
	public String returnPrintString() {
		return this.getID()+", "+this.getPurchaseId()+" "+this.getProductId()+" "+this.getUserId()+" "+this.getRate()+" "+this.getQty()+" "+this.getPrice();
	}
	
}
