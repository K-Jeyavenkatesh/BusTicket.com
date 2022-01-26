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

import model.BusDriver;
import service.BusDriverDaoImpl;

@WebServlet("/ViewBusDriver")
public class ViewBusDriver extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String phoneno = request.getParameter("phone_no");
		String licenceno = request.getParameter("licence_no");
		
		BusDriver driver = null;
		if(licenceno != null && !licenceno.equals("")) {
			driver = new BusDriverDaoImpl().getBusDriver("licenceno", licenceno);
			
		} else {
			driver = new BusDriverDaoImpl().getBusDriver("phoneno", phoneno);
		}
		session.setAttribute("driver", driver);
		
		RequestDispatcher rd=request.getRequestDispatcher("viewbusdriver.jsp");    
		rd.forward(request, response);
	}
}
