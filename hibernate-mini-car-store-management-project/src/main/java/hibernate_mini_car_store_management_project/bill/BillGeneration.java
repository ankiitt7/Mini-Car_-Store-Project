package hibernate_mini_car_store_management_project.bill;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import hibernate_mini_car_store_management_project.dto.CarBooking;

public class BillGeneration {
	public static void main(String[] args) 
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("ankit");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter CarBookingId to generate Bill");
		int carBookingId=scanner.nextInt();
		CarBooking carBooking=entityManager.find(CarBooking.class, carBookingId);
		try 
		{
			FileWriter fileWritter=new FileWriter("V:\\BillGeneration.txt");
			fileWritter.write("Car Id is : "+carBooking.getCar().getCarId());
			
			fileWritter.write("\nCar Name is: "+carBooking.getCar().getCarName());
			fileWritter.write("\nCar Price is :"+String.valueOf(carBooking.getCar().getCarPrice()));;
			fileWritter.write("\nPerson Name is :"+carBooking.getPerson().getPersonName());
			fileWritter.write("\nPerson Pan No. is :"+carBooking.getPerson().getPan().getPanNumber());
			fileWritter.write("\nPerson Address is : "+carBooking.getPerson().getAddress().getCityName());
			fileWritter.close();	
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		scanner.close();
	}

}
