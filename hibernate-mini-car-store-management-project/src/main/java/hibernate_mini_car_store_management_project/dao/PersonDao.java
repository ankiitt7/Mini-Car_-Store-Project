package hibernate_mini_car_store_management_project.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hibernate_mini_car_store_management_project.dto.Address;
import hibernate_mini_car_store_management_project.dto.Car;
import hibernate_mini_car_store_management_project.dto.Pan;
import hibernate_mini_car_store_management_project.dto.Person;

public class PersonDao {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("ankit");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	public void insertPesron(Person person,List<Car> cars,Pan pan,Address address)
	{
		entityTransaction.begin();
		entityManager.persist(person);
		for (Car car : cars) 
		{
			entityManager.persist(car);
		}
		entityManager.persist(address);
		entityManager.persist(pan);
		entityTransaction.commit();
		System.out.println("Data Inserted Succesfully");
	}
	public void updatePerson(int personId,Person person)
	{
		Person person2=entityManager.find(Person.class, personId);
		
		if((person.getPersonName()!=null) && (person.getPersomEmail()!=null) && (person.getPersonPhone()!=0))
		{
			person2.setPersonName(person.getPersonName());
			person2.setPersomEmail(person.getPersomEmail());
			person2.setPersonPhone(person.getPersonPhone());
			entityTransaction.begin();
			entityManager.merge(person2);
			System.out.println("Data Updated");
			entityTransaction.commit();
		}
		else if(person.getPersonName()!=null)
		{
			person2.setPersonName(person.getPersonName());
			entityTransaction.begin();
			entityManager.merge(person2);
			System.out.println("Data Updated");
			entityTransaction.commit();
		}
		else if(person.getPersomEmail()!=null)
		{
			person2.setPersomEmail(person.getPersomEmail());
			entityTransaction.begin();
			entityManager.merge(person2);
			System.out.println("Data Updated");
			entityTransaction.commit();
		}
		else if(person.getPersonPhone()!=0)
		{
			person2.setPersonPhone(person.getPersonPhone());
			entityTransaction.begin();
			entityManager.merge(person2);
			System.out.println("Data Updated");
			entityTransaction.commit();
		}
		
		else
		{
			System.out.println("Enter correct person Id");
		}
		
	}
	public void deletePerson(int personId)
	{
		Person person=entityManager.find(Person.class, personId);
		List<Car> cars=person.getCar();
		Address	address=person.getAddress();
		Pan pan=person.getPan();
		entityTransaction.begin();
		for (Car car : cars) 
		{
			entityManager.remove(car);
		}
		entityManager.remove(address);
		entityManager.remove(pan);
		entityManager.remove(person);
		entityTransaction.commit();	
	}
	@SuppressWarnings("unchecked")
	public List<Person> displayPerson()
	{
		String select =	"select p from Person p";
		Query query=entityManager.createQuery(select);
		return query.getResultList();
	}
	
}
