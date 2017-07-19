package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewReviewServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("|View Review| button clicked in PassengerDetails.jsp");
		System.out.println("==========================Inside doGet() of ViewReviewServlet==========================");
		
		RequestDispatcher rd = request.getRequestDispatcher("ViewReview.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("|View Review| button clicked in PassengerDetails.jsp");
		System.out.println("==========================Inside doPost() of ViewReviewServlet==========================");
	}
}
