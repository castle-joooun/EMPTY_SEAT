package com.empty.search.model.vo;

public class StoreSeat {

	private String storeId;
	private int col;
	private int row;
	private String seatNum;
	private String seatCheck;
	
	public StoreSeat() {
		// TODO Auto-generated constructor stub
	}
	
	public StoreSeat(String storeId, int col, int row, String seatNum, String seatCheck) {
		super();
		this.storeId = storeId;
		this.col = col;
		this.row = row;
		this.seatNum = seatNum;
		this.seatCheck = seatCheck;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public String getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(String seatNum) {
		this.seatNum = seatNum;
	}

	public String getSeatCheck() {
		return seatCheck;
	}

	public void setSeatCheck(String seatCheck) {
		this.seatCheck = seatCheck;
	}

	@Override
	public String toString() {
		return "StoreSeat [storeId=" + storeId + ", col=" + col + ", row=" + row + ", seatNum=" + seatNum
				+ ", seatCheck=" + seatCheck + "]";
	}
	
}
