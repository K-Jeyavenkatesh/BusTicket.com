package model;

import java.util.ArrayList;

public class Ticket {
	
	private String pnr;
	private ArrayList<TravelInformation> travelnfo;
	private BusDetails busdetails;
	private String TransactionID;
	private String TransactionMode;
	
	public String getPnr() {
		return pnr;
	}
	public void setPnr(String pnr) {
		this.pnr = pnr;
	}
	public ArrayList<TravelInformation> getTravelnfo() {
		return travelnfo;
	}
	public void setTravelnfo(ArrayList<TravelInformation> travelnfo) {
		this.travelnfo = travelnfo;
	}
	public BusDetails getBusdetails() {
		return busdetails;
	}
	public void setBusdetails(BusDetails busdetails) {
		this.busdetails = busdetails;
	}
	public String getTransactionID() {
		return TransactionID;
	}
	public void setTransactionID(String transactionID) {
		TransactionID = transactionID;
	}
	public String getTransactionMode() {
		return TransactionMode;
	}
	public void setTransactionMode(String transactionMode) {
		TransactionMode = transactionMode;
	}
}
