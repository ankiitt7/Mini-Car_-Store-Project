package hibernate_mini_car_store_management_project.service;

import java.util.List;

import hibernate_mini_car_store_management_project.dao.PersonDao;
import hibernate_mini_car_store_management_project.dto.Address;
import hibernate_mini_car_store_management_project.dto.Car;
import hibernate_mini_car_store_management_project.dto.Pan;
import hibernate_mini_car_store_management_project.dto.Person;

public class PersonService {
	PersonDao dao=new PersonDao();
	public void insertPesron(Person person,List<Car> cars,Pan pan,Address address)
	{
		dao.insertPesron(person, cars, pan, address);
	}
	public void updatePerson(int personId,Person person)
	{
		dao.updatePerson(personId, person);
	}
	public void deletePerson(int personId)
	{
		dao.deletePerson(personId);
	}
	public List<Person> displayPerson()
	{
		return	dao.displayPerson();
	}
}
