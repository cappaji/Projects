<%@page import="com.model.pojo.FlightDetails"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.text.SimpleDateFormat,javax.servlet.http.HttpSession,com.model.pojo.Passenger;"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Booking Confirmation</title>
<link rel="stylesheet" href="./CSS/font-awesome-4.6.3/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="./CSS/Common.css">
<style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}
td{
	text-align: left;
	border: 1px solid #dddddd;
    padding: 8px;
}
th{
	background-color: #dddddd;
	border: 1px solid #dddddd;
    padding: 8px;
    text-align: left;
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
	height:auto;
}
#printLink{
	text-align: right;
    padding: 30px;
    font-size: 20px;
    font-family: Circular,Helvetica,Arial,sans-serif;
}
h1{
	text-align: center;
    font-family: Arial;
    color: #444;
    font-family: 'Roboto', sans-serif;
    font-weight: 100;
    padding-bottom: 20px;
    box-shadow: 0px 5px 5px #b4b4b4;
    margin: 0;
}
#ticketDiv{
	padding:20px;
}
ul{
	padding:0;
}
h3{
	background-color: #cfcfcf;
    padding: 10px;
    font-family: Circular,Helvetica,Arial,sans-serif;
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
						<a href="HomePage.jsp"><img src="./Images/logo.png" style="width:100%;height:50px;margin-top:15px;cursor:pointer;"></a>
					</div>	
			</div>
			<div id="header2">
				<div id="mainHeader2">
					<nav>
						<ul>
							<a href="BookFlight.jsp" style="background-color:#404040"><li>Book a Flight <i class="fa fa-plane" aria-hidden="true"></i></li></a>
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
			   <a href="WriteReview.jsp"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Write Review</a>
			  <a href="ViewReview.jsp"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> View Review</a>
			  <a href="ManageBooking.jsp"><i class="fa fa-th-list" aria-hidden="true"></i> Manage Booking</a>
			  <a href="FlightStatus.jsp"><i class="fa fa-clock-o" aria-hidden="true"></i> Flight Status</a>
			  <a href="WebCheckin.jsp"><i class="fa fa-suitcase" aria-hidden="true"></i> Web Check-in</a>
			</div>
			<div id="center">
	
		<div id="ticketDiv">
		<h1>Booking Confirmation <i class="fa fa-check" aria-hidden="true"></i></h1>
		<%
						System.out.println("========================Inside Payment.jsp========================");				
						session=request.getSession(false);
						String name=(String)session.getAttribute("UserId");
						if(name==null){
							name="";
						}
		%>
		<h3>Welcome! <%=name%></h3>
		<a href="Baggage.jsp">Baggage Information</a>
		<div id="printLink"><a href="javascript:void(0);" onClick="printDiv('ticketDiv')"><i class="fa fa-print" aria-hidden="true"></i> Print Itinerary</a></div>
		
		<%
			session=request.getSession(false);
			Passenger passenger=(Passenger)session.getAttribute("passenger");
			FlightDetails flightDetails=(FlightDetails)session.getAttribute("flightDetails");
			
			String PNR=session.getAttribute("PNR").toString();
			String BookingStatus="Booked";
			String BookingDate=new SimpleDateFormat("dd-MM-yyyy").format(new Date());
			int NumberOfPassengers=1;
			
			String passengerFirstName=passenger.getFirstName();
			String passengerLastName=passenger.getLastName();
			String gender=passenger.getGender();
			String passengerType=passenger.getPassengerType();
			String travelClass;
			String seatNumber="23";
			String mealPreference=passenger.getMealPreference();
			
			String airlinesName=flightDetails.getAirlinesName();
			String carrierCode=flightDetails.getCarrierCode();
			String airlinesImage=flightDetails.getAirlinesImage();
			String flightNumber=flightDetails.getFlightNumber();
			String flightModel=flightDetails.getFlightModel();
			
			String departureDate=flightDetails.getDepartureDate();
			String departureTime=flightDetails.getDepartureTime();
			String departureCity=flightDetails.getDepartureCity();
			String departureAirportName=flightDetails.getArrivalAirportName();
			String departureTerminal="Terminal - "+flightDetails.getDepartureTerminal();
			
			String arrivalDate=flightDetails.getArrivalDate();
			String arrivalTime=flightDetails.getArrivalTime();
			String arrivalCity=flightDetails.getArrivalCity();
			String arrivalAirportName=flightDetails.getArrivalAirportName();
			String arrivalTerminal="Terminal - "+flightDetails.getArrivalTerminal();
			
			String creditCardNumber=(String)session.getAttribute("creditCardNumber");
			String totalAmount="$ "+flightDetails.getPrice();
		%>
		
		<table>
		<tr>
			<th>PNR Number</th>
			<th>Booking status</th>
			<th>Booking Date</th>
			<th>Number of Passengers</th>
			<th rowspan="2" style="background-color: #ffffff"><img src="./Images/Barcode.jpg" style="width: 300px;height: 100px;"></img></th>
		</tr>
		<tr>
			<td><%=PNR%></td>
			<td><%=BookingStatus%></td>
			<td><%=BookingDate%></td>
			<td><%=NumberOfPassengers%></td>
		</tr>
		<tr><td colspan="5"></td></tr>
		<tr>
			<th>Passenger Name</th>
			<th>Passenger Type</th>
			<th>Class</th>
			<th>Seat</th>
			<th>Meal Preference</th>
		</tr>
		<tr>
			<td><%=gender+" "+passengerFirstName+" "+passengerLastName%></td>
			<td><%=passengerType %></td>
			<td>Economy</td>
			<td><%=seatNumber%></td>
			<td><%=mealPreference%></td>
		</tr>
		<tr><td colspan="5"></td></tr>
		<tr>
			<th colspan="5" style="text-align:center">FLIGHT DETAILS <i class="fa fa-plane" aria-hidden="true"></i></th>
		</tr>
		<tr><td colspan="5"></tr>
		<tr>
			<th colspan="2">Flight</th>
			<th colspan="2">Departure</th>
			<th colspan="2">Arrival</th>		
		</tr>
		<tr>
			<td>
				<img src="<%=airlinesImage%>"></img>				
			</td>
			<td>
				<ul>
					<li><%=airlinesName%></li>
					<li><%=carrierCode+"-"+flightNumber%></li>
					<li><%=flightModel%></li>
				</ul>
			</td>
			<td colspan="2">
				<ul>
					<li><%=departureDate%></li>
					<li><%=departureTime%></li>
					<li><%=departureCity%></li>
					<li><%=departureAirportName%></li>
					<li><%=departureTerminal%></li>
				</ul>
			</td>
			<td colspan="2">
				<ul>
					<li><%=arrivalDate%></li>
					<li><%=arrivalTime%></li>
					<li><%=arrivalCity%></li>
					<li><%=arrivalAirportName%></li>
					<li><%=arrivalTerminal%></li>
				</ul>
			</td>
		</tr>
		<tr><td colspan="5"></tr>
		<tr>
			<th colspan="5" style="text-align:center">BILLING DETAILS</th>
		</tr>
		<tr>
			<td colspan="5">Payment method : <b>Credit Card ending XXXX-<%=creditCardNumber%></b></td>
		</tr>
		<tr>
			<td colspan="5">Total amount paid : <b><%=totalAmount%></b></td>
		</tr>
	</table>
	</div>
	</div>
		</div>
		<div class='footer' id='footer'><ul><li><b>Contact</b></li><li>Team 7</li><li>CSP 595</li><li>EWA</li><li>Project</li></ul></div>
	</div>
</body>
<script>
function printDiv(divName) {
    var printContents = document.getElementById(divName).innerHTML;
    var originalContents = document.body.innerHTML;
    document.body.innerHTML = printContents;
    window.print();
    document.body.innerHTML = originalContents;
}
</script>
</html>