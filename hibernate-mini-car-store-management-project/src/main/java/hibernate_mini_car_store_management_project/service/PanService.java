package hibernate_mini_car_store_management_project.service;

import java.util.List;

import hibernate_mini_car_store_management_project.dao.PanDao;
import hibernate_mini_car_store_management_project.dto.Address;
import hibernate_mini_car_store_management_project.dto.Pan;

public class PanService {
	PanDao panDao=new PanDao();
	public void insertPan(Pan pan,Address address)
	{
		panDao.insertPan(pan,address);
	}
	public void updatePan(int panId,Pan pan)
	{
		panDao.updatePan(panId, pan);
	}
	public void deletePan(int panId)
	{
		panDao.deletePan(panId);
	}
	public List<Pan> displayPan()
	{
		return panDao.displayPan();
	}			
}
