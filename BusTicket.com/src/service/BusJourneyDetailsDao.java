package service;

import java.util.ArrayList;

import model.BusDetails;

public interface BusJourneyDetailsDao {

	public ArrayList<BusDetails> getJourneyDetails();
	public ArrayList<BusDetails> getJourneyDetails(String date, String from, String to);
	public ArrayList<BusDetails> getFilteredJourneyDetails(String[] filter);
	public ArrayList<BusDetails> getFilteredJourneyDetails(String date, String from, String to, String[] filter);
	public void updateBookingSeats(String busId, String[] seats);
	public ArrayList<BusDetails> filterByCurrentDate(ArrayList<BusDetails> buses);
}
