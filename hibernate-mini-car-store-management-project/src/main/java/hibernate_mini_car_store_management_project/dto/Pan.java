package hibernate_mini_car_store_management_project.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Pan {
	@Id
	private int panId;
	private String panNumber;
	@Temporal(value=TemporalType.DATE)
	private Date Dob;
	@Override
	public String toString() {
		return "Pan [panId=" + panId + ", panNumber=" + panNumber + ", Dob=" + Dob + ", Gender=" + Gender + "]";
	}
	private String Gender;
	@OneToOne
	private  Address address;
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public int getPanId() {
		return panId;
	}
	public void setPanId(int panId) {
		this.panId = panId;
	}
	public Date getDob() {
		return Dob;
	}
	public void setDob(Date dob) {
		Dob = dob;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
}
