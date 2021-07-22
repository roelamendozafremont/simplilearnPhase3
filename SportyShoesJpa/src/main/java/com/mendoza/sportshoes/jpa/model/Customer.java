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
@Table(name = "customers")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull @Size (min = 2, message = "firstname should have atleast 2 characters")
	@Column(name = "firstname")
	private String firstname;
	
	@NotNull @Size (min = 2, message = "lastname should have atleast 2 characters")
	@Column(name = "lastname")
	private String lastname;
	
	@NotEmpty @Email(message = "email is a required field")
	@Column(name = "email")
	private String email;
	
	@NotNull @Size (min = 2, message = "address should have atleast 2 characters")
	@Column(name = "address")
	private String address;
	
	@NotNull @Size(min = 2, message = "address should have atleast 2 characters")
	@Column(name = "creditnumber")
	private String creditnumber;

	public Customer(Integer id, String firstname, String lastname, String email, String address, String creditnumber) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.address = address;
		this.creditnumber = creditnumber;
	}

	public Customer() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	@Override
	public String toString() {
		return String.format("Customer [id=%s, firstName=%s, lastName=%s, email=%s, address=%s, creditnumber=%s]", id, firstname, lastname, email, address, creditnumber);
	}

}
