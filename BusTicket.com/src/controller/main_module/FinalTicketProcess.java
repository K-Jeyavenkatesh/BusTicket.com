package controller.main_module;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BusDetails;
import model.Passenger;
import model.TravelInformation;

@WebServlet("/FinalTicketProcess")
public class FinalTicketProcess extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		Passenger passenger = (Passenger)session.getAttribute("passenger");
		String journeyID = (String) session.getAttribute("journeyID");
		BusDetails busDetails = (BusDetails) session.getAttribute("currentBus");
		String seats = (String) session.getAttribute("seat");
		String[] seat_no = seats.split(",");
		ArrayList<TravelInformation> arr = (ArrayList<TravelInformation>) session.getAttribute("tripPassenger");
		long pnr = (long) session.getAttribute("pnr");
		
		RequestDispatcher rd=request.getRequestDispatcher("final.jsp");    
		rd.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
