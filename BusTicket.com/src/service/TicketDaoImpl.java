package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.BusDetails;
import model.Ticket;
import model.TravelInformation;

public class TicketDaoImpl implements TicketDao{

	@Override
	public long addTicket(Ticket ticket) {
		
		long pnr = -1;
		ArrayList<TravelInformation> info = ticket.getTravelnfo();
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		for(int i = 0; i < info.size(); i++) {
			TravelInformation t = info.get(i);
			ArrayList<String> arr = new ArrayList<String>();
			arr.add(t.getJourneyID());
			arr.add(t.getPassengerEmailIds());
			arr.add(t.getPassengerNames());
			arr.add(t.getPassengerAge());
			arr.add(t.getPassengerGender());
			arr.add(t.getPassengerBoardings());
			arr.add(t.getPassengerDroppings());
			list.add(arr);
		}
		StringBuilder sb = new StringBuilder(list.toString());
		StringBuilder sb1 = new StringBuilder(list.toString());
		int j = 0, k = 0;
		for(int i = 1; i < sb.length()-1; i++) {
			if(sb.charAt(i) == '[') {
				sb1.insert(i+j, "\"");
				k++;
			}
			if(sb.charAt(i) == ']') {
				sb1.insert(i+2+j, "\"");
				k++;
			}
			if(k == 2) {
				k = 0;
				j += 2;
			}
		}
		String t_info = "\'"+sb1.toString()+"\'";
		
		String busid = ticket.getBusdetails().getBusID();
		try {
			Connection conn = new DBConnection().DBConnection();
			Statement st = conn.createStatement();
			String query = "insert into ticket(travelinfo, busid, transacationid, transactionmode) values("+t_info+",\""+busid+"\",\""+ticket.getTransactionID()+"\",\""+ticket.getTransactionMode()+"\")";
			
			int r = st.executeUpdate(query);
			ResultSet rt = st.executeQuery("select pnr from ticket where pnr=(select max(pnr) from ticket)");
			rt.next();
			pnr = (long) rt.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pnr;
	}

	@Override
	public Ticket getTicket(String pnr) {
		
		Ticket ticket = new Ticket();
		try {
			
			Connection conn = new DBConnection().DBConnection();
			Statement st = conn.createStatement();
			ResultSet r = st.executeQuery("select * from ticket where pnr=\""+pnr+"\";");
			r.next();
			ticket.setPnr(r.getString(1));
			ticket.setTransactionID(r.getString(4));
			ticket.setTransactionMode(r.getString(5));
			String info = r.getString(2);
			
			ArrayList<TravelInformation> arr = new ArrayList<TravelInformation>();
			
			info = info.substring(3, info.length()-3);
			String[] tempArr = info.split("\\]\", \"\\[");
			for(int i = 0; i < tempArr.length; i++) {
				String[] temp = tempArr[i].split(", ");
				TravelInformation t = new TravelInformation();
				t.setPassengerNames(temp[2]);
				t.setPassengerAge(temp[3]);
				t.setPassengerGender(temp[4]);
				t.setPassengerBoardings(temp[5]);
				t.setPassengerDroppings(temp[6]);
				arr.add(t);
			}
			ticket.setTravelnfo(arr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ticket;
	}
	

}
