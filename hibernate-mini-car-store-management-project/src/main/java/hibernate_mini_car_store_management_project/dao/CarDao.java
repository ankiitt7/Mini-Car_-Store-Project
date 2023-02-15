package hibernate_mini_car_store_management_project.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hibernate_mini_car_store_management_project.dto.Car;

public class CarDao {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("ankit");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
//	We can insert Cars but it will not be a foreign key in person table.
	public void insertCars(List<Car> Cars) 
	{
		entityTransaction.begin();
		for (Car car : Cars) 
		{
			entityManager.persist(car);
		}
		entityTransaction.commit();
		System.out.println("Data Inserted");
	}
	public void updateCars(int carId,Car car)
	{
		
		Car car2=entityManager.find(Car.class,carId);
		if((car.getCarName()!=null) && (car.getCarPrice()!=0) && (car.getCarModel()!=0) && (car.getCarColor()!=null) )
		{
			car2.setCarName(car.getCarName());
			car2.setCarPrice(car.getCarPrice());
			car2.setCarModel(car.getCarModel());
			car2.setCarColor(car.getCarColor());
			entityTransaction.begin();
			entityManager.merge(car2);
			entityTransaction.commit();
			System.out.println("Data Updated");
		}
		else if(car.getCarName()!=null)
		{
			car2.setCarName(car.getCarName());
			entityTransaction.begin();
			entityManager.merge(car2);
			entityTransaction.commit();
			System.out.println("Data Updated");
		}
		else if(car.getCarPrice()!=0)
		{
			car2.setCarPrice(car.getCarPrice());
			entityTransaction.begin();
			entityManager.merge(car2);
			entityTransaction.commit();
			System.out.println("Data Updated");
		}
		else if(car.getCarModel()!=0)
		{
			car2.setCarModel(car.getCarModel());
			entityTransaction.begin();
			entityManager.merge(car2);
			entityTransaction.commit();
			System.out.println("Data Updated");
		}
		else if(car.getCarColor()!=null)
		{
			car2.setCarColor(car.getCarColor());
			entityTransaction.begin();
			entityManager.merge(car2);
			entityTransaction.commit();
			System.out.println("Data Updated");
		}
		else
		{
			System.out.println("Enter correct id");
		}
		
	}
//	We can not delete cars which is foreign key in person table
	public void deleteCar(int carId)
	{
		Car car=entityManager.find(Car.class, carId);
		if(car!=null)
		{
			entityTransaction.begin();
			entityManager.remove(car);
			entityTransaction.commit();
			System.out.println("Car deleted");
		}
		else
		{
			System.out.println("Insert correct Car Id");
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Car> displayCar()
	{
		String select="select c from Car c";
		Query query=entityManager.createQuery(select);
		return query.getResultList();
	}

}
