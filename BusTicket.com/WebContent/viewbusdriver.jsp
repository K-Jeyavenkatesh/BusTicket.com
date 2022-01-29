
<%@page import="service.BusDriveManagerDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>BusTicket.com</title>
        <link rel="stylesheet" href="VIEW/CSS/reqular.css">
        <link rel="stylesheet" href="VIEW/CSS/viewbusdriver.css">
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
                        <li><a href="index.html" style="padding: 14px 20px;">HOME</a></li>
                       
                        <div class="dropdown">
						    <button class="dropbtn">VIEW 
						      <i class="fa fa-caret-down"></i>
						    </button>
						    <div class="dropdown-content">
						      <a href="viewbusdriver.jsp">BUS DRIVER</a>
						      <a href="viewbusinfo.jsp">BUS DETAILS</a>
						    </div>
						  </div> 
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
            <% BusDriver driver = (BusDriver)session.getAttribute("driver"); %>
            <% if(driver == null) {
            	driver = new BusDriver();
            } %>
            <div class="toppanel">
            	<form action="ViewBusDriver" method="POST">
            	<label id="licence_no" for="ans_licence_no">Licence No</label>
            	<input type="text" id="ans_licence_no" name="licence_no">
            	<h4 style="position:absolute;top:335px;left:120px;">OR</h4>
            	<label id="phone_no" for="ans_phone_no">Phone No</label>
            	<input type="text" id="ans_phone_no" name="phone_no">
            	<input type="submit" id="filterApplyinfo" value="APPLY">
            	</form>
            </div>
            <div class="maindownpanel">
            	<label id="name" for="ans_name">Name</label>
            	<input type="text" id="ans_name" name="name" value="<%=driver.getName() %>" disabled="disabled">
            	<label id="licenceno" for="ans_licence">Licence No</label>
            	<input type="text" id="ans_licence" name="licenceno" value="<%=driver.getLicenceNo() %>" disabled="disabled">
            	<label id="emailid" for="ans_emailid">Email ID</label>
            	<input type="text" id="ans_emailid" name="emailid" value="<%=driver.getEmailid() %>" disabled="disabled">
            	<label id="phoneno" for="ans_phone">Phone No</label>
            	<input type="text" id="ans_phone" name="phoneno" value="<%=driver.getPhoneno() %>" disabled="disabled">
            	<label id="licencefront" for="ans_licencefront">Licence Front PhotoCopy</label>
            	<img id="ans_licencefront" src="data:image/jpg;base64,<%=driver.getLicencePhotofrontDB() %>" width="440" height="300"/>
            	<label id="licenceback" for="ans_licenceback">Licence Back PhotoCopy</label>
            	<img id="ans_licenceback" src="data:image/jpg;base64,<%=driver.getLicencePhotobackDB() %>" width="440" height="300"/>
            	<form action="DownloadDriverHealthCertificate" method="post">
            		<label id="downloadtext">If you want, you can download and See Driver's Health Certificate</label>
            		<input type="hidden" name="licenceno" value="<%=driver.getLicenceNo() %>">
            		<input type="submit" id="ans_download" value="Download HealthCertificate">
            	</form>
            </div>
         </div>
	</body>
</html>