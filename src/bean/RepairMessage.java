package bean;

public class RepairMessage {

	
	@Override
	public String toString() {
		return "RepairMessage [repairNo=" + repairNo + ", repairName=" + repairName + ", buildNo=" + buildNo
				+ ", roomNo=" + roomNo + ", repairTime=" + repairTime + ", repairContent=" + repairContent + "]";
	}

	private int repairNo;
	
	private String repairName;
	
	private int buildNo;
	
	private String roomNo;
	
	private String repairTime;
	
	private String repairContent;

	public int getRepairNo() {
		return repairNo;
	}

	public void setRepairNo(int repairNo) {
		this.repairNo = repairNo;
	}

	public String getRepairName() {
		return repairName;
	}

	public void setRepairName(String repairName) {
		this.repairName = repairName;
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

	public String getRepairTime() {
		return repairTime;
	}

	public void setRepairTime(String repairTime) {
		this.repairTime = repairTime;
	}

	public String getRepairContent() {
		return repairContent;
	}

	public void setRepairContent(String repairContent) {
		this.repairContent = repairContent;
	}
	
}
