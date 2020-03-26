package com.empty.member.model.vo;

import java.util.Date;

public class Member {

	private String userId;
	private boolean userDiv;
	private String password;
	private String userName;
	private String email;
	private String phone;
	private String address;
	private String gender;
	private int cash;
	private Date enrollDate;
	private boolean userAppr;
	public Member() {
		super();
	}

	public Member(String email) {
		super();
		this.email = email;
	}

	public Member(String userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}
	
	public Member(String userId, String password, String userName, String email, String phone,
			String address, String gender) {
		super();
		this.userId = userId;
		this.password = password;
		this.userName = userName;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.gender = gender;
	}
	


	public Member(String userId, boolean userDiv, String password, String userName, String email, String phone,
			String address, String gender, int cash, Date enrollDate, boolean userAppr) {
		super();
		this.userId = userId;
		this.userDiv = userDiv;
		this.password = password;
		this.userName = userName;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.gender = gender;
		this.cash = cash;
		this.enrollDate = enrollDate;
		this.userAppr = userAppr;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public boolean isUserDiv() {
		return userDiv;
	}

	public void setUserDiv(boolean userDiv) {
		this.userDiv = userDiv;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getCash() {
		return cash;
	}
	public void setCash(int cash) {
		this.cash = cash;
	}
	public Date getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}
	public boolean isUserAppr() {
		return userAppr;
	}
	public void setUserAppr(boolean userAppr) {
		this.userAppr = userAppr;
	}
	@Override
	public String toString() {
		return "Member [userId=" + userId + ", userDiv=" + userDiv + ", password=" + password + ", userName=" + userName
				+ ", email=" + email + ", phone=" + phone + ", address=" + address + ", gender=" + gender + ", cash="
				+ cash + ", enrollDate=" + enrollDate + ", userAppr=" + userAppr + "]";
	}

}