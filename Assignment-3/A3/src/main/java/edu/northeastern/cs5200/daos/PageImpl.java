package edu.northeastern.cs5200.daos;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import edu.northeastern.cs5200.Connection;
import edu.northeastern.cs5200.models.Developer;
import edu.northeastern.cs5200.models.Page;
import edu.northeastern.cs5200.models.Website;

public class PageImpl {
	public static void createPageForWebsite(int websiteId, Page page)
	{
		String INSERT_PAGE = "INSERT INTO page (created, description, name, updated, views, website_id) VALUES (?,?,?,?,?,?)"; 
		try {
			java.sql.Connection connection = Connection.getConnection();
			PreparedStatement insertW = connection.prepareStatement(INSERT_PAGE);
			insertW.setDate(1, (Date) page.getCreated()); 
			insertW.setString(2, page.getDescription());
			insertW.setString(3, page.getName());
			insertW.setDate(4, (Date) page.getUpdated());
			insertW.setInt(5, page.getViews()); 
			insertW.setInt(6, websiteId);
			insertW.executeUpdate(); 

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		 
		
	}
	public static Collection<Page> findAllPages()
	{
		String FIND_ALL = "SELECT * FROM page";
		Collection<Page> pages = new ArrayList<Page>(); 
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
					int views = results.getInt("views"); 
					Page page = new Page(id, name, description, created, updated, views); 
					pages.add(page); 
			
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

		return pages; 
		
	}
	
	public static Page findPageById(int pageId)
	{
		String FIND_BY_ID = "SELECT * FROM page WHERE id="+pageId;
		
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
					int views = results.getInt("views"); 
					Page page = new Page(id, name, description, created, updated, views); 
					return page; 
			
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
	
	public static Collection<Page> findPagesForWebsite(int websiteId)
	{
		String FIND_BY_ID = "SELECT * FROM page WHERE website_id="+websiteId;
		Collection<Page> pages = new ArrayList<Page>(); 
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
					int views = results.getInt("views");  
					Page page= new Page(id, name, description, created, updated, views); 
					page.setWebsite(WebsiteDAO.findWebsiteById(websiteId));
					pages.add(page); 
			
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
		return pages; 
	}
	
	public static int updatePage(int pageId, Page page)
	{
		
		String UPDATE = "UPDATE page p SET p.name = \""+ page.getName()+"\", p.description = \""+page.getDescription()+ "\" , p.created = \""+page.getCreated()+"\", p.updated = \""+
				page.getUpdated()+ "\",p.views = \""+page.getViews()+ "\", p.website_id= \""+page.getWebsite().getId() +"\" WHERE p.id="+pageId; 
		
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
		return pageId; 
		
		
	}
	public static int deletePage(int pageId)
	{
		String DELETE = "DELETE FROM page WHERE id="+pageId; 
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
		
		return pageId;
	
	}
	

}
