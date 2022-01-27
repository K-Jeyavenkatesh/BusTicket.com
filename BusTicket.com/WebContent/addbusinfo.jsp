<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
			<title>BusTicket.com</title>
			<link rel="stylesheet" type="text/css" href="VIEW/CSS/reqular.css">
			<link rel="stylesheet" type="text/css" href="VIEW/CSS/addbusinfo.css">
	        <link rel="icon" type="image/png" href="VIEW/CSS/IMAGES/favicon.png">
	        <style>
	        	.blockpanel{
	        		position: absolute;
	        		top: 100px;
	        		left: 400px;
	        		width: 700px;
	        		height: 625px;
	        		background-color: white;
	        		opacity: 0.9;
	        		border-radius: 20px;
	        		overflow-y: auto;
	        		font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
    				font-weight: bold;
    				font-size: 20px;
	        	}
	        	
	        	#busno, #busmodelname, #ownername, #ownerphone, #owneremail, #rcbook, #insurance, #PUCCertificate, #fitness {
	        		margin-left: 150px;
	        	}
	        	
	        	#ans_busno, #ans_busmodelname, #ans_ownername, #ans_ownerphone, #ans_owneremail, #ans_rcbook, #ans_insurance, #ans_PUCCertificate, #ans_fitness {
	        		margin-left: 150px;
	        		margin-bottom: 15px;
	        		height: 30px;
	        		width: 400px;
	        		font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
    				font-weight: bold;
    				font-size: 15px;
	        	}
	        	
	        	#submit_id {
        		
	        		height: 50px;
	        		width: 200px;
	        		top: 450px;
	        		left: 300px;
	        		background-color: #ffc400;
	        		color: rgb(77,77,77);
	        		font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
	    			font-weight: bold;
	    			font-size: 20px;
	    			border-radius: 10px;
	    			border: none;
	    			margin: 10px;
	    			margin-left: 450px;
	    			margin-top: -70px;
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
            <div class="blockpanel">
            <form action="AddBusInfo" method="post" enctype="multipart/form-data">
            	<label id="busno" for="ans_busno">Bus Number</label><br/>
	         	<input type="text" id="ans_busno" name="busno"><br/>
	         	<label id="busmodelname" for="ans_busmodelname">Bus Model</label><br/>
	         	<input type="text" id="ans_busmodelname" name="busmodelname"><br/>
	         	<label id="ownername" for="ans_ownername">Owner Name</label><br/>
	         	<input type="text" id="ans_ownername" name="ownername"><br/>
	         	<label id="owneremail" for="ans_owneremail">Owner Email</label><br/>
	         	<input type="text" id="ans_owneremail" name="owneremail"><br/>
	         	<label id="ownerphone" for="ans_ownerphone">Owner Phone No</label><br/>
	         	<input type="text" id="ans_ownerphone" name="ownerphone"><br/>
	         	<label id="rcbook" for="ans_rcbook">Registration Certificate pdf</label><br/>
	         	<input type="file" id="ans_rcbook" accept="application/pdf" name="rcbook"><br/>
	         	<label id="insurance" for="ans_insurance">Insurance pdf</label><br/>
	         	<input type="file" id="ans_insurance" accept="application/pdf" name="insurance"><br/>
	         	<label id="PUCCertificate" for="ans_PUCCertificate">PUC Certificate pdf</label><br/>
	         	<input type="file" id="ans_PUCCertificate" accept="application/pdf" name="PUCCertificate"><br/>
	         	<label id="fitness" for="ans_fitness">Fitness pdf</label><br/>
	         	<input type="file" id="ans_fitness" accept="application/pdf" name="fitness"><br/>
	         	<input type="submit" id="submit_id" value="REGISTER">
	         </form>
            </div>
         </div>
       </body>
</html>




