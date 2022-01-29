<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>BusTicket.com</title>
		<link rel="stylesheet" type="text/css" href="VIEW/CSS/passengerhistory.css">
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
						      <a href="profile.jsp">PROFILE</a>
						      <a href="index.html" onclick="logout()">SIGN OUT</a>
						    </div>
						  </div> 
                    </ul>
                </div>
            </div>
            <% ArrayList<PassengerBookingHistory> arr = (ArrayList<PassengerBookingHistory>)session.getAttribute("passHistory"); %>
            <div class="mainblock">
            	<%for(int i = 0; i < arr.size(); i++) { %>
            	<div class="miniblock">
            		<p id="text">ID: <%=arr.get(i).getJourneyID() %> - - -	<%=arr.get(i).getBoardingPoint() %> to <%=arr.get(i).getDroppingPoint() %> - - - 	from <%=arr.get(i).getBoardingTime() %> to <%=arr.get(i).getDroppingTime() %> - - -	<%=arr.get(i).getDate() %></p>
            	</div>
            	<%} %>
            </div>
          </div>
	</body>
</html>