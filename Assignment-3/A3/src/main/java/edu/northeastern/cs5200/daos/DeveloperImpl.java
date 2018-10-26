package edu.northeastern.cs5200.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.springframework.cglib.core.CollectionUtils;

import edu.northeastern.cs5200.Connection;
import edu.northeastern.cs5200.models.Address;
import edu.northeastern.cs5200.models.Developer;
import edu.northeastern.cs5200.models.Phone;
import edu.northeastern.cs5200.daos.DeveloperDAO;
public class DeveloperImpl {
	
	public static Developer insertDeveloper (Developer developer)
	{
		String INSERT_DEVELOPER = "INSERT INTO developer(id, developer_key) VALUES (?,?) ";
		String INSERT_PERSON = "INSERT INTO person (id,firstname,lastname, username, password, email, dob) VALUES(?,?,?,?,?,?,?)"; 
		String INSERT_PHONE = "INSERT INTO phone(phone, primary_number, person_id) VALUES (?,?,?)"; 
		String INSERT_ADD = "INSERT INTO address(street1, street2,city,state,zip,primary_address,person_id) VALUES (?,?,?,?,?,?,?)"; 
		
		try {
			java.sql.Connection connection = Connection.getConnection();
			PreparedStatement insertD = connection.prepareStatement(INSERT_DEVELOPER);
			insertD.setInt(1,developer.getId()); 
			insertD.setString(2, developer.getDeveloper_key());
			insertD.executeUpdate(); 
			
			PreparedStatement insertP = connection.prepareStatement(INSERT_PERSON); 
			insertP.setInt(1, developer.getId());
			insertP.setString(2, developer.getFirstname());
			insertP.setString(3, developer.getLastname());
			insertP.setString(4, developer.getUsername());
			insertP.setString(5, developer.getPassword());
			insertP.setString(6, developer.getEmail());
			insertP.setDate(7, (java.sql.Date) developer.getDob()); 
			insertP.executeUpdate(); 
			Collection<Phone> phones = new ArrayList<Phone>();
			phones = developer.getPhone_number(); 
			for (Phone phone : phones)
			{
				PreparedStatement insertPhone = connection.prepareStatement(INSERT_PHONE);
				insertPhone.setString(1, phone.getPhone());
				insertPhone.setBoolean(2, phone.isPrimary_number());
				insertPhone.setInt(3, developer.getId()); 
				insertPhone.executeUpdate(); 
			}
			Collection<Address> addresses = new ArrayList<Address>(); 
			addresses = developer.getAddress(); 
			for (Address address : addresses)
			{
				PreparedStatement insertA = connection.prepareStatement(INSERT_ADD); 
				insertA.setString(1, address.getStreet1()); 
				insertA.setString(2, address.getStreet2());
				insertA.setString(3, address.getCity()); 
				insertA.setString(4, address.getState());
				insertA.setString(5, address.getZip()); 
				insertA.setBoolean(6, address.isPrimary_address());
				insertA.setInt(7, developer.getId());
				insertA.executeUpdate(); 
			}
			return new  Developer(developer.getId(), developer.getFirstname(), developer.getLastname(),developer.getUsername(), developer.getPassword(), developer.getDeveloper_key(), null, null, null, INSERT_PERSON); 
			

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return null;
		
	}
	private final static String FIND_ALL_DEVELOPERS = "SELECT * FROM person JOIN developer ON developer.id = person.id"; 
	public static Collection<Developer> findAllDevelopers() {
		Collection<Developer> developers = new ArrayList<Developer>(); 
		try {
			java.sql.Connection connection = Connection.getConnection();
			Statement statement = connection.createStatement(); 
			
			ResultSet results = statement.executeQuery(FIND_ALL_DEVELOPERS);
			
			while(results.next())
			{
				int id = results.getInt("id"); 
				String firstname = results.getString("firstname");
				String lastname = results.getString("lastname"); 
				String username = results.getString("username"); 
				String password = results.getString("password"); 
				String email = results.getString("email"); 
				Date dob = results.getDate("dob"); 
				String developer_key = results.getString("developer_key");
				Developer developer = new Developer(id, firstname, lastname, developer_key); 
				developers.add(developer); 
		
			}
			results.close(); 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		return developers; 
	}
	
	public static Developer findDeveloperByID(int id)
	{
		String FIND_BY_ID = "SELECT * FROM person JOIN developer ON person.id = developer.id WHERE person.id = "+id;
		
		ResultSet results;
		try {
			
			java.sql.Connection connection;
			
			try {
				connection = Connection.getConnection();
				PreparedStatement findID = connection.prepareStatement(FIND_BY_ID);
				results = findID.executeQuery();
				while(results.next())
				{
					int id1 = results.getInt("id"); 
					String firstname = results.getString("firstname");
					String lastname = results.getString("lastname"); 
					String username = results.getString("username"); 
					String password = results.getString("password"); 
					String email = results.getString("email"); 
					Date dob = results.getDate("dob"); 
					String developer_key = results.getString("developer_key");
					Developer developer = new Developer(id1, firstname, lastname, developer_key); 
					return developer; 
					
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return null; 
		
	}
	public static Developer findDeveloperByUsername(String username)

	{
		String FIND_BY_USERNAME = "SELECT * FROM person JOIN developer ON person.id = developer.id WHERE person.username = \""+username+"\"";
		ResultSet results;
		try {
			
			java.sql.Connection connection;
			
			try {
				connection = Connection.getConnection();
				PreparedStatement findName = connection.prepareStatement(FIND_BY_USERNAME);
				results = findName.executeQuery();
				while(results.next())
				{
					int id = results.getInt("id"); 
					String firstname = results.getString("firstname");
					String lastname = results.getString("lastname"); 
					String username1 = results.getString("username"); 
					String password = results.getString("password"); 
					String email = results.getString("email"); 
					Date dob = results.getDate("dob"); 
					String developer_key = results.getString("developer_key");
					Developer developer = new Developer(id, firstname, lastname, username, password, developer_key, dob); 
					return developer; 
					
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return null; 
		
	}
	public static Developer findDeveloperByCredentials(String username, String password)
	{
		String FIND_BY_CRED = "SELECT * FROM person JOIN developer ON person.id = developer.id WHERE person.username = \""+username+ "\" AND person.password = \""+password+"\""; 
		ResultSet results;
		try {
			
			java.sql.Connection connection;
			
			try {
				connection = Connection.getConnection();
				PreparedStatement findName = connection.prepareStatement(FIND_BY_CRED);
				results = findName.executeQuery();
				while(results.next())
				{
					int id = results.getInt("id"); 
					String firstname = results.getString("firstname");
					String lastname = results.getString("lastname"); 
					String username1 = results.getString("username"); 
					String password1 = results.getString("password"); 
					String email = results.getString("email"); 
					Date dob = results.getDate("dob"); 
					String developer_key = results.getString("developer_key");
					Developer developer = new Developer(id, firstname, lastname, developer_key); 
					return developer; 
					
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return null; 
		
	}
	public static int updateDeveloper(int developerId, Developer developer)
	{
		String UPDATE = "UPDATE person p JOIN developer d ON p.id = d.id SET p.firstname = \""+ developer.getFirstname()+"\", p.lastname = \""+developer.getLastname()+ "\" , p.username = \""+developer.getUsername()+"\", p.password = \""+
				developer.getPassword()+ "\", p.email = \""+developer.getEmail()+ "\", d.developer_key= \""+developer.getDeveloper_key() +"\" WHERE d.id="+developerId; 
		Collection<Phone> phones = new ArrayList<Phone>();
		phones = developer.getPhone_number(); 
		java.sql.Connection connection;	
	if(phones == null)
	{
		String DELETE_PHONES = "DELETE FROM phone WHERE person_id="+developerId;

		try {
			connection = Connection.getConnection();
			PreparedStatement delete = connection.prepareStatement(DELETE_PHONES); 
			delete.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 
	else
		{
			for(Phone phone: phones)
			{
				String UPDATE_PHONE = "UPDATE phone p SET phone= \" "+phone.getPhone()+" \", primary_number="+phone.isPrimary_number()+ " WHERE  person_id=\""+developerId+ "\" AND primary_number="+phone.isPrimary_number();  

				try {
					connection = Connection.getConnection();
					PreparedStatement findPhone;
					findPhone = connection.prepareStatement(UPDATE_PHONE);
					int results = findPhone.executeUpdate();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
		}

		
Collection<Address> addresses = new ArrayList<Address>(); 
addresses = developer.getAddress(); 
if(addresses == null)
{
	String DELETE_ADD = "DELETE FROM address WHERE person_id="+developerId; 

	try {
		connection = Connection.getConnection();
		PreparedStatement delete = connection.prepareStatement(DELETE_ADD); 
		delete.executeUpdate();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
else 
{
	for(Address address: addresses)
	{
		String UPDATE_ADD = "UPDATE address SET street1= \""+address.getStreet1()
			+"\", street2= \" "+address.getStreet2()+"\", city= \" "+address.getCity()+" \", state= \""+address.getState()+" \", zip= \""+address.getZip()+
			" \" WHERE person_id="+developerId+" AND primary_address="+address.isPrimary_address(); 
			
;
		try {
			connection = Connection.getConnection();
			PreparedStatement findPhone;
			findPhone = connection.prepareStatement(UPDATE_ADD);
			int results = findPhone.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
	
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
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		
		return developerId; 
		
		
	}
	
	public static int deleteDeveloper(int developerId)
	{
		String DELETE = "DELETE person, developer FROM person JOIN developer on developer.id=person.id WHERE person.id="+developerId; 
		String DELETE_PHONE = "DELETE phone WHERE person_id="+developerId; 
		String DELETE_ADD = "DELETE address WHERE person_id="+developerId; 

		try {
			java.sql.Connection connection = Connection.getConnection();
			PreparedStatement delete = connection.prepareStatement(DELETE); 
			delete.executeUpdate(); 
			PreparedStatement delete1 = connection.prepareStatement(DELETE_PHONE); 
			delete1.executeUpdate(); 
			
			PreparedStatement delete2 = connection.prepareStatement(DELETE_ADD); 
			delete2.executeUpdate(); 
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return developerId;
	}
	
}

