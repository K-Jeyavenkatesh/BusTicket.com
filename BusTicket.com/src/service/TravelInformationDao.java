package service;

import java.util.ArrayList;

import model.TravelInformation;

public interface TravelInformationDao {
	
	public String getJourneyID(String busId);
	public void updateTravelsList(ArrayList<TravelInformation> arr);
}
