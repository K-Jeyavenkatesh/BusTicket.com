
<%@page import="service.BusDriveManagerDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>BusTicket.com</title>
        <link rel="stylesheet" href="VIEW/CSS/reqular.css">
        <link rel="stylesheet" href="VIEW/CSS/viewbusinfo.css">
        <link rel="icon" type="image/png" href="VIEW/CSS/IMAGES/favicon.png">
        <style>
	        .mainpanel {
	        	position: absoulte;
	        }
        	.toppanel {
        		position: absoulte;
        		margin-top: 200px;
        		margin-left: 100px;
        		width: 400px;
        		height: 300px;
        		background-color: rgb(77, 77, 77);
        		border-radius: 20px;
        		opacity: 0.7;
        	}
        	
        	.maindownpanel {
        		position: absoulte;
        		margin-top: -450px;
        		margin-left: 550px;
        		width: 800px;
        		height: 600px;
        		background-color: white;
        		border-radius: 20px;
        		overflow-y: auto;
        		font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
    			font-weight: bold;
    			font-size: 20px;
        	}
        	
        	#bus_nol {
        		position: absolute;
        		font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
    			font-weight: bold;
    			font-size: 20px;
    			left: 150px;
    			top: 275px;
        	}
        	
        	#ans_bus_nol {
        		position: absolute;
        		font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
    			font-weight: bold;
    			font-size: 20px;
    			left: 150px;
    			top: 300px;
    			width: 300px;
    			height: 30px;
        	}
        	
        	#filterApplyinfo {
        		position: absolute;
        		height: 40px;
        		width: 100px;
        		top: 450px;
        		left: 350px;
        		background-color: #ffc400;
        		color: rgb(77,77,77);
        		font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
    			font-weight: bold;
    			font-size: 20px;
        	}
        	
        	#bus_no , #bus_model, #bus_ownername, #bus_owneremailid, #bus_ownerphone, #bus_travelname{
        		position: relative;
        		top: 20px;
        		margin: 20px;
        	}
        	
        	#ans_bus_no , #ans_bus_model, #ans_bus_ownername, #ans_bus_owneremailid, #ans_bus_ownerphone, #ans_bus_travelname{
        		position: relative;
        		top: 20px;
        		width: 400px;
        		height: 30px;
        		font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
    			font-weight: bold;
    			font-size: 20px;
        	}
        	
        	#ans_bus_no {
        		left: 100px;
        	}
        	#ans_bus_model {
        		left: 70px;
        	}
        	#ans_bus_ownername {
        		left: 52px;
        	}
        	#ans_bus_owneremailid {
        		left: 30px;
        	}
        	#ans_bus_ownerphone {
        		left: 48px;
        	}
        	#ans_bus_travelname {
        		left: -13px;
        	}
        	
        	#rc, #insu, #puc, #fit {
        		
        		height: 50px;
        		width: 300px;
        		top: 450px;
        		left: 350px;
        		background-color: #ffc400;
        		color: rgb(77,77,77);
        		font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
    			font-weight: bold;
    			font-size: 20px;
    			border-radius: 10px;
    			border: 5px solid rgb(77,77,77);
    			margin: 10px;
    			margin-left: 250px;
        	}
        </style>
	</head>
	<body>
		<div class="main">
			<div class="navbar">
                <div class="icon">
                    <h2 class="logo"><a href="#">BusTicket.com</a></h2>
                </div>
                <div class="menu">
                    <ul>
                        <li><a href="#" style="padding: 14px 20px;">HOME</a></li>
                        <div class="dropdown">
						    <button class="dropbtn">EDIT 
						      <i class="fa fa-caret-down"></i>
						    </button>
						    <div class="dropdown-content">
						      <a href="#">BUS DRIVER</a>
						      <a href="#">BUS DETAILS</a>
						    </div>
						  </div>
                        <div class="dropdown">
						    <button class="dropbtn">VIEW 
						      <i class="fa fa-caret-down"></i>
						    </button>
						    <div class="dropdown-content">
						      <a href="viewbusdriver.jsp">BUS DRIVER</a>
						      <a href="#">BUS DETAILS</a>
						    </div>
						  </div> 
                        <div class="dropdown">
						    <button class="dropbtn">ACCOUNT 
						      <i class="fa fa-caret-down"></i>
						    </button>
						    <div class="dropdown-content">
						      <a href="#">PROFILE</a>
						      <a href="#">SIGN OUT</a>
						    </div>
						  </div> 
                    </ul>
                </div>
            </div>
              <% BusInfo businfo = (BusInfo)session.getAttribute("businfo"); %>
            <% if(businfo == null) {
            	businfo = new BusInfo();
            } %>
            <div class="toppanel">
            	<form action="ViewBusInfo" method="POST">
            	<label id="bus_nol" for="ans_bus_nol">Bus No</label>
            	<input type="text" id="ans_bus_nol" name="businfo"><br/>
            	<input type="submit" id="filterApplyinfo" value="APPLY">
            	</form>
            </div>
            <div class="maindownpanel">
            	<label id="bus_no" for="ans_bus_no">Bus No </label>
            	<input type="text" id="ans_bus_no" name="bus_no" value="<%=businfo.getBusno() %>" disabled="disabled"><br/><br/>
            	<label id="bus_model" for="ans_bus_model">Bus Model</label>
            	<input type="text" id="ans_bus_model" name="bus_model" value="<%=businfo.getBusmodel()%>" disabled="disabled"><br/><br/>
            	<label id="bus_ownername" for="ans_bus_ownername">Owner Name</label>
            	<input type="text" id="ans_bus_ownername" name="bus_ownername" value="<%=businfo.getOwnername() %>" disabled="disabled"><br/><br/>
            	<label id="bus_owneremailid" for="ans_bus_owneremailid">Owner Email ID</label>
            	<input type="text" id="ans_bus_owneremailid" name="bus_owneremailid" value="<%=businfo.getOwneremail() %>" disabled="disabled"><br/><br/>
            	<label id="bus_ownerphone" for="ans_bus_ownerphone">Owner Phone</label>
            	<input type="text" id="ans_bus_ownerphone" name="bus_ownerphone" value="<%=businfo.getOwnerphone() %>" disabled="disabled"><br/><br/>
            	<label id="bus_travelname" for="ans_bus_travelname">Travel Agency Name</label>
            	<input type="text" id="ans_bus_travelname" name="bus_travelname" value="<%=businfo.getTravelsagency() %>" disabled="disabled"><br/><br/>
            	<form action="DownloadBusInfo" method="post">
            		<input type="hidden" name="rcbook" value="<%=businfo.getBusno() %>">
            		<input type="submit" id="rc" value="Download RcBook">
            	</form>
            	<form action="DownloadBusInfo" method="post">
            		<input type="hidden" name="insurance" value="<%=businfo.getBusno() %>">
            		<input type="submit" id="insu" value="Download Insurance">
            	</form>
            	<form action="DownloadBusInfo" method="post">
            		<input type="hidden" name="puccert" value="<%=businfo.getBusno() %>">
            		<input type="submit" id="puc" value="Download PUC Certificate">
            	</form>
            	<form action="DownloadBusInfo" method="post">
            		<input type="hidden" name="fitness" value="<%=businfo.getBusno() %>">
            		<input type="submit" id="fit" value="Download Fitness Certificate">
            	</form>
            	
            </div>
         </div>
	</body>
</html>