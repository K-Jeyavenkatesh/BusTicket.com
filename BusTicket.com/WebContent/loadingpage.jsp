<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import=" java.util.concurrent.TimeUnit"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<style>
		.loader {
			position: absolute;
			top: 150px;
			left: 650px;
			  border: 16px solid rgb(77, 77, 77);
			  border-radius: 50%;
			  border-top: 16px solid #ffc400;
			  width: 120px;
			  height: 120px;
			  -webkit-animation: spin 2s linear infinite; /* Safari */
			  animation: spin 2s linear infinite;
		}
		
		#text {
			position: absolute;
			top: 350px;
			left: 550px;
			font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
   			font-weight: bold;
   			font-size: 20px;
		}
		
		@-webkit-keyframes spin {
		  0% { -webkit-transform: rotate(0deg); }
		  100% { -webkit-transform: rotate(360deg); }
		}
		
		@keyframes spin {
		  0% { transform: rotate(0deg); }
		  100% { transform: rotate(360deg); }
		}
	</style>
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










