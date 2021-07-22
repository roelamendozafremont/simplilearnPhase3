package com.sporty.shoes.mngt.app.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
@Table(name = "purchase_table")
@DynamicUpdate

@NamedQueries(value = {
		@NamedQuery(name = "Purchase.findLikeuserid", query = "SELECT p FROM Purchase p WHERE p.userId LIKE ?1"), })

public class Purchase {

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", length=60,nullable=false)
	private String ID;

	@Column(name = "user_id", length = 60, nullable = false)
	private String userId;

	@Column(name = "date", nullable = false)
	private Date date;

	@Column(name = "gross_total", nullable = false)
	private BigDecimal total;

	public String getID() {
		return this.ID;
	}

	public String getUserId() {
		return this.userId;
	}

	public BigDecimal getTotal() {
		return this.total;
	}

	public Date getDate() {
		return this.date;
	}

	public void setID(String id) {
		this.ID = id;
	}

	public void setUserId(String value) {
		this.userId = value;
	}

	public void setTotal(BigDecimal value) {
		this.total = value;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Purchase() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Purchase(String id, String userid, BigDecimal total) {
		super();
		this.setID(id);
		this.setUserId(userid);
		this.setTotal(total);
		this.setDate(new Date());
	}

	public String returnPrintString() {
		return this.getID()+", "+this.getUserId()+" "+this.getTotal()+" "+this.getDate();
	}
}
