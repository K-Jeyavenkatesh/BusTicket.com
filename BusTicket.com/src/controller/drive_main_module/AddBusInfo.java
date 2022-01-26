package controller.drive_main_module;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.BusDriveAdmin;
import model.BusInfo;
import service.BusDriveManagerDaoImpl;

@WebServlet("/AddBusInfo")
@MultipartConfig(maxFileSize = 16177215)
public class AddBusInfo extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		BusDriveAdmin admin = (BusDriveAdmin)session.getAttribute("busdriveadmin");
		
		String busno = request.getParameter("busno");
		String busmodel = request.getParameter("busmodelname");
		String ownername = request.getParameter("ownername");
		String owneremailid = request.getParameter("owneremail");
		String ownerphoneno = request.getParameter("ownerphone");
		String travelsagency = admin.getTravelsName();

		Part rcbook = request.getPart("rcbook");
		Part insurance = request.getPart("insurance");
		Part puccert = request.getPart("PUCCertificate");
		Part fitness = request.getPart("fitness");
	
		InputStream rcbook_stream = rcbook.getInputStream();
		InputStream insurance_stream = insurance.getInputStream();
		InputStream puccert_stream = puccert.getInputStream();
		InputStream fitness_stream = fitness.getInputStream();
		
        byte[] bytesrcbook = new byte[rcbook_stream.available()];
        byte[] bytesinsurance = new byte[insurance_stream.available()];
        byte[] bytespuccert = new byte[puccert_stream.available()];
        byte[] bytesfitness = new byte[fitness_stream.available()];
        
        rcbook_stream.read(bytesrcbook);
        insurance_stream.read(bytesinsurance);
        puccert_stream.read(bytespuccert);
        fitness_stream.read(bytesfitness);
        
        BusInfo businfo = new BusInfo();
        businfo.setBusno(busno);
        businfo.setBusmodel(busmodel);
        businfo.setOwnername(ownername);
        businfo.setOwneremail(owneremailid);
        businfo.setOwnerphone(ownerphoneno);
        businfo.setTravelsagency(travelsagency);
        businfo.setRcbook(bytesrcbook);
        businfo.setInsurance(bytesinsurance);
        businfo.setPuccert(bytespuccert);
        businfo.setFitness(bytesfitness);
        
        boolean status = new BusDriveManagerDaoImpl().addBusInfo(businfo);
        if(status) {
        	out.println("<script type=\"text/javascript\">");
			out.println("alert('Successfully Registered !!!');");
			out.println("location='maindrivepage.jsp';");
			out.println("</script>");
        } else {
        	out.println("<script type=\"text/javascript\">");
			out.println("alert('Something Error. Try Again');");
			out.println("location='addbusinfo.jsp';");
			out.println("</script>");
        }
	}
}
