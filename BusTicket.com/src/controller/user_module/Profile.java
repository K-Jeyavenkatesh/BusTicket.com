package controller.user_module;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Passenger;
import service.PassengerDaoImpl;

@WebServlet("/Profile")
public class Profile extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		Passenger p = (Passenger)session.getAttribute("passenger");
		Passenger passenger = new Passenger();
		String username = request.getParameter("username");
		String emailid = request.getParameter("email");
		System.out.println(emailid);
		String password = request.getParameter("password");
		String fullname = request.getParameter("fullname");
		String dob = request.getParameter("dob");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		
		passenger.setUsername(username);
		passenger.setFullname(fullname);
		passenger.setDob(dob);
		passenger.setGender(gender);
		passenger.setPhonenumber(phone);
		passenger.setPassword(password);
		passenger.setEmail(p.getEmail());
		
		new PassengerDaoImpl().updatePassenger(passenger);
		session.setAttribute("passenger", passenger);
		RequestDispatcher rd=request.getRequestDispatcher("main.jsp");    
		rd.forward(request, response);
		
	}
}
