package com.model.pojo;

public class Passenger {
	
	String firstName;
	String lastName;
	String gender;
	String passengerType;
	String phone;
	String email;
	String passportNumber;
	String issuingCountry;
	String mealPreference;
	public Passenger(String firstName, String lastName, String gender, String passengerType, String phone, String email, String passportNumber,
			String issuingCountry, String mealPreference) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.passengerType = passengerType;
		this.phone = phone;
		this.email = email;
		this.passportNumber = passportNumber;
		this.issuingCountry = issuingCountry;
		this.mealPreference = mealPreference;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPassengerType() {
		return passengerType;
	}
	public void setPassengerType(String passengerType) {
		this.passengerType = passengerType;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	public String getIssuingCountry() {
		return issuingCountry;
	}
	public void setIssuingCountry(String issuingCountry) {
		this.issuingCountry = issuingCountry;
	}
	public String getMealPreference() {
		return mealPreference;
	}
	public void setMealPreference(String mealPreference) {
		this.mealPreference = mealPreference;
	}
}