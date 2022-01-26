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

@WebServlet("/FilterBus")
public class FilterBus extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String date = request.getParameter("journey_date");
		String from = request.getParameter("journey_from");
		String to = request.getParameter("journey_to");
		String[] filter_objects = new String[6];
		String ac = (String)request.getParameter("Ac");
		String nonac = (String)request.getParameter("NonAc");
		if(ac!=null && nonac!=null && (ac).equals("Ac") && (nonac).equals("NonAc")) {
			filter_objects[0] = null;
		} else if(ac!=null && (ac).equals("Ac")) {
			filter_objects[0] = ((String)request.getParameter("Ac"));
		} else if(nonac!= null && (nonac).equals("NonAc")) {
			filter_objects[0] = ((String)request.getParameter("NonAc"));
		} 
		String st = (String)request.getParameter("Seater");
		String sp = (String)request.getParameter("Sleeper");
		if(st!=null && sp!=null && (st).equals("Seater") && (sp).equals("Sleeper")) {
			filter_objects[1] = null;
		} else if(st!=null && (st).equals("Seater")) {
			filter_objects[1] = ((String)request.getParameter("Seater"));
		} else if(sp!=null && (sp).equals("Sleeper")) {
			filter_objects[1] = ((String)request.getParameter("Sleeper"));
		} 
		filter_objects[2] = request.getParameter("wifi");
		if(filter_objects[2] != null && filter_objects[2].equals("wifi")) {
			filter_objects[2] = "yes";
		} else {
			filter_objects[2] = "no";
		}
		filter_objects[3] = request.getParameter("charging");
		if(filter_objects[3] != null && filter_objects[3].equals("charging")) {
			filter_objects[3] = "yes";
		} else {
			filter_objects[3] = "no";
		}
		filter_objects[4] = request.getParameter("foodorsnacks");
		if(filter_objects[4] != null && filter_objects[4].equals("foodorsnacks")) {
			filter_objects[4] = "yes";
		} else {
			filter_objects[4] = "no";
		}
		filter_objects[5] = request.getParameter("movie");
		if(filter_objects[5] != null && filter_objects[5].equals("movie")) {
			filter_objects[5] = "yes";
		} else {
			filter_objects[5] = "no";
		}
		
		System.out.println("date-"+date+"-"+from+"-"+to);
		HttpSession session = request.getSession();
		ArrayList<BusDetails> buses = null;
		if(date != null && from != null && to != null && !date.equals("") && !from.equals("") && !to.equals("")) {
			date = date.substring(8)+"."+date.substring(5,7)+"."+date.substring(0,4);
			buses = new BusJourneyDetailsDaoImpl().getFilteredJourneyDetails(date, from, to, filter_objects);
		}
		else {
			buses = new BusJourneyDetailsDaoImpl().getFilteredJourneyDetails(filter_objects);
		}
		session.setAttribute("buses", buses);
		RequestDispatcher rd=request.getRequestDispatcher("main.jsp");    
		rd.forward(request, response);
	}
}
