<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
        	}
        	
        	#tick {
        		height: 100px;
        		width: 100px;
        		border-radius: 50%;
        	}
        </style>
	</head>
	<body>
	<script>
		function logout() {
			
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
            	<div class="mainblockpanel">
            		<img id="tick" src="VIEW/CSS/IMAGES/tick.jfif">
            		<p id="tick_title">SUCCESSFULLY BOOKING</p><br/>
            		<p id="pnr">PNR : 1234567890</p><br/>
            		<p id="tras_id">Transaction ID : 1234567890</p><br/>
            		<p id="trans_mode">Transaction Mode : 1234567890</p><br/>
            		<form action="ETicket" method="post">
            			<label for="downloadTicket" id="ticket">You can Download your E-Ticket here</label><br/>
            			<input type="submit" value="DOWNLOAD E-TICKET">
            		</form>
            		<p id="subtitle">Thank you for your booking at BusTicket.com<br/>We Eagerly waiting for Next Booking !!!</p>
            		<a href="index.html" onclick="logout()">Go To Home</a>
            	</div>
           </div>
	</body>
</html>