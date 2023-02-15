package hibernate_mini_car_store_management_project.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;


import hibernate_mini_car_store_management_project.dto.Address;
import hibernate_mini_car_store_management_project.dto.Pan;
import hibernate_mini_car_store_management_project.service.PanService;

public class PanController {
	public static void main(String[] args) 
	{
		Scanner scanner=new Scanner(System.in);		
		PanService panService=new PanService();
	while(true)
	{
		System.out.println("1.Insert/n2.Update/n3.Delete/n4.Display/n5.Exit");
		System.out.println("Choose your choice");
		int ch=scanner.nextInt();
		switch(ch)
		{
		case 1:
			{
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
					e.printStackTrace();
				}
				pan.setAddress(address);
				panService.insertPan(pan,address);
			}break;
		case 2:
			{
				System.out.println("1.Update_Pan/n2.Update_Pan_Number/n3.Update_Pan_Gender/n4.Update_Pan_DOB");
				System.out.println("Choose your choice");
				int choice=scanner.nextInt();
				switch(choice)
				{
				case 1:
					{
						Pan pan=new Pan();
						System.out.println("Enter Pan Id to update");
						int panId=scanner.nextInt();
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
							e.printStackTrace();
						}
						panService.updatePan(panId, pan);
					}break;
				case 2:
					{
						Pan pan=new Pan();
						System.out.println("Enter Pan Id to update");
						int panId=scanner.nextInt();
						System.out.println("Enter Pan Number");
						pan.setPanNumber(scanner.next());
						panService.updatePan(panId, pan);
					}break;
				case 3:
					{
						Pan pan=new Pan();
						System.out.println("Enter Pan Id to update");
						int panId=scanner.nextInt();
						System.out.println("Enter the Gender");
						pan.setGender(scanner.next());
						panService.updatePan(panId, pan);
					}break;
				case 4:
					{
						Pan pan=new Pan();
						System.out.println("Enter Pan Id to update");
						int panId=scanner.nextInt();
						System.out.println("Enter the DOB ");
						SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
						java.util.Date date;
						try 
						{
							date = simpleDateFormat.parse(scanner.next());
							pan.setDob(date);
						} catch (ParseException e) 
						{
							e.printStackTrace();
						}
						panService.updatePan(panId, pan);
					}break;
				}
			}break;
		case 3:
			{
				System.out.println("Enter pan Id to delete");
				int panId=scanner.nextInt();
				panService.deletePan(panId);
			}break;
		case 4:
			{
				List<Pan> pans=panService.displayPan();
				for (Pan pan : pans) 
				{
					System.out.println(pan);
					Address address=pan.getAddress();
					System.out.println(address);
				}
			}break;
		}
	}
	}
}
