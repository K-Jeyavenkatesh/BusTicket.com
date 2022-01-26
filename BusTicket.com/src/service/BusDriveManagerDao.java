package service;

import java.util.ArrayList;

import model.BusDetails;
import model.BusDriveAdmin;
import model.BusDriver;
import model.BusInfo;

public interface BusDriveManagerDao {

	public String registerTravelAgency(BusDriveAdmin admin);
	public BusDriveAdmin getTravelsAdminDetails(String emailid, String password);
	public ArrayList<BusDetails> getAllBuses(String travelsName);
	public boolean addBusTravel(BusDetails busdetails);
	public boolean addBusInfo(BusInfo businfo);
	public Object[] getAllHistory();
	public byte[] getBusInfo(String pdf, String busno);
	public BusInfo getBusInfo(String busno);
}
