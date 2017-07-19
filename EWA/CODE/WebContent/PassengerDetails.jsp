<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.text.SimpleDateFormat,javax.servlet.http.HttpSession;"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Passenger Details</title>
<link rel="stylesheet" type="text/css" href="./CSS/Common.css">
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
	height:500px;
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
			  <a href="ViewReviewServlet"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> View Review</a>
			  <a href="ManageBooking.jsp"><i class="fa fa-th-list" aria-hidden="true"></i> Manage Booking</a>
			  <a href="FlightStatus.jsp"><i class="fa fa-clock-o" aria-hidden="true"></i> Flight Status</a>
			  <a href="WebCheckin.jsp"><i class="fa fa-suitcase" aria-hidden="true"></i> Web Check-in</a>
			</div>
			<div id="center">
				<form action="processUserDetailsServlet" method="post">
				<h1>Traveller Details <i class="fa fa-users" aria-hidden="true"></i></h1>
				<%
					System.out.println("========================Inside PassengerDetails.jsp========================");				
					session=request.getSession(false);
					String name=(String)session.getAttribute("UserId");
					if(name==null){
						name="";
					}
				%>
				<h3>Welcome! <%=name%></h3>
				<table id="passengerDetailsTable">
					<!-- <tr>
						<th colspan="3">Enter Traveller details <i class="fa fa-users" aria-hidden="true"></i></th>
					</tr> -->
					<tr>
						<td>
							<select class="userIPFieldSelect" name="gender">
								<option value="Mr" class="gender">Mr</option>
								<option value="Mrs" class="gender">Mrs</option>
							</select>	
							<label for="Name" class="addressLabel">First Name
							<input type="text" name="firstName" class='userIPField' placeholder="First name"></input>
							</label>
						</td>
						<td>
							<label for="Name" class="addressLabel">Last Name</label>
							<input type="text" name="lastName" class='userIPField' placeholder="last name"></input>
						</td>
						<td>
							<select class="userIPFieldSelect" name="passengerType">
								<option value="Adult" class="passengerType">Adult</option>
								<option value="Child" class="passengerType">Child</option>
							</select>
						</td>
						
					</tr>
					<tr>
						<td>
							<label class="addressLabel">Date of Birth</label>
							<input type="text" name="DOBDay" class='dateField' placeholder="DD" maxlength="2"></input>
							<input type="text" name="DOBMonth" class='dateField' placeholder="MM" maxlength="2"></input>
							<input type="text" name="DOBYear" class='dateField' placeholder="YYYY" maxlength="4"></input>
						</td>
						<td>
							<label for="Phone" class="addressLabel">Meal Preference <i class="fa fa-cutlery" aria-hidden="true"></i></label>
							<select class="userIPField" name="mealPreference">
								<option value="" class=""> Select Meal </option>
								<option value="Vegetarian Jain Meal">Vegetarian Jain Meal</option>
								<option value="Kosher Meal">Kosher Meal</option>
								<option value="Moslem Meal">Moslem Meal</option>
								<option value="Baby Meal">Baby Meal</option>
								<option value="Hindu ( Non Vegetarian) Meal">Hindu ( Non Vegetarian) Meal</option>
								<option value="Vegetarian Hindu Meal">Vegetarian Hindu Meal</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>
							<label class="addressLabel">Passport Number</label>
							<input type="text" name="passportNumber" class='userIPField' placeholder="Passport Number"></input>
						</td>
						<td>
									<label class="addressLabel">Issuing Country</label>
									<select class="userIPField" name="issuingCountry">
										<option value="?">Issuing Country</option>
										<option value="India">India</option> 
										<option value="Afghanistan">Afghanistan</option> 
										<option value="Albania">Albania</option> 
										<option value="Algeria">Algeria</option> 
										<option value="Andorra">Andorra</option> 
										<option value="AO">Angola</option> 
										<option value="Angola">Anguilla</option> 
										<option value="Antigua and Barbuda">Antigua and Barbuda</option> 
									</select>
						</td>
						<td>
							<label class="addressLabel">Date of Expiry</label>
							<input type="text" name="DOEDate" class='dateField' placeholder="DD" maxlength="2"></input>
							<input type="text" name="DOEMonth" class='dateField' placeholder="MM" maxlength="2"></input>
							<input type="text" name="DOEYear" class='dateField' placeholder="YYYY" maxlength="4"></input>
						</td>
					</tr>
					<tr>
						<td>
							<label for="Phone" class="">Phone <i class="fa fa-phone" aria-hidden="true"></i></label>
							<input type="text" name="phoneNumber" class='userIPField' placeholder="Phone Number"></input>
						</td>
						<td>
							<label for="Email" class="">Email</label>
							<input type="text" name="email" class='userIPField' placeholder="Email"></input>
						</td>								
					</tr>
					</table>
					<div><button type="submit" id="makeSecurePaymentButton">Make Secure Payment</button></div>
				</form>
			</div>
		</div>
		<div class='footer' id='footer'><ul><li><b>Contact</b></li><li>Team 7</li><li>CSP 595</li><li>EWA</li><li>Project</li></ul></div>
	</div>
</body>
</html>