package com.empty.member.model.vo;

import java.util.Date;

public class outMoneyDB {
	private String userId;
	private int outputNum;
	private Date omDate;
	private String omNumber;
	private int om;
	private int afterOm;
	
	public outMoneyDB() {
		// TODO Auto-generated constructor stub
	}

	public outMoneyDB(String userId, int outputNum, Date omDate, String omNumber, int om, int afterOm) {
		super();
		this.userId = userId;
		this.outputNum = outputNum;
		this.omDate = omDate;
		this.omNumber = omNumber;
		this.om = om;
		this.afterOm = afterOm;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getOutputNum() {
		return outputNum;
	}

	public void setOutputNum(int outputNum) {
		this.outputNum = outputNum;
	}

	public Date getOmDate() {
		return omDate;
	}

	public void setOmDate(Date omDate) {
		this.omDate = omDate;
	}

	public String getOmNumber() {
		return omNumber;
	}

	public void setOmNumber(String omNumber) {
		this.omNumber = omNumber;
	}

	public int getOm() {
		return om;
	}

	public void setOm(int om) {
		this.om = om;
	}

	public int getAfterOm() {
		return afterOm;
	}

	public void setAfterOm(int afterOm) {
		this.afterOm = afterOm;
	}

	@Override
	public String toString() {
		return "outMoneyDB [userId=" + userId + ", outputNum=" + outputNum + ", omDate=" + omDate + ", omNumber="
				+ omNumber + ", om=" + om + ", afterOm=" + afterOm + "]";
	}

	
	
	
	
}
