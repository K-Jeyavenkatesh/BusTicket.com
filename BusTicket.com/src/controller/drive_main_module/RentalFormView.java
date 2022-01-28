package controller.drive_main_module;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Rental;
import service.RentalDaoImpl;

@WebServlet("/RentalFormView")
public class RentalFormView extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		ArrayList<Rental> rentalList = new RentalDaoImpl().getAllRentals();
		
		session.setAttribute("rentalList", rentalList);
		
		RequestDispatcher rd=request.getRequestDispatcher("rentalformview.jsp");    
		rd.forward(request, response);
	}
}
