<%@page import="model.Passenger"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>BusTicket.com</title>
		<link rel="stylesheet" type="text/css" href="VIEW/CSS/otpverification.css">
        <link rel="icon" type="image/png" href="VIEW/CSS/IMAGES/favicon.png">
	</head>
	<body>
	<script>
	function loadDoc() {
		  var xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		      document.getElementById("demo").innerHTML =
		      this.responseText;
		      run();
		    }
		  };
		  var path = "ResendOTP";
		  xhttp.open("POST", path, true);
		  xhttp.send();
		}
	
	function run() {
		var fiveMinutes = 120 * 1,
        display = document.querySelector('#time');
		document.getElementById("timeLabel").value="1";
    startTimer(fiveMinutes, display);
    return false;
	}
	
	function startTimer(duration, display) {
	    var start = Date.now(),
	        diff,
	        minutes,
	        seconds;
	    var flag = true;
	    function timer() {
	        // get the number of seconds that have elapsed since 
	        // startTimer() was called
	        diff = duration - (((Date.now() - start) / 1000) | 0);

	        // does the same job as parseInt truncates the float
	        minutes = (diff / 60) | 0;
	        seconds = (diff % 60) | 0;

	        minutes = minutes < 10 ? "0" + minutes : minutes;
	        seconds = seconds < 10 ? "0" + seconds : seconds;
			
	        if(diff > 0) {
	        display.textContent = minutes + ":" + seconds; 
	        }

	        if (diff == 0) {
	            alert("Time Over. Click Resend to send OTP again");
	            display.textContent = " 0 seconds";
	        	document.getElementById("timeLabel").value="0";
	            flag = false;
	            return false;
	        }
	    };
	    // we don't want to wait a full second before the timer starts
	    if (diff == 0) {
	            flag = false;
	            return false;
	        }
	    if(flag != false) {
	    	timer();
        	setInterval(timer, 1000);
	    } else {
	    	return false;
	    }
	   return false;
	}

	window.onload = function () {
	    var fiveMinutes = 120 * 1,
	        display = document.querySelector('#time');
	    startTimer(fiveMinutes, display);
	    return false;
	};
	</script>
		
			<div class="main">
	            <div class="navbar">
	                <div class="icon">
	                    <h2 class="logo"><a href="index.html">BusTicket.com</a></h2>
	                </div>
	            </div>
	            <% Passenger passenger = (Passenger) session.getAttribute("passenger");
	            	String email = passenger.getEmail();
	            	int x = email.indexOf("@");
	            	email = email.substring(0,4)+"********"+email.substring(x);
	            %>
		            <div class="block_panel">
		            		<p id="otp_title">OTP VERIFICATION</p>
		            		<p id="otp_text">Your OTP has send to email ID <%=email %><br/>Kindly Check there and Type here</p>
		            		 <form action="OTPVerification" method="post">
		            		 <input type="hidden" id="timeLabel" name="time" value="1">
		            		<input type="number" id="otp_input" name="otp">
		            		<input type="submit" id="submitButton" value="SUBMIT">
		            		</form>
			             	<div id="time1">OTP valid for only <span id="time"></span> minutes!</div> 	
			             	<form action="" method="post">
			             		<button onclick="loadDoc()">Resend</button>
			             	</form>
		           </div>
	           </div>      
	</body>
</html>