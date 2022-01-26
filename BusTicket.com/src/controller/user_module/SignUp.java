package controller.user_module;

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
import javax.swing.JOptionPane;

import model.Passenger;
import service.PassengerDaoImpl;

//@WebServlet("/SignUp")
public class SignUp extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
		String emailid = request.getParameter("emailid");
		String password = request.getParameter("password");
		String conform_passowrd = request.getParameter("conform_password");
		
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
			out.println("location='signup.html';");
			out.println("</script>");
		}
		
		if(!password.equals(conform_passowrd)) {
			flag = false;
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Password and Conform Password is not matched');");
			out.println("location='signup.html';");
			out.println("</script>");
		}
		
		if(flag) {
			Passenger passenger = new Passenger();
			passenger.setUsername(username);
			passenger.setEmail(emailid);
			passenger.setPassword(password);
			String status = new PassengerDaoImpl().registerPassenger(passenger);
			//System.out.println(status);
			if(status.equals("success")) {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Registered Successfully !!');");
				out.println("</script>");
				RequestDispatcher rd=request.getRequestDispatcher("login.html");    
				rd.forward(request, response);
			} 
			if(status.equals("duplicate")) {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('User email ID is already registered');");
				out.println("location='signup.html';");
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
