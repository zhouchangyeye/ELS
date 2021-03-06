package po.inforManagementPO;

import java.io.Serializable;

import state.Gender;

public class DriversPO implements Serializable{
	private String ID;
	private String name;
	private String birthDate;
	private String identyNum;
	private String phone;
	private String driveLimitDate;
	private Gender gender;
	private String busiHallID;

	public String getBusiHallID() {
		return busiHallID;
	}

	public void setBusiHallID(String busiHallID) {
		this.busiHallID = busiHallID;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getIdentyNum() {
		return identyNum;
	}

	public void setIdentyNum(String identyNum) {
		this.identyNum = identyNum;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getDriveLimitDate() {
		return driveLimitDate;
	}

	public void setDriveLimitDate(String driveLimitDate) {
		this.driveLimitDate = driveLimitDate;
	}
	
}
