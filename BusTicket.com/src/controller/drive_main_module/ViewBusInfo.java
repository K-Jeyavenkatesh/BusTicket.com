package controller.drive_main_module;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BusInfo;
import service.BusDriveManagerDaoImpl;


@WebServlet("/ViewBusInfo")
public class ViewBusInfo extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String busno = request.getParameter("businfo");
		
		BusInfo businfo = null;
		if(busno != null && !busno.equals("")) {
			businfo = new BusDriveManagerDaoImpl().getBusInfo(busno);
			
		} 
		session.setAttribute("businfo", businfo);
		
		RequestDispatcher rd=request.getRequestDispatcher("viewbusinfo.jsp");    
		rd.forward(request, response);
	}
}
