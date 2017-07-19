<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BookFlight</title>
<link rel="stylesheet" type="text/css" href="./CSS/Common.css">
<link rel="stylesheet" type="text/css" href="./CSS/BookFlight.css">
<link rel="stylesheet" href="./CSS/font-awesome-4.6.3/css/font-awesome.min.css">

<style>

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
	/* background-color: #ffffff; */
	background-image:url("./Images/AirlinesHomePage2.jpg");
	background-size: 100%;
	height:auto;
	padding:45px;
}
#centerContents{
	background-color: #111;
}
</style>
</head>
<body>
	<div id="container">
		<div id="headerDiv">
			<div id="header1">
					<div id="bestDealLogo">
						<a href="HomePage.html"><img src="./Images/logo.png" style="width:100%;height:50px;margin-top:15px;cursor:pointer;"></a>
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
				<form action="FlightSearchServlet" method="get">
					<div id="formDiv">
						<div class="formDiv" id="titleDiv">
							<h1>Book a Flight <i class="fa fa-plane" aria-hidden="true"></i></h1>
						</div>
						
						
						<div name="autofillForm" id="fromDiv" class="formDiv">
						<label>From</label>
				   			<input type="text" id="departureAirport" name="departureAirport" oninput="doCompletion()" autocomplete='off' class="inputElement"></input>
							<div id="autoRow">
								<table id="AutoCompleteTable" class="gridTable" ></table>
							</div>
						</div>
						
						
						<div name="autofillForm2" id="fromDiv2" class="formDiv2">
						<label>To</label>
				   			<input type="text" id="arrivalAirport" name="arrivalAirport"  autocomplete='off' class="inputElement"></input>
							<div id="autoRow2">
								<table id="AutoCompleteTable2" class="gridTable2"></table>
							</div>
						</div>
						
						
						<div id="radioDiv" class="formDiv">
							<label><input type="radio" name="tripType" value="oneWay" >One Way</label>
							<label><input type="radio" name="tripType" value="roundTrip" >Round trip</label>
						</div>
						<div id="date" class="formDiv">
							<label>Departure <i class="fa fa-calendar" aria-hidden="true"></i></label>
							<input type="date" id="departureDate" name="departureDate" class="inputElement"></input>
							
							<label>Arrival <i class="fa fa-calendar" aria-hidden="true"></i></label>
							<input type="date" id="arrivalDate" name="arrivalDate" class="inputElement"></input>
						</div>
						<div class="formDiv">
							<button type="submit" id="searchFlightButton">Search Flights</button>
						</div>
					</div>
				</form>
				
				
			</div>
		</div>
		<div class='footer' id='footer'><ul><li><b>Contact</b></li><li>Team 7</li><li>CSP 595</li><li>EWA</li><li>Project</li></ul></div>
	</div>
</body>
<script type="text/javascript"	src="./JavaScript/AutoComplete.js"></script>
<!-- <script type="text/javascript"	src="./JavaScript/AutoComplete2.js"></script> -->
</html>