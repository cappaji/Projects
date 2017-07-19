package com.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.db.conn.MongoDBDataStoreUtilities;
import com.model.pojo.Airport;

public class AjaxUtility {

	public static HashMap<String,Airport> cityMap;
	
	public static void getCityNamesFromDB(){
		MongoDBDataStoreUtilities mongoDB=new MongoDBDataStoreUtilities();
		cityMap=mongoDB.getAllAirports();
	}

	public StringBuffer readData(String searchAreaText){
		StringBuffer sb=new StringBuffer();
		
		if(cityMap==null){
			System.out.println("CityMap is null");
			getCityNamesFromDB();
		}
		HashMap<String,Airport> data=cityMap;
		Set<Map.Entry<String,Airport>> entries=data.entrySet();
		for(Map.Entry<String,Airport> prodMap:entries){
			Airport airport=prodMap.getValue();
			if(airport.getcityName().toLowerCase().startsWith(searchAreaText.toLowerCase().trim())||airport.getcityCode().toLowerCase().startsWith(searchAreaText.toLowerCase().trim())){
				sb.append("<Airport>");
				sb.append("<CityCode>"+airport.getcityCode()+"</CityCode>");
				sb.append("<CityName>"+airport.getcityName()+" ("+airport.getcityCode()+")</CityName>");
				sb.append("</Airport>");
			}
		}
		return sb;
	}
}