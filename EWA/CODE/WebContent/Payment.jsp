<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment</title>
<link rel="stylesheet" type="text/css" href="./CSS/Common.css">
<link rel="stylesheet" type="text/css" href="./CSS/Payment.css">
<link rel="stylesheet" href="./CSS/PaymentFont-master/PaymentFont-master/css/paymentfont.min.css" type="text/css">
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
#cardDiv{
	margin-top:30px;
}
#centerContents{
	background-color: #111;
}
h3{
	background-color: #cfcfcf;
    padding: 10px;
    font-family: Circular,Helvetica,Arial,sans-serif;
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
			  <a href="BookFlight.jsp" style="background-color:#404040"><i class="fa fa-plane" aria-hidden="true"></i> Book a Flight</a>
			   <a href="WriteReview.jsp"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Write Review</a>
			  <a href="ViewReview.jsp"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> View Review</a>
			  <a href="ManageBooking.jsp"><i class="fa fa-th-list" aria-hidden="true"></i> Manage Booking</a>
			  <a href="FlightStatus.jsp"><i class="fa fa-clock-o" aria-hidden="true"></i> Flight Status</a>
			  <a href="WebCheckin.jsp"><i class="fa fa-suitcase" aria-hidden="true"></i> Web Check-in</a>
			</div>
			<div id="center">
				<form action="ProcessPaymentServlet" method="post">
					<h1>Payment</h1>
					<%
						System.out.println("========================Inside Payment.jsp========================");				
						session=request.getSession(false);
						String name=(String)session.getAttribute("UserId");
						if(name==null){
							name="";
						}
					%>
					<h3>Welcome! <%=name%></h3>
						<div id="cardDiv">
						<div id="cardFront">
						<div id="cardNameDiv">
								Credit card
							</div>
							<div id="chipDiv">
								<div id="cardReader">------------------</div>
							</div>
							<div id="userFieldsDiv">
								<div id="cardNumberDiv" class="cardDiv">
									<input type="text" name="creditCardNumber" placeholder="Card Number" maxlength="20" onKeyUp="paymentLogo()" class="cardEntryField" id="cardNumber"></input>
								</div>
								<div id="expirationDate" class="cardDiv">
									<small style="color: black; font-family: monospace; ">Expiry Date</small> 
									<select name="cardExpiryMonth" class="cardEntryField" id="cardExpiryMonth">
										<option value="0">Month</option>
										<option value="01">01-Jan</option>
										<option value="02">02-Feb</option>
										<option value="03">03-Mar</option>
										<option value="04">04-Apr</option>
										<option value="05">05-May</option>
										<option value="06">06-Jun</option>
										<option value="07">07-Jul</option>
										<option value="08">08-Aug</option>
										<option value="09">09-Sep</option>
										<option value="10">10-Oct</option>
										<option value="11">11-Nov</option>
										<option value="12">12-Dec</option>
									</select>
									<input type="text" name="cardExpiryYear" id="cardExpiryYear" placeholder="Year" maxlength="4" class="cardEntryField" min="2016"></input>
								</div>
								<div id="cardHoldersNameDiv" class="cardDiv">
									<input type="text" name="cardHoldersName" id="cardHoldersName"placeholder="Name on card" class="cardEntryField"></input>
								</div>
								<div id="paymentSystems">
								</div>
							</div>
						</div>
						
						<div id="cardBack">
							<div id="magneticStrip"></div>
							<div id="signCVV">
								<div id="signatureStrip">
									PayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPayPay
								</div>
								<div id="cvvDiv">
									<input type="password" name="cvv" id="cvv" placeholder="CVV" maxlength="4" class="cardEntryField"></input>
								</div>
							</div>
						</div>
						<div id="pay">
							<button type="submit" id="payButton">PAY</button> 
						</div>
					</div>
					</div>
					</form>
	
		</div>
		<div class='footer' id='footer'><ul><li><b>Contact</b></li><li>Team 7</li><li>CSP 595</li><li>EWA</li><li>Project</li></ul></div>
	</div>
</body>
<script type="text/javascript"	src="./JavaScript/Payment.js"></script>
</html>