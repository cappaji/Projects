package com.model.pojo;

public class CreditCardPayment {
	String creditCardNumber;
	String cardExpiryMonth;
	String cardExpiryYear;
	String cardHoldersName;
	String cvv;
	public CreditCardPayment(String creditCardNumber, String cardExpiryMonth, String cardExpiryYear,
			String cardHoldersName, String cvv) {
		super();
		this.creditCardNumber = creditCardNumber;
		this.cardExpiryMonth = cardExpiryMonth;
		this.cardExpiryYear = cardExpiryYear;
		this.cardHoldersName = cardHoldersName;
		this.cvv = cvv;
	}
	public String getCreditCardNumber() {
		return creditCardNumber;
	}
	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	public String getCardExpiryMonth() {
		return cardExpiryMonth;
	}
	public void setCardExpiryMonth(String cardExpiryMonth) {
		this.cardExpiryMonth = cardExpiryMonth;
	}
	public String getCardExpiryYear() {
		return cardExpiryYear;
	}
	public void setCardExpiryYear(String cardExpiryYear) {
		this.cardExpiryYear = cardExpiryYear;
	}
	public String getCardHoldersName() {
		return cardHoldersName;
	}
	public void setCardHoldersName(String cardHoldersName) {
		this.cardHoldersName = cardHoldersName;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
}