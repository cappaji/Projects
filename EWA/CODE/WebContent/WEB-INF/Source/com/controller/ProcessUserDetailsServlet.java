package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.db.conn.MySQLDataStoreUtilities;
import com.model.pojo.Passenger;

public class ProcessUserDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProcessUserDetailsServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("|Make Secure payment| button clicked in PassengerDetails.jsp");
		System.out.println("==========================Inside doPost() of ProcessUserDetailsServlet==========================");
		
		String gender=request.getParameter("gender");
		String passengerFirstName=request.getParameter("firstName");
		String passengerLastName=request.getParameter("lastName");
		String passengerType=request.getParameter("passengerType");
		
		String dobDay=request.getParameter("DOBDay");
		String dobMonth=request.getParameter("DOBMonth");
		String dobYear=request.getParameter("DOByear");
		
		String mealPreference=request.getParameter("mealPreference");
		
		String passportNumber=request.getParameter("passportNumber");
		String issuingCountry=request.getParameter("issuingCountry");
		String doeDay=request.getParameter("DOEDay");
		String doeMonth=request.getParameter("DOEMonth");
		String doeYear=request.getParameter("DOEyear");
		
		String phoneNumber=request.getParameter("phoneNumber");
		String email=request.getParameter("email");
		
		System.out.println("First name : "+passengerFirstName);
		System.out.println("Last name : "+passengerLastName);
		Passenger passenger=new Passenger(passengerFirstName,passengerLastName,gender,passengerType,phoneNumber,email,passportNumber,issuingCountry,mealPreference);
		
		/*MySQLDataStoreUtilities mySQL=new MySQLDataStoreUtilities();
		mySQL.insertPassengerDetails(passenger);*/
		
		HttpSession session=request.getSession(false);
		session.setAttribute("passenger", passenger);
		
		RequestDispatcher rd = request.getRequestDispatcher("Payment.jsp");
		rd.forward(request, response);
	}
}