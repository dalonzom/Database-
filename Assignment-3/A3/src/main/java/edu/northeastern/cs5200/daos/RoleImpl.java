package edu.northeastern.cs5200.daos;

import java.awt.List;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import edu.northeastern.cs5200.Connection;
import edu.northeastern.cs5200.models.Developer;
import edu.northeastern.cs5200.models.Website;
import edu.northeastern.cs5200.models.Widget;

public class RoleImpl {
	
	
	public static void assignWebsiteRole(int developerId, int websiteId, int roleId)
	{
		String INSERT_ROLE = "INSERT INTO website_role (developer_id,website_id, role_id ) VALUES (?,?,?)"; 
		String INSERT_PRIV = "INSERT INTO website_priviledge(developer_id, website_id, priviledge) VALUES(?,?,?)";
		Collection<String> privs = new ArrayList<String>(); 
		String role = new String(); 
		switch (roleId)
		{
		case 1:
			privs.add("create"); 
			privs.add("update"); 
			privs.add("read"); 
			privs.add("delete"); 
			role = "owner"; 
			break; 
		case 2:
			privs.add("create"); 
			privs.add("update"); 
			privs.add("read"); 
			privs.add("delete"); 
			role = "admin"; 
			break;
		case 3:
			privs.add("create"); 
			privs.add("update"); 
			privs.add("read");  
			role = "writer"; 
			break;
		case 4: 
			privs.add("update"); 
			privs.add("read"); 
			role = "editor"; 
			break;
		case 5: 
			privs.add("read"); 
			role = "reviewer"; 
			break;
		default: 
			role = "default"; 
			break; 	
			
		}
		for (String priv : privs)
		{
			
			java.sql.Connection connection;
			PreparedStatement insertR;
			try {
				connection = Connection.getConnection();
				insertR = connection.prepareStatement(INSERT_PRIV);
				insertR.setInt(1, developerId);
				insertR.setInt(2, websiteId); 
				insertR.setString(3, priv);
				insertR.executeUpdate();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
		}
		try {
			java.sql.Connection connection = Connection.getConnection();
			PreparedStatement insertR = connection.prepareStatement(INSERT_ROLE);
			insertR.setInt(1, developerId);
			insertR.setInt(2, websiteId); 
			insertR.setInt(3, roleId);
			insertR.executeUpdate(); 

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}
	public static void assignPageRole(int developerId, int pageId, int roleId)
	{

		String INSERT_ROLE = "INSERT INTO page_role (developer_id,page_id, role_id ) VALUES (?,?,?)"; 
		String INSERT_PRIV = "INSERT INTO page_priviledge(developer_id, page_id, priviledge) VALUES(?,?,?)";
		Collection<String> privs = new ArrayList<String>(); 
		String role = new String(); 
		switch (roleId)
		{
		case 1:
			privs.add("create"); 
			privs.add("update"); 
			privs.add("read"); 
			privs.add("delete"); 
			role = "owner"; 
			break; 
		case 2:
			privs.add("create"); 
			privs.add("update"); 
			privs.add("read"); 
			privs.add("delete"); 
			role = "admin"; 
			break;
		case 3:
			privs.add("create"); 
			privs.add("update"); 
			privs.add("read");  
			role = "writer"; 
			break;
		case 4: 
			privs.add("update"); 
			privs.add("read"); 
			role = "editor"; 
			break;
		case 5: 
			privs.add("read"); 
			role = "reviewer"; 
			break;
		default: 
			role = "default"; 
			break; 	
			
		}
		for (String priv : privs)
		{
			
			java.sql.Connection connection;
			PreparedStatement insertR;
			try {
				connection = Connection.getConnection();
				insertR = connection.prepareStatement(INSERT_PRIV);
				insertR.setInt(1, developerId);
				insertR.setInt(2, pageId); 
				insertR.setString(3, priv);
				insertR.executeUpdate();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
		}
		try {
			java.sql.Connection connection = Connection.getConnection();
			PreparedStatement insertR = connection.prepareStatement(INSERT_ROLE);
			insertR.setInt(1, developerId);
			insertR.setInt(2, pageId); 
			insertR.setInt(3, roleId);
			insertR.executeUpdate(); 

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void deleteWebsiteRole(int developerId, int websiteId, int roleId)
	{
		String DELETE = "DELETE FROM website_role WHERE developer_id="+developerId+" AND website_id="+websiteId+" AND role_id="+roleId; 
		String DELETE_PRIV = "DELETE FROM website_priviledge WHERE developer_id="+developerId+" AND website_id="+websiteId; 
		try {
			java.sql.Connection connection = Connection.getConnection();
			PreparedStatement delete = connection.prepareStatement(DELETE); 
			delete.executeUpdate(); 
			
			PreparedStatement delete1 = connection.prepareStatement(DELETE_PRIV); 
			delete1.executeUpdate(); 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}
	public static void deletePageRole(int developerId, int pageId, int roleId)
	{
		String DELETE = "DELETE FROM page_role WHERE developer_id="+developerId+" AND page_id="+pageId+" AND role_id="+roleId; 
		String DELETE_PRIV = "DELETE FROM page_priviledge WHERE develoepr_id="+developerId+" AND page_id="+pageId; 
		try {
			java.sql.Connection connection = Connection.getConnection();
			PreparedStatement delete = connection.prepareStatement(DELETE); 
			delete.executeUpdate(); 
			
			PreparedStatement delete1 = connection.prepareStatement(DELETE_PRIV); 
			delete1.executeUpdate(); 
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	
}
