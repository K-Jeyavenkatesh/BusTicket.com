package controller.drive_main_module;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.BusDriveAdmin;
import model.BusDriver;
import service.BusDriveManagerDaoImpl;
import service.BusDriverDaoImpl;
import service.DBConnection;

@WebServlet("/AddBusDriver")
@MultipartConfig(maxFileSize = 16177215)
public class AddBusDriver extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		BusDriveAdmin admin = (BusDriveAdmin)session.getAttribute("busdriveadmin");
		
		String name = request.getParameter("name");
		String licenceno = request.getParameter("licno");
		String emailid = request.getParameter("emailid");
		String phoneno = request.getParameter("number");
		String travelsagency = admin.getTravelsName();;

		Part f_lic_photo = request.getPart("fphoto");
		Part b_lic_photo = request.getPart("bphoto");
		Part healthcert = request.getPart("health");
	
		InputStream photofront = f_lic_photo.getInputStream();  
		InputStream photoback = b_lic_photo.getInputStream();
		InputStream health = healthcert.getInputStream();
		
        byte[] bytesf = new byte[photofront.available()];
        byte[] bytesb = new byte[photoback.available()];
        byte[] byteshealth = new byte[health.available()];
        photofront.read(bytesf); 
        photoback.read(bytesb); 
        health.read(byteshealth); 
        
        BusDriver driver = new BusDriver();
        driver.setName(name);
        driver.setLicenceNo(licenceno);
        driver.setEmailid(emailid);
        driver.setPhoneno(phoneno);
        driver.setTravelsAgency(travelsagency);
        driver.setLicencePhotofront(bytesf);
        driver.setLicencePhotoback(bytesb);
        driver.setHealthCertificate(byteshealth);
        
        boolean status = new BusDriverDaoImpl().addBusDriver(driver);
        if(status) {
        	out.println("<script type=\"text/javascript\">");
			out.println("alert('Successfully Registered !!!');");
			out.println("location='maindrivepage.jsp';");
			out.println("</script>");
        } else {
        	out.println("<script type=\"text/javascript\">");
			out.println("alert('Something Error. Try Again');");
			out.println("location='maindrivepage.jsp';");
			out.println("</script>");
        }
	}
}
