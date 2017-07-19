package com.db.conn;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import com.model.pojo.Airlines;
import com.model.pojo.CreditCardPayment;
import com.model.pojo.FlightDetails;
import com.model.pojo.Passenger;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class MySQLDataStoreUtilities {

	static final String JDBC_Driver="com.mysql.jdbc.Driver";
	static final String DB_URL="jdbc:mysql://localhost:3306/AIRLINES?useSSL=false";
	static final String User_Name="root";
	static final String Password="root";
	
	public Boolean insertNewAirline(Airlines a){
		System.out.println("============Inside MySQLDataStoreUtilities class insertNewAirline() method============");
		Connection conn=null;
		Boolean successFlag=false;
		try{
			Class.forName(JDBC_Driver);//Register the Driver
			conn=(Connection) DriverManager.getConnection(DB_URL,User_Name,Password);
			if(conn!=null){
				String insertPassengerDetailsQuery="INSERT INTO AIRLINES VALUES(NULL,'"+a.getAirlinesName()+"','"+a.getCarrierFsCode()+"','"+a.getImage()+"');";
				System.out.println("Query is :"+insertPassengerDetailsQuery);
				PreparedStatement prepstmtInsert=(PreparedStatement) conn.prepareStatement(insertPassengerDetailsQuery);
				int rows = prepstmtInsert.executeUpdate();
				if(rows>0){
					System.out.println("New Airlines inserted successfully");
					successFlag=true;
				}
				else{
					System.out.println("Error inserting New Airlines into DB");
					successFlag=false;
				}
			}
			else
			{
				System.out.println("Connection is null");
			}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
			if(conn!=null)
				conn.close();
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
		}
		return successFlag;
	}
	
	public int insertCreditCardDetails(CreditCardPayment c){
		System.out.println("============Inside MySQLDataStoreUtilities class insertCreditCardDetails() method============");
		Connection conn=null;
		Boolean successFlag=false;
		int paymentId=0;
		try{
			Class.forName(JDBC_Driver);//Register the Driver
			conn=(Connection) DriverManager.getConnection(DB_URL,User_Name,Password);
			if(conn!=null){
				String insertCreditCardDetailsQuery="INSERT INTO CREDITCARD_PAYMENT VALUES(NULL,'"+c.getCreditCardNumber()+"','"+c.getCardExpiryMonth()+"','"+c.getCardExpiryYear()+"','"+c.getCardHoldersName()+"','"+c.getCvv()+"');";
				System.out.println("Query is :"+insertCreditCardDetailsQuery);
				PreparedStatement prepstmtInsert=(PreparedStatement) conn.prepareStatement(insertCreditCardDetailsQuery);
				int rows = prepstmtInsert.executeUpdate();
				if(rows>0){
					System.out.println("Credit card details inserted successfully");
					successFlag=true;
					String getPaymentIdQuery="SELECT MAX(PAYMENT_ID) FROM CREDITCARD_PAYMENT";
					System.out.println("Query is : "+getPaymentIdQuery);
					PreparedStatement prepstmtGet=(PreparedStatement) conn.prepareStatement(getPaymentIdQuery);
					ResultSet rs=prepstmtGet.executeQuery();
					if(rs.next()){
						do{
							paymentId=rs.getInt("MAX(PAYMENT_ID)");
						}while(rs.next());
					}
				}
				else{
					System.out.println("Error inserting Credit card details into DB");
					successFlag=false;
				}
			}
			else
			{
				System.out.println("Connection is null");
			}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
			if(conn!=null)
				conn.close();
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
		}
		return paymentId;
	}
	
	public int insertPassengerDetails(Passenger p){
		System.out.println("============Inside MySQLDataStoreUtilities class insertPassengerDetails() method============");
		Connection conn=null;
		int passengerId=0;
		Boolean successFlag=false;
		try{
			Class.forName(JDBC_Driver);//Register the Driver
			conn=(Connection) DriverManager.getConnection(DB_URL,User_Name,Password);
			if(conn!=null){
				String insertPassengerDetailsQuery="INSERT INTO PASSENGER VALUES(NULL,'"+p.getFirstName()+"','"+p.getLastName()+"','"+p.getGender()+"','"+p.getPassengerType()+"','"+p.getPhone()+"','"+p.getEmail()+"','"+p.getPassportNumber()+"','"+p.getIssuingCountry()+"','"+p.getMealPreference()+"');";
				System.out.println("Query is :"+insertPassengerDetailsQuery);
				PreparedStatement prepstmtInsert=(PreparedStatement) conn.prepareStatement(insertPassengerDetailsQuery);
				int rows = prepstmtInsert.executeUpdate();
				if(rows>0){
					System.out.println("Passenger details inserted successfully");
					successFlag=true;
					String getPaymentIdQuery="SELECT MAX(PASSENGER_ID) FROM PASSENGER";
					System.out.println("Query is : "+getPaymentIdQuery);
					PreparedStatement prepstmtGet=(PreparedStatement) conn.prepareStatement(getPaymentIdQuery);
					ResultSet rs=prepstmtGet.executeQuery();
					if(rs.next()){
						do{
							passengerId=rs.getInt("MAX(PASSENGER_ID)");
						}while(rs.next());
					}
				}
				else{
					System.out.println("Error inserting Passenger details into DB");
					successFlag=false;
				}
			}
			else
			{
				System.out.println("Connection is null");
			}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
			if(conn!=null)
				conn.close();
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
		}
		return passengerId;
	}
	
	public int insertIntoBooking(int passengerId,int flightId,int paymentId){
		System.out.println("============Inside MySQLDataStoreUtilities class insertIntoBooking() method============");
		Connection conn=null;
		Boolean successFlag=false;
		int pnr=0;
		try{
			Class.forName(JDBC_Driver);//Register the Driver
			conn=(Connection) DriverManager.getConnection(DB_URL,User_Name,Password);
			if(conn!=null){
				String insertIntoBookingQuery="INSERT INTO BOOKING VALUES(NULL,'"+passengerId+"','"+flightId+"','"+paymentId+"');";
				System.out.println("Query is :"+insertIntoBookingQuery);
				PreparedStatement prepstmtInsert=(PreparedStatement) conn.prepareStatement(insertIntoBookingQuery);
				int rows = prepstmtInsert.executeUpdate();
				if(rows>0){
					System.out.println("Credit card details inserted successfully");
					successFlag=true;
					String getPNRQuery="SELECT MAX(PNR) FROM BOOKING";
					System.out.println("Query is : "+getPNRQuery);
					PreparedStatement prepstmtGet=(PreparedStatement) conn.prepareStatement(getPNRQuery);
					ResultSet rs=prepstmtGet.executeQuery();
					if(rs.next()){
						do{
							pnr=rs.getInt("MAX(PNR)");
						}while(rs.next());
					}
				}
				else{
					System.out.println("Error inserting Booking into DB");
					successFlag=false;
				}
			}
			else
			{
				System.out.println("Connection is null");
			}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
			if(conn!=null)
				conn.close();
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
		}
		return pnr;
	}
	
	public int getAirlinesId(String carrierCode){
		System.out.println("============Inside MySQLDataStoreUtilities class getAllAirlines() method============");
		Connection conn=null;
		int airlinesID=0;
		try{
			Class.forName(JDBC_Driver);//Register the Driver
			conn=(Connection) DriverManager.getConnection(DB_URL,User_Name,Password);
			if(conn!=null){
				String getAllAirlinesQuery="SELECT AIRLINES_ID FROM AIRLINES WHERE CARRIER_FS_CODE='"+carrierCode+"';";
				PreparedStatement prepstmtGet=(PreparedStatement) conn.prepareStatement(getAllAirlinesQuery);
				ResultSet rs = prepstmtGet.executeQuery();
				if(rs.next()){
					do{
						airlinesID=rs.getInt("AIRLINES_ID");
					}while(rs.next());
				}
			}
			else
			{
				System.out.println("Connection is null");
			}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
			if(conn!=null)
				conn.close();
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
		}
		return airlinesID;
	}
	
	public int insertFlightDetails(int airlinesId,FlightDetails f){
	System.out.println("============Inside MySQLDataStoreUtilities class insertFlightDetails() method============");
	Connection conn=null;
	int flightId=0;
	Boolean successFlag=false;
	try{
		Class.forName(JDBC_Driver);//Register the Driver
		conn=(Connection) DriverManager.getConnection(DB_URL,User_Name,Password);
		if(conn!=null){
			String insertPassengerDetailsQuery="INSERT INTO FLIGHTDETAILS VALUES(NULL,'"+airlinesId+"','"+f.getFlightNumber()+"','"+f.getDepartureDate()+"','"+f.getDepartureTime()+"','"+f.getDepartureCity()+"','"+f.getDepartureAirportName()+"','"+f.getDepartureTerminal()+"','"+f.getArrivalDate()+"','"+f.getArrivalTime()+"','"+f.getArrivalCity()+"','"+f.getArrivalAirportName()+"','"+f.getArrivalTerminal()+"','"+f.getNumberOfStops()+"','"+f.getTravelTime()+"','"+f.getFlightModel()+"','"+f.getPrice()+"');";
			System.out.println("Query is :"+insertPassengerDetailsQuery);
			PreparedStatement prepstmtInsert=(PreparedStatement) conn.prepareStatement(insertPassengerDetailsQuery);
			int rows = prepstmtInsert.executeUpdate();
			if(rows>0){
				System.out.println("Flight details inserted successfully");
				successFlag=true;
				String getPNRQuery="SELECT MAX(FLIGHT_ID) FROM FLIGHTDETAILS";
				System.out.println("Query is : "+getPNRQuery);
				PreparedStatement prepstmtGet=(PreparedStatement) conn.prepareStatement(getPNRQuery);
				ResultSet rs=prepstmtGet.executeQuery();
				if(rs.next()){
					do{
						flightId=rs.getInt("MAX(FLIGHT_ID)");
					}while(rs.next());
				}
			}
			else{
				System.out.println("Error inserting Flight details into DB");
				successFlag=false;
			}
		}
		else
		{
			System.out.println("Connection is null");
		}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
			if(conn!=null)
				conn.close();
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
		}
		return flightId;
	}
	
	public HashMap<String, Airlines> getAllAirlines(){
		System.out.println("============Inside MySQLDataStoreUtilities class getAllAirlines() method============");
		Connection conn=null;
		HashMap<String, Airlines> airlinesMap=new HashMap<String, Airlines>();
		String carrierCode;
		try{
			Class.forName(JDBC_Driver);//Register the Driver
			conn=(Connection) DriverManager.getConnection(DB_URL,User_Name,Password);
			if(conn!=null){
				String getAllAirlinesQuery="SELECT * FROM AIRLINES";
				PreparedStatement prepstmtGet=(PreparedStatement) conn.prepareStatement(getAllAirlinesQuery);
				ResultSet rs = prepstmtGet.executeQuery();
				if(rs.next()){
					do{
						carrierCode=rs.getString("CARRIER_FS_CODE");
						Airlines a=new Airlines(rs.getString("AIRLINES_NAME"),rs.getString("CARRIER_FS_CODE"),rs.getString("IMAGE"));
						airlinesMap.put(carrierCode, a);
					}while(rs.next());
				}
			}
			else
			{
				System.out.println("Connection is null");
			}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
			if(conn!=null)
				conn.close();
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
		}
		return airlinesMap;
	}
	
	public Airlines getAirlines(String carrierCode){
		System.out.println("============Inside MySQLDataStoreUtilities class getAirlines() method============");
		Connection conn=null;
		Airlines airline=null;
		try{
			Class.forName(JDBC_Driver);//Register the Driver
			conn=(Connection) DriverManager.getConnection(DB_URL,User_Name,Password);
			if(conn!=null){
				String getAllAirlinesQuery="SELECT * FROM AIRLINES WHERE CARRIER_FS_CODE='"+carrierCode+"';";
				PreparedStatement prepstmtGet=(PreparedStatement) conn.prepareStatement(getAllAirlinesQuery);
				ResultSet rs = prepstmtGet.executeQuery();
				if(rs.next()){
					do{
						carrierCode=rs.getString("CARRIER_FS_CODE");
						airline=new Airlines(rs.getString("AIRLINES_NAME"),rs.getString("CARRIER_FS_CODE"),rs.getString("IMAGE"));
					}while(rs.next());
				}
			}
			else
			{
				System.out.println("Connection is null");
			}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
			if(conn!=null)
				conn.close();
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
		}
		return airline;
	}
	
	public String[] checkUserName(String EnteredUserId,String EnteredPassword, String EnteredUserRole){
		System.out.println("============Inside MySQLDataStoreUtilities class checkUserName() method============");
		Connection conn=null;
		String DBMessage="";
		String DBErrorFlag="false";
		try{
			Class.forName(JDBC_Driver);//Register the Driver
			conn=(Connection) DriverManager.getConnection(DB_URL,User_Name,Password);
			if(conn!=null){
				String CheckUserSql="SELECT * FROM USERACCOUNTS where UserName='"+EnteredUserId+"';";//Check if the entered user already exist
				PreparedStatement prepstmt=(PreparedStatement) conn.prepareStatement(CheckUserSql);
				ResultSet rs= prepstmt.executeQuery();
				if(!rs.next()){//Checking for Entered UserID in DB.If account does not exist, then create new account.
					System.out.println("User account does not exist");
					String CreateUserSql="INSERT into USERACCOUNTS values('"+EnteredUserId+"','"+EnteredPassword+"','"+EnteredUserRole+"');";
					System.out.println("Query is : "+CreateUserSql);
					PreparedStatement prepstmtInsert=(PreparedStatement) conn.prepareStatement(CreateUserSql);
					int rows = prepstmtInsert.executeUpdate();
					if(rows>0){
						System.out.println("User account created successfully.Please login");
						DBMessage="User account created successfully.Please login";
					}
				}
				else{//User account already exist. 
					System.out.println("Error! --- Account with entered UserId already exist");
					DBMessage="Error! --- Account with entered UserId already exist";
					DBErrorFlag="true";
				}
			}
			else{
				System.out.println("Connection is null");
			}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
			if(conn!=null)
				conn.close();
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
		}
		return new String[]{DBErrorFlag,DBMessage};
	}
	
	public String[] checkUserAccount(String EnteredUserId,String EnteredUserPassword){
		System.out.println("============Inside MySQLDataStoreUtilities class checkUserAccount() method============");
		Connection conn=null;
		String validationMessage="";
		String errorFlag="false";
		try{
			Class.forName(JDBC_Driver);//Register the Driver
			conn=(Connection) DriverManager.getConnection(DB_URL,User_Name,Password);
			if(conn!=null){
				String LoginSql="SELECT * FROM USERACCOUNTS where USERNAME='"+EnteredUserId+"';";
				PreparedStatement prepstmt=(PreparedStatement) conn.prepareStatement(LoginSql);
				ResultSet rs= prepstmt.executeQuery();
				if(!rs.next()){//Checking for Entered UserID in DB
					System.out.println("Error! --- User account does not exist");
					validationMessage="User account does not exist";
					errorFlag="true";
				}
				else{
					System.out.println("User account exists");
					
					String UserIdDB = rs.getString("Username");
					String PasswordDB = rs.getString("Passwords");
					String UserRoleDB=rs.getString("Role");
					System.out.println("DB UserName : " + UserIdDB);
					System.out.println("DB password : " + PasswordDB);
					System.out.println("DB UserRole : " + UserRoleDB);
					
					if(EnteredUserPassword.equals(PasswordDB)){
						validationMessage="Welcome "+EnteredUserId;
					}
					else{
						System.out.println("Error! --- Invalid password entered");
						validationMessage="Invalid Password";
						errorFlag="true";
					}
				}
			}
			else
			{
				System.out.println("Connection is null");
			}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
			if(conn!=null)
				conn.close();
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
		}
		return new String[]{errorFlag,validationMessage};
	}
}