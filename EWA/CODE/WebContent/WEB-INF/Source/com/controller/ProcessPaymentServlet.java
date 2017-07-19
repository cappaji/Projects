package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.db.conn.MySQLDataStoreUtilities;
import com.model.pojo.CreditCardPayment;
import com.model.pojo.FlightDetails;
import com.model.pojo.Passenger;

public class ProcessPaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProcessPaymentServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("|Pay| button clicked in Payment.jsp");
		System.out.println("==========================Inside doGet() of ProcessPaymentServlet==========================");
		String creditCardNumber=request.getParameter("creditCardNumber");
		String cardExpiryMonth=request.getParameter("cardExpiryMonth");
		String cardExpiryYear=request.getParameter("cardExpiryYear");
		String cardHoldersName=request.getParameter("cardHoldersName").toUpperCase();
		String cvv=request.getParameter("cvv");
		
		System.out.println("User Inputs");
		System.out.println("CreditCard Number : "+creditCardNumber);
		System.out.println("Card expiry month : "+cardExpiryMonth);
		System.out.println("Card expiry year : "+cardExpiryYear);
		System.out.println("Card holders name : "+cardHoldersName);
		System.out.println("CVV : "+cvv);
		
		CreditCardPayment CreditCardPayment=new CreditCardPayment(creditCardNumber, cardExpiryMonth, cardExpiryYear, cardHoldersName, cvv);
		
		/*HttpSession session=request.getSession(false);
		Passenger passenger=(Passenger)session.getAttribute("passengerDetails");*/
		
		MySQLDataStoreUtilities mySQL=new MySQLDataStoreUtilities();
		
		HttpSession session=request.getSession(false);
		FlightDetails flightDetails=(FlightDetails)session.getAttribute("flightDetails");
		Passenger passenger=(Passenger)session.getAttribute("passenger");
		
		int paymentId;
		int passengerId;
		int airlinesId;
		int flightId;
		int PNR;
		
		paymentId=mySQL.insertCreditCardDetails(CreditCardPayment);//Inserting Credit card details
		System.out.println("Payment ID back from DB : "+paymentId);
		if(paymentId!=0)
		{
			System.out.println("Credit Card details successfully saved in DB : "+paymentId);
			creditCardNumber=CreditCardPayment.getCreditCardNumber();
			session.setAttribute("creditCardNumber", creditCardNumber.substring(creditCardNumber.length()-4, creditCardNumber.length()));
			passengerId=mySQL.insertPassengerDetails(passenger);//Inserting Passenger details
			System.out.println("Passenger Id BACK from DB : "+passengerId);
			if(passengerId!=0){
				System.out.println("Passenger details successfully saved in DB : "+passengerId);
				String carrierCode=flightDetails.getCarrierCode();
				airlinesId=mySQL.getAirlinesId(carrierCode);
				System.out.println("Airlines Id BACK DB : "+airlinesId);
				
				flightId=mySQL.insertFlightDetails(airlinesId, flightDetails);//Inserting Flight details
				if(flightId!=0){
					System.out.println("Flight details successfully saved in DB : "+flightId);
					PNR=mySQL.insertIntoBooking(passengerId, flightId, paymentId);
					System.out.println("PNR BACK from DB : "+PNR);
					session.setAttribute("PNR",PNR);
				}
			}
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("BookingConfirmation.jsp");
		rd.forward(request, response);
	}
}