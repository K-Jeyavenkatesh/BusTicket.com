package controller.drive_user_module;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.BusDriveAdmin;
import service.BusDriveManagerDaoImpl;

@WebServlet("/DriveRegisterAgency")
public class DriveRegisterAgency extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String TravelsName = request.getParameter("travels_name");
		String TravelsOwnerName = request.getParameter("travels_owner_name");
		String OwnerEmailid = request.getParameter("travels_owner_name_emailid");
		String OwnerPhoneNo = request.getParameter("travels_owner_name_phone");
		String AgencyAddress = request.getParameter("travels_address");
		String AgencyPhoneNo = request.getParameter("travels_agency_phone");
		String EmailId = request.getParameter("emailid");
		String Password = request.getParameter("password");
		String conform_Password = request.getParameter("conform_password");
		
		boolean flag = true;
		
		if(!Password.equals(conform_Password)) {
			flag = false;
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Password and Conform Password is not matched');");
			out.println("location='signup.html';");
			out.println("</script>");
		}
		
		if(flag) {
			
			BusDriveAdmin admin = new BusDriveAdmin();
			admin.setTravelsName(TravelsName);
			admin.setTravelsOwnerName(TravelsOwnerName);
			admin.setOwnerEmailid(OwnerEmailid);
			admin.setOwnerPhoneNo(OwnerPhoneNo);
			admin.setAgencyAddress(AgencyAddress);
			admin.setAgencyPhoneNo(AgencyPhoneNo);
			admin.setEmailId(EmailId);
			admin.setPassword(Password);
			
			
			String status = new BusDriveManagerDaoImpl().registerTravelAgency(admin);
			
			if(status.equals("success")) {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Registered Successfully !!');");
				out.println("</script>");
				RequestDispatcher rd=request.getRequestDispatcher("drivelogin.html");    
				rd.forward(request, response);
			} 
			if(status.equals("duplicate")) {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('User email ID is already registered');");
				out.println("location='driveregister.html';");
				out.println("</script>");
			} 
			if(status.equals("failed")) {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Sorry!, Unfortunately registeration failed');");
				out.println("location='index.html';");
				out.println("</script>");
			}
		}
	}
}
