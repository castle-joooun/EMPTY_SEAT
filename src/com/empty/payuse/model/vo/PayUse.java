package com.empty.payuse.model.vo;

import java.sql.Date;

public class PayUse {

	private String store_name;
	private String user_id;
	private int paymoney;
	private Date stime;
	private Date etime;
	
	public PayUse() {
		// TODO Auto-generated constructor stub
	}
	
	

	public PayUse(String store_name, String user_id, int paymoney, Date stime, Date etime) {
		super();
		this.store_name = store_name;
		this.user_id = user_id;
		this.paymoney = paymoney;
		this.stime = stime;
		this.etime = etime;
	}



	public String getStore_name() {
		return store_name;
	}

	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getPaymoney() {
		return paymoney;
	}

	public void setPaymoney(int paymoney) {
		this.paymoney = paymoney;
	}

	public Date getStime() {
		return stime;
	}

	public void setStime(Date stime) {
		this.stime = stime;
	}

	public Date getEtime() {
		return etime;
	}

	public void setEtime(Date etime) {
		this.etime = etime;
	}



	@Override
	public String toString() {
		return "PayUse [store_name=" + store_name + ", user_id=" + user_id + ", paymoney=" + paymoney + ", stime="
				+ stime + ", etime=" + etime + "]";
	}
	
	
	
	
	
	
	
}
