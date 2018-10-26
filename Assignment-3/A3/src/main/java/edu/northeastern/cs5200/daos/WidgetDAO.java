package edu.northeastern.cs5200.daos;

import java.util.Collection;

import edu.northeastern.cs5200.models.Widget;

public class WidgetDAO {
	
	private static WidgetDAO instance = null; 
	private WidgetDAO() {};  
	public static WidgetDAO getInstance()
	{
		if(instance == null) {
			instance = new WidgetDAO(); 
		}
		return instance; 
	} 
	public static void createWidgetForPage(int pageId, Widget widget)
	{
		WidgetImpl.createWidgetForPage(pageId, widget);
	}
	public static Collection<Widget> findAllWidgets()
	{
			return WidgetImpl.findAllWidgets(); 
	}
	public static Widget findWidgetById(int widgetId)
	{
		return WidgetImpl.findWidgetById(widgetId); 
	}
	
	public static Collection<Widget> findWidgetsForPage(int pageId)
	{
		return WidgetImpl.findWidgetsForPage(pageId); 
	}
	
	public static int updateWidget(int widgetId, Widget widget)
	{
		return WidgetImpl.updateWidget(widgetId, widget); 
	}
	public static int deleteWidget(int widgetId)
	{
		return WidgetImpl.deleteWidget(widgetId); 
	}
		
	

}
