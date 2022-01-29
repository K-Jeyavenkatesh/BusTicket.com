<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>BusTicket.com</title>
        <link rel="stylesheet" href="VIEW/CSS/maindrivepage.css">
        <link rel="icon" type="image/png" href="VIEW/CSS/IMAGES/favicon.png">
	</head>
	<body>
	<script type="text/javascript">
		function show() {
			var coll = document.getElementsByClassName("block_panel");
			var i;
		
			for (i = 0; i < coll.length; i++) {
			  coll[i].addEventListener("click", function() {
			    this.classList.toggle("active");
			    var content = this.nextElementSibling;
			    console.log(content);
			    if (content.style.display === "block") {
			      content.style.display = "none";
			    } else {
			      content.style.display = "block";
			    }
			  });
			}
		}
	</script>
		<div class="main">
			<div class="navbar">
                <div class="icon">
                    <h2 class="logo"><a href="index.html">BusTicket.com</a></h2>
                </div>
                <div class="menu">
                    <ul>
                        <li><a href="index.html" style="padding: 14px 20px;">HOME</a></li>
                        
                        <div class="dropdown">
						    <button class="dropbtn">VIEW 
						      <i class="fa fa-caret-down"></i>
						    </button>
						    <div class="dropdown-content">
						      <a href="viewbusdriver.jsp">BUS DRIVER</a>
						      <a href="viewbusinfo.jsp">BUS DETAILS</a>
						    </div>
						  </div> 
                        <div class="dropdown">
						    <button class="dropbtn">ACCOUNT 
						      <i class="fa fa-caret-down"></i>
						    </button>
						    <div class="dropdown-content">
						      <a href="#">PROFILE</a>
						      <a href="index.html">SIGN OUT</a>
						    </div>
						  </div> 
                    </ul>
                </div>
            </div>
            <div class="sidepanel" style="position: absolute;
													top : 100px;
													left: 50px;
													width: 400px;
													height: 610px;
													border-radius: 20px;
													background-color: rgb(77, 77, 77);
													opacity: 0.7;"	>
            	<form action="addbustrip.jsp" method="POST">
           			<input id="add_travel" type="submit" name="add_travel" value="ADD TRAVEL" style="width:200px;
           																							height:50px;
           																							position:relative;
           																							top: 50px;
           																							left: 100px;
           																							background-color: #ffc400;
				  																					color: white;
				  																					font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
																									font-weight: bold;
																									font-size: 20px;
																									cursor: pointer;
																									text-align: center;
																									border: none;
																									border-radius: 10px;">
           		</form>
           		<form action="DriveHistory" method="POST">
           			<input id="history" type="submit" name="history" value="HISTORY" style="width:200px;
           																					height:50px;
           																					margin-top: 10px;
           																					position:relative;
           																					top: 50px;
           																					left: 100px;
           																					background-color: #ffc400;
				  																			color: white;
				  																			font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
																							font-weight: bold;
																							font-size: 20px;
																							cursor: pointer;
																							text-align: center;
																							border: none;
																							border-radius: 10px;">
           		</form>
           		<form action="addbusdriver.jsp" method="POST">
           			<input id="add_busdriver" type="submit" name="add_busdriver" value="ADD BUSDRIVER" style="width:200px;
           																							margin-top: 10px;
           																							height:50px;
           																							position:relative;
           																							top: 50px;
           																							left: 100px;
           																							background-color: #ffc400;
				  																					color: white;
				  																					font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
																									font-weight: bold;
																									font-size: 20px;
																									cursor: pointer;
																									text-align: center;
																									border: none;
																									border-radius: 10px;">
           		</form>
           		<form action="addbusinfo.jsp" method="POST">
           			<input id="add_newbus" type="submit" name="add_newbus" value="ADD NEWBUS" style="width:200px;
           																							height:50px;
           																							margin-top: 10px;
           																							position:relative;
           																							top: 50px;
           																							left: 100px;
           																							background-color: #ffc400;
				  																					color: white;
				  																					font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
																									font-weight: bold;
																									font-size: 20px;
																									cursor: pointer;
																									text-align: center;
																									border: none;
																									border-radius: 10px;">
           		</form>
           		<hr id="first_hzline" style="position:relative;top:70px;left:45px;width: 300px;">
           		
           		<hr id="first_hzline" style="position:relative;top:110px;left:45px;width: 300px;">
           		<form action="RentalFormView" method="POST">
           			<input id="see_rental" type="submit" name="see_rental" value="VIEW RENTAL REQUEST" style="width:250px;
           																							margin-top: 10px;
           																							height:50px;
           																							position:relative;
           																							top: 115px;
           																							left: 75px;
           																							background-color: #ffc400;
				  																					color: white;
				  																					font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
																									font-weight: bold;
																									font-size: 20px;
																									cursor: pointer;
																									text-align: center;
																									border: none;
																									border-radius: 10px;">
           		</form>
           		<img src="VIEW/CSS/IMAGES/favicon.png" style="margin-top: 150px;margin-left: 120px;">
           		
            </div>
             <div class="mainpanel">
            	<% HttpSession ses = request.getSession(); %>
            	<% ArrayList<BusDetails> arr = (ArrayList<BusDetails>)ses.getAttribute("buslist"); %>
            	<% for(int i = 0; i < arr.size(); i++) { 
            		BusDetails bus = (BusDetails)arr.get(i); %>
            		<div class="block_panel">
	            		<p id="busid">Bus ID: <%= bus.getBusID() %></p>
	            		<p id="busno">Bus Number: <%= bus.getBusNumber() %></p>
	            		<p id="date">Date: <%= bus.getDate() %></p>
	            		<p id="journeyid">Journey ID: <%= bus.getJourneyID() %></p>
	            		<% String[] bp = bus.getBoardingPoints().split(" "); %>
	            		<p id="departure">Departure: <%= bp[0] %></p>
	            		<% String[] dp = bus.getDroppingPoints().split(" "); %>
	            		<p id="arrival">Arrival: <%= dp[0] %></p>
	            		<button type="button" class="collapsible" onclick="show()" value="MoreDetails">More Details</button>
	            		</div>
	            		<div class="down_panel">
	            			<p id="bp_points">Boarding Points: <%= bus.getBoardingPoints() %></p>
	            			<p id="dp_points">Dropping Points: <%= bus.getDroppingPoints() %></p>
	            			<p id="bp_time">Boarding Timings: <%= bus.getBoardingTime() %></p>
	            			<p id="dp_points">Dropping Timings: <%= bus.getDroppingTime() %></p>
	            			<p id="pricelist">Price: <%= bus.getPrice() %></p>
	            			<p id="aircondition">Bus AirCondition: <%= bus.getBusAirCondition() %></p>
	            			<p id="bustype">Bus Type: <%= bus.getBusType() %></p>
	            			<p id="seattype">Seats Available: <%= bus.getSeatAvaliable() %></p>
	            			<p id="totalseats">Total Seats: <%= bus.getTotalSeats() %></p>
	            			<p id="bookedseats">Booked Seats: <%= bus.getBookedSeats() %></p>
	            			<p id="driverno">Driver Phone No: <%= bus.getDriverPhone() %></p>
	            			<p id="adriverno">Additional Driver Phone No: <%= bus.getAdditionalDriverPhone() %></p>
	            			<form action="ViewBusDriver"  method="post">
	            				<input type="hidden" name="phone_no" value="<%= bus.getDriverPhone() %>">
            	 				<input id="busdriver_button" type="submit" value="view BusDriver">
	            	 		</form>
	            	 		<form action="ViewBusInfo"  method="post">
	            	 			<input type="hidden" name="businfo" value="<%= bus.getBusNumber() %>">
	            	 			<input id="businfo_button" type="submit" value="view BusDetails">
	            	 		</form>
	            	 		<form action="DownloadTripRecord"  method="post">
	            	 			<input type="hidden" name="journeyid" value="<%= bus.getJourneyID() %>">
	            	 			<input id="download_button" type="submit" value="download PassengerList">
	            	 		</form>
	            		</div>
            	 		
					
            	<% } %>
            </div> 
		</div>
	</body>
</html>