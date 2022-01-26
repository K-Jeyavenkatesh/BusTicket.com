package controller.main_module;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.files.OTPGenerator;
import model.Passenger;

@WebServlet("/PaymentMode")
public class PaymentMode extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		try{ 
			String mode = request.getParameter("paymentmode");
			if(mode == null) {
				mode = (String)session.getAttribute("mode");
			}
			if(mode.equals("debit")) {
				String cardHolderName = request.getParameter("debitcardname");
				String cardNumber = request.getParameter("debitcardno");
				String cardExpiryDate = request.getParameter("debitcardexpdate");
				String cardCvc = request.getParameter("debitcardcvc");
				
				session.setAttribute("mode","debit");
				Cookie ck=new Cookie("mode_details",cardHolderName+" "+cardNumber+" "+cardExpiryDate+" "+cardCvc);
				response.addCookie(ck);
				System.out.println(cardHolderName+" "+cardNumber+" "+cardExpiryDate+" "+cardCvc);
				
			} else if(mode.equals("credit")) {
				String cardHolderName = request.getParameter("creditcardname");
				String cardNumber = request.getParameter("creditcardno");
				String cardExpiryDate = request.getParameter("creditcardexpdate");
				String cardCvc = request.getParameter("creditcardcvc");
				
				session.setAttribute("mode","credit");
				Cookie ck=new Cookie("mode_details",cardHolderName+" "+cardNumber+" "+cardExpiryDate+" "+cardCvc);
				response.addCookie(ck);
				System.out.println(cardHolderName+" "+cardNumber+" "+cardExpiryDate+" "+cardCvc);
			} else if(mode.equals("upi")) {
				String UpiUserName = request.getParameter("upiusername");
				String UpiID = request.getParameter("upiid");
				String UpiPin = request.getParameter("upipin");
				
				session.setAttribute("mode","upi");
				Cookie ck=new Cookie("mode_details",UpiUserName+" "+UpiID+" "+UpiPin);
				response.addCookie(ck);
				System.out.println(UpiUserName+" "+UpiID+" "+UpiPin);
			} else {
				String NetUserName = request.getParameter("netbankusername");
				String NetBankID = request.getParameter("netbankid");
				String NetBankPassword = request.getParameter("netbankpin");
				
				session.setAttribute("mode","netbank");
				Cookie ck=new Cookie("mode_details",NetUserName+" "+NetBankPassword+" "+NetBankID);
				response.addCookie(ck);
				System.out.println(NetUserName+" "+NetBankPassword+" "+NetBankID);
			}
		} catch (Exception e) {
			
		} finally {
			//Passenger passenger = (Passenger) session.getAttribute("passenger");
			//int otp = new OTPGenerator().OTPGenerator(passenger.getEmail());
			int otp = new OTPGenerator().OTPGenerator("jeyavenkatesh9@gmail.com");
			session.setAttribute("otp", otp);
			RequestDispatcher rd=request.getRequestDispatcher("otpverification.jsp");    
			rd.forward(request, response);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}
}
