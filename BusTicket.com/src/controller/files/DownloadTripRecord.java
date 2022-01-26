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
import model.TravelInformation;
import service.BusDriveManagerDaoImpl;

@WebServlet("/DownloadTripRecord")
public class DownloadTripRecord extends HttpServlet {
	
	public String stringTo(String str) {
		str = str.replace("[","");
		str = str.replace("]","");
		str = str.replace("\"","");
		str = str.replace(",","");
		return str;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		ArrayList<BusDetails> bustravelinfo = (ArrayList<BusDetails>) session.getAttribute("bustravelinfo");
		ArrayList<TravelInformation> travelinfo = (ArrayList<TravelInformation>) session.getAttribute("travelinfo");
		
		if(bustravelinfo == null || travelinfo == null) {
			Object[] obj = new BusDriveManagerDaoImpl().getAllHistory();
			bustravelinfo = (ArrayList<BusDetails>) obj[1];
			travelinfo = (ArrayList<TravelInformation>) obj[0];
			session.setAttribute("travelinfo", travelinfo);
			session.setAttribute("bustravelinfo", bustravelinfo);
		}
		BusDetails bus_details = null;
		TravelInformation travel_info = null;
		
		String journeyid = request.getParameter("journeyid");
		for(int i = 0; i < travelinfo.size(); i++) {
			TravelInformation temp = travelinfo.get(i);
			if(temp.getJourneyID().equals(journeyid)) {
				bus_details = bustravelinfo.get(i);
				travel_info = travelinfo.get(i);
				break;
			}
		}
		Document doc = new Document(); 
		String path = "";
		try {  
			String name = "triprecord.pdf";
			path = getServletContext().getRealPath("/"+"files"+File.separator+name);
			System.out.println(path);
			PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(path));  
			System.out.println("PDF created.");  
			
			doc.open();
			doc.add(new Paragraph("--------------")); 
			doc.add(new Paragraph("BUSTICKET.COM")); 
			doc.add(new Paragraph("--------------")); 
			doc.add(new Paragraph("       ")); 
			doc.add(new Paragraph("Date: "+bus_details.getDate())); 
			String bp[] = bus_details.getBoardingPoints().split(" "); 
			String dp[] = bus_details.getDroppingPoints().split(" ");
			String bt[] = bus_details.getBoardingTime().split(" "); 
			String dt[] = bus_details.getDroppingTime().split(" ");
			doc.add(new Paragraph("Start of Journey : "+bp[0]+" to End of Journey : "+dp[dp.length-1])); 
			doc.add(new Paragraph("Start time of Journey : "+bt[0]+" to End of Journey Time : "+dt[dt.length-1])); 
			doc.add(new Paragraph("Bus ID: "+bus_details.getBusID())); 
			doc.add(new Paragraph("Journey ID: "+bus_details.getJourneyID())); 
			doc.add(new Paragraph("Travels Name : "+bus_details.getBusTravelsName())); 
			doc.add(new Paragraph("Bus Number : "+bus_details.getBusNumber())); 
			doc.add(new Paragraph("Boarding Points : "+bus_details.getBoardingPoints())); 
			doc.add(new Paragraph("Boarding Timings : "+bus_details.getBoardingTime())); 
			doc.add(new Paragraph("Dropping Points : "+bus_details.getDroppingPoints()));
			doc.add(new Paragraph("Dropping Timings : "+bus_details.getDroppingTime())); 
			doc.add(new Paragraph("Prices : "+bus_details.getPrice())); 
			doc.add(new Paragraph("Seating Type : "+bus_details.getBusType()+"    BusAirCondition : "+bus_details.getBusAirCondition()));
			doc.add(new Paragraph("Driver Phone : "+bus_details.getDriverPhone())); 
			doc.add(new Paragraph("Additional Driver Phone : "+bus_details.getAdditionalDriverPhone())); 
			doc.add(new Paragraph("       ")); 
			
			String[] emailids = stringTo(travel_info.getPassengerEmailIds()).split(" ");
			String[] names = stringTo(travel_info.getPassengerNames()).split(" ");
			String[] seats = stringTo(travel_info.getBusSeatings()).split(" ");
			String[] boards = stringTo(travel_info.getPassengerBoardings()).split(" ");
			String[] drops = stringTo(travel_info.getPassengerDroppings()).split(" ");
			int limit = emailids.length;
			PdfPTable table = new PdfPTable(6);
			table.addCell("S.NO");
            table.addCell("NAME");
            table.addCell("EMAILID");
            table.addCell("SEATNO");
            table.addCell("BOARDING");
            table.addCell("DROPPING");
	        for(int i = 0; i < limit; i++){
	        	table.addCell((i+1)+"");
	            table.addCell(names[i]);
	            table.addCell(emailids[i]);
	            table.addCell(seats[i]);
	            table.addCell(boards[i]);
	            table.addCell(drops[i]);
	           
	        }
	        doc.add(table);
			doc.close();  
			writer.close();  
		} catch (DocumentException e) {  
			e.printStackTrace();  
		} catch (FileNotFoundException e)  {  
			e.printStackTrace();  
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = "triprecord.pdf";
		String paths = getServletContext().getRealPath("/"+"files"+File.separator+name);
		
		response.setContentType("APPLICATION/OCTET-STREAM");
		response.setHeader("Content-Disposition", "attachment; filename=\""+name+"\"");
			FileInputStream ins = new FileInputStream(paths);
			int i;
			while((i=ins.read()) != -1) {
				out.write(i);
			}
			ins.close();
			out.close();
	}
}
