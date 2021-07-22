package com.mendoza.sportshoes.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "categories")
public class Category {
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
	
	public Category(Integer id, String name, String description, String code) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.code = code;
	}

	public Category() {
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
		return String.format("Category [id=%s, name=%s, description=%s, code=%s]", id, name, description, code);
	}

}
