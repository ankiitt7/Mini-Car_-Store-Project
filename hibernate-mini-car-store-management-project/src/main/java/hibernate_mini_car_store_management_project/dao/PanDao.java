package hibernate_mini_car_store_management_project.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hibernate_mini_car_store_management_project.dto.Address;
import hibernate_mini_car_store_management_project.dto.Pan;

public class PanDao {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("ankit");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
//	We can insert pan and address with pan but it will not be foreign key in person table.
	public void insertPan(Pan pan,Address address)
	{
		entityTransaction.begin();
		entityManager.persist(pan);
		entityManager.persist(address);
		entityTransaction.commit();
		System.out.println("Data Inserted");
	}
	public void updatePan(int panId,Pan pan)
	{
		Pan pan2=entityManager.find(Pan.class, panId);
		
		if((pan.getPanNumber()!=null) && (pan.getGender()!=null) && (pan.getDob()!=null))
		{
			pan2.setPanNumber(pan.getPanNumber());
			pan2.setGender(pan.getGender());
			pan2.setDob(pan.getDob());
			entityTransaction.begin();
			entityManager.merge(pan2);
			entityTransaction.commit();
			System.out.println("Data Updated");
		}
		else if(pan.getPanNumber()!=null)
		{
			pan2.setPanNumber(pan.getPanNumber());
			entityTransaction.begin();
			entityManager.merge(pan2);
			entityTransaction.commit();
			System.out.println("Data Updated");
		}
		else if(pan.getGender()!=null)
		{
			pan2.setGender(pan.getGender());
			entityTransaction.begin();
			entityManager.merge(pan2);
			entityTransaction.commit();
			System.out.println("Data Updated");
		}
		else if(pan.getDob()!=null)
		{
			pan2.setDob(pan.getDob());
			entityTransaction.begin();
			entityManager.merge(pan2);
			entityTransaction.commit();
			System.out.println("Data Updated");
		}
		else
		{
			System.out.println("Enter correct pan Id");
		}	
	}
//	We can not delete pan and address with pan which is foreign key of person table.
	public void deletePan(int panId)
	{
		Pan pan=entityManager.find(Pan.class, panId);
		Address address=pan.getAddress();
		entityTransaction.begin();
		entityManager.remove(pan);
		entityManager.remove(address);
		entityTransaction.commit();
		System.out.println("Data Deleted");
	}
	@SuppressWarnings("unchecked")
	public List<Pan> displayPan()
	{
		String select="select p from Pan p ";
		Query query=entityManager.createQuery(select);
		return query.getResultList();
	}
	
}
