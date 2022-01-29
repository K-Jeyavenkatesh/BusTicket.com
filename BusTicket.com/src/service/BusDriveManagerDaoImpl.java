package service;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;

import model.BusDetails;
import model.BusDriveAdmin;
import model.BusDriver;
import model.BusInfo;
import model.TravelInformation;

public class BusDriveManagerDaoImpl implements BusDriveManagerDao{
	
	public static String stringTo(String str) {
		str = str.replace("[","");
		str = str.replace("]","");
		str = str.replace("\"","");
		str = str.replace(",","");
		return str;
	}
	
	@Override
	public String registerTravelAgency(BusDriveAdmin admin) {

		try {
			Connection con = new DBConnection().DBConnection();
			Statement st = con.createStatement();
			ResultSet r = st.executeQuery("select * from bustravelagency;");
			
			while(r.next()) {
				if(r.getString(8).equals(admin.getEmailId())) {
					return "duplicate";
				}
			}
			
			PreparedStatement pt = con.prepareStatement("insert into bustravelagency(travelsName,travelsOwnerName,ownerEmailid,ownerPhoneNo,agencyAddress,agencyPhoneNo,emailid,password) values(?,?,?,?,?,?,?,?)");
			pt.setString(1, admin.getTravelsName());
			pt.setString(2, admin.getTravelsOwnerName());
			pt.setString(3, admin.getOwnerEmailid());
			pt.setString(4, admin.getOwnerPhoneNo());
			pt.setString(5, admin.getAgencyAddress());
			pt.setString(6, admin.getAgencyPhoneNo());
			pt.setString(7, admin.getEmailId());
			pt.setString(8, admin.getPassword());
			
			int res = pt.executeUpdate();
			if(res != 0) {
				return "success";
			}
			return "failed";
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "failed";
	}

	@Override
	public BusDriveAdmin getTravelsAdminDetails(String emailid, String password) {
		
		BusDriveAdmin admin = null;
		try {
			Connection con = new DBConnection().DBConnection();
			Statement st = con.createStatement();
			ResultSet r = st.executeQuery("select * from bustravelagency;");
			
			while(r.next()) {
				if(r.getString(8).equals(emailid)) {
					
					admin = new BusDriveAdmin();
					admin.setTravelAgencyId(r.getString(1));
					admin.setTravelsName(r.getString(2));
					admin.setTravelsOwnerName(r.getString(3));
					admin.setOwnerEmailid(r.getString(4));
					admin.setOwnerPhoneNo(r.getString(5));
					admin.setAgencyAddress(r.getString(6));
					admin.setAgencyPhoneNo(r.getString(7));
					admin.setEmailId(r.getString(8));
					admin.setPassword(r.getString(9));
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return admin;
	}

	@Override
	public ArrayList<BusDetails> getAllBuses(String travelsName) {
		
		ArrayList<BusDetails> buses = new ArrayList<BusDetails>();
		try {
			Connection con = new DBConnection().DBConnection();
			Statement st = con.createStatement();
			ResultSet r = st.executeQuery("select * from busdetails;");
			
			while(r.next()) {
				if(r.getString(2).equals(travelsName)) {
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
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return buses;
	}

	@Override
	public boolean addBusTravel(BusDetails busdetails) {
	
		try {
			Connection con = new DBConnection().DBConnection();
			Statement st = con.createStatement();
			String query = "insert into busdetails(bustravelname,"+  
						"busnumber,boardingpoints, droppingpoints,boardingtime,droppingtime,"+ 
                        "date,busaircondition,bustype, seatavaliable, totalseats,price, wifi,"+ 
                        "charging,foodorsnacks,movie,driverphone,additionaldriverphone,bookedseats)"+
                        "values(";
			PreparedStatement pt = con.prepareStatement(query);
			String query2 = "\""+
					""+busdetails.getBusTravelsName()+"\","+
					"\""+busdetails.getBusNumber()+"\","+
					""+busdetails.getBoardingPoints()+","+
					""+busdetails.getDroppingPoints()+","+
					""+busdetails.getBoardingTime()+","+
					""+busdetails.getDroppingTime()+","+
					"\""+busdetails.getDate()+"\","+
					"\""+busdetails.getBusAirCondition()+"\","+
					"\""+busdetails.getBusType()+"\","+
					"\""+busdetails.getSeatAvaliable()+"\","+
					"\""+busdetails.getTotalSeats()+"\","+
					""+busdetails.getPrice()+","+
					"\""+busdetails.getWifi()+"\","+
					"\""+busdetails.getCharging()+"\","+
					"\""+busdetails.getFoodOrSnacks()+"\","+
					"\""+busdetails.getMovie()+"\","+
					"\""+busdetails.getDriverPhone()+"\","+
					"\""+busdetails.getAdditionalDriverPhone()+"\","+
					""+busdetails.getBookedSeats()+"";
			
			query = query+query2+");";
			ResultSet rt;
			int r = st.executeUpdate(query);
			
			rt = st.executeQuery("select busid from busdetails where busid=(select max(busid) from busdetails)");
			rt.next();
			String busid = rt.getString(1);
			
			query = "insert into travelinformation(busid,passengeremailids,passengernames,passengerage,passengergender,passengerboardings,passengerdroppings,busseatings)"+ 
					"values("+busid+",'[]','[]','[]','[]','[]','[]','[]')";
			r += st.executeUpdate(query);
			
			rt = st.executeQuery("select journeyid from travelinformation where journeyid=(select max(journeyid) from travelinformation)");
			rt.next();
			String journeyid = rt.getString(1);
			
			query = "update busdetails set journeyid=\""+journeyid+"\" where busid=\""+busid+"\"";
			r += st.executeUpdate(query);
			
			if(r == 3) {
				return true;
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean addBusInfo(BusInfo businfo) {
		
		try {
            Connection conn = new DBConnection().DBConnection();
            String sql = "insert into businfo(busno,busmodel,ownername,owneremail,ownerphone,travelsagency,rcbook,insurance,puccert,fitness) values (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, businfo.getBusno());
            statement.setString(2, businfo.getBusmodel()); 
            statement.setString(3, businfo.getOwnername()); 
            statement.setString(4, businfo.getOwneremail()); 
            statement.setString(5, businfo.getOwnerphone()); 
            statement.setString(6, businfo.getTravelsagency());
            statement.setBytes(7, businfo.getRcbook()); 
            statement.setBytes(8, businfo.getInsurance()); 
            statement.setBytes(9, businfo.getPuccert()); 
            statement.setBytes(10, businfo.getFitness());

            int row = statement.executeUpdate();
            if (row > 0) {
               return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return false;
	}

	@Override
	public Object[] getAllHistory() {
		
		Object[] objects = new Object[2];
		ArrayList<BusDetails> bustravelinfo = new ArrayList<BusDetails>();
		ArrayList<TravelInformation> travelinfo = new ArrayList<TravelInformation>();
		try {
            Connection conn = new DBConnection().DBConnection();
            String sql = "select * from travelinformation;";
            Statement st = conn.createStatement();
            ResultSet rt = st.executeQuery(sql);
            while(rt.next()) {
            	
            	TravelInformation temp_travelinfo = new TravelInformation();
            	BusDetails temp_bustravelinfo = new BusDetails();
            	
            	temp_travelinfo.setJourneyID(rt.getString(1));
            	temp_travelinfo.setBusID(rt.getString(2));
            	temp_travelinfo.setPassengerEmailIds(rt.getString(3));
            	temp_travelinfo.setPassengerNames(rt.getString(4));
            	temp_travelinfo.setPassengerAge(rt.getString(5));
            	temp_travelinfo.setPassengerGender(rt.getString(6));
            	temp_travelinfo.setPassengerBoardings(rt.getString(7));
            	temp_travelinfo.setPassengerDroppings(rt.getString(8));
            	temp_travelinfo.setBusSeatings(rt.getString(9));
            	Connection temp_conn = new DBConnection().DBConnection();
            	String temp_sql = "select * from busdetails where busid=\""+temp_travelinfo.getBusID()+"\";";
                Statement temp_st = conn.createStatement();
                ResultSet temp_rt = temp_st.executeQuery(temp_sql);
                while(temp_rt.next()) {
                	temp_bustravelinfo.setBusID(temp_rt.getString(1));
                	temp_bustravelinfo.setBusTravelsName(temp_rt.getString(2));
                	temp_bustravelinfo.setBusNumber(temp_rt.getString(3));
                	temp_bustravelinfo.setBoardingPoints(stringTo(temp_rt.getString(4)));
                	temp_bustravelinfo.setDroppingPoints(stringTo(temp_rt.getString(5)));
                	temp_bustravelinfo.setBoardingTime(stringTo(temp_rt.getString(6)));
                	temp_bustravelinfo.setDroppingTime(stringTo(temp_rt.getString(7)));
                	temp_bustravelinfo.setDate(temp_rt.getString(8));
                	temp_bustravelinfo.setBusAirCondition(temp_rt.getString(9));
                	temp_bustravelinfo.setBusType(temp_rt.getString(10));
                	temp_bustravelinfo.setSeatAvaliable(temp_rt.getString(11));
                	temp_bustravelinfo.setTotalSeats(temp_rt.getString(12));
                	temp_bustravelinfo.setPrice(stringTo(temp_rt.getString(13)));
                	temp_bustravelinfo.setWifi(temp_rt.getString(14));
                	temp_bustravelinfo.setCharging(temp_rt.getString(15));
                	temp_bustravelinfo.setFoodOrSnacks(temp_rt.getString(16));
                	temp_bustravelinfo.setMovie(temp_rt.getString(17));
                	temp_bustravelinfo.setJourneyID(temp_rt.getString(18));
                	temp_bustravelinfo.setDriverPhone(temp_rt.getString(19));
                	temp_bustravelinfo.setAdditionalDriverPhone(temp_rt.getString(20));
                	temp_bustravelinfo.setBookedSeats(temp_rt.getString(21));
                } 
                travelinfo.add(temp_travelinfo);
                bustravelinfo.add(temp_bustravelinfo);
            }
            objects[0] = travelinfo;
            objects[1] = bustravelinfo;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return objects;
	}

	@Override
	public byte[] getBusInfo(String pdf, String busno) {
			
			try {
				Connection con = new DBConnection().DBConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("select "+pdf+" from businfo where busno=\""+busno+"\";");
				int i=1;
				InputStream in = null;
				while(rs.next()) {
					in = rs.getBinaryStream(1);
				}
				int available1 = in.available();
				byte[] bt = new byte[available1];
				in.read(bt);

				return bt;
			} catch (Exception e) {
				e.printStackTrace();
			}
		return null;
	}

	@Override
	public BusInfo getBusInfo(String busno) {
		
		BusInfo businfo = new BusInfo();

		try {
			Connection con = new DBConnection().DBConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from businfo where busno=\""+busno+"\";");
			rs.next();
			businfo.setBusno(rs.getString(1));
			businfo.setBusmodel(rs.getString(2));
			businfo.setOwnername(rs.getString(3));
			businfo.setOwneremail(rs.getString(4));
			businfo.setOwnerphone(rs.getString(5));
			businfo.setTravelsagency(rs.getString(6));
			
			return businfo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return businfo;
	}

	@Override
	public String forgetPassword(String email) {
		
		String password = null;
		try{
			
			Connection conn = new DBConnection().DBConnection();
			Statement st = conn.createStatement();
			ResultSet r = st.executeQuery("select password from bustravelagency where emailid=\""+email+"\";");
			r.next();
			password = r.getString(1);
		} catch(Exception e) {
			
		}
		return password;
	}
	
}
