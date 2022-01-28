package controller.drive_main_module;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/DelieverContactDetails")
public class DelieverContactDetails extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		session.getAttribute("busdriveadmin");
		
		
		String message;
		
		out.println("<script type=\"text/javascript\">");
		out.println("alert('Your Contacts Details Sent to Requested Person');");
		out.println("alert('You can also contact the Requested Person');");
		out.println("location='login.html';");
		out.println("</script>");
	}

}
