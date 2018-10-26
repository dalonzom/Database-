package edu.northeastern.cs5200.daos;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import edu.northeastern.cs5200.Connection;

public class PriviledgeImpl {
	
	public static void assignWebsitePriviledge(int developerId, int websiteId, String priviledge)
	{
		String INSERT_PRIV = "INSERT INTO website_priviledge(developer_id,website_id, priviledge ) VALUES (?,?,?)"; 

		try {
			java.sql.Connection connection = Connection.getConnection();
			PreparedStatement insertR = connection.prepareStatement(INSERT_PRIV);
			insertR.setInt(1, developerId);
			insertR.setInt(2, websiteId); 
			insertR.setString(3, priviledge);
			insertR.executeUpdate(); 

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}
	public static void assignPagePriviledge(int developerId, int pageId, String priviledge)
	{

		String INSERT_PRIV = "INSERT INTO page_priviledge (developer_id,page_id, priviledge ) VALUES (?,?,?)"; 

		try {
			java.sql.Connection connection = Connection.getConnection();
			PreparedStatement insertR = connection.prepareStatement(INSERT_PRIV);
			insertR.setInt(1, developerId);
			insertR.setInt(2, pageId); 
			insertR.setString(3, priviledge); 
			insertR.executeUpdate(); 

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void deleteWebsitePriviledge(int developerId, int websiteId, String priviledge)
	{
		String DELETE = "DELETE FROM website_priviledge WHERE developer_id="+developerId+" AND website_id="+websiteId+" AND priviledge="+priviledge; 
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
		
		
	}
	public static void deletePagePriviledge(int developerId, int pageId, String priviledge)
	{
		String DELETE = "DELETE FROM page_priviledge WHERE developer_id="+developerId+" AND page_id="+pageId+" AND priviledge="+priviledge; 
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
	}

}
