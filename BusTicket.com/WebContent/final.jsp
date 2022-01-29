<%@page import="service.TicketDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>BusTicket.com</title>
        <link rel="stylesheet" href="VIEW/CSS/reqular.css">
        <link rel="stylesheet" href="VIEW/CSS/final.css">
        <link rel="icon" type="image/png" href="VIEW/CSS/IMAGES/favicon.png">
	</head>
	<body>
	<script>
		function logout() {
			<%//session.invalidate();%>
		}
	</script>
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
						      <a href="index.html">SIGN OUT</a>
						    </div>
						  </div> 
                    </ul>
                </div>
            </div>
            <%Ticket ticket = new TicketDaoImpl().getTicket((long)session.getAttribute("pnr")+""); %>
            	<div class="mainblockpanel">
            		<img id="tick" src="VIEW/CSS/IMAGES/tick.jfif">
            		<p id="tick_title">SUCCESSFULLY TICKET BOOKED</p><br/>
            		<p id="pnr">PNR : <%=ticket.getPnr() %></p><br/>
            		<p id="tras_id">Transaction ID : <%=ticket.getTransactionID() %></p><br/>
            		<p id="trans_mode">Transaction Mode : <%=ticket.getTransactionMode() %></p><br/>
            		<form action="ETicket" method="post">
            			<label for="downloadTicket" id="ticket">You can Download your E-Ticket here</label><br/>
            			<input type="submit" id="submit_id" value="DOWNLOAD E-TICKET">
            		</form>
            		<p id="subtitle">Thank you for your booking at BusTicket.com<br/>We Eagerly waiting for Next Booking !!!</p>
            		<a href="index.html" id="gotohome"onclick="logout()">Go To Home</a>
            	</div>
           </div>
	</body>
</html>