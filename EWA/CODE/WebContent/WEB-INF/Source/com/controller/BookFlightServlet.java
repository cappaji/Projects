package com.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.db.conn.MySQLDataStoreUtilities;
import com.model.pojo.Airlines;
import com.model.pojo.FlightDetails;

public class BookFlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BookFlightServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Book button clicked in FlightSearchResults");
		System.out.println("==========================Inside doGet() of BookFlightServlet==========================");
		
		String departureDate;
		String departureTime;
		String arrivalDate;
		String arrivalTime;
		String flightNumber;
		String departureTerminal;
		String arrivalTerminal;
		String numberOfStops;
		String departureCity;
		String arrivalCity;
		String departureAirportName;
		String arrivalAirportName;
		String flightModel;
		String travelTime;
		String carrierCode;
		String airlinesName;
		String airlinesImage;
		Double price=0.0;

		String appId="6c7a6743";
		String appKey="85ae27fe5dc1487949b7323df8059ec8";
		
		String buttonValue=request.getParameter("bookButton").replace("-","/");
		System.out.println("Value passed from Flight Search servlet : "+buttonValue);
		
		String airlineFields[];
		airlineFields=buttonValue.split("/");
		price=Double.parseDouble(airlineFields[0]);
		carrierCode=airlineFields[1];
		flightNumber=airlineFields[2];
		departureDate=airlineFields[3]+"/"+airlineFields[4]+"/"+airlineFields[5];
		
		System.out.println("Price : "+price);
		System.out.println("Carrier code :"+carrierCode);
		System.out.println("Departure Date : "+departureDate);
		
		HttpSession session=request.getSession(false);
		HashMap<String,Airlines> airlinesMap=(HashMap<String,Airlines>)session.getAttribute("airlinesMap");
		System.out.println("AirlinesMap size : "+airlinesMap.size());
		
		Airlines airline=airlinesMap.get(carrierCode);
		airlinesName=airline.getAirlinesName();
		airlinesImage=airline.getImage();
		
		URL url=new URL("https://api.flightstats.com/flex/schedules/rest/v1/json/flight/"+carrierCode+"/"+flightNumber+"/departing/"+departureDate+"?appId="+appId+"&appKey="+appKey);
		System.out.println("REST API URL : "+url);
		HttpURLConnection conn=null;
		
		try {
			conn = (HttpURLConnection) url.openConnection();//open the Connection
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}
			InputStream in = conn.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));//From the Response body, each and every byte will be read
			String line;
			StringBuilder sb = new StringBuilder();
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			String data = sb.toString();
			System.out.println("data : " + data);
			
			//Converting output JSON String to Java Objects
			
			JSONParser parser = new JSONParser();
			JSONObject mainObject = (JSONObject) parser.parse(data);
			
			JSONArray scheduledFlightsArray=(JSONArray)mainObject.get("scheduledFlights");
			JSONObject flightObject=(JSONObject)scheduledFlightsArray.get(0);
			
			departureDate=flightObject.get("departureTime").toString().substring(0,10);
			departureTime=flightObject.get("departureTime").toString().substring(11, 16);
			arrivalDate=flightObject.get("arrivalTime").toString().substring(0,10);
			arrivalTime=flightObject.get("arrivalTime").toString().substring(11, 16);
			
			carrierCode=flightObject.get("carrierFsCode").toString();
			flightNumber=flightObject.get("flightNumber").toString();
			
			departureTerminal=flightObject.get("arrivalTerminal").toString();
			arrivalTerminal=flightObject.get("arrivalTerminal").toString();
			numberOfStops=flightObject.get("stops").toString();
			if(numberOfStops.equals("0")){
				numberOfStops="Non stop";
			}
			else{
				numberOfStops=numberOfStops+" Stops";
			}
			
			JSONObject appendixObject=(JSONObject)mainObject.get("appendix");
			JSONArray airportsArray=(JSONArray)appendixObject.get("airports");
			JSONObject departureAirportObject=(JSONObject)airportsArray.get(0);
			JSONObject arrivalAirportObject=(JSONObject)airportsArray.get(1);
			
			departureCity=departureAirportObject.get("city").toString();
			arrivalCity=arrivalAirportObject.get("city").toString();
			departureAirportName=departureAirportObject.get("name").toString();
			arrivalAirportName=arrivalAirportObject.get("name").toString();
			
			JSONArray equipmentArray=(JSONArray)appendixObject.get("equipments");
			JSONObject equipmentObject=(JSONObject)equipmentArray.get(0);
			flightModel=equipmentObject.get("name").toString();
			
			//Finding Flight durationx
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
			//	Custom date format;
			Date d1=null;
			Date d2=null;
			try {
				d1 = format.parse(flightObject.get("departureTime").toString());
				d2 = format.parse(flightObject.get("arrivalTime").toString());
		    } catch (ParseException e) {
		        e.printStackTrace();
		    }
			
			long diff = (d2.getTime() - d1.getTime())/1000;
			long diffHours = diff / 3600;
			diff=diff%3600;
			long diffMinutes = diff / 60;
			travelTime=diffHours+"h "+diffMinutes+" m";
			
			//End of date and time formatting
			MySQLDataStoreUtilities mySql=new MySQLDataStoreUtilities();
			Airlines selectedFlight=mySql.getAirlines(carrierCode);
			
			String flightDetailsRow="<tr><td>"+departureCity+" To "+arrivalCity+"</td><td><i class='fa fa-clock-o' aria-hidden='true'></i>"+travelTime+"</td><td>"+numberOfStops+"</td></tr>";
			flightDetailsRow=flightDetailsRow+"<tr><td><ul><li><img src='"+airlinesImage+"' style='width:70px;height:70px'></img></li><li>"+airlinesName+"</li><li>"+carrierCode+"-"+flightNumber+"</li><li>"+flightModel+"</li></ul><td><ul><li>"+departureDate+"</li><li>"+departureTime+"</li><li>"+departureCity+"</li></li>"+departureAirportName+"</li><li>Terminal "+departureTerminal+"</li></ul></td><td><ul><li>"+arrivalDate+"</li><li>"+arrivalTime+"</li><li>"+arrivalCity+"</li><li>"+arrivalAirportName+"</li><li>Terminal "+arrivalTerminal+"</li></ul></td></tr>";
			
			System.out.println("Airlines Name : "+airlinesName);
			System.out.println("Airlines Code : "+carrierCode);
			System.out.println("Airlines Image : "+airlinesImage);
			System.out.println("Departure city : "+departureCity);
			System.out.println("Departure Date : "+departureDate);
			System.out.println("Departure Time : "+departureTime);
			System.out.println("Departure Airport Name: "+departureAirportName);
			System.out.println("Departure Terminal : "+departureTerminal);
			System.out.println("Arrival city : "+arrivalCity);
			System.out.println("Arrival Date : "+arrivalDate);
			System.out.println("Arrival Time : "+arrivalTime);
			System.out.println("Arrival Airport Name: "+arrivalAirportName);
			System.out.println("Arrival Terminal : "+arrivalTerminal);
			System.out.println("Travel Time : "+travelTime);
			System.out.println("Number of Stops : "+numberOfStops);
			System.out.println("Flight Number : "+flightNumber);
			System.out.println("Flight Model : "+flightModel);
			System.out.println("Total price : ");
			
			FlightDetails flightDetails=new FlightDetails(carrierCode, airlinesName, airlinesImage, flightNumber, departureDate, departureTime, departureCity, departureAirportName, departureTerminal, arrivalDate, arrivalTime, arrivalCity, arrivalAirportName, arrivalTerminal, numberOfStops, travelTime, flightModel, price);
			session.setAttribute("flightDetails", flightDetails);
			
			RequestDispatcher rd = request.getRequestDispatcher("FlightReview.jsp");
			request.setAttribute("flightDetailsRow",flightDetailsRow);
			request.setAttribute("selectedFlight",selectedFlight);
			rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			conn.disconnect();
		}
	}
}