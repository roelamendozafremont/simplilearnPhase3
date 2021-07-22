package com.mendoza.sportshoes.web.model;

public class Customer {

	private Integer id;
	private String firstname;
	private String lastname;
	private String email;
	private String address;
	private String creditnumber;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCreditnumber() {
		return creditnumber;
	}

	public void setCreditnumber(String creditnumber) {
		this.creditnumber = creditnumber;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(Integer id, String firstname, String lastname, String email, String address, String creditnumber) {
		super();
		this.setId(id);
		this.setFirstname(firstname);
		this.setLastname(lastname);
		this.setEmail(email);
		this.setAddress(address);
		this.setCreditnumber(creditnumber);
	}
	
	public String returnPrintString() {
		return this.getId()+", "+this.getFirstname()+" "+this.getLastname()+" "+this.getEmail()+" "+this.getAddress()+" "+this.getCreditnumber();
	}
	
}
