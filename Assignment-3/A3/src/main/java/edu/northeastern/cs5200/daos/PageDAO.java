package edu.northeastern.cs5200.daos;

import java.util.Collection;

import edu.northeastern.cs5200.models.Page;

public class PageDAO {
	private static PageDAO instance = null; 
	private PageDAO() {};  
	public static PageDAO getInstance()
	{
		if(instance == null) {
			instance = new PageDAO(); 
		}
		return instance; 
		
	}
	
	public static void createPageForWebsite(int websiteId, Page page)
	{
		PageImpl.createPageForWebsite(websiteId, page);
	}
	public static Collection<Page> findAllPages()
	{
		return PageImpl.findAllPages(); 
	}
	public static Page findPageById(int pageId)
	{
		return PageImpl.findPageById(pageId); 
	}
	public static Collection<Page> findPagesForWebsite(int websiteId)
	{
		return PageImpl.findPagesForWebsite(websiteId); 
	}
	public static int updatePage(int pageId, Page page)
	{
		return PageImpl.updatePage(pageId, page); 
	}
	public static int deletePage(int pageId)
	{
		return PageImpl.deletePage(pageId); 
	}
}
