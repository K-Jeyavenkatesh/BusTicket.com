package controller.files;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BusDriveManagerDaoImpl;
import service.BusDriverDaoImpl;

@WebServlet("/DownloadDriverHealthCertificate")
public class DownloadDriverHealthCertificate extends HttpServlet {
	
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
			try {
				
				String licenceno = request.getParameter("licenceno");
				byte[] bt = new BusDriverDaoImpl().PdfFromDatabase(licenceno);
				String name = "driverhealthcertificate.pdf";
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
			String name = "driverhealthcertificate.pdf";
			String path = getServletContext().getRealPath("/"+"files"+File.separator+name);
			
			//C:\Users\DELL\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\PdfViewer\files\abc.pdf
			response.setContentType("APPLICATION/OCTET-STREAM");
			
			response.setHeader("Content-Disposition", "attachment; filename=\""+name+"\"");
				FileInputStream ins = new FileInputStream(path);
				//DataInputStream iii = new DataInputStream(ins);
				//System.out.println(ins);
				int i ;
				while((i=ins.read()) != -1) {
					
					out.write(i);
				}
				ins.close();
			
				out.close();
	}
}
