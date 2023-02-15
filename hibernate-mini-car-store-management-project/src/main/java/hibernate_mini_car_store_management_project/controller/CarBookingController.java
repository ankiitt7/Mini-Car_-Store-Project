package hibernate_mini_car_store_management_project.controller;

import java.util.List;
import java.util.Scanner;

import hibernate_mini_car_store_management_project.dao.CarBookingDao;
import hibernate_mini_car_store_management_project.dto.Car;
import hibernate_mini_car_store_management_project.dto.CarBooking;
import hibernate_mini_car_store_management_project.dto.Person;
import hibernate_mini_car_store_management_project.service.CarBookingService;

public class CarBookingController {

	public static void main(String[] args) 
	{
		Scanner scanner=new Scanner(System.in);	
		CarBookingService carBookingService=new CarBookingService();
	while(true)
	{
		System.out.println("1.Insert/2.Delete/3.Display/4.Exit");
		System.out.println("Choose your choice");
		int choice = scanner.nextInt();
		
		switch(choice)
		{
			
		case 1:
			{
				CarBooking carBooking=new CarBooking();
				CarBookingDao bookingDao=new CarBookingDao();
				System.out.println("Enter Car Booking Id");
				carBooking.setCarBookingid(scanner.nextInt());
				System.out.println("Enter person Id");	
				int personId=scanner.nextInt();
				Person person =bookingDao.getByPersonId(personId);
				carBooking.setPerson(person);
				System.out.println("Enter Car Id");
				int carId=scanner.nextInt();
				Car car=bookingDao.getByCarId(carId);
				carBooking.setCar(car);
				carBookingService.insertCarBooking(carBooking, personId, carId);				
			}break;
		case 2:
			{
				System.out.println("Enter carBooing Id");	
				int carBookingId=scanner.nextInt();
				carBookingService.deleteCarBooking(carBookingId);
			}break;
		case 3:
			{
				List<CarBooking> carBookings=carBookingService.displayCarBooking();
				for (CarBooking carBooking : carBookings) 
				{
					System.out.println(carBooking.getCarBookingid());
					Person person=carBooking.getPerson();
					System.out.println(person.getPersonid());
					System.out.println(person.getPersonName());
					System.out.println(person.getPersomEmail());
					System.out.println(person.getPersonPhone());
					Car car=carBooking.getCar();
					System.out.println(car.getCarId());
					System.out.println(car.getCarName());
					System.out.println(car.getCarPrice());
					System.out.println(car.getCarColor());
				}
			}break;
		}
	}
	}
}
