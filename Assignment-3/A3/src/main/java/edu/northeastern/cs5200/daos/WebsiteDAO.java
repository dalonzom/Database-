package edu.northeastern.cs5200.daos;

import java.util.Collection;

import edu.northeastern.cs5200.models.Website;

public class WebsiteDAO {
	private static WebsiteDAO instance = null; 
	private WebsiteDAO() {};  
	public static WebsiteDAO getInstance()
	{
		if(instance == null) {
			instance = new WebsiteDAO(); 
		}
		return instance; 
		
	}
	
	public static void createWebsiteForDeveloper(int developerId, Website website)
	{
		WebsiteImpl.createWebsiteForDeveloper(developerId, website);
	}

	public static  Collection<Website> findAllWebsites()
	{
		return WebsiteImpl.findAllWebsites(); 
	}
	public static Collection<Website> findWebsitesForDeveloper(int developerId)
	{
		return WebsiteImpl.findWebsitesForDeveloper(developerId); 
	}
	
	public static Website findWebsiteById(int websiteId)
	{
		return WebsiteImpl.findWebsiteById(websiteId); 
	}
	public static int updateWebsite(int websiteId, Website website)
	{
		return WebsiteImpl.updateWebsite(websiteId, website); 
	}
	public static int deleteWebsite(int websiteId)
	{
		return WebsiteImpl.deleteWebsite(websiteId); 
	}
}
