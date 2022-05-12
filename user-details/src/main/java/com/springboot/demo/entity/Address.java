package com.springboot.demo.entity;

public class Address {
	
	private int aId;
	private String aStreet;
	private String aCity;
	private String aState;
	private String aCountry;
	private Long aPinCode;
	
	private int userId;

	public Address() {
		super();
	}

	public Address(int aId, String aStreet, String aCity, String aState, String aCountry, Long aPinCode) {
		super();
		this.aId = aId;
		this.aStreet = aStreet;
		this.aCity = aCity;
		this.aState = aState;
		this.aCountry = aCountry;
		this.aPinCode = aPinCode;
	}

	public Address(int aId, String aStreet, String aCity, String aState, String aCountry, Long aPinCode, int userId) {
		super();
		this.aId = aId;
		this.aStreet = aStreet;
		this.aCity = aCity;
		this.aState = aState;
		this.aCountry = aCountry;
		this.aPinCode = aPinCode;
		this.userId = userId;
	}

	public int getaId() {
		return aId;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}

	public String getaStreet() {
		return aStreet;
	}

	public void setaStreet(String aStreet) {
		this.aStreet = aStreet;
	}

	public String getaCity() {
		return aCity;
	}

	public void setaCity(String aCity) {
		this.aCity = aCity;
	}

	public String getaState() {
		return aState;
	}

	public void setaState(String aState) {
		this.aState = aState;
	}

	public String getaCountry() {
		return aCountry;
	}

	public void setaCountry(String aCountry) {
		this.aCountry = aCountry;
	}

	public Long getaPinCode() {
		return aPinCode;
	}

	public void setaPinCode(Long aPinCode) {
		this.aPinCode = aPinCode;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Address [aId=" + aId + ", aStreet=" + aStreet + ", aCity=" + aCity + ", aState=" + aState
				+ ", aCountry=" + aCountry + ", aPinCode=" + aPinCode + ", userId=" + userId + "]";
	}
	
}
