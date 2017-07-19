<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Baggage</title>
<link rel="stylesheet" type="text/css" href="./CSS/Common.css">
<link rel="stylesheet" href="./CSS/font-awesome-4.6.3/css/font-awesome.min.css">
<style>
table {
    /* border-collapse: collapse; */
    width: 100%;
    font-family: 'Source Code Pro', 'menlo', monospace;
}

th, td {
    text-align: left;
    padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
    background-color: #4285f4;
    color: white;
    text-align: center;
}

#centerContents {
    width: 100%;
    /* float: left; */
    height:auto;
    background-color: #111;
}
#center{
	width: 75%;
    height: auto;
    float: right;
    min-height: 700px;
    /* margin-left: 25%; */
}

/*Side navigation start*/
.sidenav {
    height: 100%;
    width: 25%;
    position: fixed;
    z-index: 1;
    /* top: 0; */
    left: 0;
    background-color: #111;
    overflow-x: hidden;
    /* padding-top: 60px; */
}

.sidenav a {
    padding: 8px 8px 8px 32px;
    text-decoration: none;
    /* font-size: 25px; */
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
			  <a href="BookFlight.jsp"><i class="fa fa-plane" aria-hidden="true"></i> Book a Flight</a>
			  <a href="ManageBooking.jsp"><i class="fa fa-th-list" aria-hidden="true"></i> Manage Booking</a>
			  <a href="FlightStatus.jsp"><i class="fa fa-clock-o" aria-hidden="true"></i> Flight Status</a>
			  <a href="WebCheckin.jsp"><i class="fa fa-suitcase" aria-hidden="true"></i> Web Check-in</a>
			</div>
			<div id="center">
				<div class="formDiv" id="titleDiv">
						<h1>Baggage <i class="fa fa-suitcase" aria-hidden="true"></i></h1>
						<!-- <h3>Baggage allowances</h3>
						<h3>Excess baggage rates</h3>
						<h3>Baggage tracker</h3> -->
				</div>
				<div>
					<table>
						<tr><th colspan="4">Checked baggage allowances</th></tr>
						<tr><th></th><th>Economy Class</th><th>First Class</th><th>Business Class</th></tr>
						<tr><td>Number of pieces</td><td>2</td><td>2</td><td>3</td></tr>
						<tr><td>Weight of each bag</td><td>23Kg</td><td>23Kg</td><td>23Kg</td></tr>
						<tr><td>Maximum dimension</td><td colspan="3">Length + Width+ Height = 158cm (62in)</td></tr>
					</table>
					
					<table>
						<tr><th colspan="4">Hand baggage allowances</th></tr>
						<tr><th></th><th>Economy Class</th><th>First Class</th><th>Business Class</th></tr>
						<tr><td>Number of pieces</td><td>1</td><td>2</td><td>2</td></tr>
						<tr><td>Weight of each bag</td><td>15Kg</td><td>15Kg</td><td>15Kg</td></tr>
						<tr><td>Maximum dimension</td><td colspan="3">Length x Width x Height = 50x37x25cm (20x15x10in)</td></tr>
					</table>
				</div>			
			</div>
		</div>
		<div class='footer' id='footer'><ul><li><b>Contact</b></li><li>Team 7</li><li>A20354703</li><li><a href='mailto:sdavange@hawk.iit.edu'>sdavange@hawk.iit.edu</a></li><li>CSP 595 - Project</li></ul></div>
	</div>
</body>
</html>