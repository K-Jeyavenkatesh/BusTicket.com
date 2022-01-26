package model;

public class BusInfo {

	private String busno;
	private String busmodel;
	private String ownername;
	private String owneremail;
	private String ownerphone;
	private String travelsagency;
	private byte[] rcbook;
	private byte[] insurance;
	private byte[] puccert;
	private byte[] fitness;
	
	public String getBusno() {
		return busno;
	}
	public void setBusno(String busno) {
		this.busno = busno;
	}
	public String getBusmodel() {
		return busmodel;
	}
	public void setBusmodel(String busmodel) {
		this.busmodel = busmodel;
	}
	public String getOwnername() {
		return ownername;
	}
	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}
	public String getOwneremail() {
		return owneremail;
	}
	public void setOwneremail(String owneremail) {
		this.owneremail = owneremail;
	}
	public String getOwnerphone() {
		return ownerphone;
	}
	public void setOwnerphone(String ownerphone) {
		this.ownerphone = ownerphone;
	}
	public String getTravelsagency() {
		return travelsagency;
	}
	public void setTravelsagency(String travelsagency) {
		this.travelsagency = travelsagency;
	}
	public byte[] getRcbook() {
		return rcbook;
	}
	public void setRcbook(byte[] rcbook) {
		this.rcbook = rcbook;
	}
	public byte[] getInsurance() {
		return insurance;
	}
	public void setInsurance(byte[] insurance) {
		this.insurance = insurance;
	}
	public byte[] getPuccert() {
		return puccert;
	}
	public void setPuccert(byte[] puccert) {
		this.puccert = puccert;
	}
	public byte[] getFitness() {
		return fitness;
	}
	public void setFitness(byte[] fitness) {
		this.fitness = fitness;
	}
}
