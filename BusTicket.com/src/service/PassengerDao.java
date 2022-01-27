package service;

import model.Passenger;

public interface PassengerDao {
	
	public String registerPassenger(Passenger passenger);
	public Passenger getpassengerDetails(String emailid, String password);
	public void updatePassenger(Passenger passenger);
	public String forgetPassword(String email);
	
}
