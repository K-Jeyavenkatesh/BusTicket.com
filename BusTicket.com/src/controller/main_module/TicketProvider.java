package controller.main_module;

import java.io.IOException;
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
import service.TravelInformationDao;
import service.TravelInformationDaoImpl;

@WebServlet("/TicketProvider")
public class TicketProvider extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String seats = (String) session.getAttribute("seat");
		String[] seat_no = seats.split(",");
		BusDetails currentBus = (BusDetails)session.getAttribute("currentBus");
		
		ArrayList<TravelInformation> arr = new ArrayList<TravelInformation>();
		for(int i = 0; i < seat_no.length; i++) {
			
			
			TravelInformation travel = new TravelInformation();
			travel.setJourneyID((String)session.getAttribute("journeyID"));
			System.out.println(travel.getJourneyID());
			travel.setPassengerNames(request.getParameter("pass_"+seat_no[i]));
			System.out.println(travel.getPassengerNames());
			travel.setPassengerEmailIds(((Passenger)session.getAttribute("passenger")).getEmail());
			System.out.println(travel.getPassengerEmailIds());
			travel.setPassengerAge(request.getParameter("pass_"+seat_no[i]+"_age"));
			System.out.println(travel.getPassengerAge());
			travel.setPassengerGender(request.getParameter("gender"+seat_no[i]));
			System.out.println(travel.getPassengerGender());
			travel.setPassengerBoardings((String)session.getAttribute("passenger_boarding"));
			System.out.println(travel.getPassengerBoardings());
			travel.setPassengerDroppings((String)session.getAttribute("passenger_dropping"));
			System.out.println(travel.getPassengerDroppings());
			travel.setBusSeatings(seat_no[i]);
			
			arr.add(travel);
		}
		
		session.setAttribute("tripPassenger", arr);
		
		TravelInformationDao travel_obj = new TravelInformationDaoImpl();
		travel_obj.updateTravelsList(arr);
		
		RequestDispatcher rd=request.getRequestDispatcher("paymentmode.jsp");    
		rd.forward(request, response);
	}
}
