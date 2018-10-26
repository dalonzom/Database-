package edu.northeastern.cs5200.daos;

import edu.northeastern.cs5200.models.Person;
import edu.northeastern.cs5200.models.Phone;

public class PhoneDAO {

	private static PhoneDAO instance = null; 
	private PhoneDAO() {};  
	public static PhoneDAO getInstance()
	{
		if(instance == null) {
			instance = new PhoneDAO(); 
		}
		return instance; 
	}
	public static void insertPhone(Phone phone, int personId)
	{
		PhoneImpl.insertPhone(phone, personId); 
		
	}
}
