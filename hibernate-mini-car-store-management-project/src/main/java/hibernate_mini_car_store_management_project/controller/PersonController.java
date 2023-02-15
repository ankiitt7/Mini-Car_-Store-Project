package hibernate_mini_car_store_management_project.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



import hibernate_mini_car_store_management_project.dto.Address;
import hibernate_mini_car_store_management_project.dto.Car;
import hibernate_mini_car_store_management_project.dto.Pan;
import hibernate_mini_car_store_management_project.dto.Person;
import hibernate_mini_car_store_management_project.service.PersonService;

public class PersonController {
	public static void main(String[] args) 
	{
			Scanner scanner=new Scanner(System.in);		
			PersonService personService=new PersonService();
	while(true)
	{
			System.out.println("1.Insert/n2.Update/n3.Delete/n4.Display/n5.Exit");
			System.out.println("Choose your choice");
			int ch=scanner.nextInt();
			switch(ch)
			{
			case 1:
				{
					Person person=new Person();
					System.out.println("Enter person Id");
					person.setPersonid(scanner.nextInt());
					System.out.println("Enter person Name");
					person.setPersonName(scanner.next());
					System.out.println("Enter person phone");
					person.setPersonPhone(scanner.nextLong());
					System.out.println("Enter person Email");
					person.setPersomEmail(scanner.next());
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
					person.setCar(cars);
					Address address =new Address();
					System.out.println("Enter address id ");
					address.setAdressId(scanner.nextInt());
					System.out.println("Enter city name ");
					address.setCityName(scanner.next());
					System.out.println("Enter town no.");
					address.setTownNumber(scanner.next());
					System.out.println("Enter street no. ");
					address.setStreetNumber(scanner.next());
					System.out.println("Enter flat no. ");
					address.setFlatNumber(scanner.next());
					person.setAddress(address);
					Pan pan=new Pan();
					System.out.println("Enter Pan Id");
					pan.setPanId(scanner.nextInt());
					System.out.println("Enter Pan Number");
					pan.setPanNumber(scanner.next());
					System.out.println("Enter the Gender");
					pan.setGender(scanner.next());
					System.out.println("Enter the DOB ");
					SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
					java.util.Date date;
					try 
					{
						date = simpleDateFormat.parse(scanner.next());
						pan.setDob(date);
					} catch (ParseException e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					person.setPan(pan);
					pan.setAddress(address);
					personService.insertPesron(person, cars, pan, address);
				}break;
			case 2:
				{
					System.out.println("1.Update_Person/n2.Update_Person_Name/n3.Update_Person_Email/n4.Update_Person_Phone");
					System.out.println("Choose your choice");
					int choice=scanner.nextInt();
					switch(choice)
					{
					case 1:
						{
							Person person=new Person();
							System.out.println("Eneter Person id to update");	
							int personId=scanner.nextInt();
							System.out.println("Enter person Name");
							person.setPersonName(scanner.next());
							System.out.println("Enter person phone");
							person.setPersonPhone(scanner.nextLong());
							System.out.println("Enter person Email");
							person.setPersomEmail(scanner.next());	
							personService.updatePerson(personId, person);
						}break;
					case 2:
						{
							Person person=new Person();
							System.out.println("Eneter Person id to update");	
							int personId=scanner.nextInt();
							System.out.println("Enter person Name");
							person.setPersonName(scanner.next());
							personService.updatePerson(personId, person);
						}break;
					case 3:
						{
							System.out.println("Eneter Person id to update");	
							int personId=scanner.nextInt();
							Person person=new Person();
							System.out.println("Enter person Email");
							person.setPersomEmail(scanner.next());
							personService.updatePerson(personId, person);
						}break;
					case 4:
						{
							System.out.println("Eneter Person id to update");	
							int personId=scanner.nextInt();
							Person person=new Person();
							System.out.println("Enter person phone");
							person.setPersonPhone(scanner.nextLong());
							personService.updatePerson(personId, person);
						}break;
					}			
				}break;
			case 3:
				{
					System.out.println("Eneter person id to delete");
					int personId=scanner.nextInt();
					personService.deletePerson(personId);
				}break;
			case 4:
				{
				List<Person> persons=personService.displayPerson();
				for (Person person : persons) 
				{
					System.out.println(person);
					List<Car> cars=person.getCar();
					for (Car car : cars) 
					{
						System.out.println(car);
					}
					Address address=person.getAddress();
					System.out.println(address);
					Pan pan=person.getPan();
					System.out.println(pan);
				}
				}break;
			}
	}
	}
}
