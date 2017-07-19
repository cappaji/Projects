package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.pojo.Airlines;
import com.model.pojo.FlightDetails;

public class ProcessFlightReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProcessFlightReviewServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Continue button clicked in FlightReview.jsp");
		System.out.println("==========================Inside doPost() of ProcessFlightReviewServlet==========================");
		
		RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
		rd.forward(request, response);
		
		/*FlightDetails flightDetails=(FlightDetails)session.getAttribute("flightDetails");
		RequestDispatcher rd = request.getRequestDispatcher("PassengerDetails.jsp");
		rd.forward(request, response);*/
	}
}