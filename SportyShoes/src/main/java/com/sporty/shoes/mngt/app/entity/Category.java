package com.sporty.shoes.mngt.app.entity;



import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;

import javax.persistence.Table;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;



@Entity
@Table(name = "category_table")
@DynamicUpdate

@NamedQueries(value = { 
		@NamedQuery(name = "Category.findLikename", query = "SELECT p FROM Category p WHERE p.name LIKE ?1"),
		})

public class Category {

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", length=60,nullable=false)
	private String ID;

	@Column(name = "name",length=60,nullable=false)
	private String name;

	public String getID() {
		return this.ID;
	}

	public String getName() {
		return this.name;
	}

	public void setID(String id) {
		this.ID = id;
	}

	public void setName(String value) {
		this.name = value;
	}

	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Category(String id, String name) {
		super();
		this.setID(id);
		this.setName(name);
	}
	
	public String returnPrintString() {
		return this.getID()+", "+this.getName();
	}
	
}
