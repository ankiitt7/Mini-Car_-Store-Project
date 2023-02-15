package hibernate_mini_car_store_management_project.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hibernate_mini_car_store_management_project.dto.Address;

public class AddressDao {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("ankit");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
//	we can insert but it will not be a foreign key of person table.
	public void insertAddress(Address address)
	{
		entityTransaction.begin();
		entityManager.persist(address);
		entityTransaction.commit();
	}
	public void updateAddress(int addressId,Address address)
	{
		Address address2=entityManager.find(Address.class, addressId);
		
		if(address.getCityName()!=null && address.getTownNumber()!=null && address.getStreetNumber()!=null && address.getFlatNumber()!=null)
		{
			address2.setCityName(address.getCityName());
			address2.setTownNumber(address.getTownNumber());
			address2.setStreetNumber(address.getStreetNumber());
			address2.setFlatNumber(address.getFlatNumber());
			entityTransaction.begin();
			entityManager.merge(address2);
			entityTransaction.commit();
			System.out.println("Data Updated");
		}
		else if(address.getCityName()!=null)
		{
			address2.setCityName(address.getCityName());
			entityTransaction.begin();
			entityManager.merge(address2);
			entityTransaction.commit();
			System.out.println("Data Updated");
		}
		else if(address.getTownNumber()!=null)
		{
			address2.setTownNumber(address.getTownNumber());
			entityTransaction.begin();
			entityManager.merge(address2);
			entityTransaction.commit();
			System.out.println("Data Updated");
		}
		else if(address.getStreetNumber()!=null)
		{
			address2.setStreetNumber(address.getStreetNumber());
			entityTransaction.begin();
			entityManager.merge(address2);
			entityTransaction.commit();
			System.out.println("Data Updated");
		}
		else if(address.getFlatNumber()!=null)
		{
			address2.setFlatNumber(address.getFlatNumber());
			entityTransaction.begin();
			entityManager.merge(address2);
			entityTransaction.commit();
			System.out.println("Data Updated");
		}
		else
		{
			System.out.println("Enter correct Id");
		}
		
	}
//	we can delete only which is not the foreign key of person table.
	public void deleteAddress(int addressId)
	{
		Address address2=entityManager.find(Address.class, addressId);
		entityTransaction.begin();
		entityManager.remove(address2);
		entityTransaction.commit();
		System.out.println("Data Deleted");
	}
	@SuppressWarnings("unchecked")
	public List<Address> displayAddress()
	{
		String select="select a from Address a ";
		Query query=entityManager.createQuery(select);
		return query.getResultList();
	}
}
