package com.mendoza.sportshoes.web.model;

import java.math.BigDecimal;
import java.util.Date;

public class Product {

	private Integer id;
	private String name;
	private String description;
	private String code;
	private BigDecimal price;
	private Date dateadded;
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return this.name;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String value) {
		this.name = value;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Date getDateadded() {
		return dateadded;
	}

	public void setDateadded(Date dateadded) {
		this.dateadded = dateadded;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(Integer id, String name, String description, String code, BigDecimal price) {
		super();
		this.setId(id);
		this.setName(name);
		this.setDescription(description);
		this.setCode(code);
		this.setPrice(price);
		this.setDateadded(new Date());
	}
	
	public String returnPrintString() {
		return this.getId()+", "+this.getName()+" "+this.getDescription()+" "+this.getCode()+" "+String.valueOf(this.getPrice())+" "+this.getDateadded();
	}
	
}
