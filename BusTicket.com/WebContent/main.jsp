<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>BusTicket.com</title>
		<link rel="stylesheet" type="text/css" href="VIEW/CSS/main.css">
        <link rel="icon" type="image/png" href="VIEW/CSS/IMAGES/favicon.png">
	</head>
	<body>
	<script >
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
			document.getElementById("journey_date").setAttribute("min",today); 
		}
		function logout() {
			
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
                        <li><a href="PassengerHistory">HISTORY</a></li>
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
            <div class="search_nav">
            	<form action="ProcessBus" method="post">
				  <label class="date_label" for="journey_date">Journey Date</label>
				  <input type="date" id="journey_date" name="journey_date" onclick="present_date()">
				  <label class="from_label"  for="journey_from">FROM</label>
				  <input list="journeyFrom" name="journey_from" id="journey_from" >
				  <datalist id="journeyFrom">
				    <option value="Delhi"></option>
				  </datalist>
				
				  <label class="to_label"  for="journey_to" >TO</label>
				  <input type="journeyTo" id="journey_to" name="journey_to" >
				  
				  <datalist id="journeyTo">
				    <option value="Delhi"></option>
				  </datalist>
				  <input type="submit" value="FIND BUS" style="position :absolute;
				  												background-color: rgb(77, 77, 77);
				  												color: white;
																width: 120px;
																height: 40px;
																top: 15px;
																left : 1300px;
																font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
																font-weight: bold;
																font-size: 15px;
																cursor: pointer;
																text-align: center;
																border: none;
																border-radius: 10px;">
			</form>
           </div>
           <div class="filter_nav" style="overflow: hidden">
           		
           		
           		<hr id="first_hzline" style="position:relative;top:70px;left:25px;width: 400px;">
           		<form action="rentalform.jsp" method="POST">
           			<input id="customize_travel" type="submit" name="customize_travel" value="CUTOMIZE YOUR OWN JOURNEY" style="width:400px;
           																									height:50px;
           																									position:relative;
           																									top: 100px;
           																									left: 25px;
           																									background-color: #ffc400;
				  																							color: white;
				  																							font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
																											font-weight: bold;
																											font-size: 20px;
																											cursor: pointer;
																											text-align: center;
																											border: none;
																											border-radius: 10px;">>
           		</form>	
           		<hr id="second_hzline" style="position:relative;top:130px;left:25px;width: 400px;">
           		<p id="filername_label" style="font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
												font-weight: bold;
												font-size: 25px;
												color: white;
												position:relative;
												top: 150px;
												left: 50px;">Filter</p>	
				<form action="FilterBus"  method="POST">
					<div class="filer_selects" style="position: relative;
																top:125px;
																left:150px;
																color: white;
																
					  											font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
																font-weight: bold;
																font-size: 23px;">
						<input type="checkbox" id="Ac" name="Ac" value="Ac">
						<label for="Ac">AC</label><br>
						<input type="checkbox" id="NonAc" name="NonAc" value="NonAc">
						<label for="NonAc">NonAC</label><br>
						<input type="checkbox" id="Seater" name="Seater" value="Seater">
						<label for="Seater">Seater</label><br>
						<input type="checkbox" id="Sleeper" name="Sleeper" value="Sleeper">
						<label for="Sleeper">Sleeper</label><br>
						<input type="checkbox" id="wifi" name="wifi" value="wifi">
						<label for="wifi"> WIFI</label><br>
						<input type="checkbox" id="charging" name="charging" value="charging">
						<label for="charging">Charging</label><br>
						<input type="checkbox" id="foodorsnacks" name="foodorsnacks" value="foodorsnacks">
						<label for="foodorsnacks"> Food/Snacks</label><br>
						<input type="checkbox" id="movie" name="movie" value="movie">
						<label for="movie">Movie</label><br>
						<input type="submit" value="APPLY" id="filter_submit">
					</div>
				</form>		
           	</div>
           	<div class="bus_main">
				<%! int top_busMain = 0; %>
				<% HttpSession sessin = request.getSession();
				ArrayList<BusDetails> b = (ArrayList<BusDetails>)sessin.getAttribute("buses");
				for(int i = 0; i < b.size(); i++) {
           		
					out.println("<form action=\"MainToSeatbooking\" method=\"post\"");
					out.println("<div class=\"bus_sec"+(i+1)+"\" style=\"position :absolute;");
					out.println("	background-color: white;");
					out.println("	top : "+(top_busMain)+"px;");
					out.println("	width : 910px;");
					out.println("	height : 200px;");
					out.println("	border-radius : 18px;opacity: 0.8");
					out.println("	\">");
					
					out.println("<h1 id=\"inside\" style=\"position:relative;left: 20px;width:900px\">"+b.get(i).getBusTravelsName()+"</h1>");
					out.println("<h2 id=\"from_point\" style=\"position:relative;top:10px;left: 25px;width:150px\">"+b.get(i).getBoardingPoints().split(" ")[0]+"</h2>");
					out.println("<h3 id=\"bet_to\" style=\"position:relative;top:-15px;left:210px;width:20px;\">TO</h3>");
					String[] temp = b.get(i).getDroppingPoints().split(" ");
					out.println("<h2 id=\"to_point\" style=\"position:relative;top:-37px;left: 300px;width:200px;\">"+temp[temp.length-1]+"</h2>");
		
					out.println("<h2 id=\"from_time\" style=\"position:relative;top:-20px;left: 30px;width:100px;\">"+b.get(i).getBoardingTime().split(" ")[0]+"</h2>");
					temp = b.get(i).getDroppingTime().split(" ");
					out.println("<h2 id=\"to_time\" style=\"position:relative;top:-43px;left: 305px;width:100px;\">"+temp[temp.length-1]+"</h2>");
					out.println("<h2 id=\"date\" style=\"position:relative;top:-43px;left: 170px;width:100px;\">"+b.get(i).getDate()+"</h2>");
					out.println("<h3 id=\"seats_avl\" style=\"position:relative;top:-175px;left: 500px;width:200px;\">"+b.get(i).getSeatAvaliable()+" Seats Avaliable</h3>");
					out.println("<h3 id=\"bus_air\" style=\"position:relative;top:-165px;left: 500px;width:200px;\">"+b.get(i).getBusAirCondition()+"</h3>");
					out.println("<h3 id=\"sbus_type\" style=\"position:relative;top:-155px;left: 500px;width:200px;\">"+b.get(i).getBusType()+"</h3>");
					String facility = "";
					if(b.get(i).getWifi().equals("yes")) {
						facility += "WiFi ";
					}
					if(b.get(i).getCharging().equals("yes")) {
						facility += "Charging ";
					}
					if(b.get(i).getFoodOrSnacks().equals("yes")) {
						facility += "Food/Snacks ";
					}
					if(b.get(i).getMovie().equals("yes")) {
						facility += "Movie ";
					}
					if(!facility.equals("")) {
						facility += "are available";
					}
					out.println("<h3 id=\"facility\" style=\"position:relative;top:-95px;left: 50px;width:400px;\">"+facility+"</h3>");
					out.println("<h3 id=\"price\" style=\"position:relative;top:-185px;left: 800px;width:100px;\">"+b.get(i).getPrice().split(" ")[0]+" INR</h3>");
					out.println("<input type=\"hidden\" name=\"busid\" value=\""+b.get(i).getBusID()+"\">");
					out.println("<input type=\"submit\" value=\"BOOK\" style=\"position:relative;top:-165px;left: 775px;width:100px;\"");
					out.println("</div>");
					out.println("</form>");
					top_busMain += 225;
           		} 
           		top_busMain = 0;%>
           		
           	</div>
        </div> 
	</body>
</html>
















