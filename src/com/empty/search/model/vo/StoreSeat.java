package com.empty.search.model.vo;

public class StoreSeat {

	private String storeId;
	private int col;
	private int row;
	private String storeCheck;
	
	public StoreSeat() {
		// TODO Auto-generated constructor stub
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

	public String getStoreCheck() {
		return storeCheck;
	}

	public void setStoreCheck(String storeCheck) {
		this.storeCheck = storeCheck;
	}

	public StoreSeat(String storeId, int col, int row, String storeCheck) {
		super();
		this.storeId = storeId;
		this.col = col;
		this.row = row;
		this.storeCheck = storeCheck;
	}

	@Override
	public String toString() {
		return "StoreSeat [storeId=" + storeId + ", col=" + col + ", row=" + row + ", storeCheck=" + storeCheck + "]";
	}
	
	
}
