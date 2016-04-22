package com.bionic.edu.payment;

import javax.persistence.*;

@Entity
public class Payment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private java.sql.Date dt;
	private int merchantId;
	private int customerId;
	private String goods;
	private double sumPayed;
	private double chargePayed;
	
	public Payment() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public java.sql.Date getDt() {
		return dt;
	}

	public void setDt(java.sql.Date dt) {
		this.dt = dt;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getGoods() {
		return goods;
	}

	public void setGoods(String goods) {
		this.goods = goods;
	}

	public double getSumPayed() {
		return sumPayed;
	}

	public void setSumPayed(double sumPayed) {
		this.sumPayed = sumPayed;
	}

	public double getChargePayed() {
		return chargePayed;
	}

	public void setChargePayed(double chargePayed) {
		this.chargePayed = chargePayed;
	}

	public int getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(int merchantId) {
		this.merchantId = merchantId;
	}

	public String getPayList() {
		String payList = "<tr><td>" + this.getDt() + "<td>" + this.getMerchantId() + "<td>" + this.getCustomerId() + "<td>" + this.getGoods() + "<td>" + this.getSumPayed() + "<td>" + this.getChargePayed() + "</tr>";
		return payList;
	}
}
