package hibernate_mini_car_store_management_project.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class CarBooking {
	@Id
	private int carBookingid;
	@OneToOne
	private Car car;
	@OneToOne
	private Person person;
	public int getCarBookingid() {
		return carBookingid;
	}
	public void setCarBookingid(int carBookingid) {
		this.carBookingid = carBookingid;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
}
