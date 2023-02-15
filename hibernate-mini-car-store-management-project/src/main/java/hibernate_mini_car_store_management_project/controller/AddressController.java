package hibernate_mini_car_store_management_project.controller;

import java.util.List;
import java.util.Scanner;

import hibernate_mini_car_store_management_project.dto.Address;
import hibernate_mini_car_store_management_project.service.AddressService;

public class AddressController {
	public static void main(String[] args) 
	{
		Scanner scanner=new Scanner(System.in);		
		AddressService addressService=new AddressService();
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
				addressService.insertAddress(address);
			}break;
		case 2:
			{
				System.out.println("1.Update_Address/n2.Update_Address_City/n3.Update_Address_Town_Number/n4.Update_Address_Street_Number/n5.Update_Address_Flat_Number");
				System.out.println("Choose your choice");
				int choice=scanner.nextInt();
				switch(choice)
				{
				case 1:
					{
						Address address =new Address();
						System.out.println("Enter address id to update");
						int addressId=scanner.nextInt();
						System.out.println("Enter city name ");
						address.setCityName(scanner.next());
						System.out.println("Enter town no.");
						address.setTownNumber(scanner.next());
						System.out.println("Enter street no. ");
						address.setStreetNumber(scanner.next());
						System.out.println("Enter flat no. ");
						address.setFlatNumber(scanner.next());
						addressService.updateAddress(addressId,address);
					}break;
				case 2:
					{
						Address address =new Address();
						System.out.println("Enter address id to update");
						int addressId=scanner.nextInt();
						System.out.println("Enter city name ");
						address.setCityName(scanner.next());
						addressService.updateAddress(addressId,address);
					}break;
				case 3:
					{
						Address address =new Address();
						System.out.println("Enter address id to update");
						int addressId=scanner.nextInt();
						System.out.println("Enter town no.");
						address.setTownNumber(scanner.next());
						addressService.updateAddress(addressId,address);
					}break;
				case 4:
					{
						Address address =new Address();
						System.out.println("Enter address id to update");
						int addressId=scanner.nextInt();
						System.out.println("Enter street no. ");
						address.setStreetNumber(scanner.next());
						addressService.updateAddress(addressId,address);
					}break;
				case 5:
					{
						Address address =new Address();
						System.out.println("Enter address id to update ");
						int addressId=scanner.nextInt();
						System.out.println("Enter flat no. ");
						address.setFlatNumber(scanner.next());
						addressService.updateAddress(addressId,address);
					}break;
				}
			}break;
		case 3:
				{
					System.out.println("Enter address id to delete ");
					int addressId=scanner.nextInt();
					addressService.deleteAddress(addressId);
				}break;
		case 4:
				{
					List<Address> addresses=addressService.displayAddress();
					for (Address address : addresses) 
					{
						System.out.println(address);
					}
				}break;
		}
	}
	}
}
