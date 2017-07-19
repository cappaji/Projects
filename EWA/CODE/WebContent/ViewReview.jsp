<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.db.conn.MySQLDataStoreUtilities,com.db.conn.MongoDBDataStoreUtilities,javax.servlet.RequestDispatcher,javax.servlet.http.HttpSession,java.util.HashMap,com.model.pojo.Airlines,com.model.pojo.Reviews,java.util.Set,java.util.Map,java.util.ArrayList,java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Review</title>
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
h3{
	background-color: #cfcfcf;
    padding: 10px;
    font-family: Circular,Helvetica,Arial,sans-serif;
}
#centerContents{
	background-color: #111111;
}
table{
	width: 100%;
}
.personStarRating{
	width: 100px;
    height: 15px;
    color: #191970;
    padding: 10px;
    font-size: 18px;
	font-family: Arial;
}
#productRating{
	width: 125px;
    height: 23px;
    background-color: #191970;
    color: white;
    padding: 10px;
    font-size: 20px;
	font-family: Arial;
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
			  <a href="BookFlight.jsp"><i class="fa fa-plane" aria-hidden="true"></i> Book a Flight</a>
			  <a href="WriteReview.jsp"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Write Review</a>
			  <a href="ViewReview.jsp" style="background-color:#404040"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> View Review</a>
			  <a href="ManageBooking.jsp"><i class="fa fa-th-list" aria-hidden="true"></i> Manage Booking</a>
			  <a href="FlightStatus.jsp"><i class="fa fa-clock-o" aria-hidden="true"></i> Flight Status</a>
			  <a href="WebCheckin.jsp"><i class="fa fa-suitcase" aria-hidden="true"></i> Web Check-in</a>
			</div>
			
			<div id="center">
			<h1>REVIEWS <i class="fa fa-pencil" aria-hidden="true"></i></h1>
			<table>
			
			<%
				System.out.println("========================Inside View Review.jsp========================");				
				session=request.getSession(false);
				String name=(String)session.getAttribute("UserId");
				if(name==null){
					name="";
				}
				
				MongoDBDataStoreUtilities mongodb=new MongoDBDataStoreUtilities();
				ArrayList<Reviews> readReviewslist=mongodb.getAllReviews();
				String personName;
				int personRating;
				String personReviewText;
				String personReviewDate;
				float averageRating=0;
				float totalRating=0;
				Reviews personReview;
				String startText="";
				String airlineName;
				
				for(int i=0;i<readReviewslist.size();i++){
					personReview=readReviewslist.get(i);
					airlineName=personReview.getAirlineName();
					personName=personReview.getReviewerName();
					personRating=personReview.getReviewRating();
					personReviewText=personReview.getReviewText();
					personReviewDate=personReview.getReviewDate().toString();
					totalRating=totalRating+personRating;
					System.out.println("Person Name: "+personName+"	| Rating: "+personRating+"	|	Review text: "+personReviewText+"	|	Review date: "+personReviewDate);
					for(int j=0;j<personRating;j++){
						startText=startText+"<i class='fa fa-star' aria-hidden='true'></i>";
					}
					%>
					<tr>
						<td>
							<ul>
								<h3><%=airlineName %></h3>
								<li><b><%= personName %>   </b><%= personReviewDate%></li>
								<li><div class='personStarRating'><%= startText+personRating %></div></li>
								<li><%= personReviewText %></li>
							</ul>
							<hr>
						</td>
					</tr>
			<%
					startText="";
				}
			%>
				</table>
			</div>
		</div>
		<div class='footer' id='footer'><ul><li><b>Contact</b></li><li>Team 7</li><li>CSP 595</li><li>EWA</li><li>Project</li></ul></div>
	</div>
</body>
</html>