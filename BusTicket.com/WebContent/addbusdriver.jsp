<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
			<title>BusTicket.com</title>
			<link rel="stylesheet" type="text/css" href="VIEW/CSS/reqular.css">
			<link rel="stylesheet" type="text/css" href="VIEW/CSS/addbusdriver.css">
	        <link rel="icon" type="image/png" href="VIEW/CSS/IMAGES/favicon.png">
	</head>
	<body>
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
         	<div class="mainpanel">
         		<form action="AddBusDriver" method="POST" enctype="multipart/form-data">
	         		<label id="name" for="ans_name">Driver Name</label><br/>
	         		<input type="text" id="ans_name" name="name"><br/>
	         		<label id="licno" for="ans_licno">Driver Licence No</label><br/>
	         		<input type="text" id="ans_licno" name="licno"><br/>
	         		<label id="emailid" for="ans_emailid">Driver Email ID</label><br/>
	         		<input type="email" id="ans_emailid" name="emailid"><br/>
	         		<label id="number" for="ans_number">Driver Phone No</label><br/>
	         		<input type="number" id="ans_number" name="number"><br/>
	         		<label id="fphoto" for="ans_fphoto">DrivingLicence Photo(Front)</label><br/>
	         		<input type="file" multiple accept="image/*" id="ans_fphoto" name="fphoto"><br/>
	         		<label id="bphoto" for="ans_bphoto">DrivingLicence Photo(Back)</label><br/>
	         		<input type="file" multiple accept="image/*" id="ans_bphoto" name="bphoto"><br/>
	         		<label id="health" for="ans_health">Health Certificate</label><br/>
	         		<input type="file" id="ans_health" accept="application/pdf" name="health"><br/>
	         		<input type="submit" id="submit_id" value="REGISTER">
	         	</form>
            </div> 
         </div>
	</body>
</html>