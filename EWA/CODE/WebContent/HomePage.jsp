<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HomePage</title>
<link rel="stylesheet" type="text/css" href="./CSS/Common.css">
<style>
body{
	width:100%;
	margin:0;
	/* background-image:url("./Images/AirlinesHomePage2.jpg"); */
	background-image:url("./Images/BW2.png");
}
/* #container{
	width: 100%;
	min-height: 100%;
}
/*Header CSS*/
#headerDiv{
	height: 125px;
    width: 100%;
}
#header1{
	width:100%;
	height:75px;
	background-color:#005eb4;
	/* background-color:white; */
	float:left;
	position:fixed;
	z-index: 100;
}
#userLinks{
	width: 25%;
    height: 75px;
    float: right;
    color: white;
}
#userLogo {
    width: 50px;
    height: 40px;
    float: left;
    margin-top: 15px;
    margin-left: 6px;
    font-size: 25px;
    text-align: center;
    border-radius: 45px;
    padding-top: 8px;
    background-color: #00509b;
}
#bestDealLogo{
	width: 30%;
    height: 75px;
    /* margin:auto; */
    float:left;
    margin-left: 35%;
}
/*Footer CSS*/
#footer {
    /* background-color: #47bde5; */
    background-color: black;
    position: absolute;
    left: 0;
    bottom: 0;
    height: 80px;
    width: 100%;
    overflow:hidden;
}
#footer ul{
	margin: 0px;
    padding: 0px;
}
#footer ul li{
	color: white;
    font-family: Arial;
    display: block;
    float: left;
    text-decoration: none;
    text-align: center;
    width: 250px;
    height: 50px;
    padding-top: 30px;
}
#footer ul li a{
	color: white;
    text-decoration: none;
}
/*End of Footer CSS*/
#centerContents{
	width:75%;
	float:left;
	margin-left:0px;
}

#header2{
	width:100%;
	height: 50px;
	float:left;
	margin-top: 75px;
}
#mainHeader2{
	float: left;
    width: 100%;
    height: 52px;
}
/*Top Black Navigation header*/
ul{
	list-style:none;
}
nav{
	float:left;
	margin-left: 0px;
	width: 100%;
	height: 52px;
}
nav ul{
	margin-top:0px;
	width: 100%;
    float: left;
    padding-left: 0px;
}
nav ul li{
	text-align: center;
	background-color: #262626;
	color:#b2b2b2;
    width: 25%;
    display: inline-block;
    float: left;
    font-family: 'Source Code Pro', 'menlo', monospace;
    font-size: 20px;
    cursor: pointer;
    line-height: 52px;
}
nav ul li:hover {
	color:white;
    background-color: #0078e7;
}
nav ul li a{
	color:#b2b2b2;
	font-family: Arial;
	padding: 10px;
	text-decoration: none;
}
/*End of Top Black Navigation header*/ */
</style>
<link rel="stylesheet" href="./CSS/font-awesome-4.6.3/css/font-awesome.min.css">
</head>
<body>
	<div id="container">
		<div id="headerDiv">
			<div id="header1">
					<div id="bestDealLogo">
						<a href="HomePage.html"><img src="./Images/logo.png" style="width:100%;height:50px;margin-top:15px;cursor:pointer;"></a>
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
		
		</form>
		</div>
		<div class='footer' id='footer'><ul><li><b>Contact</b></li><li>Team 7</li><li>CSP 595</li><li>EWA</li><li>Project</li></ul></div>
	</div>
</body>
<script type="text/javascript"	src="./AutoComplete.js"></script>
</html>