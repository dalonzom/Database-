package edu.northeastern.cs5200.daos;

import edu.northeastern.cs5200.models.Website;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import edu.northeastern.cs5200.Connection;
import edu.northeastern.cs5200.models.Developer;
import edu.northeastern.cs5200.daos.*;

public class WebsiteImpl {
	
	public static void createWebsiteForDeveloper(int developerId, Website website)
	{
		String INSERT_WEBSITE = "INSERT INTO website (created, description, name, updated, visits, developer_id, id) VALUES (?,?,?,?,?,?,?) ";
		
		try {
			java.sql.Connection connection = Connection.getConnection();
			PreparedStatement insertW = connection.prepareStatement(INSERT_WEBSITE);
			insertW.setDate(1, (Date) website.getCreated()); 
			insertW.setString(2, website.getDescription());
			insertW.setString(3, website.getName());
			insertW.setDate(4, (Date) website.getUpdated());
			insertW.setInt(5, website.getVisits());
			insertW.setInt(6, developerId); 
			insertW.setInt(7,  website.getId());
			insertW.executeUpdate(); 

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	
	public static  Collection<Website> findAllWebsites()
	{

		String FIND_ALL = "SELECT * FROM website";
		Collection<Website> websites = new ArrayList<Website>(); 
		ResultSet results;
		try {
			
			java.sql.Connection connection;
			
			try {
				connection = Connection.getConnection();
				PreparedStatement findID = connection.prepareStatement(FIND_ALL);
				results = findID.executeQuery();
				
				while(results.next())
				{
					int id = results.getInt("id"); 
					String name = results.getString("name");
					String description = results.getString("description"); 
					Date created = results.getDate("created"); 
					Date updated= results.getDate("updated"); 
					int visits = results.getInt("visits"); 
					int developer_id = results.getInt("developer_id"); 
					Developer developer = DeveloperImpl.findDeveloperByID(developer_id); 
					Website website = new Website(id, name, description, created, updated, visits,developer); 
					websites.add(website); 
			
				}
				results.close(); 
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return websites; 
		
	}
	
	public static Collection<Website> findWebsitesForDeveloper(int developerId)
	{

		String FIND_BY_ID = "SELECT * FROM website WHERE developer_id="+developerId;
		Collection<Website> websites = new ArrayList<Website>(); 
		ResultSet results;
		try {
			
			java.sql.Connection connection;
			
			try {
				connection = Connection.getConnection();
				PreparedStatement findID = connection.prepareStatement(FIND_BY_ID);
				results = findID.executeQuery();
				
				while(results.next())
				{
					int id = results.getInt("id"); 
					String name = results.getString("name");
					String description = results.getString("description"); 
					Date created = results.getDate("created"); 
					Date updated= results.getDate("updated"); 
					int visits = results.getInt("visits"); 
					int developer_id = results.getInt("developer_id"); 
					Developer developer = DeveloperImpl.findDeveloperByID(developer_id); 
					Website website = new Website(id, name, description, created, updated, visits,developer); 
					websites.add(website); 
			
				}
				results.close(); 
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return websites; 
		
		
	}
	public static Website findWebsiteById(int websiteId)
	{

		String FIND_BY_ID = "SELECT * FROM website WHERE id="+websiteId;
		
		ResultSet results;
		try {
			
			java.sql.Connection connection;
			
			try {
				connection = Connection.getConnection();
				PreparedStatement findID = connection.prepareStatement(FIND_BY_ID);
				results = findID.executeQuery();
				
				while(results.next())
				{
					int id = results.getInt("id"); 
					String name = results.getString("name");
					String description = results.getString("description"); 
					Date created = results.getDate("created"); 
					Date updated= results.getDate("updated"); 
					int visits = results.getInt("visits"); 
					int developer_id = results.getInt("developer_id"); 
					Developer developer = DeveloperImpl.findDeveloperByID(developer_id); 
					Website website = new Website(id, name, description, created, updated, visits,developer); 
					return website; 
			
				}
				results.close(); 
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
	public static int updateWebsite(int websiteId, Website website)
	{
		
		String UPDATE = "UPDATE website w SET w.name = \""+ website.getName()+"\", w.description = \""+website.getDescription()+ "\" , w.created = \""+website.getCreated()+"\", w.updated = \""+
				website.getUpdated()+ "\",w.visits = \""+website.getVisits()+ "\", w.developer_id= \""+website.getDeveloper().getId() +"\" WHERE w.id="+websiteId; 
		
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
		return websiteId; 
		
		
	}
	public static int deleteWebsite(int websiteId)
	{
		String DELETE = "DELETE FROM website WHERE id="+websiteId; 
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
		
		return websiteId;
	
	}
	
	 
	


}
