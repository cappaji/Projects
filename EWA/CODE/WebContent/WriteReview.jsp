<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.db.conn.MySQLDataStoreUtilities,com.db.conn.MongoDBDataStoreUtilities,javax.servlet.RequestDispatcher,javax.servlet.http.HttpSession,java.util.HashMap,com.model.pojo.Airlines,com.model.pojo.Reviews,java.util.Set,java.util.Map,java.util.ArrayList,java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Write Review</title>
<link rel="stylesheet" type="text/css" href="./CSS/Common.css">
<link rel="stylesheet" type="text/css" href="./CSS/WriteProductReviewForm.css">
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
	background-color: #ffffff;
	min-height:600px;
	height:auto;
}
#passengerDetailsTable{
	width:100%;
	font-family: Circular,Helvetica,Arial,sans-serif;
}
.dateField{
	height: 25px;
    width: 77px;
    text-align: center;
}
label{
	color:#676767;
	display: inline-block;
    width: 200px;
    font-size: 12px;
    display:block;
    display: block;
    font-weight: 600;
}
.starClass{
	 width: 50px;
}
th{
	background-color:#0051a3;
	color:#ffffff;
}
td, th {
    padding: 8px;
}
.userIPField{
	height:25px;
	width: 250px;
}
.userIPFieldSelect{
	height:25px;
	width: 70px;
}
#makeSecurePaymentButton{
	background: #B22222;
	/* background: #448aff; */
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
h1{
	text-align: center;
    font-family: Arial;
    color: #444;
    font-family: 'Roboto', sans-serif;
    font-weight: 100;
    padding-bottom: 20px;
    /* border-bottom: 1px solid #b4b4b4; */
    box-shadow: 0px 5px 5px #b4b4b4;
    margin: 0;
}
h1{
	text-align: center;
    font-family: Arial;
    color: #444;
    font-family: 'Roboto', sans-serif;
    font-weight: 100;
    padding-bottom: 20px;
    /* border-bottom: 1px solid #b4b4b4; */
    box-shadow: 0px 5px 5px #b4b4b4;
    margin: 0;
}
h3{
	background-color: #cfcfcf;
    padding: 10px;
    font-family: Circular,Helvetica,Arial,sans-serif;
}
#centerContents{
	background-color: #111111;
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
			  <a href="BookFlight.jsp"><i class="fa fa-plane" aria-hidden="true"></i> Book a Flight</a>
			  <a href="WriteReview.jsp" style="background-color:#404040"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Write Review</a>
			  <a href="ViewReview.jsp"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> View Review</a>
			  <a href="ManageBooking.jsp"><i class="fa fa-th-list" aria-hidden="true"></i> Manage Booking</a>
			  <a href="FlightStatus.jsp"><i class="fa fa-clock-o" aria-hidden="true"></i> Flight Status</a>
			  <a href="WebCheckin.jsp"><i class="fa fa-suitcase" aria-hidden="true"></i> Web Check-in</a>
			</div>
			<%
				System.out.println("========================Inside WriteReview.jsp========================");				
				session=request.getSession(false);
				String name=(String)session.getAttribute("UserId");
				if(name==null){
					name="";
				}
				Date todaysDate=new Date();
				MySQLDataStoreUtilities mySQL=new MySQLDataStoreUtilities();
				//HashMap<String,Airlines> airlinesMap=(HashMap<String,Airlines>)session.getAttribute("airlinesMap");
				HashMap<String,Airlines> airlinesMap=mySQL.getAllAirlines();
				Set<Map.Entry<String,Airlines>> entries=airlinesMap.entrySet();
			%>
			<div id="center">
				<h1>WRITE REVIEWS <i class="fa fa-pencil" aria-hidden="true"></i></h1>
				<h3>Welcome! <%=name%></h3>
				<div id="enterDiv">
								<form action="ProcessWriteReviewServlet" method="post">
								<table id="reviewFormTable">
								<tr>
									<div id="Message">
									<% 
										String message = (String) request.getAttribute("AddReviewMessage");
										if(message!=null){
											out.println(message);
										}
									%>
									</div>
								
								</tr>
								<tr><td><input readonly type="text"  class="credentials" name="UserID" placeholder="User ID" value='<%=name%>'></li></td></tr>
								<tr><td>
									<select id="airlinesNameSelect" class="credentials" name="airlinesNameSelect">
										<%
										for(Map.Entry<String,Airlines> airlineMap:entries){
											Airlines airline=airlineMap.getValue();
											
										
										%>
										<option value='<%=airline.getAirlinesName()%>'><%=airline.getAirlinesName()%></option>
										<%
										}
										%>
									</select>
								</td></tr>
								<tr>
								<td>
									<ul style="padding: 0;">
										<li>
											<div>Review rating</div>
											<div class="stars">
												<input class='star star-5' value='5' id='star-5' type='radio' name='star'/>
												<label class='star star-5 starClass' for='star-5'></label>
												<input class='star star-4' value='4' id='star-4' type='radio' name='star'/>
												<label class='star star-4 starClass' for='star-4'></label>
												<input class='star star-3' id='star-3' value='3' type='radio' name='star'/>
												<label class='star star-3 starClass' for='star-3'></label>
												<input class='star star-2' value='2' id='star-2' type='radio' name='star'/>
												<label class='star star-2 starClass' for='star-2'></label>
												<input class='star star-1' value='1' id='star-1' type='radio' name='star'/>
												<label class='star star-1 starClass' for='star-1'></label>
											</div>
										</li>
									</ul>
								</td>
								</tr>
								<tr><td>Review Date <input value='<%=todaysDate%>' type='date' name='bday'></td></tr>
								<tr><td><textarea name='reviewText' rows="5" cols="40" maxlength="100">Review text...</textarea></td></tr>
								<tr><td><button type="submit" value="login" id="addProductButton" class="registerButtons">Submit Review <i class="fa fa-pencil-square" aria-hidden="true"></i></button></td></tr>
									</table>
								</form>
							</div>
			</div>
		</div>
		<div class='footer' id='footer'><ul><li><b>Contact</b></li><li>Team 7</li><li>CSP 595</li><li>EWA</li><li>Project</li></ul></div>
	</div>
</body>
</html>