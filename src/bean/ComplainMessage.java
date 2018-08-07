package bean;

public class ComplainMessage {

	
	@Override
	public String toString() {
		return "ComplainMessage [complainNo=" + complainNo + ", complainName=" + complainName + ", complainTime="
				+ complainTime + ", complainContent=" + complainContent + "]";
	}

	private int complainNo;
	
	private String complainName;
	
	private String complainTime;
	
	private String complainContent;

	public int getComplainNo() {
		return complainNo;
	}

	public void setComplainNo(int complainNo) {
		this.complainNo = complainNo;
	}

	public String getComplainName() {
		return complainName;
	}

	public void setComplainName(String complainName) {
		this.complainName = complainName;
	}

	public String getComplainTime() {
		return complainTime;
	}

	public void setComplainTime(String complainTime) {
		this.complainTime = complainTime;
	}

	public String getComplainContent() {
		return complainContent;
	}

	public void setComplainContent(String complainContent) {
		this.complainContent = complainContent;
	}
	
}
