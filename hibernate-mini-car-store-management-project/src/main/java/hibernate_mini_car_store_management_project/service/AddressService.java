package hibernate_mini_car_store_management_project.service;

import java.util.List;

import hibernate_mini_car_store_management_project.dao.AddressDao;
import hibernate_mini_car_store_management_project.dto.Address;

public class AddressService {
AddressDao addressDao=new AddressDao();
	
	public void insertAddress(Address address)
	{
		addressDao.insertAddress(address);
	}
	public void updateAddress(int addressId,Address address)
	{
		addressDao.updateAddress(addressId, address);
	}
	public void deleteAddress(int addressId)
	{
		addressDao.deleteAddress(addressId);
	}
	public List<Address> displayAddress()
	{
		return addressDao.displayAddress();
	}
}
