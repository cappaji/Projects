Install JDK 1.7
Install Tomcat 7 
Install MYSQL 5..x
Intall MongoDB 2.6

Compile the Entire Source code using :
javac -cp ../Path_to_lib_folder_where_Jars_Present/* *.java files.


a) Perform below steps in MYSQL
	Create schema 'AIRLINES'
	Execute all the script file in MYSqlScripts

i.e,

MySql:
==========
create database AIRLINES;

use AIRLINES;

copy contents of script one by one;

Now MySql with the Database is setup completely.

MySql workbench can also be used for the interface.

b) MongoDB
	Create database airports
	Create collection cityCodes
	copy the given AirlinesProject.war into the webapps folder

	Run the Mongo Daemon using the command - mongod
	Then from another instance run mongo shell - using mongo from the terminal

i.e,
In the mongo shell execute the below command:
MongoDB:
===========

db.createCollection(“cityCodes”);
db.createCollection("reviews");

MongoDB Dump:
================
>mongoimport --db airports --collection cityCodes --drop --jsonArray --file AirportCityCodes.json

Copy all the Jars into the lib folder of tomcat

Also Copy the ProductCatalog.xml into the bin folder of tomcat.


Open URL : http://localhost:8080/AirlinesProject/     
-or-
Open URL : http://localhost:8080/AirlinesProject/login.html   in browser


==========================================
c) Simpler way to Run the Entire Web-APP:
==========================================

I have created a web-app archive which is a .war file. 

i.e Copy the AirlinesProject.war file given in the folder into the tomcat webapps folder. 
Then Launch the Browser and open the url : http://localhost:8080/AirlinesProject/ 
-OR-
http://localhost:8080/AirlinesProject/login.html   in browser

This launches the web-app.


NOTE:
=====
The webapps folder provided in the submission contains the entire web app along with the source files, binaries and the executable.


Assignment Features Implemented:
==================================
1) Use of Servlets
2) JSP
3) MySql for Airlines, Payment and Customer Information
4) MongoDB for Storing Reviews and for Ajax Feature
5) Ajax for Selecting "TO" and "FROM" Travel Destination.

Other Features Implemented:
==================================
Using Flex API for Flight Information in Real-Time.

Flight Stats Flex API Details:
=====================
appId=6c7a6743
appKey=85ae27fe5dc1487949b7323df8059ec8
flightURL=https://api.flightstats.com/flex/schedules/rest/v1/json/


Total Lines of Code: Approximately 5000 lines
=====================


	



