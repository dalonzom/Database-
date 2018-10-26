package edu.northeastern.cs5200.daos;

import java.util.Collection;

import edu.northeastern.cs5200.models.User;

public class UserDAO {
	private static UserDAO instance = null; 
	private UserDAO() {};  
	public static UserDAO getInstance()
	{
		if(instance == null) {
			instance = new UserDAO(); 
		}
		return instance; 
		
	}
  
	public static User createUser(User user)
	{
		return UserImpl.insertUser(user); 
	}
	public static Collection<User> findAllUsers() 
	{
		return UserImpl.findAllUsers();
	}
	
	public static User findUserByID(int id)
	{
		return UserImpl.finduserByID(id); 
	}
	public static User findUserByUsername(String username)
	{
		return UserImpl.findUserByUsername(username);
	}
	public static User findUserByCredentials(String username, String password)
	{
		return UserImpl.findUserByCredentials(username, password);
	}
	
	public static int updateUser(int userId, User user)
	{
		return UserImpl.updateUser(userId, user);
	}
	public static int deleteUser(int userId)
	{
		return UserImpl.deleteUser(userId); 
	}
	
	

}
