package edu.northeastern.cs5200.daos; 

import edu.northeastern.cs5200.models.Developer;
import edu.northeastern.cs5200.models.Person; 

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import edu.northeastern.cs5200.Connection; 

public class DeveloperDAO {
	private static DeveloperDAO instance = null; 
	private DeveloperDAO() {};  
	public static DeveloperDAO getInstance()
	{
		if(instance == null) {
			instance = new DeveloperDAO(); 
		}
		return instance; 
		
	}
  
	public static Developer createDeveloper(Developer developer)
	{
		return DeveloperImpl.insertDeveloper(developer); 
	}
	public static Collection<Developer> findAllDevelopers() 
	{
		return DeveloperImpl.findAllDevelopers();
	}
	
	public static Developer findDeveloperByID(int id)
	{
		return DeveloperImpl.findDeveloperByID(id); 
	}
	public static Developer findDeveloperByUsername(String username)
	{
		return DeveloperImpl.findDeveloperByUsername(username);
	}
	public static Developer findDeveloperByCredentials(String username, String password)
	{
		return DeveloperImpl.findDeveloperByCredentials(username, password);
	}
	
	public static int updateDeveloper(int developerId, Developer developer)
	{
		return DeveloperImpl.updateDeveloper(developerId, developer);
	}
	public static int deleteDeveloper(int developerId)
	{
		return DeveloperImpl.deleteDeveloper(developerId); 
	}
	
	
}
