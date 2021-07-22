package com.mendoza.sportshoes.web.model;

public class Category {

	private Integer id;
	private String name;
	private String description;
	private String code;
	
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

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(Integer id, String name, String description, String code) {
		super();
		this.setId(id);
		this.setName(name);
		this.setDescription(description);
		this.setCode(code);
	}
	
	public String returnPrintString() {
		return this.getId()+", "+this.getName()+" "+this.getDescription()+" "+this.getCode();
	}
	
}
