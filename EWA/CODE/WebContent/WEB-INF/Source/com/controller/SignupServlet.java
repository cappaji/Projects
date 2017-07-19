package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.conn.MySQLDataStoreUtilities;

public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SignupServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("|SIGNUP| button clicked in Signup.jsp");
		System.out.println("==========================Inside doPost() of SignupServlet==========================");
		
		try{
			String EnteredName=request.getParameter("Name");
			String EnteredUserId=request.getParameter("EmailId");
			String EnteredPassword=request.getParameter("Password");
			String EnteredRepeatPassword=request.getParameter("RepeatPassword");
			String EnteredUserRole=request.getParameter("userRoleSelect");
			System.out.println("Entered parameters - \nName	:	"+EnteredName+"\nEmailId	:	"+EnteredUserId+"\nPassword	:	"+EnteredPassword+"\nRepeatPassword	:	"+EnteredRepeatPassword+"\nUserRole	:	"+EnteredUserRole);
			
			String inputErrorMessage="";
			Boolean errorFlag=false;
			//trim
			//equalsIgnoreCase("")
			//isEmpty()
			//null
			if(EnteredName.trim().isEmpty()||EnteredName.equalsIgnoreCase(null))
			{
				inputErrorMessage="Enter your name\n";
				System.out.println("Name is empty");
				errorFlag=true;
			}
			if(EnteredUserId.trim().isEmpty()||EnteredUserId.equalsIgnoreCase(null))
			{
				inputErrorMessage=inputErrorMessage+"Enter a valid EmailId\n";
				System.out.println("EmailId is empty");
				errorFlag=true;
			}
			if(EnteredPassword.trim().isEmpty()||EnteredPassword.equals(null))
			{
				inputErrorMessage=inputErrorMessage+"Enter your password";
				System.out.println("Password is empty");
				errorFlag=true;
			}
			else if(EnteredRepeatPassword.trim().isEmpty()||EnteredRepeatPassword.equals(null))
			{
				inputErrorMessage="Type your password again";
				System.out.println("Type your password again");
				errorFlag=true;
			}
			else if(!(EnteredPassword).equals(EnteredRepeatPassword)){//Check if 2 strings are not equal
				inputErrorMessage="Passwords must match";
				System.out.println("Passwords must match");
				errorFlag=true;
			}
			if(errorFlag.equals(true)){
				RequestDispatcher rd = request.getRequestDispatcher("Signup.jsp");
				request.setAttribute("InputErrorMessage",inputErrorMessage);
				rd.forward(request, response);
			}
			else{
				System.out.println("No user input errors");
				
				MySQLDataStoreUtilities mySql=new MySQLDataStoreUtilities();
				String[] userValidation=mySql.checkUserName(EnteredUserId, EnteredPassword,EnteredUserRole);
				String DBErrorFlag=userValidation[0];
				String DBMessage=userValidation[1];
				System.out.println("Error Message : "+DBMessage+" Message : "+errorFlag);
				
				if(DBErrorFlag.equalsIgnoreCase("true")){
					RequestDispatcher rd = request.getRequestDispatcher("Signup.jsp");
					request.setAttribute("InputErrorMessage",DBMessage);
					rd.forward(request, response);
				}
				else{
					RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
					request.setAttribute("ErrorMsg",DBMessage);
					rd.forward(request, response);
				}
			}
		}
			catch(Exception e){
				e.printStackTrace();
			}
	}
}