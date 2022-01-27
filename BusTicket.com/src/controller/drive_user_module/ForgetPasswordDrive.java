package controller.drive_user_module;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.files.Gmail;
import service.BusDriveManagerDaoImpl;
import service.PassengerDaoImpl;

@WebServlet("/ForgetPasswordDrive")
public class ForgetPasswordDrive extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String message = "Your Password is "+new BusDriveManagerDaoImpl().forgetPassword(request.getParameter("passEmail"));
		new Gmail().Gmail("19euit065@skcet.ac.in", request.getParameter("passEmail"), "19euit065skcet@KJV9", "BusTicket.com", message);
		
		RequestDispatcher rd=request.getRequestDispatcher("drivelogin.html");    
		rd.forward(request, response);
	}

}
