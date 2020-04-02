package com.empty.search.model.vo;

public class Store {

	private String storeId;
	private String storeName;
	private String storePhone;
	private String storeTime;
	private String storeInfo;
	private String storeFacility;
	private String storeAddress;
	private String storeLogo;
	private String email;
	private String enrollDate;
	private int storePrice;
	
	
	public Store() {
		// TODO Auto-generated constructor stub
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

	public String getStorePhone() {
		return storePhone;
	}

	public void setStorePhone(String storePhone) {
		this.storePhone = storePhone;
	}

	public String getStoreTime() {
		return storeTime;
	}

	public void setStoreTime(String storeTime) {
		this.storeTime = storeTime;
	}

	public String getStoreInfo() {
		return storeInfo;
	}

	public void setStoreInfo(String storeInfo) {
		this.storeInfo = storeInfo;
	}

	public String getStoreFacility() {
		return storeFacility;
	}

	public void setStoreFacility(String storeFacility) {
		this.storeFacility = storeFacility;
	}

	public String getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}

	public String getStoreLogo() {
		return storeLogo;
	}

	public void setStoreLogo(String storeLogo) {
		this.storeLogo = storeLogo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}
	
	public int getStorePrice() {
		return storePrice;
	}

	public void setStorePrice(int storePrice) {
		this.storePrice = storePrice;
	}

	@Override
	public String toString() {
		return "Store [storeId=" + storeId + ", storeName=" + storeName + ", storePhone=" + storePhone + ", storeTime="
				+ storeTime + ", storeInfo=" + storeInfo + ", storeFacility=" + storeFacility + ", storeAddress="
				+ storeAddress + ", storeLogo=" + storeLogo + ", email=" + email + ", enrollDate=" + enrollDate + "]";
	}

	public Store(String storeId, String storeName, String storePhone, String storeTime, String storeInfo,
			String storeFacility, String storeAddress, String storeLogo,int storePrice) {
		super();
		this.storeId = storeId;
		this.storeName = storeName;
		this.storePhone = storePhone;
		this.storeTime = storeTime;
		this.storeInfo = storeInfo;
		this.storeFacility = storeFacility;
		this.storeAddress = storeAddress;
		this.storeLogo = storeLogo;
		this.storePrice = storePrice;
	}
	public Store(String storeId, String storeName, String storePhone, String storeTime, String storeInfo,
			String storeFacility, String storeAddress, String storeLogo, String email, String enrollDate) {
		super();
		this.storeId = storeId;
		this.storeName = storeName;
		this.storePhone = storePhone;
		this.storeTime = storeTime;
		this.storeInfo = storeInfo;
		this.storeFacility = storeFacility;
		this.storeAddress = storeAddress;
		this.storeLogo = storeLogo;
		this.email = email;
		this.enrollDate = enrollDate;
	}

	public Store(String storeId, String storeName, String storePhone, String storeTime, String storeInfo,
			String storeFacility, String storeAddress, String storeLogo, String email, String enrollDate,
			int storePrice) {
		super();
		this.storeId = storeId;
		this.storeName = storeName;
		this.storePhone = storePhone;
		this.storeTime = storeTime;
		this.storeInfo = storeInfo;
		this.storeFacility = storeFacility;
		this.storeAddress = storeAddress;
		this.storeLogo = storeLogo;
		this.email = email;
		this.enrollDate = enrollDate;
		this.storePrice = storePrice;
	}
	
	
/*    STORE_ID VARCHAR2(40) PRIMARY KEY,
    STORE_NAME VARCHAR2(40) NOT NULL,
    STORE_PHONE VARCHAR2(30) NOT NULL,
    STORE_TIME VARCHAR2(200),
    STORE_INFO VARCHAR2(300) NOT NULL,
    STORE_ADDRESS VARCHAR2(100) NOT NULL,
    STORE_LOGO VARCHAR2(100) NOT NULL,
    CONSTRAINTS FK_STORE_ID FOREIGN KEY(STORE_ID)
    REFERENCES MEMBER(USERID)*/
}