package controller.drive_user_module;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BusDriveAdmin;
import model.Passenger;
import service.BusDriveManagerDao;
import service.BusDriveManagerDaoImpl;
import service.PassengerDaoImpl;

@WebServlet("/DriveAgencyLogin")
public class DriveAgencyLogin extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String emailid = request.getParameter("emailid");
		String password = request.getParameter("password");
		
		Pattern p = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?");
		Matcher m = p.matcher(emailid);
		String tempId = "";
		
		boolean flag = true;
		while(m.find()) {
			tempId += m.group();
		}
		if(!emailid.equals(tempId)) {
			flag = false;
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Please provide a valid E-Mail ID');");
			out.println("location='drivelogin.html';");
			out.println("</script>");
		}
		
		BusDriveAdmin admin = new BusDriveManagerDaoImpl().getTravelsAdminDetails(emailid, password);
		
		if(admin == null) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Please provide a registered E-Mail ID');");
			out.println("location='drivelogin.html';");
			out.println("</script>");
		}
		if(!admin.getPassword().equals(password)) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Invalid Password');");
			out.println("location='drivelogin.html';");
			out.println("</script>");
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("busdriveadmin", admin);
			RequestDispatcher rd=request.getRequestDispatcher("ReadyBusDrive");    
			rd.forward(request, response);
		}
	}
}
