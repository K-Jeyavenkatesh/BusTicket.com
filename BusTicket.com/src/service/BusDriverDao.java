package service;

import model.BusDriver;

public interface BusDriverDao {

	public boolean addBusDriver(BusDriver driver);
	public BusDriver getBusDriver(String attribute, String value);
	public byte[] PdfFromDatabase(String licenceno);
}
