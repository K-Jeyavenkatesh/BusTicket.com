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
import model.TravelInformation;
import service.BusDriveManagerDaoImpl;


@WebServlet("/DriveHistory")
public class DriveHistory extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		BusDriveAdmin admin = (BusDriveAdmin)session.getAttribute("busdriveadmin");
		String travels = admin.getTravelsName();
		Object[] obj = new BusDriveManagerDaoImpl().getAllHistory();
		ArrayList<BusDetails> bustravelinfo = (ArrayList<BusDetails>) obj[1];
		ArrayList<TravelInformation> travelinfo = (ArrayList<TravelInformation>) obj[0];
		for(int i = 0; i < bustravelinfo.size(); i++) {
			if(!(bustravelinfo.get(i).getBusTravelsName().equals(travels))) {
				bustravelinfo.remove(i);
				travelinfo.remove(i);
			}
		}
		session.setAttribute("travelinfo", travelinfo);
		session.setAttribute("bustravelinfo", bustravelinfo);
		
		RequestDispatcher rd=request.getRequestDispatcher("drivehistory.jsp");    
		rd.forward(request, response);
	}
}
