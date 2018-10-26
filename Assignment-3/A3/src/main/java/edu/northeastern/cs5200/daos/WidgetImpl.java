package edu.northeastern.cs5200.daos;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import edu.northeastern.cs5200.Connection;
import edu.northeastern.cs5200.models.Page;
import edu.northeastern.cs5200.models.Widget;

public class WidgetImpl {

	public static void createWidgetForPage(int pageId, Widget widget)
	{
		String INSERT_WIDGET = "INSERT INTO widget (id, name, width,height, css_Class,css_Style,  text, order_type, dtype, page_id) VALUES (?,?,?,?,?,?, ?,?, ?,?)"; 
		try {
			java.sql.Connection connection = Connection.getConnection();
			PreparedStatement insertW = connection.prepareStatement(INSERT_WIDGET);
			insertW.setInt(1, widget.getId()); 
			insertW.setString(2, widget.getName());
			insertW.setInt(3, widget.getWidth());
			insertW.setInt(4, widget.getHeight()); 
			insertW.setString(5, widget.getCss_Class());
			insertW.setString(6, widget.getCss_Style()); 
			insertW.setString(7,  widget.getText());
			insertW.setInt(8, widget.getOrderType()); 
			insertW.setString(9,  widget.getDtype());
			insertW.setInt(10, pageId); 
			insertW.executeUpdate(); 

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	public static Collection<Widget> findAllWidgets()
	{
		String FIND_ALL = "SELECT * FROM widget";
		Collection<Widget> widgets = new ArrayList<Widget>(); 
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
					int width = results.getInt("width"); 
					int height = results.getInt("height"); 
					String css_Class = results.getString("css_Class"); 
					String css_Style = results.getString("css_Style");
					String text = results.getString("test"); 
					int order_type = results.getInt("order_type"); 
					String dtype = results.getString("dtype"); 
					Widget widget = new Widget(id, name, width,height, css_Class,css_Style,  text, order_type, dtype);  
					widgets.add(widget); 
			
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

		return widgets; 
	}
	
	public static Widget findWidgetById(int widgetId)
	{
		String FIND_BY_ID = "SELECT * FROM widget WHERE id="+widgetId;
		
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
					int width = results.getInt("width"); 
					int height = results.getInt("height");  
					String css_Class = results.getString("css_Class"); 
					String css_Style = results.getString("css_Style"); 
					String text = results.getString("text"); 
					int order_type = results.getInt("order_type"); 
					String dtype = results.getString("dtype"); 
					Widget widget = new Widget(id, name, width,height, css_Class,css_Style,  text, order_type, dtype); 
					return widget; 
			
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
	public static Collection<Widget> findWidgetsForPage(int pageId)
	{
		String FIND_BY_ID = "SELECT * FROM widget WHERE page_id="+pageId;
		Collection<Widget> widgets = new ArrayList<Widget>(); 
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
					int width = results.getInt("width"); 
					int height = results.getInt("height");  
					String css_Class = results.getString("css_Class"); 
					String css_Style = results.getString("css_Style"); 
					String text = results.getString("text"); 
					int order_type = results.getInt("order_type"); 
					String dtype = results.getString("dtype"); 
					Widget widget = new Widget(id, name, width,height, css_Class,css_Style,  text, order_type, dtype); 
					widgets.add(widget); 
			
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

		return widgets; 
	}
	
	public static int updateWidget(int widgetId, Widget widget)
	{
		
		String UPDATE = "UPDATE widget w SET w.id = "+ widget.getId()+", w.name = \""+widget.getName()+ "\" , w.width = "+widget.getWidth()+", w.height= "+
				widget.getHeight()+ " ,w.css_class = \""+widget.getCss_Class()+ "\", w.css_style= \""+widget.getCss_Style() + "\", w.text= \""+widget.getText()+"\", w.order_type="+widget.getOrderType()+", w.dtype= \" "+widget.getDtype()+ "\" WHERE w.id="+widgetId; 

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
		return widgetId; 
		
	}
	public static int deleteWidget(int widgetId)
	{
		String DELETE = "DELETE FROM widget WHERE id="+widgetId; 
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
		
		return widgetId;
	
	}
	
	
}
