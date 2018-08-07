package bean;

public class RoomMessage {

	@Override
	public String toString() {
		return "RoomMessage [roomNo=" + roomNo + ", userName=" + userName + ", buildNo=" + buildNo + ", roomArea="
				+ roomArea + ", roomType=" + roomType + "]";
	}

	private String roomNo;
	
	private String userName;
	
	private int buildNo;
	
	private String roomArea;
	
	private String roomType;

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getBuildNo() {
		return buildNo;
	}

	public void setBuildNo(int buildNo) {
		this.buildNo = buildNo;
	}

	public String getRoomArea() {
		return roomArea;
	}

	public void setRoomArea(String roomArea) {
		this.roomArea = roomArea;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	
	
}
