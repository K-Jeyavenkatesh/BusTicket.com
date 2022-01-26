package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.PassengerBookingHistory;

public class PassengerBookingHistoryDaoImpl implements PassengerBookingHistoryDao{

	@Override
	public void insertPassengerToHistory(PassengerBookingHistory history) {

		
		try {
			Connection con = new DBConnection().DBConnection();
			PreparedStatement p = con.prepareStatement("insert into passengerbookinghistory(email ,journeyid,boardingpoint,droppingpoint,boardingtime,droppingtime,date,price) "
														+"values(?,?,?,?,?,?,?,?);");
			p.setString(1, history.getEmail());
			p.setString(2, history.getJourneyID());
			p.setString(3, history.getBoardingPoint());
			p.setString(4, history.getDroppingPoint());
			p.setString(5, history.getBoardingTime());
			p.setString(6, history.getDroppingTime());
			p.setString(7, history.getDate());
			p.setString(8, history.getPrice());
			
			int r = p.executeUpdate();
			
			System.out.println("OO"+r);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return;
	}

}
