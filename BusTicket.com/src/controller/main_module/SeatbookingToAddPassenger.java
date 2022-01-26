package controller.main_module;

import java.io.IOException;
import java.io.PrintWriter;

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
import service.BusJourneyDetailsDao;
import service.BusJourneyDetailsDaoImpl;
import service.PassengerBookingHistoryDao;
import service.PassengerBookingHistoryDaoImpl;

@WebServlet("/SeatbookingToAddPassenger")
public class SeatbookingToAddPassenger extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		
		HttpSession session  = request.getSession();
		Passenger passenger = (Passenger)session.getAttribute("passenger");
		BusDetails currentBus = (BusDetails)session.getAttribute("currentBus");
		String passenger_boarding = (String)request.getParameter("bp");
		String passenger_dropping = (String)request.getParameter("dp");
		String seat = (String)request.getParameter("i_seat_booked");
		String time1 = (String)request.getParameter("time_booked");
		String journeyID = (String)session.getAttribute("journeyID");
		
		if(seat.equals("")) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Please select atleast one seat');");
			out.println("location='seatbook.jsp';");
			out.println("</script>");
		} else {
			session.setAttribute("passenger_boarding", passenger_boarding);
			session.setAttribute("passenger_dropping", passenger_dropping);
			session.setAttribute("seat", seat);
			
			BusJourneyDetailsDao obj = new BusJourneyDetailsDaoImpl();
			obj.updateBookingSeats(currentBus.getBusID(), seat.split(","));
			
			PassengerBookingHistory history = new PassengerBookingHistory();
			history.setEmail(passenger.getEmail());
			history.setBoardingPoint(passenger_boarding);
			history.setDroppingPoint(passenger_dropping);
			history.setBoardingTime(time1.substring(0,7));
			history.setDroppingTime(time1.substring(12));
			history.setDate(currentBus.getDate());
			System.out.println("p"+(String)request.getParameter("price_booked"));
			history.setPrice((String)request.getParameter("price_booked"));
			history.setJourneyID(journeyID);
			
			System.out.println(journeyID);
			PassengerBookingHistoryDao history_obj = new PassengerBookingHistoryDaoImpl();
			history_obj.insertPassengerToHistory(history);
				
			RequestDispatcher rd=request.getRequestDispatcher("addpassengerlist.jsp");    
			rd.forward(request, response);
		}
	}
}
