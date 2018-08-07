package bean;

public class UserMessage {

	@Override
	public String toString() {
		return "UserMessage [user_Id=" + user_Id + ", userName=" + userName + ", userPassword=" + userPassword
				+ ", age=" + age + ", buildNo=" + buildNo + ", roomNo=" + roomNo + ", telPhone=" + telPhone
				+ ", userOrAdmin=" + userOrAdmin + "]";
	}

	private int user_Id;
	
	private String userName;
	
	private String userPassword;
	
	private String age;
	
	private int buildNo;
	
	private String roomNo;
	
	private String telPhone;
	
	private String userOrAdmin;
	
	public int getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public int getBuildNo() {
		return buildNo;
	}

	public void setBuildNo(int buildNo) {
		this.buildNo = buildNo;
	}

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public String getTelPhone() {
		return telPhone;
	}

	public void setTelPhone(String telPhone) {
		this.telPhone = telPhone;
	}

	public String getUserOrAdmin() {
		return userOrAdmin;
	}

	public void setUserOrAdmin(String userOrAdmin) {
		this.userOrAdmin = userOrAdmin;
	}

	
}
