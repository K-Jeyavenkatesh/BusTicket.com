package controller.drive_main_module;

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
import model.BusDriveAdmin;
import service.BusDriveManagerDaoImpl;

@WebServlet("/AddBusTrip")
public class AddBusTrip extends HttpServlet {
	
	public String convertTime(String str)
	{
		String result = "";
	    int h1 = (int)str.charAt(0) - '0';
	    int h2 = (int)str.charAt(1)- '0';
	    int hh = h1 * 10 + h2;
	    String Meridien;
	    if (hh < 12) {
	        Meridien = "am";
	    }
	    else {
	        Meridien = "pm";
	    }
	    hh %= 12;
	    if (hh == 0) {
	    	result += "12";
	        System.out.print("12");
	        for (int i = 2; i < 5; ++i) {
	        	result += str.charAt(i);
	        }
	    }
	    else {
	    	result += hh;
	        for (int i = 2; i < 5; ++i) {
	        	result += str.charAt(i);
	        }
	    }
	    result += Meridien;
	    return result;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		BusDetails busdetails = new BusDetails();
		BusDriveAdmin admin = (BusDriveAdmin)session.getAttribute("busdriveadmin");
		
		busdetails.setBusTravelsName(admin.getTravelsName());
		busdetails.setBusNumber(request.getParameter("busno"));
		
		StringBuilder sb = new StringBuilder();
		String a = request.getParameter("boarding_name[0]");
		int i = 0;
		sb.append("'[");
		while(a != null) {
			sb.append("\""+a+"\",");
			i++;
			a = request.getParameter("boarding_name["+i+"]");
		}
		
		sb.delete(sb.length()-1, sb.length());
		sb.append("]'");
		busdetails.setBoardingPoints(sb.toString());
		
		sb.setLength(0);
		a = request.getParameter("time_name[0]");
		i = 0;
		sb.append("'[");
		while(a != null) {
			a = this.convertTime(a);
			sb.append("\""+a+"\",");
			i++;
			a = request.getParameter("time_name["+i+"]");
		}
		
		sb.deleteCharAt(sb.length()-1);
		sb.append("]'");
		busdetails.setBoardingTime(sb.toString());
		
		sb.setLength(0);
		a = request.getParameter("price_name[0]");
		i = 0;
		sb.append("'[");
		while(a != null) {
			sb.append("\""+a+"\",");
			i++;
			a = request.getParameter("price_name["+i+"]");
		}
		
		sb.deleteCharAt(sb.length()-1);
		sb.append("]'");
		busdetails.setPrice(sb.toString());
		
		sb.setLength(0);
		a = request.getParameter("dropping_name[0]");
		i = 0;
		sb.append("'[");
		while(a != null) {
			sb.append("\""+a+"\",");
			i++;
			a = request.getParameter("dropping_name["+i+"]");
		}
		
		sb.deleteCharAt(sb.length()-1);
		sb.append("]'");
		busdetails.setDroppingPoints(sb.toString());
		
		sb.setLength(0);
		a = request.getParameter("dtime_name[0]");
		i = 0;
		sb.append("'[");
		while(a != null) {
			a = this.convertTime(a);
			sb.append("\""+a+"\",");
			i++;
			a = request.getParameter("dtime_name["+i+"]");
		}
		
		sb.deleteCharAt(sb.length()-1);
		sb.append("]'");
		busdetails.setDroppingTime(sb.toString());
		String date = request.getParameter("date");
		String modifiedDate = date.substring(8,10)+"."+date.substring(5,7)+"."+date.substring(0,4);
		System.out.println(modifiedDate);
		busdetails.setDate(modifiedDate); 
		busdetails.setBusAirCondition(request.getParameter("air"));
		busdetails.setBusType(request.getParameter("seattype"));
		
		if(request.getParameter("seattype").equals("Sleeper")) {
			busdetails.setSeatAvaliable("32");
			busdetails.setTotalSeats("32");
		} else {
			busdetails.setSeatAvaliable("34");
			busdetails.setTotalSeats("34");
		}
		busdetails.setWifi(request.getParameter("wifi"));
		busdetails.setCharging(request.getParameter("charging"));
		busdetails.setFoodOrSnacks(request.getParameter("food"));
		busdetails.setMovie(request.getParameter("movie"));
		busdetails.setDriverPhone(request.getParameter("driverno"));
		busdetails.setAdditionalDriverPhone(request.getParameter("adriverno"));
		busdetails.setBookedSeats("\'[]\'");
		
		if(new BusDriveManagerDaoImpl().addBusTravel(busdetails)) {
			RequestDispatcher rd=request.getRequestDispatcher("maindrivepage.jsp");    
			rd.forward(request, response);
		} else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Problem in Add a Trip - Try Again');");
			out.println("location='maindrivepage.jsp';");
			out.println("</script>");
		}
	}
}
