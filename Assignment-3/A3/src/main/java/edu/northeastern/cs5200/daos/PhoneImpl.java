package edu.northeastern.cs5200.daos;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import edu.northeastern.cs5200.Connection;
import edu.northeastern.cs5200.models.Person;
import edu.northeastern.cs5200.models.Phone;

public class PhoneImpl {
	
	public static void insertPhone (Phone phone, int personId)
	{
		String INSERT_DEVELOPER = "INSERT INTO phone(id, phone, primary_number,person_id) VALUES (?,?,?,?) ";
		
		try {
			java.sql.Connection connection = Connection.getConnection();
			PreparedStatement insertD = connection.prepareStatement(INSERT_DEVELOPER);
			insertD.setInt(1,phone.getId()); 
			insertD.setString(2, phone.getPhone());
			insertD.setBoolean(3, phone.isPrimary_number());
			insertD.setInt(4, personId); 
			insertD.executeUpdate(); 
			
			
			//return new  Phone(phone.getPhone(), phone.isPrimary_number(), personId); 
			

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	//	return null;
		
	}
 
	public static void updatePrimaryPhone(Person person, Phone phone)
	{
		String UPDATE = "UPDATE phone p  SET phone= \""+phone.getPhone()+" \" WHERE person_id="+person.getId(); 

		java.sql.Connection connection;
		try {
			connection = Connection.getConnection();
			PreparedStatement findName;
			try {
				findName = connection.prepareStatement(UPDATE);
				int results = findName.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		

	}
	
}
