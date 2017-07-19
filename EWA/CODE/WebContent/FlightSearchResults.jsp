<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FlightSearchResults</title>
<link rel="stylesheet" type="text/css" href="./CSS/Common.css">
<link rel="stylesheet" href="./CSS/font-awesome-4.6.3/css/font-awesome.min.css">
<style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    text-align: center;
    padding: 8px;
    color: #808080;
    font-family: 'Roboto', sans-serif;
    font-weight: 100;
}
tr{
	border: 1px solid #e5e5e5;
/* 	border-bottom-width: 15px;
    border-left-width: 15px;
    border-right-width: 15px; */
}
th{
	background-color: #0051a3;
	color:white;
}
/* tr:nth-child(even) {
    background-color: #dddddd;
} */
#bookButton{
	background: #B22222;
    border: none;
    width: 140px;
    height: 40px;
    color: white;
    font-family: "Roboto","Helvetica","Arial",sans-serif;
    text-transform: uppercase;
    cursor: pointer;
    display: block;
    margin: 0 auto;
    border-radius: 3px;
}
body{
	width:100%;
	margin:0;
	background-color:#111;
}
#searchInputs{
	height:50px;
	width:90%;
	margin:auto;
	padding: 10px;
}

.inputFieldClass{
	width: 33%;
	float:left;
    height: 45px;
    text-align: center;
    border: 1px solid #888888;
    line-height: 42px;
    font-family: Circular,Helvetica,Arial,sans-serif;
    font-size: 20px;
}
.inputFieldClass label{
	color: #707070;
    font-size: 15px;
    font-weight: bold;
}
#searchResultsCount{
	background-color: #cfcfcf;
    padding: 10px;
    width: 98%;
    margin: auto;
    font-family: Circular,Helvetica,Arial,sans-serif;
    font-size: 15px;
    color: #676767;
}

/*Side navigation start*/
.sidenav {
    height: auto;
    width: 25%;
    position: fixed;
    z-index: 1;
    left: 0;
    background-color: #111;
    overflow-x: hidden;
}

.sidenav a {
    padding: 8px 8px 8px 32px;
    text-decoration: none;
    color: #919496;
    display: block;
    transition: 0.3s;
    border-bottom: 1px solid #323232 !important;
    font-family: Circular,Helvetica,Arial,sans-serif;
    font-weight: 300;
    background-color: transparent;
    padding: 20px 15px 20px 30px;
}

.sidenav a:hover, .offcanvas a:focus{
    color: #f1f1f1;
    background-color: #005eb4;
}
/*Side navigation end*/
#center{
	margin-left: 25%;
	background-size: 100%;
	background-color: #ffffff;
	min-height:600px;
}
</style>
<link rel="stylesheet" href="./CSS/font-awesome-4.6.3/css/font-awesome.min.css">
</head>
<body>
	<div id="container">
	<div id="headerDiv">
			<div id="header1">
					<div id="bestDealLogo">
						<a href="HomePage.jsp"><img src="./Images/logo.png" style="width:100%;height:50px;margin-top:15px;cursor:pointer;"></a>
					</div>	
			</div>
			<div id="header2">
				<div id="mainHeader2">
					<nav>
						<ul>
							<a href="BookFlight.jsp"><li>Book a Flight <i class="fa fa-plane" aria-hidden="true"></i></li></a>
							<a href="ManageBooking.jsp"><li>Manage Booking <i class="fa fa-th-list" aria-hidden="true"></i></li></a>
							<a href="FlightStatus.jsp"><li>Flight Status <i class="fa fa-clock-o" aria-hidden="true"></i></li></a>
							<a href="WebCheckin.jsp"><li><span>Web Check-in <i class="fa fa-suitcase" aria-hidden="true"></i></li></a>
						</ul>
					</nav>
				</div>
			</div>	
		</div>
		<div id="centerContents">
		
		<div id="mySidenav" class="sidenav">
			  <a href="HomePage.jsp"><i class="fa fa-home" aria-hidden="true"></i> Home</a>
			  <a href="BookFlight.jsp" style="background-color:#404040"><i class="fa fa-plane" aria-hidden="true"></i> Book a Flight</a>
			  <a href="ManageBooking.jsp"><i class="fa fa-th-list" aria-hidden="true"></i> Manage Booking</a>
			  <a href="FlightStatus.jsp" ><i class="fa fa-clock-o" aria-hidden="true"></i> Flight Status</a>
			  <a href="WebCheckin.jsp"><i class="fa fa-suitcase" aria-hidden="true"></i> Web Check-in</a>
		</div>
		<div id="center">
		<div id="searchResultsCount">Search results
			<%
				int searchResultCount=(Integer) request.getAttribute("searchResultCount");
				out.println(searchResultCount);
			%>
			flights found.
		</div>
		<div id="searchInputs">
			<div id="departureArrivalCity" class="inputFieldClass">
				<label>TRIP</label>
				<i class="fa fa-map-marker" aria-hidden="true"></i>
			<%	
				String departureCity=(String) request.getAttribute("departureCity");
				if(departureCity!=null){
					out.println(departureCity);
				}
				
				%>
				To
				<%
				String arrivalCity=(String) request.getAttribute("arrivalCity");
				if(arrivalCity!=null){
					out.println(arrivalCity);
				}
				%>
			</div>
			<div id=departureDate class="inputFieldClass">
				<label>DEPARTURE</label>
				<i class="fa fa-calendar-o" aria-hidden="true"></i>
				<% 
					String departureDate = (String) request.getAttribute("departureDate");
					
					
					if(departureDate!=null){
						out.println(departureDate);
					}
					
				%>
			</div>
			<div id="arrivalDate" class="inputFieldClass">
				<label>ARRIVAL</label>
				<i class="fa fa-calendar-o" aria-hidden="true"></i>
				<%
				String arrivalDate = (String) request.getAttribute("arrivalDate");
				if(arrivalDate!=null){
						out.println(arrivalDate);
					}
				%>
			</div>
		</div>
		<!-- <div id="searchCount">
			
		</div> -->	
		<div id="searchResultsTable">
			<table id="flightSearchResults">
			<form action="BookFlight" method="get">
				<tr>
					<th>Airlines</th>
					<th>Flight Number</th>
					<th>Departure <i class="fa fa-plane" aria-hidden="true"></i></th>
					<th>Arrival</th>
					<th>Duration</th>
					<th>Price</th>
					<th></th>
				</tr>
			
			<% 
				String flightSearchResultTable = (String) request.getAttribute("flightSearchResultTable");
				if(flightSearchResultTable!=null){
					out.println(flightSearchResultTable);
				}
			%>
			</form>
			</table>
		</div>
		</div>
		</div>
		<div class='footer' id='footer'><ul><li><b>Contact</b></li><li>Team 7</li><li>CSP 595</li><li>EWA</li><li>Project</li></ul></div>
	</div>
</body>
</html>