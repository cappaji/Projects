package com.db.conn;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import com.model.pojo.Airport;
import com.model.pojo.Reviews;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class MongoDBDataStoreUtilities {
	
	static DBCollection cityCollection;
	static DBCollection reviewCollection;
	public static MongoClient mongo;
	
	public static void getConnection(){
		mongo=new MongoClient("localhost",27017);
		DB db=mongo.getDB("airports");
		cityCollection=db.getCollection("cityCodes");
		reviewCollection=db.getCollection("reviews");
	}
	
	public HashMap<String,Airport> getAllAirports(){
		System.out.println("Inside MongoDBDataStoreUtilities class getAllAirports() method");
		HashMap<String,Airport> airportsMap=new HashMap<String,Airport>();
		getConnection();
		
		Iterable<DBObject> output = cityCollection.find(new BasicDBObject("iata",new BasicDBObject("$exists",true)).append("city", new BasicDBObject("$exists",true)), new BasicDBObject("city",1).append("iata", 1).append("_id", 0));
		for (DBObject dbObject : output)
		 {
			 //System.out.println(dbObject);
			 airportsMap.put(dbObject.get("iata").toString(), new Airport(dbObject.get("city").toString(),dbObject.get("iata").toString()));
		 }
		mongo.close();
		return airportsMap;
	}
	
	public static boolean insertReview(String airlineName,String reviewerName, int ReviewRating, String ReviewText){
		System.out.println("Inside MongoDBDataStoreUtilities class insertReview() method");
		Boolean InsertToDBFlag=false;
		String reviewName=reviewerName;
		int reviewRating=ReviewRating;
		Date reviewDate=new Date();
		String reviewText=ReviewText;
		
		getConnection();
		BasicDBObject dbObj=new BasicDBObject();
		
		dbObj.put("airlinesName",airlineName);
		dbObj.put("userId",reviewName);
		dbObj.put("reviewRating",reviewRating);
		dbObj.put("reviewDate",reviewDate);
		dbObj.put("reviewText",reviewText);
		
		reviewCollection.insert(dbObj);
		InsertToDBFlag=true;
		mongo.close();
		return InsertToDBFlag;
	}
	
	public static ArrayList<Reviews> getAllReviews(){
		System.out.println("Inside MongoDBDataStoreUtilities class selectReview() method");
		getConnection();
		
		BasicDBObject dbObj=new BasicDBObject();
		//dbObj.put("productId", productId);
		System.out.println("Basic DB Object :"+dbObj);
		
		int reviewsCount=reviewCollection.find().count();
		System.out.println("Number of Reviews : "+reviewsCount);
		DBCursor cursor=reviewCollection.find();//Query
		int i=0;
		ArrayList<Reviews> reviewList=new ArrayList<Reviews>();
		while(cursor.hasNext()){
			BasicDBObject obj=(BasicDBObject)cursor.next();
			System.out.println("Getting date---------------");
			reviewList.add(new Reviews(i,obj.getString("airlinesName"),obj.getString("userId"),obj.getInt("reviewRating"),obj.getString("reviewText"),obj.getDate("reviewDate")));
			i++;
		}
		System.out.println("Reviews sent from Mongo DB");
		cursor.close();
		mongo.close();
		return reviewList;
	}
}