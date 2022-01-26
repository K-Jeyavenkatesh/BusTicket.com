package controller.files;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BusDriveManagerDaoImpl;

@WebServlet("/DownloadBusInfo")
public class DownloadBusInfo extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String rcbook = request.getParameter("rcbook");
		String insurance = request.getParameter("insurance");
		String puccert = request.getParameter("puccert");
		String fitness = request.getParameter("fitness");
		
		String busno = null;
		String name = null;
		if(rcbook != null && !rcbook.equals("")) {
			busno = request.getParameter("rcbook");
			name = "rcbook";
		} else if(insurance != null && !insurance.equals("")) {
			busno = request.getParameter("insurance");
			name = "insurance";
		} else if(puccert != null && !puccert.equals("")) {
			busno = request.getParameter("puccert");
			name = "puccert";
		} else if(fitness != null && !fitness.equals("")) {
			busno = request.getParameter("fitness");
			name = "fitness";
		} else {
			busno = request.getParameter("rcbook");
			name = "rcbook";
		}
		
		try {
			
			byte[] bt = new BusDriveManagerDaoImpl().getBusInfo(name, busno);
			name += ".pdf";
			String path = getServletContext().getRealPath("/"+"files"+File.separator+name);
			FileOutputStream fout = new FileOutputStream(path);
			DataOutputStream dout = new DataOutputStream(fout);

			for (byte b: bt) {
			    dout.write(b);  
			} 

			dout.flush();
			fout.close();
		}
		catch(Exception e) {
			System.out.println(e);
		} 
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String path = getServletContext().getRealPath("/"+"files"+File.separator+name);
		
		response.setContentType("APPLICATION/OCTET-STREAM");
		response.setHeader("Content-Disposition", "attachment; filename=\""+name+"\"");
			FileInputStream ins = new FileInputStream(path);
			int i;
			while((i=ins.read()) != -1) {
				out.write(i);
			}
			ins.close();
			out.close();
	}
}
