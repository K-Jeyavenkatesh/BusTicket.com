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
import model.PassengerBookingHistory;
import service.TravelInformationDaoImpl;

@WebServlet("/MainToSeatbooking")
public class MainToSeatbooking extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		
		HttpSession session  = request.getSession();
		ArrayList<BusDetails> arr = (ArrayList<BusDetails>)session.getAttribute("buses");
		Passenger passenger = (Passenger) session.getAttribute("passenger");
		BusDetails currentBus = null;
		String busID_page = request.getParameter("busid");
		for(int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i).getBusID() +" "+ busID_page);
			if(arr.get(i).getBusID().equals(busID_page)) {
				currentBus = arr.get(i);
			}
		}
		String journeyID = new TravelInformationDaoImpl().getJourneyID(busID_page);
		session.setAttribute("journeyID", journeyID);
		session.setAttribute("currentBus", currentBus);
		
		RequestDispatcher rd=request.getRequestDispatcher("seatbook.jsp");    
		rd.forward(request, response);
	}

}
