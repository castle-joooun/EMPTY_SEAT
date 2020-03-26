package com.semi.model.vo;

public class VinUser {
	
	
	private String userId;
	private String password;
	private int cash;
	
	
	public VinUser() {}
	
	public VinUser(String userId, String password, int cash) {
		super();
		this.userId = userId;
		this.password = password;
		this.cash = cash;
	}	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getCash() {
		return cash;
	}
	public void setCash(int cash) {
		this.cash = cash;
	}
		
}
