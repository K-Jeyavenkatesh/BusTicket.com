package service;

import java.util.ArrayList;

import model.Rental;

public interface RentalDao {

	public boolean insertRentals(Rental rental);
	public ArrayList<Rental> getAllRentals();
	public boolean removeSelectedRequest(String id);
}
