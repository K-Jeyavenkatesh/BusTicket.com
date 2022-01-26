package controller.drive_user_module;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.BusDriveAdmin;
import model.Passenger;
import service.BusDriveManagerDaoImpl;
import service.PassengerDaoImpl;

@WebServlet("/DriveRegisterAgency")
@MultipartConfig
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
		
		Pattern p = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?");
		Matcher m = p.matcher(EmailId);
		String tempId = "";
		
		boolean flag = true;
		while(m.find()) {
			tempId += m.group();
		}
		if(!EmailId.equals(tempId)) {
			flag = false;
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Please provide a valid E-Mail ID');");
			out.println("location='signup.html';");
			out.println("</script>");
		}
		
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
			
			//String status = new BusDriveManagerDaoImpl().registerTravelAgency(admin);
			
			String status = "success";
			//System.out.println(status);
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

/*String fName = request.getParameter("travels_licence");
System.out.println(fName);*/

/*Part part = request.getPart("travels_licence");
String fileName = part.getSubmittedFileName();

String path = getServletContext().getRealPath("/"+"files"+File.separator+fileName);
System.out.println(path);

InputStream i = part.getInputStream();
boolean flag = upload(i, path);
if(flag) {
	System.out.println("S");
} else {
	System.out.println("F");
}*/

/*public boolean upload(InputStream i, String path) {

boolean test = false;

try {
	byte[] byt = new byte[i.available()];
	i.read();
	FileOutputStream f = new FileOutputStream(path);
	f.write(byt);
	f.flush();
	f.close();
	
	test = true;
} catch (Exception e) {
	e.printStackTrace();
}
return test;
}*/
