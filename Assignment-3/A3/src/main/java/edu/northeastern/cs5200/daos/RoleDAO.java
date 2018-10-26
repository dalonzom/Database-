package edu.northeastern.cs5200.daos;

public class RoleDAO {

	private static RoleDAO instance = null; 
	private RoleDAO() {};  
	public static RoleDAO getInstance()
	{
		if(instance == null) {
			instance = new RoleDAO(); 
		}
		return instance; 
	} 
	public static void assignWebsiteRole(int developerId, int websiteId, int roleId)
	{
		 RoleImpl.assignWebsiteRole(developerId, websiteId, roleId);
	}
	public static void assignPageRole(int developerId, int pageId, int roleId)
	{
		RoleImpl.assignPageRole(developerId, pageId, roleId);
	}
	public static void deleteWebsiteRole(int developerId, int websiteId, int roleId)
	{
		RoleImpl.deleteWebsiteRole(developerId, websiteId, roleId);
	}
	public static void deletePageRole(int developerId, int pageId, int roleId)
	{
		RoleImpl.deletePageRole(developerId, pageId, roleId);
	}
}
