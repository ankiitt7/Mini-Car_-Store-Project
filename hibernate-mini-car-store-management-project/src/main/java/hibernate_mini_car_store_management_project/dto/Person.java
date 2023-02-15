package hibernate_mini_car_store_management_project.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Person {
	@Id
	private int personid;
	private String personName;
	private long personPhone;
	private String persomEmail;
	@OneToMany
	private List<Car> car;
	@Override
	public String toString() {
		return "Person [personid=" + personid + ", personName=" + personName + ", personPhone=" + personPhone
				+ ", persomEmail=" + persomEmail + "]";
	}
	@OneToOne
	private Address address;
	@OneToOne
	private Pan pan;
	public int getPersonid() {
		return personid;
	}
	public void setPersonid(int personid) {
		this.personid = personid;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public long getPersonPhone() {
		return personPhone;
	}
	public void setPersonPhone(long personPhone) {
		this.personPhone = personPhone;
	}
	public String getPersomEmail() {
		return persomEmail;
	}
	public void setPersomEmail(String persomEmail) {
		this.persomEmail = persomEmail;
	}
	
	public List<Car> getCar() {
		return car;
	}
	public void setCar(List<Car> car) {
		this.car = car;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Pan getPan() {
		return pan;
	}
	public void setPan(Pan pan) {
		this.pan = pan;
	}
	
}
