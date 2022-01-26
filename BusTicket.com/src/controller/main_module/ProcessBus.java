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
import service.BusJourneyDetailsDaoImpl;

@WebServlet("/ProcessBus")
public class ProcessBus extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String date = request.getParameter("journey_date");
		String from = request.getParameter("journey_from");
		String to = request.getParameter("journey_to");
		
		System.out.println("date-"+date+"-"+from+"-"+to);
		HttpSession session = request.getSession();
		ArrayList<BusDetails> buses = null;
		
		BusJourneyDetailsDaoImpl obj = new BusJourneyDetailsDaoImpl();
		if(date != null && from != null && to != null && !date.equals("") && !from.equals("") && !to.equals("")) {
			date = date.substring(8)+"."+date.substring(5,7)+"."+date.substring(0,4);
			buses = obj.getJourneyDetails(date, from, to);
		}
		else {
			buses = obj.getJourneyDetails();
		}
		buses = obj.filterByCurrentDate(buses);
		session.setAttribute("buses", buses);
		System.out.println(buses);
		RequestDispatcher rd=request.getRequestDispatcher("main.jsp");    
		rd.forward(request, response);
	}
}
