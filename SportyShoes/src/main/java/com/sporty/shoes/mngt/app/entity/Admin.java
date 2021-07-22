package com.sporty.shoes.mngt.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
@Table(name = "admin_table")
@DynamicUpdate


@NamedQueries(value = { 
		@NamedQuery(name = "Admin.findLikeadminid", query = "SELECT p FROM Admin p WHERE p.adminId LIKE ?1"),
		})


public class Admin {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", length=60,nullable=false)
	private String ID;

	@Column(name = "admin_id",length=60,nullable=false)
	private String adminId;

	@Column(name = "admin_pwd",length=60,nullable=false)
	private String pwd;

	public String getID() {
		return this.ID;
	}

	public String getAdminId() {
		return this.adminId;
	}

	public String getAdminPwd() {
		return this.pwd;
	}

	public void setID(String id) {
		this.ID = id;
	}

	public void setAdminId(String value) {
		this.adminId = value;
	}

	public void setAdminPwd(String value) {
		this.pwd = value;
	}
	
	
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Admin(String adminid, String id, String adminpwd) {
		super();
		this.setID(id);
		this.setAdminId(adminid);
		this.setAdminPwd(adminpwd);
	}
	
	public String returnPrintString() {
		return this.getID()+", "+this.getAdminId()+" "+this.getAdminPwd();
	}
	
}
