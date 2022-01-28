package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sun.corba.se.spi.orbutil.fsm.State;

import model.Rental;

public class RentalDaoImpl implements RentalDao{

	@Override
	public boolean insertRentals(Rental rental) {
		
		try {
			
			Connection conn = new DBConnection().DBConnection();
			PreparedStatement r = conn.prepareStatement("insert into rental(places,date,days,details,busdetails,username,useremail,userphoneno1,userphone2) values(?,?,?,?,?,?,?,?,?);");
			r.setString(1, rental.getExpect_place());
			r.setString(2, rental.getExpect_date());
			r.setString(3, rental.getExpect_days());
			r.setString(4, rental.getExpect_details());
			r.setString(5, rental.getExpect_busdetails());
			r.setString(6, rental.getUsername());
			r.setString(7, rental.getUseremail());
			r.setString(8, rental.getUserphone1());
			r.setString(9, rental.getUserphone2());
			
			int t = r.executeUpdate();
			if(t > 0) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	@Override
	public ArrayList<Rental> getAllRentals() {
		
		ArrayList<Rental> arr = new ArrayList<Rental>();
		try {
			
			Connection conn = new DBConnection().DBConnection();
			Statement st = conn.createStatement();
			ResultSet r = st.executeQuery("select * from rental;");
			while(r.next()) {
				Rental rental = new Rental();
				rental.setId(r.getString(1));
				rental.setExpect_place(r.getString(2));
				rental.setExpect_date(r.getString(3));
				rental.setExpect_days(r.getString(4));
				rental.setExpect_details(r.getString(5));
				rental.setExpect_busdetails(r.getString(6));
				rental.setUsername(r.getString(7));
				rental.setUseremail(r.getString(8));
				rental.setUserphone1(r.getString(9));
				rental.setUserphone2(r.getString(10));
				
				arr.add(rental);
			}
			
		} catch (Exception e) {
			
		}
		return arr;
	}

	@Override
	public boolean removeSelectedRequest(String id) {

		try {
			
			Connection conn = new DBConnection().DBConnection();
			Statement st = conn.createStatement();
			String query = "delete from rental where id=\""+id+"\";";
			int r = st.executeUpdate(query);
			
			if(r > 0) {
				return true;
			}
			
		} catch (Exception e) {
			
		}
		return false;
	}

}
