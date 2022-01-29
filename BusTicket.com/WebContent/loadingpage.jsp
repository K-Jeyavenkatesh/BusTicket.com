<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import=" java.util.concurrent.TimeUnit"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>BusTicket.com</title>
        <link rel="stylesheet" href="VIEW/CSS/loadingpage.css">
        <link rel="icon" type="image/png" href="VIEW/CSS/IMAGES/favicon.png">
	
	</head>
	<body>
		<script type="text/javascript">
			function startTimer(duration, display) {
			    var start = Date.now(),
			        diff,
			        minutes,
			        seconds;
			    var flag = true;
			    function timer() {
			       
			        diff = duration - (((Date.now() - start) / 1000) | 0);
			        minutes = (diff / 60) | 0;
			        seconds = (diff % 60) | 0;
	
			        minutes = minutes < 10 ? "0" + minutes : minutes;
			        seconds = seconds < 10 ? "0" + seconds : seconds;
					
			        if(diff > 0) {
			        display.textContent = minutes + ":" + seconds; 
			        }
	
			        if (diff == 0) {
			            alert("Payment Success !!!");
			            window.location.href = "FinalTicketProcess";
			        
			            flag = false;
			            return false;
			        }
			    };
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
			    var fiveMinutes = 5 * 1,
			        display = document.querySelector('#time');
			    startTimer(fiveMinutes, display);
			    return false;
			};
		</script>
		<div class="loader"></div>
		<p id="text">Please wait. Your Payment is Processing</p>
		<span id="time" hidden></span>
		
	</body>
</html>










