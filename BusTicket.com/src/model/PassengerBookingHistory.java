package model;

public class PassengerBookingHistory {

	private String email;
	private String journeyID;
	private String boardingPoint;
	private String droppingPoint;
	private String boardingTime;
	private String droppingTime;
	private String date;
	private String price;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBoardingPoint() {
		return boardingPoint;
	}
	public void setBoardingPoint(String boardingPoint) {
		this.boardingPoint = boardingPoint;
	}
	public String getDroppingPoint() {
		return droppingPoint;
	}
	public void setDroppingPoint(String droppingPoint) {
		this.droppingPoint = droppingPoint;
	}
	public String getBoardingTime() {
		return boardingTime;
	}
	public void setBoardingTime(String boardingTime) {
		this.boardingTime = boardingTime;
	}
	public String getDroppingTime() {
		return droppingTime;
	}
	public void setDroppingTime(String droppingTime) {
		this.droppingTime = droppingTime;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getJourneyID() {
		return journeyID;
	}
	public void setJourneyID(String journeyID) {
		this.journeyID = journeyID;
	}
}
