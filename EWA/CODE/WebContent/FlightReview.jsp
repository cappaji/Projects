<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.text.SimpleDateFormat,javax.servlet.http.HttpSession,com.model.pojo.FlightDetails;"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Flight Review</title>
<link rel="stylesheet" type="text/css" href="./CSS/Common.css">
<link rel="stylesheet" href="./CSS/font-awesome-4.6.3/css/font-awesome.min.css">
<style>
#center{
	height:500px;
	margin-left: 25%;
	background-size: 100%;
	background-color: #ffffff;
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
table {
    font-family: Circular,Helvetica,Arial,sans-serif;
    border-collapse: collapse;
    margin:5px;
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
}
th{
	background-color: #0051a3;
	color:white;
}
ul {
  text-align: left;
  padding-left: 0;
}

#flightDetailsTable{
	vertical-align: top;
    float: left;
    width: 74%;
}
#fareDetailsTable{
	vertical-align: top;
    float: right;
    width: 24%;
}
#continueAsGuestButton{
	background: #B22222;
    border: none;
    width: 300px;
    height: 50px;
    color: white;
    font-family: Circular,Helvetica,Arial,sans-serif;
    text-transform: uppercase;
    cursor: pointer;
    display: block;
    margin: 0 auto;
    border-radius: 3px;
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
				<!-- <div id="userLinks">
					<div id="userLogo" id="userLogo"><i class="fa fa-user" aria-hidden="true"></i></div>
					<div id="loginLink" class="accountLinks"><a href="Login.html">Login <i class="fa fa-sign-in" aria-hidden="true"></i></a></div>
					<div id="SignupLink" class="accountLinks"><a href="Signup.html">Sign up <i class="fa fa-user-plus" aria-hidden="true"></i></a></div>
				</div> -->
			</div>
			<div id="header2">
				<div id="mainHeader2">
					<nav>
						<ul>
							<a href="BookFlight.jsp" style="background-color: #404040;"><li>Book a Flight <i class="fa fa-plane" aria-hidden="true"></i></li></a>
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
			  <a href="FlightStatus.jsp"><i class="fa fa-clock-o" aria-hidden="true"></i> Flight Status</a>
			  <a href="WebCheckin.jsp"><i class="fa fa-suitcase" aria-hidden="true"></i> Web Check-in</a>
		</div>
			<div id="center">
			<!-- <form action="PassengerDetails.jsp"> -->
			<form action="ProcessFlightReviewServlet" method="post">
					<table id="flightDetailsTable">
						<form action="BookFlight" method="get">
							<tr><th colspan="3">FLIGHT DETAILS</th></tr>
							<tr>
								<th>Airlines</th>
								<th>Departure <i class="fa fa-plane" aria-hidden="true"></i></th>
								<th>Arrival</th>
								
							</tr>
						<% 
							String flightDetailsTableRow = (String) request.getAttribute("flightDetailsRow");
							if(flightDetailsTableRow!=null){
								out.println(flightDetailsTableRow);
							}
							session=request.getSession(false);
							FlightDetails flightDetails=(FlightDetails)session.getAttribute("flightDetails");
							Double price=flightDetails.getPrice();
							Double tax=20.0;
							Double total=price+tax;
						%>
						</form>
					</table>
					<table id="fareDetailsTable">
						<tr><th colspan="2">Fare Summary</th></tr>
						<tr>
							<td>
								<ul>
									<li><b>Base Fare</b></li>
									<li>1 X Adult(s)</li>
								</ul>
							</td>
							<td>
								<ul>
									<li>$<%=price%></li>
									<li>1 X $<%=price%></li>
								</ul>
							</td>
						</tr>
						
						<tr><td>Taxes and Fees</td><td>$<%=tax%></td></tr>
						<!-- <tr><td>Discount</td><td></td></tr> -->
						<tr><td>Total</td><td>$<%=total%></td></tr>
					</table>
					<div id="enterDiv" style="display:none">
					<form action="LoginProcess.jsp" method="post">
						<div><input type="text"  class="credentials" name="EmailId" placeholder="Email ID" maxlength="25" autofocus></input></div>
						<div><input type="password"  class="credentials" name="Password" placeholder="Password"></input></div>
						<div>
							<select type="select" class="credentials" name="UserRole">
								<option value="Select">Select user type</option>
								<option value="Customer" selected>Customer</option>
								<option value="StoreManager">Store Manager</option>
								<option value="Salesman">Salesman</option>
							</select>
						</div>
						<div><button type="submit" value="login" id="loginButton" class="registerButtons">Login <i class="fa fa-lock" aria-hidden="true"></i></button></div>
						<div><button id="signUpButton" class="registerButtons"><a href="Signup.jsp" id="signupLink">New to Best Deal? Sign up</a></button></div>
					</form>
					</div>
					<div><button type="submit" id="continueAsGuestButton" onclick=document.forms[0].action = 'PassengerDetails.jsp'; return true;">Continue</button></div>
				</form>
				</div>
	</div>
	<div class='footer' id='footer'><ul><li><b>Contact</b></li><li>Team 7</li><li>CSP 595</li><li>EWA</li><li>Project</li></ul></div>
</div>
</body>
</html>