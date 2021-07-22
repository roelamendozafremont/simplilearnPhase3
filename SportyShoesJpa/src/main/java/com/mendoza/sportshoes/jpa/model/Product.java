package com.mendoza.sportshoes.jpa.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull @Size (min = 2, message = "name should have atleast 2 characters")
	@Column(name = "name")
	private String name;
	
	@NotNull @Size (min = 2, message = "description should have atleast 2 characters")
	@Column(name = "description")
	private String description;
	
	@NotNull @Size(min = 2, message = "code should have atleast 2 characters")
	@Column(name = "code")
	private String code;
	
	@NotNull (message = "price is mandatory")
	@Column(name = "price")
	private BigDecimal price;
	
	@NotNull (message = "price is mandatory")
	@Column(name = "dateadded")
	private Date dateadded;
	
	public Product(Integer id, String name, String description, String code, BigDecimal price, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.code = code;
		this.price = price;
		this.dateadded = new Date();
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
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


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

	public String toString() {
		return String.format("Product [id=%s, name=%s, description=%s, code=%s, price=%s, , dateadded=%s]", id, name, description, code, String.valueOf(price), dateadded);
	}

}
