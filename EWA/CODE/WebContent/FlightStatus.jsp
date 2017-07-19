<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Flight Status</title>
<link rel="stylesheet" type="text/css" href="./CSS/Common.css">
<link rel="stylesheet" href="./CSS/font-awesome-4.6.3/css/font-awesome.min.css">
<style>
#footer{
	position:absolute;
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
	background-image:url("./Images/AirlinesHomePage2.jpg");
	height:500px;
	margin-left: 25%;
	background-size: 100%;
	background-color: #ffffff;
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
				<div id="userLinks">
					<div id="userLogo" id="userLogo"><i class="fa fa-user" aria-hidden="true"></i></div>
					<div id="loginLink" class="accountLinks"><a href="Login.html">Login <i class="fa fa-sign-in" aria-hidden="true"></i></a></div>
					<div id="SignupLink" class="accountLinks"><a href="Signup.html">Sign up <i class="fa fa-user-plus" aria-hidden="true"></i></a></div>
				</div>
			</div>
			<div id="header2">
				<div id="mainHeader2">
					<nav>
						<ul>
							<a href="BookFlight.jsp"><li>Book a Flight <i class="fa fa-plane" aria-hidden="true"></i></li></a>
							<a href="ManageBooking.jsp"><li>Manage Booking <i class="fa fa-th-list" aria-hidden="true"></i></li></a>
							<a href="FlightStatus.jsp" style="background-color: #404040;"><li>Flight Status <i class="fa fa-clock-o" aria-hidden="true"></i></li></a>
							<a href="WebCheckin.jsp"><li><span>Web Check-in <i class="fa fa-suitcase" aria-hidden="true"></i></li></a>
						</ul>
					</nav>
				</div>
			</div>	
		</div>
		<div id="centerContents">
			<div id="mySidenav" class="sidenav">
			  <a href="HomePage.jsp"><i class="fa fa-home" aria-hidden="true"></i> Home</a>
			  <a href="BookFlight.jsp"><i class="fa fa-plane" aria-hidden="true"></i> Book a Flight</a>
			  <a href="ManageBooking.jsp"><i class="fa fa-th-list" aria-hidden="true"></i> Manage Booking</a>
			  <a href="FlightStatus.jsp" style="background-color:#404040"><i class="fa fa-clock-o" aria-hidden="true"></i> Flight Status</a>
			  <a href="WebCheckin.jsp"><i class="fa fa-suitcase" aria-hidden="true"></i> Web Check-in</a>
			</div>
			<div id="center">
				<form>
					<div name="autofillForm" id="fromDiv" class="formDiv">
						<label>From</label>
			   			<input type="text" id="departureAirport" name="departureAirport" oninput="doCompletion()" autocomplete='off' class="inputElement"></input>
						<div id="autoRow">
							<table id="AutoCompleteTable" class="gridTable" ></table>
						</div>
					</div>
				
					<div name="autofillForm" id="toDiv" class="formDiv">
						<label>To</label>
			   			<input type="text" id="arrivalAirport" name="arrivalAirport" autocomplete='off' class="inputElement"></input>
						<div id="autoRow">
							<table id="AutoCompleteTable2" class="gridTable"></table>
						</div>
					</div>
					<input type="button" value="CHECK STATUS"></input>
				</form>
			</div>
		</div>
		<div class='footer' id='footer'><ul><li><b>Contact</b></li><li>Team 7</li><li>CSP 595</li><li>EWA</li><li>Project</li></ul></div>
</div>
</body>
</html>