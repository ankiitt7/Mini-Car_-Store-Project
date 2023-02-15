package hibernate_mini_car_store_management_project.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hibernate_mini_car_store_management_project.dto.Car;
import hibernate_mini_car_store_management_project.dto.CarBooking;
import hibernate_mini_car_store_management_project.dto.Person;

public class CarBookingDao {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("ankit");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	public void insertCarBooking(CarBooking carBooking,int personId,int carId)
	{
		entityTransaction.begin();
		Person person=entityManager.find(Person.class, personId);
		if(person!=null)
		{
			entityManager.persist(person);;
		}
		else
		{
			System.out.println("This id is not present");
		}
		Car car=entityManager.find(Car.class, carId);
		if(car!=null)
		{
		entityManager.persist(car);
		}
		else
		{
			System.out.println("Enter correct Car id");
		}
		entityManager.persist(carBooking);
		entityTransaction.commit();
		System.out.println("Data Inserted");
	}
	public Person getByPersonId(int personId)
	{
		Person person=entityManager.find(Person.class, personId);
		if(person!=null)
		{
			return person;
		}
		else
		{
			return null;
		}
	}
	public Car getByCarId(int carId)
	{
		Car car=entityManager.find(Car.class, carId);
		if(car!=null)
		{
			return car;
		}
		else
		{
			return null;
		}
	}
	public void deleteCarBooking(int carBookingId)
	{
		CarBooking carBooking=entityManager.find(CarBooking.class, carBookingId);
		entityTransaction.begin();
		entityManager.remove(carBooking);
		entityTransaction.commit();
		System.out.println("Data Deleted");
	}
	@SuppressWarnings("unchecked")
	public List<CarBooking> displayCarBooking()
	{
		String select="select c from CarBooking c";
		Query query=entityManager.createQuery(select);
		return query.getResultList();
	}
}
