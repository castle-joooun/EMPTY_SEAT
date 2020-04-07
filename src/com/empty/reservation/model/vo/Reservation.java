package com.empty.reservation.model.vo;

import java.util.Date;

public class Reservation {
	
	private String storeId;
	private String seatNum;
	private String seatYN;
	private String seatEndTime;
	
	public Reservation() {
		// TODO Auto-generated constructor stub
	}

	public Reservation(String storeId, String seatNum, String seatYN, String seatEndTime) {
		super();
		this.storeId = storeId;
		this.seatNum = seatNum;
		this.seatYN = seatYN;
		this.seatEndTime = seatEndTime;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(String seatNum) {
		this.seatNum = seatNum;
	}

	public String getSeatYN() {
		return seatYN;
	}

	public void setSeatYN(String seatYN) {
		this.seatYN = seatYN;
	}

	public String getSeatEndTime() {
		return seatEndTime;
	}

	public void setSeatEndTime(String seatEndTime) {
		this.seatEndTime = seatEndTime;
	}

	@Override
	public String toString() {
		return "Reservation [storeId=" + storeId + ", seatNum=" + seatNum + ", seatYN=" + seatYN + ", seatEndTime="
				+ seatEndTime + "]";
	}
	
	
	
	
}
