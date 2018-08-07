package bean;

public class ParkingMessage {
	

	@Override
	public String toString() {
		return "ParkingMessage [parkingNo=" + parkingNo + ", parkingArea=" + parkingArea + ", userName=" + userName
				+ ", carType=" + carType + ", carNumber=" + carNumber + ", telPhone=" + telPhone + "]";
	}

	private int parkingNo;
	
	private String parkingArea;
	
	private String userName;
	
	private String carType;
	
	private String carNumber;
	
	private String telPhone;

	public int getParkingNo() {
		return parkingNo;
	}

	public void setParkingNo(int parkingNo) {
		this.parkingNo = parkingNo;
	}

	public String getParkingArea() {
		return parkingArea;
	}

	public void setParkingArea(String parkingArea) {
		this.parkingArea = parkingArea;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public String getTelPhone() {
		return telPhone;
	}

	public void setTelPhone(String telPhone) {
		this.telPhone = telPhone;
	}
	
}
