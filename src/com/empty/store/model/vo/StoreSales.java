package com.empty.store.model.vo;

import java.util.Date;

public class StoreSales {

	 private String storeId;
	 private String storeName;
	 private Date enDate;
	 private char dayOfWeek;
	 private int customer;
	 private int netProfit;
	 private int tax;
	 private int totalProfit;
	 private String sdfDate;
	 
	public String getSdfDate() {
		return sdfDate;
	}
	public void setSdfDate(String sdfDate) {
		this.sdfDate = sdfDate;
	}
	public StoreSales() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StoreSales(String storeId, String storeName, Date enDate, char dayOfWeek, int customer, int netProfit,
			int tax, int totalProfit) {
		super();
		this.storeId = storeId;
		this.storeName = storeName;
		this.enDate = enDate;
		this.dayOfWeek = dayOfWeek;
		this.customer = customer;
		this.netProfit = netProfit;
		this.tax = tax;
		this.totalProfit = totalProfit;
	}
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public Date getEnDate() {
		return enDate;
	}
	public void setEnDate(Date enDate) {
		this.enDate = enDate;
	}
	public char getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(char dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	public int getCustomer() {
		return customer;
	}
	public void setCustomer(int customer) {
		this.customer = customer;
	}
	public int getNetProfit() {
		return netProfit;
	}
	public void setNetProfit(int netProfit) {
		this.netProfit = netProfit;
	}
	public int getTax() {
		return tax;
	}
	public void setTax(int tax) {
		this.tax = tax;
	}
	public int getTotalProfit() {
		return totalProfit;
	}
	public void setTotalProfit(int totalProfit) {
		this.totalProfit = totalProfit;
	}
	@Override
	public String toString() {
		return "StoreSales [storeId=" + storeId + ", storeName=" + storeName + ", enDate=" + enDate + ", dayOfWeek="
				+ dayOfWeek + ", customer=" + customer + ", netProfit=" + netProfit + ", tax=" + tax + ", totalProfit="
				+ totalProfit + ", sdfDate=" + sdfDate + "]";
	}
	 


}

