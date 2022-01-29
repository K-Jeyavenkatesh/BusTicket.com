package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.BusDetails;

public class BusJourneyDetailsDaoImpl implements BusJourneyDetailsDao{
	
	public static String stringTo(String str) {
		str = str.replace("[","");
		str = str.replace("]","");
		str = str.replace("\"","");
		str = str.replace(",","");
		return str;
	}

	@Override
	public ArrayList<BusDetails> getJourneyDetails() {
		
		ArrayList<BusDetails> buses = new ArrayList<BusDetails>();
		try {
			Connection con = new DBConnection().DBConnection();
			Statement st = con.createStatement();
			ResultSet r = st.executeQuery("select * from busdetails;");
			
			while(r.next()) {
				BusDetails bus = new BusDetails();
				bus.setBusID(r.getString(1));
				bus.setBusTravelsName(r.getString(2));
				bus.setBusNumber(r.getString(3));
				bus.setBoardingPoints(stringTo(r.getString(4)));
				bus.setDroppingPoints(stringTo(r.getString(5)));
				bus.setBoardingTime(stringTo(r.getString(6)));
				bus.setDroppingTime(stringTo(r.getString(7)));
				bus.setDate(r.getString(8));
				bus.setBusAirCondition(r.getString(9));
				bus.setBusType(r.getString(10));
				bus.setSeatAvaliable(r.getString(11));
				bus.setTotalSeats(r.getString(12));
				bus.setPrice(stringTo(r.getString(13)));
				bus.setWifi(r.getString(14));
				bus.setCharging(r.getString(15));
				bus.setFoodOrSnacks(r.getString(16));
				bus.setMovie(r.getString(17));
				bus.setJourneyID(r.getString(18));
				bus.setDriverPhone(r.getString(19));
				bus.setAdditionalDriverPhone(r.getString(20));
				bus.setBookedSeats(r.getString(21));
				
				buses.add(bus);
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return buses;
	}

	@Override
	public ArrayList<BusDetails> getJourneyDetails(String date, String from, String to) {
		
		ArrayList<BusDetails> buses = new ArrayList<BusDetails>();
		
		try {
			Connection con = new DBConnection().DBConnection();
			Statement st = con.createStatement();
			ResultSet r = st.executeQuery("select * from busdetails where date=\""+date+"\";");
			while(r.next()) {
				BusDetails bus = new BusDetails();
				bus.setBusID(r.getString(1));
				bus.setBusTravelsName(r.getString(2));
				bus.setBusNumber(r.getString(3));
				bus.setBoardingPoints(stringTo(r.getString(4)));
				bus.setDroppingPoints(stringTo(r.getString(5)));
				bus.setBoardingTime(stringTo(r.getString(6)));
				bus.setDroppingTime(stringTo(r.getString(7)));
				bus.setDate(r.getString(8));
				bus.setBusAirCondition(r.getString(9));
				bus.setBusType(r.getString(10));
				bus.setSeatAvaliable(r.getString(11));
				bus.setTotalSeats(r.getString(12));
				bus.setPrice(stringTo(r.getString(13)));
				bus.setWifi(r.getString(14));
				bus.setCharging(r.getString(15));
				bus.setFoodOrSnacks(r.getString(16));
				bus.setMovie(r.getString(17));
				bus.setJourneyID(r.getString(18));
				bus.setDriverPhone(r.getString(19));
				bus.setAdditionalDriverPhone(r.getString(20));
				bus.setBookedSeats(r.getString(21));
				
				buses.add(bus);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		ArrayList<BusDetails> buses_temp = new ArrayList<BusDetails>();
		for(int i = 0; i < buses.size(); i++) {
			boolean flag1 = false, flag2 = false;
			BusDetails b = buses.get(i);
			String[] arr = b.getBoardingPoints().split(" ");
			for(int j = 0; j < arr.length; j++) {
				if(from.equals(arr[j])) {
					flag1 = true;
					break;
				}
			}
			arr = b.getDroppingPoints().split(" ");
			for(int j = 0; j < arr.length; j++) {
				if(to.equals(arr[j])) {
					flag2 = true;
					break;
				}
			}
			if(flag1 && flag2) {
				buses_temp.add(b);
			}
		}
		System.out.println(buses_temp);
		return buses_temp;
	}

	@Override
	public ArrayList<BusDetails> getFilteredJourneyDetails(String date, String from, String to, String[] filter) {
		
		ArrayList<BusDetails> buses = new ArrayList<BusDetails>();
		
		String query = "select * from busdetails where date=\""+date+"\"";
		String[] attribute = new String[]{"busaircondition","bustype","wifi","charging","foodorsnacks","movie"};
		for(int i = 0; i < 6; i++) {
			if(filter[i] != null) {
				query += " and "+attribute[i]+" = \""+filter[i]+"\"";
			}
		}
		query += ";";
		
		try {
			Connection con = new DBConnection().DBConnection();
			Statement st = con.createStatement();
			ResultSet r = st.executeQuery(query);
			
			while(r.next()) {
				BusDetails bus = new BusDetails();
				bus.setBusID(r.getString(1));
				bus.setBusTravelsName(r.getString(2));
				bus.setBusNumber(r.getString(3));
				bus.setBoardingPoints(stringTo(r.getString(4)));
				bus.setDroppingPoints(stringTo(r.getString(5)));
				bus.setBoardingTime(stringTo(r.getString(6)));
				bus.setDroppingTime(stringTo(r.getString(7)));
				bus.setDate(r.getString(8));
				bus.setBusAirCondition(r.getString(9));
				bus.setBusType(r.getString(10));
				bus.setSeatAvaliable(r.getString(11));
				bus.setTotalSeats(r.getString(12));
				bus.setPrice(stringTo(r.getString(13)));
				bus.setWifi(r.getString(14));
				bus.setCharging(r.getString(15));
				bus.setFoodOrSnacks(r.getString(16));
				bus.setMovie(r.getString(17));
				bus.setJourneyID(r.getString(18));
				bus.setDriverPhone(r.getString(19));
				bus.setAdditionalDriverPhone(r.getString(20));
				bus.setBookedSeats(r.getString(21));
				
				buses.add(bus);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ArrayList<BusDetails> buses_temp = new ArrayList<BusDetails>();
		for(int i = 0; i < buses.size(); i++) {
			boolean flag1 = false, flag2 = false;
			BusDetails b = buses.get(i);
			String[] arr = b.getBoardingPoints().split(" ");
			for(int j = 0; j < arr.length; j++) {
				if(from.equals(arr[j])) {
					flag1 = true;
					break;
				}
			}
			arr = b.getDroppingPoints().split(" ");
			for(int j = 0; j < arr.length; j++) {
				if(to.equals(arr[j])) {
					flag2 = true;
					break;
				}
			}
			if(flag1 && flag2) {
				buses_temp.add(b);
			}
		}
		System.out.println(buses_temp.get(0).getBoardingPoints());
		return buses_temp;
		
	}
	
	@Override
	public ArrayList<BusDetails> getFilteredJourneyDetails(String[] filter) {

		ArrayList<BusDetails> buses = new ArrayList<BusDetails>();
		
		String query = "select * from busdetails ";
		String[] attribute = new String[]{"busaircondition","bustype","wifi","charging","foodorsnacks","movie"};
		boolean flag = true;
		for(int i = 0; i < 6; i++) {
			if(filter[i] != null) {
				if(flag) {
					query += "where "+attribute[i]+" = \""+filter[i]+"\"";
					flag = false;
				} else {
					query += " and "+attribute[i]+" = \""+filter[i]+"\"";
				}
			}
		}
		query += ";";

		try {
			Connection con = new DBConnection().DBConnection();
			Statement st = con.createStatement();
			ResultSet r = st.executeQuery(query);
			System.out.println(query);
			while(r.next()) {
				BusDetails bus = new BusDetails();
				bus.setBusID(r.getString(1));
				bus.setBusTravelsName(r.getString(2));
				bus.setBusNumber(r.getString(3));
				bus.setBoardingPoints(stringTo(r.getString(4)));
				bus.setDroppingPoints(stringTo(r.getString(5)));
				bus.setBoardingTime(stringTo(r.getString(6)));
				bus.setDroppingTime(stringTo(r.getString(7)));
				bus.setDate(r.getString(8));
				bus.setBusAirCondition(r.getString(9));
				bus.setBusType(r.getString(10));
				bus.setSeatAvaliable(r.getString(11));
				bus.setTotalSeats(r.getString(12));
				bus.setPrice(stringTo(r.getString(13)));
				bus.setWifi(r.getString(14));
				bus.setCharging(r.getString(15));
				bus.setFoodOrSnacks(r.getString(16));
				bus.setMovie(r.getString(17));
				bus.setJourneyID(r.getString(18));
				bus.setDriverPhone(r.getString(19));
				bus.setAdditionalDriverPhone(r.getString(20));
				bus.setBookedSeats(r.getString(21));
				
				buses.add(bus);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return buses;
	}

	@Override
	public void updateBookingSeats(String busId, String[] seats) {
		
		String query = "select bookedseats from busdetails where busid=\""+busId+"\";";
		int n = seats.length;
		
		try {
			Connection con = new DBConnection().DBConnection();
			Statement st = con.createStatement();
			ResultSet r = st.executeQuery(query);
			r.next();
			String temp = r.getString(1);
			StringBuilder booked = new StringBuilder(temp.substring(0,temp.length()-1));
			
			if(!(booked.toString()).equals("[")) {
				booked.append(", ");
			}
			for(int i = 0; i < seats.length-1; i++) {
				booked.append("\""+seats[i]+"\", ");
			}
			booked.append("\""+seats[seats.length-1]+"\"]\'");
			booked.insert(0, "\'");
			System.out.println(booked.toString());
			query = "update busdetails set bookedseats=("+booked.toString()+") where busid=\""+busId+"\";";
			
			int result = st.executeUpdate(query);
			
			query = "select seatavaliable from busdetails where busid=\""+busId+"\";";
			
			r = st.executeQuery(query);
			r.next();
			temp = r.getString(1);
			n = Integer.valueOf(temp)-n;
			
			query = "update busdetails set seatavaliable=\""+n+"\" where busid=\""+busId+"\";";
			
			result += st.executeUpdate(query);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return;
		
	}

	@Override
	public ArrayList<BusDetails> filterByCurrentDate(ArrayList<BusDetails> buses) {
		
		//buses = this.getJourneyDetails();
		ArrayList<BusDetails> result = new ArrayList<BusDetails>();
		try {
			  System.out.println(buses);
			  
		      Date date = new Date();  
		    
			  SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
			  String curr = sdformat.format(date); 
			  System.out.println(curr);
		      Date d1 = sdformat.parse(curr);
		      for(int i = 0; i < buses.size(); i++) {
		    	  String temp = buses.get(i).getDate();
		    	  String expect = temp.substring(6)+"-"+temp.substring(3,5)+"-"+temp.substring(0,2);
		    	  Date d2 = sdformat.parse(expect);
		    	  if(d1.compareTo(d2) < 0) {
				         result.add(buses.get(i));
				   }
		      }
		       
		} catch(Exception e) {
			
		}
		return result;
	}
	
}















