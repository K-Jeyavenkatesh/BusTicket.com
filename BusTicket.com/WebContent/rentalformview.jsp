<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.*,java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>BusTicket.com</title>
        <link rel="stylesheet" href="VIEW/CSS/reqular.css">
        <link rel="stylesheet" href="VIEW/CSS/rentalformview.css">
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
        		height: 220px;
        		left: 25px;
        		color: white;
        		background-color: rgb(77, 77, 77);
        		margin-top: 10px;
        		margin-bottom: 10px; 
        		border-radius: 20px;
        	}
        	#submit_id {
	        		height: 50px;
	        		width: 200px;
	        		margin-bottom: 20px;
	        		margin-top: -30px;
	        		margin-left: 1000px;
	        		background-color: #ffc400;
	        		color: rgb(77,77,77);
	        		font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
	    			font-weight: bold;
	    			font-size: 20px;
	    			border-radius: 10px;
	    			border: none;	
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
                        <li><a href="www.google.com">HOME</a></li>
                        <li><a href="#">ABOUT</a></li>
                        <li><a href="#">SERVICE</a></li>
                        <div class="dropdown">
						    <button class="dropbtn">ACCOUNT 
						      <i class="fa fa-caret-down"></i>
						    </button>
						    <div class="dropdown-content">
						      <a href="#">SIGN OUT</a>
						    </div>
						  </div> 
                    </ul>
                </div>
            	</div>
            	<% ArrayList<Rental> arr = (ArrayList<Rental>)session.getAttribute("rentalList"); %>
            	<div class="blockpanel">
            		<%for(int i = 0; i < arr.size(); i++) { %>
            		<div class="blockelements">
	            		<p style="margin-left: 50px">ID: <%=arr.get(i).getId() %></p>
	            		<p style="margin-top: -20px; margin-left: 500px;">Requested User : <%=arr.get(i).getUsername() %></p>
	            		<p style="margin-left: 50px">Expected Date : <%=arr.get(i).getExpect_date() %></p>
	            		<p style="margin-top: -20px; margin-left: 500px;">Expected No of Days : <%=arr.get(i).getExpect_days() %></p>
	            		<p style="margin-left: 50px">Places : <%= arr.get(i).getExpect_place()%></p>
	            		<p style="margin-left: 50px">Other Details:</p>
	            		<p style="margin-left: 50px"><%=arr.get(i).getExpect_details() %></p>
	            		<p style="margin-left: 50px">Expected Bus Details:</p>
	            		<p style="margin-left: 50px"><%=arr.get(i).getExpect_busdetails() %></p>
	            		<p style="margin-left: 50px">Email ID : <%=arr.get(i).getUseremail() %></p>
	            		<p style="margin-top: -20px; margin-left: 450px;">Phone No 1 : <%=arr.get(i).getUserphone1() %></p>
	            		<p style="margin-top: -25px; margin-left: 730px;">Phone No 2 : <%=arr.get(i).getUserphone2() %></p>
	            		<from action="DelieverContactDetails" method="post">
	            			<input type="submit" id="submit_id" value="ACCEPT">
	            		</from>
	            	</div>
	            	<%} %>
            	</div>
            </div>
	
	</body>
</html>