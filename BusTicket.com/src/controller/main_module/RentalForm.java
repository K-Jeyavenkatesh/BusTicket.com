package controller.main_module;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Rental;
import service.RentalDaoImpl;


@WebServlet("/RentalForm")
public class RentalForm extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String expect_place = request.getParameter("expect_place");
		String expect_date = request.getParameter("expect_date");
		String expect_days = request.getParameter("expect_days");
		String expect_details = request.getParameter("expect_details");
		String expect_busdetails = request.getParameter("expect_busdetails");
		String Username = request.getParameter("Username");
		String Useremail = request.getParameter("Useremail"); 
		String Userphone1 = request.getParameter("Userphone1");
		String Userphone2 = request.getParameter("Userphone2");
		
		Rental rental = new Rental();
		rental.setExpect_place(expect_place);
		rental.setExpect_date(expect_date);
		rental.setExpect_days(expect_days);
		rental.setExpect_details(expect_details);
		rental.setExpect_busdetails(expect_busdetails);
		rental.setUsername(Username);
		rental.setUseremail(Useremail);
		rental.setUserphone1(Userphone1);
		rental.setUserphone2(Userphone2);
		
		boolean flag = new RentalDaoImpl().insertRentals(rental);
		
		if(flag) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Your Request Submitted');");
			out.println("location='main.jsp';");
			out.println("</script>");
		} else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Something Wrong, Try Again !!!');");
			out.println("location='main.jsp';");
			out.println("</script>");
		}
		//RequestDispatcher rd=request.getRequestDispatcher("main.jsp");    
		//rd.forward(request, response);
	}
}
