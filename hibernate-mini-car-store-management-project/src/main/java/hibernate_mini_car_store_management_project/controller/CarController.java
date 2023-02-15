package hibernate_mini_car_store_management_project.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import hibernate_mini_car_store_management_project.dto.Car;
import hibernate_mini_car_store_management_project.service.CarService;

public class CarController {
	public static void main(String[] args) 
	{
		Scanner scanner=new Scanner(System.in);		
		CarService carService=new CarService();
	while(true)
	{
		System.out.println("1.Insert/n2.Update/n3.Delete/n4.Display/n5.Exit");
		System.out.println("Choose your choice");
		int ch=scanner.nextInt();
		switch(ch)
		{
		case 1:
			{
				System.out.println("Enter no. of cars");
				int size=scanner.nextInt();
				List<Car> cars=new ArrayList<Car>();
				for(int i=1;i<=size;i++)
				{
				Car car=new Car(); 
				System.out.println("Enter car Id");
				car.setCarId(scanner.nextInt());
				System.out.println("Enter car name");
				car.setCarName(scanner.next());
				System.out.println("Enter car color");
				car.setCarColor(scanner.next());
				System.out.println("Enter car price");
				car.setCarPrice(scanner.nextDouble());
				System.out.println("Enter car model");
				car.setCarModel(scanner.nextInt());
				cars.add(car);
				}
				carService.insertCars(cars);
			}break;
		case 2:
			{
				System.out.println("1.Update_Car/n2.Update_Car_Name/n3.Update_Car_Color/n4.Update_Car_Price/n5.Upadte_Car_Model");
				System.out.println("Choose your choice");
				int choice=scanner.nextInt();
				switch(choice)
				{
				case 1:
					{
						Car car=new Car(); 
						System.out.println("Enter car Id to update");
						int carId=scanner.nextInt();
						System.out.println("Enter car name");
						car.setCarName(scanner.next());
						System.out.println("Enter car color");
						car.setCarColor(scanner.next());
						System.out.println("Enter car price");
						car.setCarPrice(scanner.nextDouble());
						System.out.println("Enter car model");
						car.setCarModel(scanner.nextInt());
						carService.updateCars(carId, car);
					}break;
				case 2:
					{
						Car car=new Car(); 
						System.out.println("Enter car Id to update Name");
						int carId=scanner.nextInt();
						System.out.println("Enter car name");
						carService.updateCars(carId, car);
					}break;
				case 3:
					{
						Car car=new Car(); 
						System.out.println("Enter car Id to update Color");
						int carId=scanner.nextInt();
						System.out.println("Enter car color");
						car.setCarColor(scanner.next());
						carService.updateCars(carId, car);
					}break;
				case 4:
					{
						Car car=new Car(); 
						System.out.println("Enter car Id to update price");
						int carId=scanner.nextInt();
						System.out.println("Enter car price");
						car.setCarPrice(scanner.nextDouble());
						carService.updateCars(carId, car);
					}break;
				case 5:
					{
						Car car=new Car(); 
						System.out.println("Enter car Id to update model");
						int carId=scanner.nextInt();
						System.out.println("Enter car model");
						car.setCarModel(scanner.nextInt());
						carService.updateCars(carId, car);
					}break;
				}
			}break;
		case 3:
			{
				System.out.println("Enter Car id to Delete");
				int carId=scanner.nextInt();
				carService.deleteCar(carId);
			}break;
		case 4:
			{
				List<Car> cars=carService.displayCar();
				for (Car car : cars) 
				{
					System.out.println(car);
				}
			}break;
		}
	}
	}
}
