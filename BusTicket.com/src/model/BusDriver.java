package model;

public class BusDriver {

	private String name;
	private String licenceNo;
	private String emailid;
	private String phoneno;
	private String travelsAgency;
	private byte[] licencePhotofront;
	private byte[] licencePhotoback;
	private byte[] healthCertificate;
	private String licencePhotofrontDB;
	private String licencePhotobackDB;
	
	public String getLicencePhotofrontDB() {
		return licencePhotofrontDB;
	}
	public void setLicencePhotofrontDB(String licencePhotofrontDB) {
		this.licencePhotofrontDB = licencePhotofrontDB;
	}
	public String getLicencePhotobackDB() {
		return licencePhotobackDB;
	}
	public void setLicencePhotobackDB(String licencePhotobackDB) {
		this.licencePhotobackDB = licencePhotobackDB;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLicenceNo() {
		return licenceNo;
	}
	public void setLicenceNo(String licenceNo) {
		this.licenceNo = licenceNo;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getTravelsAgency() {
		return travelsAgency;
	}
	public void setTravelsAgency(String travelsAgency) {
		this.travelsAgency = travelsAgency;
	}
	public byte[] getLicencePhotofront() {
		return licencePhotofront;
	}
	public void setLicencePhotofront(byte[] licencePhotofront) {
		this.licencePhotofront = licencePhotofront;
	}
	public byte[] getLicencePhotoback() {
		return licencePhotoback;
	}
	public void setLicencePhotoback(byte[] licencePhotoback) {
		this.licencePhotoback = licencePhotoback;
	}
	public byte[] getHealthCertificate() {
		return healthCertificate;
	}
	public void setHealthCertificate(byte[] healthCertificate) {
		this.healthCertificate = healthCertificate;
	}
}
