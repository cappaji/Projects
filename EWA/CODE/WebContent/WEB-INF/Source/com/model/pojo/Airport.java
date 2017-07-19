package com.model.pojo;

public class Airport {
	String cityName;
	String cityCode;
	
	public Airport(String cityName,String cityCode){
		this.cityName=cityName;
		this.cityCode=cityCode;
	}

	public String getcityName() {
		return cityName;
	}

	public void setcityName(String cityName) {
		cityName = cityName;
	}

	public String getcityCode() {
		return cityCode;
	}

	public void setcityCode(String cityCode) {
		cityCode = cityCode;
	}
	
}
