package controller.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import model.BusDetails;
import model.Passenger;
import model.Ticket;
import model.TravelInformation;
import service.TicketDaoImpl;


@WebServlet("/ETicket")
public class ETicket extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();

		Passenger passenger = (Passenger)session.getAttribute("passenger");
		String journeyID = (String) session.getAttribute("journeyID");
		BusDetails bus_details = (BusDetails) session.getAttribute("currentBus");
		String seats = (String) session.getAttribute("seat");
		String[] seat_no = seats.split(",");
		ArrayList<TravelInformation> arr = (ArrayList<TravelInformation>) session.getAttribute("tripPassenger");
		TravelInformation travel_info = arr.get(0);
		long pnr = (long) session.getAttribute("pnr");
		
		Ticket tickets = new TicketDaoImpl().getTicket(pnr+"");
		
		
		///////////////
		Document doc = new Document(); 
		String path = "";
		try {  
			String name = "e-ticket.pdf";
			path = getServletContext().getRealPath("/"+"files"+File.separator+name);
			System.out.println(path);
			PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(path));  
			System.out.println("PDF created.");  
			
			doc.open();
			doc.add(new Paragraph("------------------")); 
			doc.add(new Paragraph("BUSTICKET.COM")); 
			doc.add(new Paragraph("------------------")); 
			doc.add(new Paragraph("       ")); 
			doc.add(new Paragraph("PNR : "+pnr)); 
			doc.add(new Paragraph("Date: "+bus_details.getDate())); 
			String bp[] = bus_details.getBoardingPoints().split(" "); 
			String dp[] = bus_details.getDroppingPoints().split(" ");
			String bt[] = bus_details.getBoardingTime().split(" "); 
			String dt[] = bus_details.getDroppingTime().split(" ");
			doc.add(new Paragraph("Start of Journey : "+travel_info.getPassengerBoardings()+" to End of Journey : "+travel_info.getPassengerDroppings())); 
			doc.add(new Paragraph("Bus ID: "+bus_details.getBusID())); 
			doc.add(new Paragraph("Journey ID: "+bus_details.getJourneyID())); 
			doc.add(new Paragraph("Travels Name : "+bus_details.getBusTravelsName())); 
			doc.add(new Paragraph("Bus Number : "+bus_details.getBusNumber())); 
			doc.add(new Paragraph("Seating Type : "+bus_details.getBusType()+"    BusAirCondition : "+bus_details.getBusAirCondition()));
			doc.add(new Paragraph("Driver Phone : "+bus_details.getDriverPhone())); 
			doc.add(new Paragraph("Additional Driver Phone : "+bus_details.getAdditionalDriverPhone())); 
			doc.add(new Paragraph("       ")); 
			
			/*String[] emailids = stringTo(travel_info.getPassengerEmailIds()).split(" ");
			String[] names = stringTo(travel_info.getPassengerNames()).split(" ");
			String[] seats = stringTo(travel_info.getBusSeatings()).split(" ");
			String[] boards = stringTo(travel_info.getPassengerBoardings()).split(" ");
			String[] drops = stringTo(travel_info.getPassengerDroppings()).split(" ");*/
			int limit = arr.size();
			PdfPTable table = new PdfPTable(6);
            table.addCell("NAME");
            table.addCell("AGE");
            table.addCell("GENDER");
            table.addCell("SEATNO");
            table.addCell("BOARDING");
            table.addCell("DROPPING");
	        for(int i = 0; i < limit; i++){
	        	travel_info = arr.get(i);
	        	table.addCell(travel_info.getPassengerNames());
	            table.addCell(travel_info.getPassengerAge());
	            table.addCell(travel_info.getPassengerGender());
	            table.addCell(seat_no[i]);
	            table.addCell(travel_info.getPassengerBoardings());
	            table.addCell(travel_info.getPassengerDroppings());
	        }
	        doc.add(table);
	        
	        doc.add(new Paragraph("Trasaction ID :"+tickets.getTransactionID()));
	        doc.add(new Paragraph("Trasaction Mode :"+tickets.getTransactionMode()));
	        doc.add(new Paragraph("------------------")); 
			doc.add(new Paragraph("!!! HAPPY JOURNEY !!!")); 
			doc.add(new Paragraph("------------------"));
			doc.close();  
			writer.close();  
		} catch (DocumentException e) {  
			e.printStackTrace();  
		} catch (FileNotFoundException e)  {  
			e.printStackTrace();  
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = "e-ticket.pdf";
		String paths = getServletContext().getRealPath("/"+"files"+File.separator+name);
		
		//C:\Users\DELL\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\PdfViewer\files\abc.pdf
		response.setContentType("APPLICATION/OCTET-STREAM");
		
		response.setHeader("Content-Disposition", "attachment; filename=\""+name+"\"");
			FileInputStream ins = new FileInputStream(paths);
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
