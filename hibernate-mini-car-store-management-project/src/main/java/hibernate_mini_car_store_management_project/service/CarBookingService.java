package hibernate_mini_car_store_management_project.service;

import java.util.List;

import hibernate_mini_car_store_management_project.dao.CarBookingDao;
import hibernate_mini_car_store_management_project.dto.CarBooking;

public class CarBookingService {
CarBookingDao carBookingDao=new CarBookingDao();
	
	public void insertCarBooking(CarBooking carBooking,int personId,int carId)
	{
		
		carBookingDao.insertCarBooking(carBooking, personId, carId);
		
	}
	public void updateCarBooking(int carBookingId)
	{
		
	}
	public void deleteCarBooking(int carBookingId)
	{
		carBookingDao.deleteCarBooking(carBookingId);
	}
	public List<CarBooking> displayCarBooking()
	{
		return carBookingDao.displayCarBooking();
	}
}
