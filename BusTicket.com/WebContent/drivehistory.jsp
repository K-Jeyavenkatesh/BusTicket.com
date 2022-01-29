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