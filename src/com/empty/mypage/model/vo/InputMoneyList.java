package com.empty.mypage.model.vo;

import java.sql.Date;

public class InputMoneyList {

	
	private String user_id;
	private int input_num;
	private Date ipdate;
	private int ipmoney;
	private int after_im;
	
	public InputMoneyList() {
		// TODO Auto-generated constructor stub
	}
	
	public InputMoneyList(String user_id, int input_num, Date ipdate, int ipmoney, int after_im) {
		super();
		this.user_id = user_id;
		this.input_num = input_num;
		this.ipdate = ipdate;
		this.ipmoney = ipmoney;
		this.after_im = after_im;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getInput_num() {
		return input_num;
	}

	public void setInput_num(int input_num) {
		this.input_num = input_num;
	}

	public Date getIpdate() {
		return ipdate;
	}

	public void setIpdate(Date ipdate) {
		this.ipdate = ipdate;
	}

	public int getIpmoney() {
		return ipmoney;
	}

	public void setIpmoney(int ipmoney) {
		this.ipmoney = ipmoney;
	}

	public int getAfter_im() {
		return after_im;
	}

	public void setAfter_im(int after_im) {
		this.after_im = after_im;
	}

	@Override
	public String toString() {
		return "InputMoneyList [user_id=" + user_id + ", input_num=" + input_num + ", ipdate=" + ipdate + ", ipmoney="
				+ ipmoney + ", after_im=" + after_im + "]";
	}
	
	
	
	
}
