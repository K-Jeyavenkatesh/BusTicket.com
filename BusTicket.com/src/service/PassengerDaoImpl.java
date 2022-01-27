package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Passenger;

public class PassengerDaoImpl implements PassengerDao{

	@Override
	public String registerPassenger(Passenger passenger) {
		
		
		try {
			Connection connection = new DBConnection().DBConnection();
			PreparedStatement st = connection.prepareStatement("insert into passenger values(?,?,?,?,?,?,?);");
			st.setString(1, passenger.getUsername());
			st.setString(2, "Not filled");
			st.setString(3, "Not filled");
			st.setString(4, "Not filled");
			st.setString(5, "Not filled");
			st.setString(6, passenger.getEmail());
			st.setString(7, passenger.getPassword());
			
			int r = st.executeUpdate();
			if(r == 1) {
				return "success";
			}
			return "failed";
		} catch (SQLException e) {
			//e.printStackTrace();
			System.out.println(e.getClass().toString());
			if("class java.sql.SQLIntegrityConstraintViolationException".equals(e.getClass().toString())) {
				return "duplicate";
			}
			return "failed";
		}
	}

	@Override
	public Passenger getpassengerDetails(String emailid, String password) {
		
		
		try {
			Connection connection = new DBConnection().DBConnection();
			Statement st = connection.createStatement();
			ResultSet result = st.executeQuery("select * from passenger where emailid=\""+emailid+"\";");
			while(result.next()) {
				if(result.getString(6).equals(emailid)) {
					Passenger passenger = new Passenger();
					passenger.setUsername(result.getString(1));
					passenger.setFullname(result.getString(2));
					passenger.setDob(result.getString(3));
					passenger.setGender(result.getString(4));
					passenger.setPhonenumber(result.getString(5));
					passenger.setEmail(result.getString(6));
					passenger.setPassword(result.getString(7));
					return passenger;
				}
			}
			return null;
		} catch (SQLException e) {
			return null;
		}
	}

	@Override
	public void updatePassenger(Passenger passenger) {
		
		try {
			
			Connection conn = new DBConnection().DBConnection();
			Statement st = conn.createStatement();
			int r = 0;
			System.out.println("update passenger set fullname=\""+passenger.getFullname()+"\" where emailid=\""+passenger.getEmail()+"\";");
			r += st.executeUpdate("update passenger set username=\""+passenger.getUsername()+"\" where emailid=\""+passenger.getEmail()+"\";");
			r += st.executeUpdate("update passenger set fullname=\""+passenger.getFullname()+"\" where emailid=\""+passenger.getEmail()+"\";");
			r += st.executeUpdate("update passenger set dob=\""+passenger.getDob()+"\" where emailid=\""+passenger.getEmail()+"\";");
			r += st.executeUpdate("update passenger set gender=\""+passenger.getGender()+"\" where emailid=\""+passenger.getEmail()+"\";");
			r += st.executeUpdate("update passenger set phonenumber=\""+passenger.getPhonenumber()+"\" where emailid=\""+passenger.getEmail()+"\";");
			r += st.executeUpdate("update passenger set password=\""+passenger.getPassword()+"\" where emailid=\""+passenger.getEmail()+"\";");
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return;
		
	}

	@Override
	public String forgetPassword(String email) {
		
		String password = null;
		try{
			
			Connection conn = new DBConnection().DBConnection();
			Statement st = conn.createStatement();
			ResultSet r = st.executeQuery("select password from passenger where emailid=\""+email+"\";");
			r.next();
			password = r.getString(1);
		} catch(Exception e) {
			
		}
		return password;
	}

}
