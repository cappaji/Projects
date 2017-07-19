package com.model.pojo;

public class FlightDetails {

	String flightId;
	String carrierCode;
	String airlinesName;
	String airlinesImage;
	String flightNumber;
	
	String departureDate;
	String departureTime;
	String departureCity;
	String departureAirportName;
	String departureTerminal;
	
	String arrivalDate;
	String arrivalTime;
	String arrivalCity;
	String arrivalAirportName;
	String arrivalTerminal;
	
	String numberOfStops;
	String travelTime;
	String flightModel;
	double price;
	public FlightDetails(String carrierCode, String airlinesName, String airlinesImage, String flightNumber,
			String departureDate, String departureTime, String departureCity, String departureAirportName,
			String departureTerminal, String arrivalDate, String arrivalTime, String arrivalCity,
			String arrivalAirportName, String arrivalTerminal, String numberOfStops, String travelTime,
			String flightModel, double price) {
		super();
		this.carrierCode = carrierCode;
		this.airlinesName = airlinesName;
		this.airlinesImage = airlinesImage;
		this.flightNumber = flightNumber;
		this.departureDate = departureDate;
		this.departureTime = departureTime;
		this.departureCity = departureCity;
		this.departureAirportName = departureAirportName;
		this.departureTerminal = departureTerminal;
		this.arrivalDate = arrivalDate;
		this.arrivalTime = arrivalTime;
		this.arrivalCity = arrivalCity;
		this.arrivalAirportName = arrivalAirportName;
		this.arrivalTerminal = arrivalTerminal;
		this.numberOfStops = numberOfStops;
		this.travelTime = travelTime;
		this.flightModel = flightModel;
		this.price = price;
	}
	public String getCarrierCode() {
		return carrierCode;
	}
	public void setCarrierCode(String carrierCode) {
		this.carrierCode = carrierCode;
	}
	public String getAirlinesName() {
		return airlinesName;
	}
	public void setAirlinesName(String airlinesName) {
		this.airlinesName = airlinesName;
	}
	public String getAirlinesImage() {
		return airlinesImage;
	}
	public void setAirlinesImage(String airlinesImage) {
		this.airlinesImage = airlinesImage;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public String getDepartureCity() {
		return departureCity;
	}
	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}
	public String getDepartureAirportName() {
		return departureAirportName;
	}
	public void setDepartureAirportName(String departureAirportName) {
		this.departureAirportName = departureAirportName;
	}
	public String getDepartureTerminal() {
		return departureTerminal;
	}
	public void setDepartureTerminal(String departureTerminal) {
		this.departureTerminal = departureTerminal;
	}
	public String getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public String getArrivalCity() {
		return arrivalCity;
	}
	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}
	public String getArrivalAirportName() {
		return arrivalAirportName;
	}
	public void setArrivalAirportName(String arrivalAirportName) {
		this.arrivalAirportName = arrivalAirportName;
	}
	public String getArrivalTerminal() {
		return arrivalTerminal;
	}
	public void setArrivalTerminal(String arrivalTerminal) {
		this.arrivalTerminal = arrivalTerminal;
	}
	public String getNumberOfStops() {
		return numberOfStops;
	}
	public void setNumberOfStops(String numberOfStops) {
		this.numberOfStops = numberOfStops;
	}
	public String getTravelTime() {
		return travelTime;
	}
	public void setTravelTime(String travelTime) {
		this.travelTime = travelTime;
	}
	public String getFlightModel() {
		return flightModel;
	}
	public void setFlightModel(String flightModel) {
		this.flightModel = flightModel;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}