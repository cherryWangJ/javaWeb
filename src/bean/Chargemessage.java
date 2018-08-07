package bean;

public class Chargemessage {

	
	@Override
	public String toString() {
		return "Chargemessage [chargeNo=" + chargeNo + ", chargeName=" + chargeName + ", chargeNumber=" + chargeNumber
				+ ", chargeUser=" + chargeUser + ", chargeTime=" + chargeTime + ", chargeContent=" + chargeContent
				+ "]";
	}

	private int chargeNo;
	
	private String chargeName;
	
	private String chargeNumber;
	
	private String chargeUser;
	
	private String chargeTime;
	
	private String chargeContent;

	public int getChargeNo() {
		return chargeNo;
	}

	public void setChargeNo(int chargeNo) {
		this.chargeNo = chargeNo;
	}

	public String getChargeName() {
		return chargeName;
	}

	public void setChargeName(String chargeName) {
		this.chargeName = chargeName;
	}

	public String getChargeNumber() {
		return chargeNumber;
	}

	public void setChargeNumber(String chargeNumber) {
		this.chargeNumber = chargeNumber;
	}

	public String getChargeUser() {
		return chargeUser;
	}

	public void setChargeUser(String chargeUser) {
		this.chargeUser = chargeUser;
	}

	public String getChargeTime() {
		return chargeTime;
	}

	public void setChargeTime(String chargeTime) {
		this.chargeTime = chargeTime;
	}

	public String getChargeContent() {
		return chargeContent;
	}

	public void setChargeContent(String chargeContent) {
		this.chargeContent = chargeContent;
	}
	
}
