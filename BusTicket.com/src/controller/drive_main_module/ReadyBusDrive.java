package controller.drive_main_module;

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
import model.BusDriveAdmin;
import service.BusDriveManagerDaoImpl;
import service.BusJourneyDetailsDaoImpl;


@WebServlet("/ReadyBusDrive")
public class ReadyBusDrive extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		BusDriveAdmin admin = (BusDriveAdmin)session.getAttribute("busdriveadmin");
		
		ArrayList<BusDetails> arr = new BusDriveManagerDaoImpl().getAllBuses(admin.getTravelsName());
		arr = new BusJourneyDetailsDaoImpl().filterByCurrentDate(arr);
		session.setAttribute("buslist", arr);
		
		RequestDispatcher rd=request.getRequestDispatcher("maindrivepage.jsp");    
		rd.forward(request, response);
	}
}
