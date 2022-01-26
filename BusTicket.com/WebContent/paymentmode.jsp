<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>BusTicket.com</title>
		<link rel="stylesheet" type="text/css" href="VIEW/CSS/paymentmode.css">
        <link rel="icon" type="image/png" href="VIEW/CSS/IMAGES/favicon.png">
	</head>
	<body>
	
		<script type="text/javascript">
		function show(panel) {
			var coll = document.getElementsByClassName(panel);
			console.log(coll);
			var i;
		
			for (i = 0; i < coll.length; i++) {
			  coll[i].addEventListener("click", function() {
			    this.classList.toggle("active");
			    var content = this.nextElementSibling;
			    if (content.style.display === "block") {
			      content.style.display = "none";
			    } else {
			      content.style.display = "block";
			    }
			  });
			}
		}
		
		function logout() {
			
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
						      <a href="#">PROFILE</a>
						      <a href="index.html" onclick="logout()">SIGN OUT</a>
						    </div>
						  </div>  
                    </ul>
                </div>
            </div>
            <div class=mainpanel>
            	<p id="title">Payment Mode</p>
            	<form action="PaymentMode" method="POST">
            	<input type="hidden" id="mode" name="paymentmode" value="debit">
	            	<div class="panel_debit">
	            		<p id="payment_title">DEBIT CARD</p>
	            		<input type="button" id="clickbox" value="Proceed" onclick="show('panel_debit')">
	            	</div>
	            	<div class="debitExpand">
	            		<label id="cardname" for="ans_cardname">Card Holder Name : </label>
	            		<input type="text" id="ans_cardname" name="debitcardname"><br/>
	            		<label id="cardno" for="ans_cardno">Card Number : </label>
	            		<input type="text" id="ans_cardno" name="debitcardno"><br/>
	            		<label id="cardexpdate" for="ans_cardexpdate">Card Expiry Date : </label>
	            		<input type="text" id="ans_cardexpdate" name="debitcardexpdate"><br/>
	            		<label id="cardcvc" for="ans_cardcvc">CVV/CVC : </label>
	            		<input type="text" id="ans_cardcvc" name="debitcardcvc">
	            		<input type="submit" id="clickboxinside">
	            	</div>
            	</form>
            	<form action="PaymentMode" method="POST">
            	<input type="hidden" id="mode" name="paymentmode" value="credit">
	            	<div class="panel_credit">
	            		<p id="payment_title">CREDIT CARD</p>
	            		<input type="button" id="clickbox" value="Proceed" onclick="show('panel_credit')">
	            	</div>
	            	<div class="creditExpand">
	            		<label id="cardname" for="ans_cardname">Card Holder Name : </label>
	            		<input type="text" id="ans_cardname" name="creditcardname"><br/>
	            		<label id="cardno" for="ans_cardno">Card Number : </label>
	            		<input type="text" id="ans_cardno" name="creditcardno"><br/>
	            		<label id="cardexpdate" for="ans_cardexpdate">Card Expiry Date : </label>
	            		<input type="text" id="ans_cardexpdate" name="creditcardexpdate"><br/>
	            		<label id="cardcvc" for="ans_cardcvc">CVV/CVC : </label>
	            		<input type="text" id="ans_cardcvc" name="creditcardcvc">
	            		<input type="submit" id="clickboxinside">
	            	</div>
            	</form>
            	<form action="PaymentMode" method="POST">
            	<input type="hidden" id="mode" name="paymentmode" value="upi">
	            	<div class="panel_upi">
	            		<p id="payment_title">UPI PAYMENT</p>
	            		<input type="button" id="clickbox" value="Proceed" onclick="show('panel_upi')">
	            	</div>
	            	<div class="upiExpand">
	            		<label id="upiname" for="ans_upiname">UPI User Name : </label>
	            		<input type="text" id="ans_upiname" name="upiusername"><br/>
	            		<label id="upiid" for="ans_upiid">UPI ID : </label>
	            		<input type="text" id="ans_upiid" name="upiid"><br/>
	            		<label id="upipin" for="ans_upipin">UPI PIN : </label>
	            		<input type="password" id="ans_upipin" name="upipin"><br/>
	            		<input type="submit" id="clickboxinside">
	            	</div>
            	</form>
            	<form action="PaymentMode" method="POST">
            	<input type="hidden" id="mode" name="paymentmode" value="netbanking">
	            	<div class="panel_netbank">
	            		<p id="payment_title">NET BANKING</p>
	            		<input type="button" id="clickbox" value="Proceed" onclick="show('panel_netbank')">
	            	</div>
	            	<div class="netbankExpand">
	            		<label id="netbankname" for="ans_netbankname">NetBanking User Name : </label>
	            		<input type="text" id="ans_netbankname" name="netbankusername"><br/>
	            		<label id="netbankid" for="ans_netbankid">NetBanking ID : </label>
	            		<input type="text" id="ans_netbankid" name="netbankid"><br/>
	            		<label id="netbankpin" for="ans_netbankpin">Password : </label>
	            		<input type="password" id="ans_netbankpin" name="netbankpin"><br/>
	            		<input type="submit" id="clickboxinside">
	            	</div>
            	</form>
            </div>
         </div>
	</body>
</html>