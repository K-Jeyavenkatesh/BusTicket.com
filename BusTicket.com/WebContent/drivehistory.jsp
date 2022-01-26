<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>BusTicket.com</title>
        <link rel="stylesheet" href="VIEW/CSS/reqular.css">
        <link rel="stylesheet" href="VIEW/CSS/drivehistory.css">
        <link rel="icon" type="image/png" href="VIEW/CSS/IMAGES/favicon.png">
        <style>
        	.blockpanel{
        		position: absolute;
        		margin-top: 50px;
        		left: 100px;
        		width:1300px;
        		height: 600px;
        		background-color: white;
        		border-radius: 20px;
        		opacity: 0.9;
        		overflow-y; auto;
        	}
        	
        	.blockelements {
        		position: relative;
        		font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
    			font-weight: bold;
    			font-size: 20px;
        		width: 1250px;
        		height: 75px;
        		left: 25px;
        		color: white;
        		background-color: rgb(77, 77, 77);
        		margin-top: 10px;
        		margin-bottom: 10px; 
        		border-radius: 20px;
        	}
        	
        	#journeyid {
        		position: relative;
        		left: 10px;
        		top: 23px;
        		width: 200px;
        	}
        	
        	#busno {
        		position: relative;
        		left: 175px;
        		width: 200px;
        	}
        	
        	#places {
        		position: relative;
        		left: 325px;
        		width: 300px;
        		top: -22px;
        	}
	       
	       #duration {
        		position: relative;
        		left: 550px;
        		width: 200px;
        		top: -45px;
        	}
        	
        	#date {
        		position: relative;
        		left: 775px;
        		width: 200px;
        		top: -65px;
        	}
        	
        	#submit_button {
        		position: relative;
        		left: 925px;
        		width: 300px;
        		height: 40px;
        		top: -95px;
        		cursor: pointer;
				text-align: center;
				border: none;
				border-radius: 10px;
				background-color: #ffc400;
				color: white;
				font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
    			font-weight: bold;
    			font-size: 20px;
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
            <%ArrayList<BusDetails> bustravelinfo = (ArrayList<BusDetails>)session.getAttribute("bustravelinfo"); %>
            <div class="blockpanel">
            	<%for(int i = 0; i < bustravelinfo.size(); i++) { %>
	            	<div class="blockelements">
	            		<p id="journeyid">JourneyID: <%= bustravelinfo.get(i).getJourneyID()%></p>
	            		<p id="busno"><%= bustravelinfo.get(i).getBusNumber()%></p>
	            		<% String bp[] = bustravelinfo.get(i).getBoardingPoints().split(" "); 
	            			String dp[] = bustravelinfo.get(i).getDroppingPoints().split(" ");
	            			String bt[] = bustravelinfo.get(i).getBoardingTime().split(" "); 
	            			String dt[] = bustravelinfo.get(i).getDroppingTime().split(" ");
	            		%>
	            		<p id="places"><%= bp[0]%> to <%= dp[dp.length-1]%></p>
	            		<p id="duration"><%= bt[0]%> to <%= dt[dt.length-1]%></p>
	            		<p id="date"><%= bustravelinfo.get(i).getDate()%></p>
	            		<form action="DownloadTripRecord" method="post">
	            			<input type="hidden" name="journeyid" value="<%= bustravelinfo.get(i).getJourneyID()%>">
	            			<input type="submit" id="submit_button" value="Download Trip Record">
	            		</form>
	            	</div>
	            <%} %>
            </div>
            </div>
	</body>
</html>