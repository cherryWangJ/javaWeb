package bean;

public class BuildMessage {

	@Override
	public String toString() {
		return "BuildMessage [buildNo=" + buildNo + ", buildHeight=" + buildHeight + ", buildArea=" + buildArea
				+ ", buildTime=" + buildTime + ", buildType=" + buildType + "]";
	}

	private int buildNo;
	
	private String buildHeight;
	
	private String buildArea;
	
	private String buildTime;
	
	private String buildType;

	public int getBuildNo() {
		return buildNo;
	}

	public void setBuildNo(int buildNo) {
		this.buildNo = buildNo;
	}

	public String getBuildHeight() {
		return buildHeight;
	}

	public void setBuildHeight(String buildHeight) {
		this.buildHeight = buildHeight;
	}

	public String getBuildArea() {
		return buildArea;
	}

	public void setBuildArea(String buildArea) {
		this.buildArea = buildArea;
	}

	public String getBuildTime() {
		return buildTime;
	}

	public void setBuildTime(String buildTime) {
		this.buildTime = buildTime;
	}

	public String getBuildType() {
		return buildType;
	}

	public void setBuildType(String buildType) {
		this.buildType = buildType;
	}
}
