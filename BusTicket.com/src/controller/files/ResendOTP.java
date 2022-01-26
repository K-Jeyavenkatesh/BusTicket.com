package controller.files;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Passenger;

@WebServlet("/ResendOTP")
public class ResendOTP extends HttpServlet {

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Passenger passenger = (Passenger) session.getAttribute("passenger");
		int otp = new OTPGenerator().OTPGenerator(passenger.getEmail());
		session.setAttribute("otp", otp);
		System.out.println("Called");
	}

}
