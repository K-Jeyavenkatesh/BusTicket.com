package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Passenger;
import model.TravelInformation;

public class TravelInformationDaoImpl implements TravelInformationDao{
	
	public String stringToArray(String temp, String[] ptr) {
		StringBuilder arr = new StringBuilder(temp.substring(0,temp.length()-1));
		
		if(!(arr.toString()).equals("[")) {
			arr.append(", ");
		}
		for(int i = 0; i < ptr.length-1; i++) {
			arr.append("\""+ptr[i]+"\", ");
		}
		arr.append("\""+ptr[ptr.length-1]+"\"]\'");
		arr.insert(0, "\'");
		
		return arr.toString();
	}

	@Override
	public String getJourneyID(String busId) {
		
		String journeyID = null; 
		
		try {
			Connection connection = new DBConnection().DBConnection();
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("select journeyid from travelinformation where busid=\""+busId+"\"");
			result.next();
			journeyID = result.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return journeyID;
	}

	@Override
	public void updateTravelsList(ArrayList<TravelInformation> arr) {
		
		String journeyId = arr.get(0).getJourneyID();
		
		try {
			Connection connection = new DBConnection().DBConnection();
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("select * from travelinformation where journeyid=\""+journeyId+"\";");
			result.next();
			
			String email = result.getString(3);
			String name = result.getString(4);
			String age = result.getString(5);
			String gender = result.getString(6);
			String board = result.getString(7);
			String drop = result.getString(8);
			String seats = result.getString(9);
			
			String[] t3 = new String[arr.size()];
			String[] t4 = new String[arr.size()];
			String[] t5 = new String[arr.size()];
			String[] t6 = new String[arr.size()];
			String[] t7 = new String[arr.size()];
			String[] t8 = new String[arr.size()];
			String[] t9 = new String[arr.size()];
			for(int i = 0; i < arr.size(); i++) {
				t3[i] = arr.get(i).getPassengerEmailIds();
				t4[i] = arr.get(i).getPassengerNames();
				t5[i] = arr.get(i).getPassengerAge();
				t6[i] = arr.get(i).getPassengerGender();
				t7[i] = arr.get(i).getPassengerBoardings();
				t8[i] = arr.get(i).getPassengerDroppings();
				t9[i] = arr.get(i).getBusSeatings();
			}
			
			/*System.out.println(stringToArray(email, t3));
			System.out.println(stringToArray(name, t4));
			System.out.println(stringToArray(age, t5));
			System.out.println(stringToArray(gender, t6));
			System.out.println(stringToArray(board, t7));
			System.out.println(stringToArray(drop, t8));*/
			
			int res = 0;
			String query = "update travelinformation set passengeremailids=("+stringToArray(email, t3)+") where journeyid=\""+journeyId+"\";";
			res += statement.executeUpdate(query);
			query = "update travelinformation set passengernames=("+stringToArray(name, t4)+") where journeyid=\""+journeyId+"\";";
			res += statement.executeUpdate(query);
			query = "update travelinformation set passengerage=("+stringToArray(age, t5)+") where journeyid=\""+journeyId+"\";";
			res += statement.executeUpdate(query);
			query = "update travelinformation set passengergender=("+stringToArray(gender, t6)+") where journeyid=\""+journeyId+"\";";
			res += statement.executeUpdate(query);
			query = "update travelinformation set passengerboardings=("+stringToArray(board, t7)+") where journeyid=\""+journeyId+"\";";
			res += statement.executeUpdate(query);
			query = "update travelinformation set passengerdroppings=("+stringToArray(drop, t8)+") where journeyid=\""+journeyId+"\";";
			res += statement.executeUpdate(query);
			query = "update travelinformation set busseatings=("+stringToArray(seats, t9)+") where journeyid=\""+journeyId+"\";";
			res += statement.executeUpdate(query);
			
			System.out.println(res);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return;
	}
	
	/*public static void main(String[] args) {
		ArrayList<TravelInformation> arr = new ArrayList<TravelInformation>();
		for(int i = 0; i < 2; i++) {
			
			TravelInformation travel = new TravelInformation();
			travel.setJourneyID((i+1)+"");
			travel.setPassengerNames("sdf");
			travel.setPassengerEmailIds("sdf");
			travel.setPassengerAge("sdf");
			travel.setPassengerGender("sdf");
			travel.setPassengerBoardings("sdf");
			travel.setPassengerDroppings("sdf");
			arr.add(travel);
		}
		new TravelInformationDaoImpl().updateTravelsList(arr);
	}*/

}
