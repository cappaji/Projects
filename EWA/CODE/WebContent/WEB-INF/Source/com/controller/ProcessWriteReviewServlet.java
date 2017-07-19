package com.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.db.conn.MongoDBDataStoreUtilities;
import com.model.pojo.Reviews;


public class ProcessWriteReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ProcessWriteReviewServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("|Submit Review| button clicked in Payment.jsp");
		System.out.println("==========================Inside doGet() of ProcessWriteReviewServlet==========================");
		
		String airlineName=request.getParameter("airlinesNameSelect");
		HttpSession session=request.getSession(false);
		String reviewerName=(String)session.getAttribute("UserId");
		int reviewRating=Integer.parseInt(request.getParameter("star"));
		String reviewText=request.getParameter("reviewText");
		Date reviewDate=new Date();
		
		MongoDBDataStoreUtilities mongoDBInsert=new MongoDBDataStoreUtilities();
		Reviews review=new Reviews(airlineName,reviewerName, reviewRating, reviewText, reviewDate);
		
		Boolean SuccessFlag=mongoDBInsert.insertReview(airlineName,reviewerName,reviewRating,reviewText);
		if(SuccessFlag){
			System.out.println("Add review success message displayed");
			RequestDispatcher rd = request.getRequestDispatcher("WriteReview.jsp");
			request.setAttribute("AddReviewMessage","Review submitted successfully!");
			rd.forward(request, response);
		}
	}
}