<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.*,java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>BusTicket.com</title>
        <link rel="stylesheet" href="VIEW/CSS/reqular.css">
        <link rel="stylesheet" href="VIEW/CSS/rentalfromview.css">
        <link rel="icon" type="image/png" href="VIEW/CSS/IMAGES/favicon.png">
	</head>
	<body>
		<div class="main">
			<div class="navbar">
                <div class="icon">
                    <h2 class="logo"><a href="index.html">BusTicket.com</a></h2>
                </div>
                <div class="menu">
                    <ul>
                        <li><a href="index.html">HOME</a></li>
                        <li><a href="#">ABOUT</a></li>
                        <li><a href="#">SERVICE</a></li>
                        <div class="dropdown">
						    <button class="dropbtn">ACCOUNT 
						      <i class="fa fa-caret-down"></i>
						    </button>
						    <div class="dropdown-content">
						      <a href="index.html">SIGN OUT</a>
						    </div>
						  </div> 
                    </ul>
                </div>
            	</div>
            	<% ArrayList<Rental> arr = (ArrayList<Rental>)session.getAttribute("rentalList"); %>
            	
            	<div class="blockpanel">
            		<%for(int i = 0; i < arr.size(); i++) { %>
            		<div class="blockelements">
	            		<p style="margin-left: 50px">ID: <%=arr.get(i).getId() %></p>
	            		<p style="margin-top: -20px; margin-left: 500px;">Requested User : <%=arr.get(i).getUsername() %></p>
	            		<p style="margin-left: 50px">Expected Date : <%=arr.get(i).getExpect_date() %></p>
	            		<p style="margin-top: -20px; margin-left: 500px;">Expected No of Days : <%=arr.get(i).getExpect_days() %></p>
	            		<p style="margin-left: 50px">Places : <%= arr.get(i).getExpect_place()%></p>
	            		<p style="margin-left: 50px">Other Details:</p>
	            		<p style="margin-left: 50px"><%=arr.get(i).getExpect_details() %></p>
	            		<p style="margin-left: 50px">Expected Bus Details:</p>
	            		<p style="margin-left: 50px"><%=arr.get(i).getExpect_busdetails() %></p>
	            		<p style="margin-left: 50px">Email ID : <%=arr.get(i).getUseremail() %></p>
	            		<p style="margin-top: -20px; margin-left: 450px;">Phone No 1 : <%=arr.get(i).getUserphone1() %></p>
	            		<p style="margin-top: -25px; margin-left: 730px;">Phone No 2 : <%=arr.get(i).getUserphone2() %></p>
	            		<form action="DelieverContactDetails" method="post">
	            			<input type="hidden" name="requested_id" value="<%=arr.get(i).getId() %>">
	            			<input type="hidden" name="requested_emailid" value="<%=arr.get(i).getUseremail() %>">
	            			<input type="submit" id="submit_id" value="ACCEPT">
	            		</form>
	            	</div>
	            	<%} %>
            	</div>
            </div>
	
	</body>
</html>