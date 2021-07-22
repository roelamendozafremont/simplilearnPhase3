package com.sporty.shoes.mngt.app.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@Table(name = "user_table")
@DynamicUpdate

@NamedQueries(value = {
		@NamedQuery(name = "User.findLikefname", query = "SELECT p FROM User p WHERE p.fname LIKE ?1"), })

public class User {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", length = 60, nullable = false)
	private String ID;

	@Column(name = "fname", length = 60, nullable = false)
	private String fname;

	@Column(name = "lname", length = 60, nullable = false)
	private String lname;

	@Column(name = "address", length = 160, nullable = true)
	private String address;

	@Column(name = "age", nullable = true)
	private int age;

	@Column(name = "date_added", nullable = false)
	private Date dateAdded;

	@Column(name = "emailid", length = 60, nullable = false)
	private String emailId;

	@Column(name = "pwd", length = 60, nullable = false)
	private String pwd;

	public String getID() {
		return this.ID;
	}

	public String getEmail() {
		return this.emailId;
	}

	public String getFname() {
		return this.fname;
	}

	public String getLname() {
		return this.lname;
	}

	public String getAddress() {
		return this.address;
	}

	public String getPwd() {
		return this.pwd;
	}

	public int getAge() {
		return this.age;
	}

	public Date getDateAdded() {
		return this.dateAdded;
	}

	public void setID(String id) {
		this.ID = id;
	}

	public void setEmail(String value) {
		this.emailId = value;
	}

	public void setFname(String value) {
		this.fname = value;
	}

	public void setLname(String value) {
		this.lname = value;
	}

	public void setAddress(String value) {
		this.address = value;
	}

	public void setPwd(String value) {
		this.pwd = value;
	}

	public void setAge(int value) {
		this.age = value;
	}

	public void setDateAdded(Date date) {
		this.dateAdded = date;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String id, String fname, String lname, String email, String password) {
		super();
		this.setID(id);
		this.setFname(fname);
		this.setLname(lname);
		this.setEmail(email);
		this.setPwd(password);
	}

	public String returnPrintString() {
		return this.getID() + ", " + this.getFname() + " " + this.getLname() + " " + this.getEmail() + " "
				+ this.getPwd();
	}

}
