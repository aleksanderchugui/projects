package com.bionic.edu.transmoney;

import javax.persistence.*;

@Entity
public class Transmoney {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int merchantId;
	private double sumSent;
	private java.sql.Date sentDate;
	private short status;
	
	Transmoney() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(int merchantId) {
		this.merchantId = merchantId;
	}

	public double getSumSent() {
		return sumSent;
	}

	public void setSumSent(double sumSent) {
		this.sumSent = sumSent;
	}

	public java.sql.Date getSentDate() {
		return sentDate;
	}

	public void setSentDate(java.sql.Date sentDate) {
		this.sentDate = sentDate;
	}

	public short getStatus() {
		return status;
	}

	public void setStatus(short status) {
		this.status = status;
	}
	
	public String getTransmoneyList() {
		String trnsMon = "<tr><td>" + this.getId() + "<td>" + this.getMerchantId() + "<td>" + this.getSumSent() + "<td>" + this.getSentDate() + "<td>" + this.getStatus() + "</tr>";
		return trnsMon;
	}
	
}
