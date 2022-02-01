<%@page import="model.BusDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>BusTicket.com</title>
        <link rel="stylesheet" href="VIEW/CSS/seatbook.css">
        <link rel="icon" type="image/png" href="VIEW/CSS/IMAGES/favicon.png">
	</head>
	<% HttpSession sessin = request.getSession();%>
    <% BusDetails curentBus = (BusDetails)sessin.getAttribute("currentBus"); %>
	<% String bookedSeats = curentBus.getBookedSeats(); %>
	<body onmouseenter='markBookedSeats()'>
		<script >
		
		function markBookedSeats() {
			<% String bookedSeat = curentBus.getBookedSeats(); %>
			<% out.println("var a = "+bookedSeat); %>
			
			for(var i = 0; i < a.length; i++) {
				var b = "seat_"+a[i].toLowerCase();
				document.getElementById(b).style.backgroundColor="#ff4747";
				document.getElementById(b).disabled = true;
			}
		}
		
		function selectBPoint(point) {
				
				var a1 = document.getElementById(point.id).value;
				document.getElementById("boarding").innerHTML = "Boarding At : "+a1;
				document.getElementById("boarding").value = a1;
				var i = document.getElementById(point.id).selectedIndex;
				<% String bp_time = curentBus.getBoardingTime(); %>
				<% out.println("var b = \""+bp_time+"\";"); %>
				<% out.println("var bprice = \""+curentBus.getPrice()+"\";"); %>
				var c = b.split(" ");
				var d = document.getElementById("time").innerHTML;
				var e = d.split(" ");
				var bb = bprice.split(" ");
				console.log(bb);
				document.getElementById("time").innerHTML = c[i]+" "+e[1]+" "+e[2];
				document.getElementById("time").value = c[i]+" "+e[1]+" "+e[2];
				document.getElementById("time_booked_now").value = c[i]+" "+e[1]+" "+e[2];
				document.getElementById("price").value = bb[i];
				document.getElementById("price_booked_now").value = bb[i];
				document.getElementById("price").innerHTML = "Price Per Passenger : "+bb[i]+" INR";
				console.log(document.getElementById("time_booked_now").value);
				var num_seats = document.getElementById("price_booked_number").value;
	    		document.getElementById("price_booked_total").value = document.getElementById("price_booked_now").value * num_seats;
	    		console.log(document.getElementById("price_booked_total").value);
	    		document.getElementById("ans_tc").innerHTML = document.getElementById("price_booked_total").value+" INR/-";
	    		document.getElementById("ans_sc").innerHTML = document.getElementById("price_booked_total").value*0.08 +" INR/-";
	    		document.getElementById("ans_cc").innerHTML = document.getElementById("price_booked_total").value*0.08 +" INR/-";
				totalAmount();
			}
		
		function selectDPoint(point) {
			
			var a1 = document.getElementById(point.id).value;
			document.getElementById("dropping").innerHTML = "Dropping At : "+a1;
			document.getElementById("dropping").value = a1;
			var i = document.getElementById(point.id).selectedIndex;
			<% String dp_time = curentBus.getDroppingTime(); %>
			<% out.println("var b = \""+dp_time+"\";"); %>
			var c = b.split(" ");
			var d = document.getElementById("time").innerHTML;
			var e = d.split(" ");
			document.getElementById("time").innerHTML = e[0]+" "+e[1]+" "+c[i];
			document.getElementById("time").value = e[0]+" "+e[1]+" "+c[i];
			document.getElementById("time_booked_now").value = e[0]+" "+e[1]+" "+c[i];
			console.log(document.getElementById("time_booked_now").value);
		}
		
	    	function handleClick(obj) {
	    		var id = document.getElementById(obj.id);
	    		var arr = document.getElementById("seats_booked_now");
	    		var text = arr.innerHTML;
	    		if(text.length == 0) {
	    			text += obj.value;
	    		} else {
	    			text += ","+obj.value;
	    		}
	    		var array = text.split(",");
	    		var seatNumbers = [];
	    		array.forEach((c) => {
	    		    if (!seatNumbers.includes(c)) {
	    		        seatNumbers.push(c);
	    		    }
	    		});
	    		if(seatNumbers.length > 8) {
	    			alert("Only 8 seats can booked per transcation");
	    			return;
	    		}
	    		if(id.title == "Unselect") {
	    			id.style.backgroundColor = "#dedede";
	    			id.title = "Select";
	    			const index = array.indexOf(id.value);
	    			if (index > -1) {
	    				seatNumbers.splice(index, 1);
	    			}
	    		} else {
	    			id.style.backgroundColor = "#75ff70";
	    			id.title = "Unselect";
	    			
	    		}
	    		seatNumbers.sort();
	    		var num_seats = seatNumbers.length;
	    		
	    		
	    		document.getElementById("price_booked_number").value = num_seats;
	    		document.getElementById("price_booked_total").value = document.getElementById("price_booked_now").value * num_seats;
	    		console.log(document.getElementById("price_booked_total").value);
	    		document.getElementById("ans_tc").innerHTML = document.getElementById("price_booked_total").value+" INR/-";
	    		document.getElementById("ans_sc").innerHTML = document.getElementById("price_booked_total").value*0.08 +" INR/-";
	    		document.getElementById("ans_cc").innerHTML = document.getElementById("price_booked_total").value*0.08 +" INR/-";
	    		arr.innerHTML = seatNumbers.toString();
	    		arr.value = seatNumbers.toString();
	    		document.getElementById("i_seats_booked_now").value = seatNumbers.toString();
	    		
	    		totalAmount();
	    	}
	    	function addInsurance() {
	    		document.getElementById("ans_is").innerHTML = "10 INR/-";
	    		totalAmount();
	    	}
	    	function remInsurance() {
	    		document.getElementById("ans_is").innerHTML = "0 INR/-";
	    		totalAmount();
	    	}
	    	function totalAmount() {
	    		var a = parseInt(document.getElementById("price_booked_total").value);
	    		var b = parseInt(document.getElementById("price_booked_number").value);
	    		var c = a/b;
	    		var i = 0;
	    		var t = document.getElementById("ans_is").innerHTML;
	    		if(t.charAt(0) == "1") {
	    			i = 10;
	    		}
	    		var ans = a+b*(c*0.16)+i;
	    		document.getElementById("ans_final").innerHTML = ans +" INR/-";
	    		document.getElementById("totalprice").value = ans;
	    	}
	    	function logout() {
				
			}
	    </script>
	    <form action="SeatbookingToAddPassenger" method="POST">
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
            
            <% String busType = curentBus.getBusType();%>
            <% if(busType.equals("Seater")) {
            	out.println("<div class=\"bus_seatBooking\">"+
            	"<span id=\"exit\">EXIT</span>"+
            	"<span id=\"driver\"><span id=\"driver_inside\">Driver</span></span>"+
            	"<input type=\"button\" id=\"seat_s01\" name=\"01\" value=\"S01\" title=\"Select\" onclick='handleClick(this);'>"+
            	"<input type=\"button\" id=\"seat_s02\" name=\"02\" value=\"S02\" title=\"Select\" onclick='handleClick(this);'>"+
            	"<input type=\"button\" id=\"seat_s03\" name=\"03\" value=\"S03\" title=\"Select\" onclick='handleClick(this);'>"+
            	"<input type=\"button\" id=\"seat_s04\" name=\"04\" value=\"S04\" title=\"Select\" onclick='handleClick(this);'>"+
            	
            	"<input type=\"button\" id=\"seat_s05\" name=\"05\" value=\"S05\" title=\"Select\" onclick='handleClick(this);'>"+
            	"<input type=\"button\" id=\"seat_s06\" name=\"06\" value=\"S06\" title=\"Select\" onclick='handleClick(this);'>"+
            	"<input type=\"button\" id=\"seat_s07\" name=\"07\" value=\"S07\" title=\"Select\" onclick='handleClick(this);'>"+
            	"<input type=\"button\" id=\"seat_s08\" name=\"08\" value=\"S08\" title=\"Select\" onclick='handleClick(this);'>"+
            	
            	"<input type=\"button\" id=\"seat_s09\" name=\"09\" value=\"S09\" title=\"Select\" onclick='handleClick(this);'>"+
            	"<input type=\"button\" id=\"seat_s10\" name=\"10\" value=\"S10\" title=\"Select\" onclick='handleClick(this);'>"+
            	"<input type=\"button\" id=\"seat_s11\" name=\"11\" value=\"S11\" title=\"Select\" onclick='handleClick(this);'>"+
            	"<input type=\"button\" id=\"seat_s12\" name=\"12\" value=\"S12\" title=\"Select\" onclick='handleClick(this);'>"+
            	
            	"<input type=\"button\" id=\"seat_s13\" name=\"13\" value=\"S13\" title=\"Select\" onclick='handleClick(this);'>"+
            	"<input type=\"button\" id=\"seat_s14\" name=\"14\" value=\"S14\" title=\"Select\" onclick='handleClick(this);'>"+
            	"<input type=\"button\" id=\"seat_s15\" name=\"15\" value=\"S15\" title=\"Select\" onclick='handleClick(this);'>"+
            	"<input type=\"button\" id=\"seat_s16\" name=\"16\" value=\"S16\" title=\"Select\" onclick='handleClick(this);'>"+
            	
            	"<input type=\"button\" id=\"seat_s17\" name=\"17\" value=\"S17\" title=\"Select\" onclick='handleClick(this);'>"+
            	"<input type=\"button\" id=\"seat_s18\" name=\"18\" value=\"S18\" title=\"Select\" onclick='handleClick(this);'>"+
            	"<input type=\"button\" id=\"seat_s19\" name=\"19\" value=\"S19\" title=\"Select\" onclick='handleClick(this);'>"+
            	"<input type=\"button\" id=\"seat_s20\" name=\"20\" value=\"S20\" title=\"Select\" onclick='handleClick(this);'>"+
            	
            	"<input type=\"button\" id=\"seat_s21\" name=\"21\" value=\"S21\" title=\"Select\" onclick='handleClick(this);'>"+
            	"<input type=\"button\" id=\"seat_s22\" name=\"22\" value=\"S22\" title=\"Select\" onclick='handleClick(this);'>"+
            	"<input type=\"button\" id=\"seat_s23\" name=\"23\" value=\"S23\" title=\"Select\" onclick='handleClick(this);'>"+
            	"<input type=\"button\" id=\"seat_s24\" name=\"24\" value=\"S24\" title=\"Select\" onclick='handleClick(this);'>"+
            	
            	"<input type=\"button\" id=\"seat_s25\" name=\"25\" value=\"S25\" title=\"Select\" onclick='handleClick(this);'>"+
            	"<input type=\"button\" id=\"seat_s26\" name=\"26\" value=\"S26\" title=\"Select\" onclick='handleClick(this);'>"+
            	"<input type=\"button\" id=\"seat_s27\" name=\"27\" value=\"S27\" title=\"Select\" onclick='handleClick(this);'>"+
            	"<input type=\"button\" id=\"seat_s28\" name=\"28\" value=\"S28\" title=\"Select\" onclick='handleClick(this);'>"+
            	
            	"<input type=\"button\" id=\"seat_s29\" name=\"29\" value=\"S29\" title=\"Select\" onclick='handleClick(this);'>"+
            	"<input type=\"button\" id=\"seat_s30\" name=\"30\" value=\"S30\" title=\"Select\" onclick='handleClick(this);'>"+
            	"<input type=\"button\" id=\"seat_s31\" name=\"31\" value=\"S31\" title=\"Select\" onclick='handleClick(this);'>"+
            	"<input type=\"button\" id=\"seat_s32\" name=\"32\" value=\"S32\" title=\"Select\" onclick='handleClick(this);'>"+
            	"<input type=\"button\" id=\"seat_s33\" name=\"33\" value=\"S33\" title=\"Select\" onclick='handleClick(this);'>"+
            	"<input type=\"button\" id=\"seat_s34\" name=\"34\" value=\"S34\" title=\"Select\" onclick='handleClick(this);'>"+
            	
            "</div>");
            } else {
            	out.println("<div class=\"bus_seatBooking\">"+
                    	"<span id=\"exit\">EXIT</span>"+
                    	"<span id=\"u_berth\">U - Upper berth</span>"+
                        "<span id=\"l_berth\">L - Lower berth</span>"+
                    	"<span id=\"driver\"><span id=\"driver_inside\">Driver</span></span>"+
                    	"<input type=\"button\" id=\"seat_u01\" name=\"01\" value=\"U01\" title=\"Select\" onclick='handleClick(this);'>"+
                    	"<input type=\"button\" id=\"seat_u02\" name=\"02\" value=\"U02\" title=\"Select\" onclick='handleClick(this);'>"+
                    	"<input type=\"button\" id=\"seat_u03\" name=\"03\" value=\"U03\" title=\"Select\" onclick='handleClick(this);'>"+
                    	"<input type=\"button\" id=\"seat_u04\" name=\"04\" value=\"U04\" title=\"Select\" onclick='handleClick(this);'>"+
                    	
                    	"<input type=\"button\" id=\"seat_l05\" name=\"05\" value=\"L05\" title=\"Select\" onclick='handleClick(this);'>"+
                    	"<input type=\"button\" id=\"seat_l06\" name=\"06\" value=\"L06\" title=\"Select\" onclick='handleClick(this);'>"+
                    	"<input type=\"button\" id=\"seat_l07\" name=\"07\" value=\"L07\" title=\"Select\" onclick='handleClick(this);'>"+
                    	"<input type=\"button\" id=\"seat_l08\" name=\"08\" value=\"L08\" title=\"Select\" onclick='handleClick(this);'>"+
                    	
                    	"<input type=\"button\" id=\"seat_u09\" name=\"09\" value=\"U09\" title=\"Select\" onclick='handleClick(this);'>"+
                    	"<input type=\"button\" id=\"seat_u10\" name=\"10\" value=\"U10\" title=\"Select\" onclick='handleClick(this);'>"+
                    	"<input type=\"button\" id=\"seat_u11\" name=\"11\" value=\"U11\" title=\"Select\" onclick='handleClick(this);'>"+
                    	"<input type=\"button\" id=\"seat_u12\" name=\"12\" value=\"U12\" title=\"Select\" onclick='handleClick(this);'>"+
                    	
                    	"<input type=\"button\" id=\"seat_l13\" name=\"13\" value=\"L13\" title=\"Select\" onclick='handleClick(this);'>"+
                    	"<input type=\"button\" id=\"seat_l14\" name=\"14\" value=\"L14\" title=\"Select\" onclick='handleClick(this);'>"+
                    	"<input type=\"button\" id=\"seat_l15\" name=\"15\" value=\"L15\" title=\"Select\" onclick='handleClick(this);'>"+
                    	"<input type=\"button\" id=\"seat_l16\" name=\"16\" value=\"L16\" title=\"Select\" onclick='handleClick(this);'>"+
                    	
                    	"<input type=\"button\" id=\"seat_u17\" name=\"17\" value=\"U17\" title=\"Select\" onclick='handleClick(this);'>"+
                    	"<input type=\"button\" id=\"seat_u18\" name=\"18\" value=\"U18\" title=\"Select\" onclick='handleClick(this);'>"+
                    	"<input type=\"button\" id=\"seat_u19\" name=\"19\" value=\"U19\" title=\"Select\" onclick='handleClick(this);'>"+
                    	"<input type=\"button\" id=\"seat_u20\" name=\"20\" value=\"U20\" title=\"Select\" onclick='handleClick(this);'>"+
                    	
                    	"<input type=\"button\" id=\"seat_l21\" name=\"21\" value=\"L21\" title=\"Select\" onclick='handleClick(this);'>"+
                    	"<input type=\"button\" id=\"seat_l22\" name=\"22\" value=\"L22\" title=\"Select\" onclick='handleClick(this);'>"+
                    	"<input type=\"button\" id=\"seat_l23\" name=\"23\" value=\"L23\" title=\"Select\" onclick='handleClick(this);'>"+
                    	"<input type=\"button\" id=\"seat_l24\" name=\"24\" value=\"L24\" title=\"Select\" onclick='handleClick(this);'>"+
                    	
                    	"<input type=\"button\" id=\"seat_u25\" name=\"25\" value=\"U25\" title=\"Select\" onclick='handleClick(this);'>"+
                    	"<input type=\"button\" id=\"seat_u26\" name=\"26\" value=\"U26\" title=\"Select\" onclick='handleClick(this);'>"+
                    	"<input type=\"button\" id=\"seat_u27\" name=\"27\" value=\"U27\" title=\"Select\" onclick='handleClick(this);'>"+
                    	"<input type=\"button\" id=\"seat_u28\" name=\"28\" value=\"U28\" title=\"Select\" onclick='handleClick(this);'>"+
                    	
                    	"<input type=\"button\" id=\"seat_l29\" name=\"29\" value=\"L29\" title=\"Select\" onclick='handleClick(this);'>"+
                    	"<input type=\"button\" id=\"seat_l30\" name=\"30\" value=\"L30\" title=\"Select\" onclick='handleClick(this);'>"+
                    	"<input type=\"button\" id=\"seat_l31\" name=\"31\" value=\"L31\" title=\"Select\" onclick='handleClick(this);'>"+
                    	"<input type=\"button\" id=\"seat_l32\" name=\"32\" value=\"L32\" title=\"Select\" onclick='handleClick(this);'>"+
                    	
                    "</div>");
            }%>
            <%
            	String bp[] = curentBus.getBoardingPoints().split(" ");
            	String dp[] = curentBus.getDroppingPoints().split(" ");
            	String bt[] = curentBus.getBoardingTime().split(" ");
            	String dt[] = curentBus.getDroppingTime().split(" ");
            	String price[] = curentBus.getPrice().split(" ");
	            out.println("<div class=\"selecting_panel\">"+
			        		"<label class=\"bp_label\" for=\"bp\">Boarding Point</label>"+
							  "<select class=\"bp_select\" name=\"bp\" id=\"bp\" onclick=\"selectBPoint(this)\">");
			        			for(int i = 0; i < bp.length; i++) {
			        				
							   		out.println(" <option value=\""+bp[i]+"\">"+bp[i]+"</option>");
			        			}
							    
				out.println( "</select>"+
						  "<label class=\"dp_label\" for=\"dp\">Dropping Point</label>"+
							 " <select class=\"dp_select\" name=\"dp\" id=\"dp\" onclick=\"selectDPoint(this)\">");
							 for(int i = 0; i < dp.length; i++) {
								 
							   		out.println(" <option value=\""+dp[i]+"\">"+dp[i]+"</option>");
			        		}
							 out.println(" </select>"+
			        		"</div>"+
					        "<div class=\"final_panel\">"+
					        	"<h2 id=\"departure\">Departure : "+bp[0]+"</h2>"+
					        	"<h2 id=\"destination\">Destination : "+dp[dt.length-1]+"</h2>"+
					        	"<h2 id=\"boarding\" name=\"bp_name\" value=\""+bp[0]+"\">Boarding At : "+bp[0]+"</h2>"+
					        	"<h2 id=\"dropping\" name=\"dp_name\" value=\""+dp[0]+"\">Dropping At : "+dp[0]+"</h2>"+
					        	"<h2 id=\"date\">Date : "+curentBus.getDate()+"</h2>"+
					        	"<input type=\"hidden\"id=\"date_booked_now\" name=\"date_booked\" value=\""+curentBus.getDate()+"\"></h2>"+
					        	"<input type=\"hidden\"id=\"time_booked_now\" name=\"time_booked\" value=\""+bt[0]+" to "+dt[dt.length-1]+"\"></h2>"+
					        	"<h2 id=\"time\" name=\"time\" value=\""+bt[0]+" to "+dt[dt.length-1]+"\">"+bt[0]+" to "+dt[dt.length-1]+"</h2>"+
					        	
					        	"<h2 id=\"seats_label\">Seats Booked : </h2>"+
					        	"<h2 id=\"seats_booked_now\" name=\"seat_booked\" value=\"\"></h2>"+
					        	"<input type=\"hidden\"id=\"i_seats_booked_now\" name=\"i_seat_booked\" value=\"\"></h2>"+
					        	"<h2 id=\"price\" name=\"seat_price\" value=\""+price[0]+"\">Price Per Passenger : "+price[0]+"</h2>"+
					        	"<input type=\"hidden\"id=\"price_booked_now\" name=\"price_booked\" value=\""+price[0]+"\">"+
					            "<input type=\"hidden\"id=\"price_booked_total\" name=\"price_booked_total\" value=\""+price[0]+"\">"+
					            "<input type=\"hidden\"id=\"price_booked_number\" name=\"price_booked_number\" value=\"0\">"+
					        	"<h3 id=\"insurance\">Do you need a travel insurance ?</h3>"+
					        	"<input type=\"radio\" id=\"insurance_yes\" name=\"i\" value=\"YES\" onclick=\"addInsurance()\">"+
								"<label for=\"yes\" id=\"yes_label\">YES</label><br>"+
								"<input type=\"radio\" id=\"insurance_no\" name=\"i\" value=\"NO\" onclick=\"remInsurance()\">"+
								"<label for=\"no\" id=\"no_label\">NO</label><br>"+
								"<div class=\"bill_panel\">"+
									"<h2 id=\"tc\">Total Cost:</h2>"+
									"<h2 id=\"ans_tc\">0 INR /-</h2>"+
									"<h2 id=\"sc\" style=\"position: relative;"+
										"top: 50px;"+
										"left : 10px;"+
										"font-size: 25px;"+
										"font-family: \'Franklin Gothic Medium\', \'Arial Narrow\', Arial, sans-serif;"+
									    "font-weight: bold;"+
									    "color:white;\">SGST:</h2>"+
									"<h2 id=\"ans_sc\">0 INR /-</h2>"+
									"<h2 id=\"cc\" style=\"position: relative;"+
											"top: 50px;"+
											"left : 10px;"+
											"font-size: 25px;"+
											"font-family: \'Franklin Gothic Medium\', \'Arial Narrow\', Arial, sans-serif;"+
										    "font-weight: bold;"+
										    "color:white;\">CGST:</h2>"+
									"<h2 id=\"ans_cc\">0 INR /-</h2>"+
									"<h2 id=\"is\" style=\"position: relative;"+
											"top: 50px;"+
											"left : 10px;"+
											"font-size: 25px;"+
											"font-family: \'Franklin Gothic Medium\', \'Arial Narrow\', Arial, sans-serif;"+
										    "font-weight: bold;"+
										    "color:white;\">Insurance:</h2>"+
									"<h2 id=\"ans_is\" >0 INR /-</h2>"+
									"<h2 id=\"final\">Total Amount : </h2>"+
									"<h2 id=\"ans_final\" style=\"position: relative;"+
											"top: 120px;"+
											"left : 10px;"+
											"font-size: 25px;"+
											"font-family: \'Franklin Gothic Medium\', \'Arial Narrow\', Arial, sans-serif;"+
										    "font-weight: bold;"+
										    "color:white;\">0 INR /--</h2>"+
								"<input type=\"hidden\"id=\"totalprice\" name=\"totalprice\" value=\"0\">"+
								"</div>"+
				        	"</div>");
            %>
		</div>
		<input type=submit class="submit_button">
		</form>
	</body>
</html>










