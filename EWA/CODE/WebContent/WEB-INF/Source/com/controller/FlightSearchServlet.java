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
import java.util.Random;

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
import com.poc.sax.ProductDataStore;

public class FlightSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FlightSearchServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("==========================Inside doGet() of FlightSearchServlet==========================");
		String departureCityInput=request.getParameter("departureAirport").toUpperCase();
		String departureCity=departureCityInput.substring(departureCityInput.indexOf("(")+1, departureCityInput.indexOf(")"));
		String arrivalCity=request.getParameter("arrivalAirport").toUpperCase();
		//Added for AJAX
		//String arrivalCityInput=request.getParameter("arrivalAirport").toUpperCase();
		//String arrivalCity=arrivalCityInput.substring(arrivalCityInput.indexOf("(")+1, arrivalCityInput.indexOf(")"));
		//End of Added for AJAX
		String departureDate=request.getParameter("departureDate").replace("-","/");
		String arrivalDate=request.getParameter("arrivalDate").replace("-","/");
		String tripType=request.getParameter("tripType");
		
		System.out.println("--------------User inputs---------------");
		System.out.println("Departure City : "+departureCity);
		System.out.println("Arrival City : "+arrivalCity);
		System.out.println("Departure Date : "+departureDate);
		System.out.println("Trip type : "+tripType);
		
		String flightSearchResultTable="";
		String departureTime;
		String arrivalTime;
		String airlinesName="";
		String carrierCode;
		String image;
		String flightNumber;
		
		String appId="6c7a6743";
		String appKey="85ae27fe5dc1487949b7323df8059ec8";
		
		int numberOfResults=0;
		HashMap<String,Airlines> airlinesMap;
		
		//Reading data from XML
		/*ProductDataStore productStore=new ProductDataStore(getServletContext().getRealPath("AirlinesCatalog.xml"));
		System.out.println("Finished reading products from Products.xml");
		airlinesMap=productStore.addProductsToMap();
    	System.out.println("Added produst read from XML to HashMap");*/
		
		MySQLDataStoreUtilities mySQL=new MySQLDataStoreUtilities();
		airlinesMap=mySQL.getAllAirlines();
		System.out.println("Airlines Map size : "+airlinesMap.size());
		HttpSession session=request.getSession(true);
		session.setAttribute("airlinesMap", airlinesMap);
		
		HttpURLConnection conn=null;
		
		URL url=new URL("https://api.flightstats.com/flex/schedules/rest/v1/json/from/"+departureCity+"/to/"+arrivalCity+"/departing/"+departureDate+"?appId="+appId+"&appKey="+appKey);
		System.out.println("REST URL request:"+url);
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
			
			if(scheduledFlightsArray.size()!=0){
			JSONObject appendixObject=(JSONObject)mainObject.get("appendix");
			
			JSONArray airlinesArray=(JSONArray)appendixObject.get("airlines");
			System.out.println("Number of Airlines in search result : "+airlinesArray.size());
			
			/*for(int ai=0;ai<airlinesArray.size();ai++){
				JSONObject airlineObject=(JSONObject)airlinesArray.get(ai);
				//System.out.println(airlineObject.get("name"));
			}*/
			
			numberOfResults=scheduledFlightsArray.size();
			System.out.println("Number of Search Results : "+numberOfResults);
			
			for(int i=0;i<numberOfResults;i++){
				JSONObject flightObject=(JSONObject)scheduledFlightsArray.get(i);
				departureDate=flightObject.get("departureTime").toString().substring(0,10);
				departureTime=flightObject.get("departureTime").toString().substring(11, 16);
				arrivalDate=flightObject.get("arrivalTime").toString().substring(0,10);
				arrivalTime=flightObject.get("arrivalTime").toString().substring(11, 16);
				carrierCode=flightObject.get("carrierFsCode").toString();
				flightNumber=flightObject.get("flightNumber").toString();
				
				//airlinesName=airlinesMap.get(carrierCode).getAirlinesName();
				for(int ai=0;ai<airlinesArray.size();ai++){
					JSONObject airlineObject=(JSONObject)airlinesArray.get(ai);
					airlinesName=airlineObject.get("name").toString();
				}
				
				//Check if Airlines exist in the DB
				if(airlinesMap.containsKey(carrierCode)){
					//System.out.println("Airlines exist in DB");
					image=airlinesMap.get(carrierCode).getImage();
				}
				else{
					//System.out.println("Airlines not exist in DB/MAP");
					image="./Images/DefaultAirline.jpg";
					Airlines newAirline=new Airlines(airlinesName, carrierCode, image);
					airlinesMap.put(carrierCode, newAirline);
					mySQL.insertNewAirline(newAirline);//uncomment later
				}
				
				
				//Finding Flight duration
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
			    //System.out.println("Time in minutes: " + diffMinutes + " minutes.");
			    //System.out.println("Time in hours: " + diffHours + " hours.");
				
			    String stops="";
			    if(flightObject.get("stops").toString().equals("0")){
			    	stops="Non stop";
			    }
			    else{
			    	stops=stops+" Stops";
				}
			    
			    int price;
			    Random r = new Random();
			    int lowestPrice = 100;
			    int highestPrice = 200;
			    price = r.nextInt(highestPrice-lowestPrice) + lowestPrice;
			    
				//System.out.println("Airline name : "+flightObject.get("carrierFsCode")+"\t Flight number : "+flightObject.get("flightNumber")+"\t DepartureTime : "+flightObject.get("departureTime")+"\t Arrival time : "+flightObject.get("arrivalTime"));
				flightSearchResultTable=flightSearchResultTable+"<tr><td rowspan='2'><img src="+image+" style='width:100px;height:100px'></img></td><td>"+airlinesName+"</td><td rowspan='2'>"+departureDate+" "+departureTime+"</td><td rowspan='2'>"+arrivalDate+" "+arrivalTime+"</td><td>"+diffHours+"h "+diffMinutes+" m</td><td rowspan='2'>$ "+price+"</td><td rowspan='2'><button type='submit' id='bookButton' name='bookButton' value='"+price+"/"+carrierCode+"/"+flightNumber+"/"+departureDate+"'>BOOK</button></td></tr><tr><td>"+carrierCode+"-"+flightNumber+"</td><td>"+stops+"</td></tr>";
			}
			}
			else{
				flightSearchResultTable=flightSearchResultTable+"<tr><td colspan='7'><h1><i class='fa fa-frown-o' aria-hidden='true'></i> Sorry! No Flights found in this route</h1></td></tr>";
			}
			
			request.setAttribute("flightSearchResultTable",flightSearchResultTable);
			RequestDispatcher rd = request.getRequestDispatcher("FlightSearchResults.jsp");
			request.setAttribute("departureDate",departureDate);
			request.setAttribute("arrivalDate",arrivalDate);
			request.setAttribute("departureCity",departureCity);
			request.setAttribute("arrivalCity",arrivalCity);
			request.setAttribute("searchResultCount",numberOfResults);
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			conn.disconnect();
		}
	}
}