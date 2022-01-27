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

import controller.files.TransactionIdCreator;
import model.BusDetails;
import model.Ticket;
import model.TravelInformation;
import service.TicketDaoImpl;

@WebServlet("/OTPVerification")
public class OTPVerification extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String otp_user = request.getParameter("otp");
		String otp_server = session.getAttribute("otp")+"";
		String time = request.getParameter("time");
		
		if(otp_server.equals(otp_user)) {
			Ticket ticket = new Ticket();
			
			ticket.setTransactionID(new TransactionIdCreator().getTransactionId());
			ticket.setBusdetails((BusDetails) session.getAttribute("currentBus"));
			ticket.setTravelnfo((ArrayList<TravelInformation>) session.getAttribute("tripPassenger"));
			ticket.setTransactionMode((String)session.getAttribute("mode"));
			
			long pnr = new TicketDaoImpl().addTicket(ticket);
			session.setAttribute("pnr", pnr);
			RequestDispatcher rd=request.getRequestDispatcher("loadingpage.jsp");    
			rd.forward(request, response);
		} else if(time.equals("0")) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Time Limit Exceeded');");
			out.println("location='PaymentMode';");
			out.println("</script>");
		} else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Invalid OTP');");
			out.println("location='PaymentMode';");
			out.println("</script>");
		}
	}

}
