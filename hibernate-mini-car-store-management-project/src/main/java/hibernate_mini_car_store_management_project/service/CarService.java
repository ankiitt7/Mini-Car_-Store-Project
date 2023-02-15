package hibernate_mini_car_store_management_project.service;

import java.util.List;

import hibernate_mini_car_store_management_project.dao.CarDao;
import hibernate_mini_car_store_management_project.dto.Car;

public class CarService {
	CarDao carDao=new CarDao();
	public void insertCars(List<Car> Cars) 
	{
		carDao.insertCars(Cars);
	}
	public void updateCars(int carId,Car car)
	{
		carDao.updateCars(carId, car);
	}
	public void deleteCar(int carId)
	{
		carDao.deleteCar(carId);
	}
	public List<Car> displayCar()
	{
		return carDao.displayCar();
	}
}
