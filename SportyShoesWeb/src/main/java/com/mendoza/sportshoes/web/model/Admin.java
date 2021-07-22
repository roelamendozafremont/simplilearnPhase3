package com.mendoza.sportshoes.web.model;

public class Admin {

	private Integer id;
	private String name;
	private String password;
	private String email;
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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


	
	
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Admin(String name, Integer id, String password, String email) {
		super();
		this.setId(id);
		this.setName(name);
		this.setPassword(password);
		this.setEmail(email);
	}
	
	public String returnPrintString() {
		return this.getId()+", "+this.getName()+" "+this.getPassword()+" "+this.getEmail();
	}
	
}
