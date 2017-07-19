package com.model.pojo;

public class Airlines {
	
	String AirlinesName;
	String carrierFsCode;
	String Image;
	
	public Airlines(){
		
	}
	public Airlines(String airlinesName, String carrierFsCode, String image) {
		super();
		AirlinesName = airlinesName;
		this.carrierFsCode = carrierFsCode;
		Image = image;
	}
	public String getAirlinesName() {
		return AirlinesName;
	}
	public void setAirlinesName(String airlinesName) {
		AirlinesName = airlinesName;
	}
	public String getCarrierFsCode() {
		return carrierFsCode;
	}
	public void setCarrierFsCode(String carrierFsCode) {
		this.carrierFsCode = carrierFsCode;
	}
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
	}
}