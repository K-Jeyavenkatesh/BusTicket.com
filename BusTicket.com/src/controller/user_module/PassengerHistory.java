package controller.user_module;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Passenger;
import model.PassengerBookingHistory;
import service.PassengerBookingHistoryDaoImpl;


@WebServlet("/PassengerHistory")
public class PassengerHistory extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session =  request.getSession();
		Passenger passenger = (Passenger)session.getAttribute("passenger");
		ArrayList<PassengerBookingHistory> passHistory = new PassengerBookingHistoryDaoImpl().getAllHistory(passenger.getEmail());
		session.setAttribute("passHistory", passHistory);
		RequestDispatcher rd=request.getRequestDispatcher("passengerhistory.jsp");    
		rd.forward(request, response);
	}
}
