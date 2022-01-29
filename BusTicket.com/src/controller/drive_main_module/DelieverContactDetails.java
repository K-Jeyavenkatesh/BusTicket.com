package controller.drive_main_module;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.files.Gmail;
import model.BusDriveAdmin;
import service.RentalDaoImpl;


@WebServlet("/DelieverContactDetails")
public class DelieverContactDetails extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		
		BusDriveAdmin admin = (BusDriveAdmin)session.getAttribute("busdriveadmin");
		String requested_emailid = request.getParameter("requested_emailid");
		String requested_id = request.getParameter("requested_id");
		String state1 = admin.getTravelsName();
		String state2 = admin.getAgencyAddress();
		String state3 = admin.getEmailId();
		String state4 = admin.getAgencyPhoneNo();
		
		String message = "Your Request has accepted by "+state1+". Here, Travels agency Address : "+state2+
				". TRAVEL AGENCY EMAIL ID :"+state3+" and TRAVEL AGENCY PHONE NUMBER :"+state4+". You can contact and they can also contact you as soon as possible";

		new Gmail().Gmail("19euit065@skcet.ac.in", requested_emailid, "19euit065skcet@KJV9", "BusTicket.com", message);
		new RentalDaoImpl().removeSelectedRequest(requested_id);
		
		out.println("<script type=\"text/javascript\">");
		out.println("alert('Your Contacts Details Sent to Requested Person');");
		out.println("alert('You can also contact the Requested Person');");
		out.println("location='login.html';");
		out.println("</script>");
	}

}
