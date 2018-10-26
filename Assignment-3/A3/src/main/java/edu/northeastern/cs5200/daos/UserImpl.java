package edu.northeastern.cs5200.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import edu.northeastern.cs5200.Connection;
import edu.northeastern.cs5200.models.User;
import edu.northeastern.cs5200.models.User;

public class UserImpl {
	public static User insertUser (User user)
	{
		String INSERT_DEVELOPER = "INSERT INTO user(id, user_key) VALUES (?,?) ";
		String INSERT_PERSON = "INSERT INTO person (id,firstname,lastname, username, password, email, dob) VALUES(?,?,?,?,?,?,?)"; 
		
		try {
			java.sql.Connection connection = Connection.getConnection();
			PreparedStatement insertD = connection.prepareStatement(INSERT_DEVELOPER);
			insertD.setInt(1,user.getId()); 
			insertD.setString(2, user.getUser_key());
			insertD.executeUpdate(); 
			
			PreparedStatement insertP = connection.prepareStatement(INSERT_PERSON); 
			insertP.setInt(1, user.getId());
			insertP.setString(2, user.getFirstname());
			insertP.setString(3, user.getLastname());
			insertP.setString(4, user.getUsername());
			insertP.setString(5, user.getPassword());
			insertP.setString(6, user.getEmail());
			insertP.setDate(7, (java.sql.Date) user.getDob()); 
			insertP.executeUpdate(); 
			
			return new  User(user.getId(), user.getFirstname(), user.getLastname(),user.getUsername(), user.getPassword(), user.getUser_key(), null, null, null, false, INSERT_PERSON); 
			

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return null;
		
	}
	private final static String FIND_ALL_userS = "SELECT * FROM person JOIN user ON user.id = person.id"; 
	public static Collection<User> findAllUsers() {
		Collection<User> users = new ArrayList<User>(); 
		try {
			java.sql.Connection connection = Connection.getConnection();
			Statement statement = connection.createStatement(); 
			
			ResultSet results = statement.executeQuery(FIND_ALL_userS);
			
			while(results.next())
			{
				int id = results.getInt("id"); 
				String firstname = results.getString("firstname");
				String lastname = results.getString("lastname"); 
				String username = results.getString("username"); 
				String password = results.getString("password"); 
				String email = results.getString("email"); 
				Date dob = results.getDate("dob"); 
				String user_key = results.getString("user_key");
				User user = new User(id, firstname, lastname, user_key, user_key); 
				users.add(user); 
		
			}
			results.close(); 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		return users; 
	}
	
	public static User finduserByID(int id)
	{
		String FIND_BY_ID = "SELECT * FROM person JOIN user ON person.id = user.id WHERE person.id = "+id;
		
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
					String user_key = results.getString("user_key");
					User user = new User(id1, firstname, lastname, user_key, user_key); 
					return user; 
					
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
	public static User findUserByUsername(String username)

	{
		String FIND_BY_USERNAME = "SELECT * FROM person JOIN user ON person.id = user.id WHERE person.username = \""+username+"\"";
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
					String user_key = results.getString("user_key");
					User user = new User(id, firstname, lastname, username, password, user_key, dob); 
					return user; 
					
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
	public static User findUserByCredentials(String username, String password)
	{
		String FIND_BY_CRED = "SELECT * FROM person JOIN user ON person.id = user.id WHERE person.username = \""+username+ "\" AND person.password = \""+password+"\""; 
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
					String user_key = results.getString("user_key");
					User user = new User(id, firstname, lastname, user_key, user_key); 
					return user; 
					
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
	public static int updateUser(int userId, User user)
	{
		String UPDATE = "UPDATE person p JOIN user d ON p.id = d.id SET p.firstname = \""+ user.getFirstname()+"\", p.lastname = \""+user.getLastname()+ "\" , p.username = \""+user.getUsername()+"\", p.password = \""+
				user.getPassword()+ "\", p.email = \""+user.getEmail()+ "\", d.user_key= \""+user.getUser_key() +"\" WHERE d.id="+userId; 
		
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
		return userId; 
		
		
	}
	
	public static int deleteUser(int userId)
	{
		String DELETE = "DELETE person, user FROM person JOIN user on user.id=person.id WHERE person.id="+userId; 
		System.out.println(DELETE); 
		try {
			java.sql.Connection connection = Connection.getConnection();
			PreparedStatement delete = connection.prepareStatement(DELETE); 
			delete.executeUpdate(); 
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return userId;
	}
	
}
