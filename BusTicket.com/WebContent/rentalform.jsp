<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>BusTicket.com</title>
        <link rel="stylesheet" href="VIEW/CSS/reqular.css">
        <link rel="stylesheet" href="VIEW/CSS/rentalform.css">
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
        		overflow-y: auto;
        	}
        </style>
	</head>
	<body>
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
						      <a href="#">SIGN OUT</a>
						    </div>
						  </div> 
                    </ul>
                </div>
            	</div>
            	<form action="" method="post">
            	<div class="mainblockpanel">
            		<label for="expectPlace" id="expect_place">Expected Place To be Visited (like Delhi, Agra)</label><br/>
            		<input type="text" id="expectPlace" name="expect_place"><br/>
            		<label for="expectDate" id="expect_date">Expected Date</label><br/>
            		<input type="date" id="expectDate" name="expect_date"><br/>
            		<label for="expectDays" id="expect_days">Expected Number of Days</label><br/>
            		<input type="number" id="expectDays" name="expect_days"><br/>
            		<label for="expectDetails" id="expect_details">Please Provided More Details</label><br/>
            		<textarea cols="40" rows="5" style="width:200px; height:150px;" id="expectDetails" name="expect_details"></textarea><br/>
            		<label for="expectbusDetails" id="expect_busdetails">Expected Bus Requirements</label><br/>
            		<textarea cols="40" rows="5" style="width:200px; height:150px;" id="expectbusDetails" name="expect_busdetails"></textarea><br/>
            		<label for="username" id="user_name">Username of this Rental Book</label><br/>
            		<input type="text" id="username" name="Username"><br/>
            		<label for="useremail" id="user_email">User Email ID</label><br/>
            		<input type="text" id="useremail" name="Useremail"><br/>
            		<label for="userphone1" id="user_phone1">User Phone Number</label><br/>
            		<input type="number" id="userphone1" name="Userphone1"><br/>
            		<label for="userphone2" id="user_phone2">User Alternative Number</label><br/>
            		<input type="number" id="userphone2" name="Userphone2"><br/>
            		<input type="submit" value="SUBMIT REQUEST">
            	</div>
            	</form>
            </div>
	</body>
</html>