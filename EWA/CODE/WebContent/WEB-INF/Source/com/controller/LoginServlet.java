package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.db.conn.MySQLDataStoreUtilities;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("|LOGIN| button clicked in Login.jsp");
		System.out.println("==========================Inside doPost() of LoginServlet==========================");
		String EnteredUserId=request.getParameter("EmailId");
		String EnteredPassword=request.getParameter("Password");
		String EnteredUserRole=request.getParameter("UserRole");
		System.out.println("Entered parameters - \nUserId	:	"+EnteredUserId+"\nPassword	:	"+EnteredPassword+"\nUserRole	:	"+EnteredUserRole);
		
		MySQLDataStoreUtilities mySql=new MySQLDataStoreUtilities();
		String[] userValidation=mySql.checkUserAccount(EnteredUserId, EnteredPassword);
		String errorFlag=userValidation[0];
		String errorMessage=userValidation[1];
		
		System.out.println("Error Message : "+errorMessage+" Error flag : "+errorFlag);
		if(errorFlag.equalsIgnoreCase("true")){
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
				request.setAttribute("ErrorMsg",errorMessage);
				rd.forward(request, response);
		}
		else{
				System.out.println("Login successful");
				HttpSession session=request.getSession(true);
				session.setAttribute("UserId",EnteredUserId);
				session.setAttribute("UserRole", EnteredUserRole);
				
				RequestDispatcher rd = request.getRequestDispatcher("PassengerDetails.jsp");
				rd.forward(request, response);
		}
	}
}
