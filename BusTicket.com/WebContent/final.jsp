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
        <style>
        	.mainblockpanel {
        		position: absolute;
        		top: 100px;
        		left: 100px;
        		width: 1300px;
        		height: 600px;
        		background-color: white;
        		opacity: 0.9;
        		border-radius: 20px;
        		font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
	    		font-weight: bold;
	    		font-size: 23px;
        	}
        	
        	#tick {
        		position: absolute;
        		height: 100px;
        		width: 100px;
        		border-radius: 50%;
        		left: 300px;
        	}
        	#tick_title {
        		 position: absolute;
        		font-size: 40px;
        		top: 30px;
        		left: 400px;
        	}
        	#pnr {
        		position: absolute;
        		top: 130px;
        		left: 400px;
        	}
        	#tras_id {
        		position: absolute;
        		top: 170px;
        		left: 400px;
        	}
        	#trans_mode {
        		position: absolute;
        		top: 220px;
        		left: 400px;
        	}
        	#ticket {
        		position: absolute;
        		top: 270px;
        		left: 400px;
        	}
        	#subtitle {
        		position: absolute;
        		top: 470px;
        		left: 400px;
        	}
        	#gotohome {
        		position: absolute;
        		top: 540px;
        		left: 550px;
        	}
        	#submit_id {
        			position: absolute;
	        		height: 50px;
	        		width: 300px;
	        		top: 320px;
	        		left: 440px;
	        		background-color: #ffc400;
	        		color: rgb(77,77,77);
	        		font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
	    			font-weight: bold;
	    			font-size: 20px;
	    			border-radius: 10px;
	    			border: none;	
	        	}
        	
        </style>
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
                    <h2 class="logo"><a href="#">BusTicket.com</a></h2>
                </div>
                <div class="menu">
                    <ul>
                        <li><a href="www.google.com">HOME</a></li>
                        <li><a href="#">ABOUT</a></li>
                        <li><a href="#">SERVICE</a></li>
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