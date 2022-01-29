<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>BusTicket.com</title>
		<link rel="stylesheet" type="text/css" href="VIEW/CSS/profile.css">
        <link rel="icon" type="image/png" href="VIEW/CSS/IMAGES/favicon.png">
	</head>
	<body>
		<script>
			function opens() {
				document.getElementById("ans_username").disabled = false;
				document.getElementById("ans_fullname").disabled = false;
				document.getElementById("ans_dob").disabled = false;
				document.getElementById("ans_gender").disabled = false;
				document.getElementById("ans_phone").disabled = false;
				document.getElementById("ans_password").disabled = false;
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
            <% Passenger passenger = (Passenger)session.getAttribute("passenger"); %>
     		<form action="Profile" method="post">        
	            <div class="mainblockpanel">
	            	<label for="ans_username" id="username">USERNAME</label><br/>
	            	<input type="text" id="ans_username" name="username" value="<%=passenger.getUsername() %>" disabled="disabled"><br/>
	            	<label for="ans_fullname" id="fullname">FULLNAME</label><br/>
	            	<input type="dob" id="ans_fullname" name="fullname" value="<%=passenger.getFullname() %>" disabled="disabled"><br/>
	            	<label for="ans_dob" id="dob">DATE OF BIRTH</label><br/>
	            	<input type="date" id="ans_dob" name="dob" value="<%=passenger.getDob() %>" disabled="disabled"><br/>
	            	<label for="ans_gender" id="gender">GENDER</label><br/>
	            	<input type="text" id="ans_gender" name="gender" value="<%=passenger.getGender() %>" disabled="disabled"><br/>
	            	<label for="ans_phone" id="phone">PHONE</label><br/>
	            	<input type="number" id="ans_phone" name="phone" value="<%=passenger.getPhonenumber() %>" disabled="disabled"><br/>
	            	<label for="ans_email" id="email">EMAIL ID</label><br/>
	            	<input type="text" id="ans_email" name="email" value="<%=passenger.getEmail() %>" disabled="disabled"><br/>
	            	<label for="ans_password" id="password">PASSWORD</label><br/>
	            	<input type="password" id="ans_password" name="password" value="<%=passenger.getPassword() %>" disabled="disabled"><br/>
	            	<input type="submit" id="update" value="UPDATE">
	            	
	            </div>
	            </form>
	            <button id="edit" onclick="opens()">Edit</button>

          </div>
	</body>
</html>








