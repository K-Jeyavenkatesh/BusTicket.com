<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>BusTicket.com</title>
		<link rel="stylesheet" type="text/css" href="VIEW/CSS/addpassengerlist.css">
        <link rel="icon" type="image/png" href="VIEW/CSS/IMAGES/favicon.png">
        <style>
        	#pass_submit {
        		positive: relative;
				margin-top: 30px;
				margin-bottom: 30px;
				margin-left: 340px;
				width: 200px;
				height: 50px;
				background-color: #ffc400;
				color: white;
				font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
				font-weight: bold;
				font-size: 20px;
				cursor: pointer;
				text-align: center;
				border: 2px solide black;
				border-radius: 10px;
        	}
         </style>
	</head>
	<body>
	<script>
		function logout() {
			<% session.invalidate();%>
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
						      <a href="profile.jsp">PROFILE</a>
						      <a href="index.html" onclick="logout()">SIGN OUT</a>
						    </div>
						  </div>  
                    </ul>
                </div>
            </div>
            <h2>Add Passenger Details</h2>
            <% HttpSession sessin = request.getSession(); %>
            <% String seat = (String)sessin.getAttribute("seat");
            	String[] seat_numbers = seat.split(",");
            %>
            <form action="TicketProvider" method="POST">
            <div class="panel">
            	<% for(int i = 0; i < seat_numbers.length; i++) {
	            	out.println("<div class=\"inside_panel\">"+
	            		"<h2 id=\"title_p\">Passenger : Seat "+seat_numbers[i]+"</h2>"+
	            		"<h2 id=\"title_name\">Name : </h2>"+
	            		"<input id=\"input_name\" type=\"text\" name=\"pass_"+seat_numbers[i]+"\" required>"+
	            		"<h2 id=\"title_age\">Age : </h2>"+
	            		"<input id=\"input_age\"type=\"number\" name=\"pass_"+seat_numbers[i]+"_age\" required>"+
	            		"<h2 id=\"title_gender\">Gender : </h2>"+
	            		"<input type=\"radio\" id=\"genderm\" name=\"gender"+seat_numbers[i]+"\" value=\"Male\" required>"+
						"<label id=\"genderml\"for=\"Male\">Male</label><br>"+
						"<input type=\"radio\" id=\"genderf\" name=\"gender"+seat_numbers[i]+"\" value=\"Female\" required>"+
						"<label id=\"genderfl\" for=\"Female\">Female</label><br>"+
	            	"</div>");
            	} %>
            	<input type="submit" id="pass_submit" value="BOOK TICKET">
            </div>
            
            </form>
        </div>
	</body>
</html>