package service;

import java.util.ArrayList;

import model.PassengerBookingHistory;

public interface PassengerBookingHistoryDao {

	public void insertPassengerToHistory(PassengerBookingHistory history);
	public ArrayList<PassengerBookingHistory> getAllHistory(String email);
}
