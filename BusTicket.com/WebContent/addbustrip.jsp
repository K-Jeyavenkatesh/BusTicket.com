<%@page import="model.BusDriveAdmin"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>BusTicket.com</title>
		<link rel="stylesheet" type="text/css" href="VIEW/CSS/addbustrip.css">
        <link rel="icon" type="image/png" href="VIEW/CSS/IMAGES/favicon.png">
        
	</head>
	<body>
	<script>
	function present_date() {
	    var today = new Date();
	    var dd = today.getDate();
	    var mm = today.getMonth()+1; 
	    var yyyy = today.getFullYear();
	    if(dd<10){
	      dd='0'+dd
	    } 
	    if(mm<10){
	      mm='0'+mm
	    } 
	    today = yyyy+'-'+mm+'-'+dd;
		document.getElementById("ans_date").setAttribute("min",today); 
	}
	</script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
			    var maxField = 20; 
			    var addButton = $('.add_button'); 
			    var wrapper = $('.field_wrapper'); 
			    var x = 1; 
			    var addButton_r = $('.add_button_r'); 
			    var wrapper_r = $('.field_wrapper_r'); 
			    var y = 1;
			    $(addButton).click(function(){
			    	var fieldHTML = '<div><a href="javascript:void(0);" class="remove_button"><img id="imgg" src="VIEW/CSS/IMAGES/remove-icon.png"/></a><input id="first_text" type="text" name="boarding_name['+x+']" value=""/>'+
			        '<input id="second_text" type="time" name="time_name['+x+']" value=""/><input id="third_text" type="number" name="price_name['+x+']" value=""/></div>'; //New input field html 
			    	console.log(fieldHTML);
			    	
			    	if(x < maxField){ 
			            x++; 			        
			            $(wrapper).append(fieldHTML); 
			        }
			    });
			    $(addButton_r).click(function(){
			    	var fieldHTMLr = '<div><a href="javascript:void(0);" class="remove_button_r"><img id="imgg" src="VIEW/CSS/IMAGES/remove-icon.png"/></a><input id="first_text" type="text" name="dropping_name['+y+']" value=""/>'+
			        '<input id="second_text" type="time" name="dtime_name['+y+']" value=""/></div>'; 
			    	console.log(fieldHTMLr);
			    	
			    	if(y < maxField){ 
			            y++; 			        
			            $(wrapper_r).append(fieldHTMLr); 
			        }
			    });
			    
			    $(wrapper).on('click', '.remove_button', function(e){
			        e.preventDefault();
			        $(this).parent('div').remove(); 
			        x--; 
			    });
			    $(wrapper_r).on('click', '.remove_button_r', function(e){
			        e.preventDefault();
			        $(this).parent('div').remove(); 
			        y--; 
			    });
			});
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
						      <a href="#">PROFILE</a>
						      <a href="index.html">SIGN OUT</a>
						    </div>
						  </div> 
                    </ul>
                </div>
            </div>
            <% BusDriveAdmin admin = (BusDriveAdmin)session.getAttribute("busdriveadmin"); %>
            <form action="AddBusTrip" method="POST">
            <div class="mainpanel">
	            <div class="panel1">
	            	<label id="travelsname" for="ans_travelsname">Travels Name</label>
	            	<input type="text" id="ans_travelsname" name="travelsname" value="<%= admin.getTravelsName()%>" disabled="disabled">
	            	  <label id="busno" for="ans_busno">Bus Vehicle Number</label>
	            	<input type="text" id="ans_busno" name="busno">
	            	<label id="driverno" for="ans_driverno">Driver Phone Number</label>
	            	<input type="text" id="ans_driverno" name="driverno">
	            	<label id="adriverno" for="ans_adriverno">Additional Driver Ph.No</label>
	            	<input type="text" id="ans_adriverno" name="adriverno">
	            	<label id="date" for="ans_date">Date</label>
	            	<input type="date" id="ans_date" name="date" onclick="present_date()">
	            	<label for="air" id="l_air">Bus AirCondition</label>
					  <select name="air" id="air">
					    <option value="Ac">Ac</option>
					    <option value="NonAc">NonAc</option>
					  </select>
					  <label for="seattype" id="seattype">Bus Seating Type</label>
					  <select name="seattype" id="aseattype">
					    <option value="Sleeper">Sleeper</option>
					    <option value="Seater">Seater</option>
					  </select>
					  <p id="wifi">Wifi Available</p>
					  <input type="radio" id="wifiy" name="wifi" value="yes">
					  <label for="wifiy" id="wifiys">Yes</label>
					  <input type="radio" id="wifin" name="wifi" value="no">
					  <label for="wifin" id="wifins">No</label>
					  <p id="charging">Charging Available</p>
					  <input type="radio" id="chargingy" name="charging" value="yes">
					  <label for="chargingy" id="chargingys">Yes</label>
					  <input type="radio" id="chargingn" name="charging" value="no">
					  <label for="chargingn" id="chargingns">No</label>
					  <p id="food">Food/Snacks Available</p>
					  <input type="radio" id="foody" name="food" value="yes">
					  <label for="foody" id="foodys">Yes</label>
					  <input type="radio" id="foodn" name="food" value="no">
					  <label for="foodn" id="foodns">No</label>
					  <p id="movie">Movie Available</p>
					  <input type="radio" id="moviey" name="movie" value="yes">
					  <label for="moviey" id="movieys">Yes</label>
					  <input type="radio" id="movien" name="movie" value="no">
					  <label for="movien" id="moviens">No</label> 
				 </div>
				 <div class="panel2">
				 	<p id="b_point_label">Boarding Point</p>
				 	<p id="bp_time_label">Boarding Time</p>
				 	<p id="price_label">Price</p>
				 	<div class="boarding_panel">
				 		<div class="field_wrapper">
						    <div>
						    <a href="javascript:void(0);" class="add_button" title="Add field"><img id="imgg" src="VIEW/CSS/IMAGES/add-icon.png"/></a>
						        <input id="first_text" type="text" name="boarding_name[0]" value=""/>
						        <input id="second_text" type="time" name="time_name[0]" value=""/>
						        <input id="third_text" type="number" name="price_name[0]" value=""/>
						    </div>
						</div>
				 	</div>
				 	<p id="d_point_label">Dropping Point</p>
				 	<p id="dp_time_label">Dropping Time</p>
				 	<div class="dropping_panel">
				 		<div class="field_wrapper_r">
						    <div>
						    <a href="javascript:void(0);" class="add_button_r" title="Add field"><img id="imgg" src="VIEW/CSS/IMAGES/add-icon.png"/></a>
						        <input id="first_text" type="text" name="dropping_name[0]" value=""/>
						        <input id="second_text" type="time" name="dtime_name[0]" value=""/>
						
						    </div>
						</div>
				 	</div>
				 	<input type="submit" id="submit_button" name="submit" value="Add Bus Trip">
				 </div>
            </div>
            </form>
          </div>
	</body>
</html>