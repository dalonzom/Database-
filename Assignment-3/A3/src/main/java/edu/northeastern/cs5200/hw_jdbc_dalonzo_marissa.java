package edu.northeastern.cs5200;


import java.awt.List;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.NoSuchElementException;

import com.mysql.jdbc.CallableStatement;

import edu.northeastern.cs5200.daos.DeveloperDAO;
import edu.northeastern.cs5200.daos.PageDAO;
import edu.northeastern.cs5200.daos.PhoneDAO;
import edu.northeastern.cs5200.daos.RoleDAO;
import edu.northeastern.cs5200.daos.UserDAO;
import edu.northeastern.cs5200.daos.WebsiteDAO;
import edu.northeastern.cs5200.daos.WidgetDAO;
import edu.northeastern.cs5200.models.Address;
import edu.northeastern.cs5200.models.Developer;
import edu.northeastern.cs5200.models.HeadingWidget;
import edu.northeastern.cs5200.models.HtmlWidget;
import edu.northeastern.cs5200.models.ImageWidget;
import edu.northeastern.cs5200.models.Page;
import edu.northeastern.cs5200.models.Phone;
import edu.northeastern.cs5200.models.User;
import edu.northeastern.cs5200.models.Website;
import edu.northeastern.cs5200.models.Widget;
import edu.northeastern.cs5200.models.YouTubeWidget;

public class hw_jdbc_dalonzo_marissa {
	
	public static void main(String args[])
	{
		
		//Insert into developers and users 
		
		//Dummy phone and address
		ArrayList<Phone> phones = new ArrayList<Phone>(); 
		Phone phone = new Phone("002-000-0000", true);
		phones.add(phone); 
		ArrayList<Address> addresses = new ArrayList<Address>(); 
		Address address = new Address("Main Street12", "Metropolis", "NY", true); 
		addresses.add(address);

		Developer alice = new Developer(12, "Alice", "Wonder", "alice", "alice", "alice@wonder.com", null, phones, addresses, "4321rewq");
		DeveloperDAO.createDeveloper(alice); 
		
		Developer bob = new Developer(23, "Bob", "Marley", "bob", "bob", "bob@marley.com", null, phones, addresses, "5432trew");
		DeveloperDAO.createDeveloper(bob); 
	
		
		Developer charlie = new Developer(34, "Charles", "Garcia", "charlie", "charlie", "chuch@garcia.com", null, phones, addresses, "6543ytre");
		DeveloperDAO.createDeveloper(charlie); 
		
		User dan = new User(45, "Dan", "Martin", "dan", "dan", "dan@martin.com", null, phones, addresses, false, "7654fda"); 
		UserDAO.createUser(dan); 
		
		User ed = new User(56, "Ed", "Karaz", "ed", "ed", "ed@kar.com", null, phones, addresses, false, "5678dfgh"); 
		UserDAO.createUser(ed); 
		
		long date1 = 20181024; 
		Date date = new Date(date1); 
		//Insert into websites
		Website facebook = new Website(123, "Facebook", "an online social media and social networking service", date, date, 1234234, DeveloperDAO.findDeveloperByUsername("alice"));
		WebsiteDAO.createWebsiteForDeveloper( DeveloperDAO.findDeveloperByUsername("alice").getId(), facebook);
		
		Website twitter = new Website(234, "Twitter", "an online news and social networking service", date, date, 4321543, DeveloperDAO.findDeveloperByUsername("bob"));
		WebsiteDAO.createWebsiteForDeveloper(DeveloperDAO.findDeveloperByUsername("bob").getId(), twitter);
		
		Website wikipedia = new Website(345, "Wikipedia", "a free online encyclopedia", date, date, 3456654, DeveloperDAO.findDeveloperByUsername("charlie"));
		WebsiteDAO.createWebsiteForDeveloper(DeveloperDAO.findDeveloperByUsername("charlie").getId(), wikipedia);
		
		Website cnn = new Website(456, "CNN", "an American basic cable and satellite television news channel", date, date, 6543345, DeveloperDAO.findDeveloperByUsername("alice"));
		WebsiteDAO.createWebsiteForDeveloper(DeveloperDAO.findDeveloperByUsername("alice").getId(), cnn);
		
		Website cnet = new Website(567, "CNET", "an American media website that publishes reviews, news, articles, blogs, podcasts and videos on technology and consumer electronics", date, date, 5433455, DeveloperDAO.findDeveloperByUsername("bob"));
		WebsiteDAO.createWebsiteForDeveloper(DeveloperDAO.findDeveloperByUsername("bob").getId(), cnet);
		
		Website gizmodo = new Website(678, "Gizmodo", "a design, technology, science and science fiction website that also writes articles on politics", date, date, 4322345, DeveloperDAO.findDeveloperByUsername("charlie"));
		WebsiteDAO.createWebsiteForDeveloper(DeveloperDAO.findDeveloperByUsername("charlie").getId(), gizmodo);
		
		
	
		//Facebook Roles
		RoleDAO.assignWebsiteRole(DeveloperDAO.findDeveloperByUsername("alice").getId(),123, 1);
		
		RoleDAO.assignWebsiteRole(DeveloperDAO.findDeveloperByUsername("bob").getId(),123, 2);
		RoleDAO.assignWebsiteRole(DeveloperDAO.findDeveloperByUsername("charlie").getId(),123, 3);
		
		//Twitter Roles 
		RoleDAO.assignWebsiteRole(DeveloperDAO.findDeveloperByUsername("bob").getId(),234, 1);
		RoleDAO.assignWebsiteRole(DeveloperDAO.findDeveloperByUsername("charlie").getId(),234, 2);
		RoleDAO.assignWebsiteRole(DeveloperDAO.findDeveloperByUsername("alice").getId(),234, 3); 
		
		//Wikipedia Roles 
		RoleDAO.assignWebsiteRole(DeveloperDAO.findDeveloperByUsername("charlie").getId(),345, 1); 
		RoleDAO.assignWebsiteRole(DeveloperDAO.findDeveloperByUsername("alice").getId(),345, 2); 
		RoleDAO.assignWebsiteRole(DeveloperDAO.findDeveloperByUsername("bob").getId(),345, 3);
		
		//CNN Roles
		RoleDAO.assignWebsiteRole(DeveloperDAO.findDeveloperByUsername("alice").getId(),456, 1); 
		RoleDAO.assignWebsiteRole(DeveloperDAO.findDeveloperByUsername("bob").getId(),456, 2); 
		RoleDAO.assignWebsiteRole(DeveloperDAO.findDeveloperByUsername("charlie").getId(),456, 3); 
		
		//CNET Roles 
		RoleDAO.assignWebsiteRole(DeveloperDAO.findDeveloperByUsername("bob").getId(),567, 1);
		RoleDAO.assignWebsiteRole(DeveloperDAO.findDeveloperByUsername("charlie").getId(),567, 2);
		RoleDAO.assignWebsiteRole(DeveloperDAO.findDeveloperByUsername("alice").getId(),567, 3);
		
		//Gizmodo Roles 
		RoleDAO.assignWebsiteRole(DeveloperDAO.findDeveloperByUsername("charlie").getId(),678, 1); 
		RoleDAO.assignWebsiteRole(DeveloperDAO.findDeveloperByUsername("alice").getId(),678, 2); 
		RoleDAO.assignWebsiteRole(DeveloperDAO.findDeveloperByUsername("bob").getId(),678, 3);
		
		//Insert into pages
		//Home 
		Page home = new Page(123, "Home", "Landing Page", date, date, 123434); 
		PageDAO.createPageForWebsite(567, home);
		
		//About 
		Page about = new Page(234, "About", "Website Description", date, date, 234545); 
		PageDAO.createPageForWebsite(678, about);
		
		//Contact 
		Page contact = new Page(345, "Contact", "Addresses, phones, and contact info", date, date, 345656); 
		PageDAO.createPageForWebsite(345, contact);
		
		//Preferences
		Page preferences = new Page(456, "Preferences", "Where users can configure their preferences", date, date, 456776); 
		PageDAO.createPageForWebsite(456, preferences);
		
		//Profile 
		Page profile = new Page(567, "Profile", "Where users can configure their personal information", date, date, 567878); 
		PageDAO.createPageForWebsite(567, profile);
		
		
		//Home Roles 
		RoleDAO.assignPageRole(DeveloperDAO.findDeveloperByUsername("alice").getId(),123 , 1);
		RoleDAO.assignPageRole(DeveloperDAO.findDeveloperByUsername("bob").getId(),123 , 2);
		RoleDAO.assignPageRole(DeveloperDAO.findDeveloperByUsername("charlie").getId(),123 , 3);
		
		//About Roles
		RoleDAO.assignPageRole(DeveloperDAO.findDeveloperByUsername("bob").getId(),234 , 1);
		RoleDAO.assignPageRole(DeveloperDAO.findDeveloperByUsername("charlie").getId(),234 , 2);
		RoleDAO.assignPageRole(DeveloperDAO.findDeveloperByUsername("alice").getId(),234 , 3);
		
		//Contact Roles
		RoleDAO.assignPageRole(DeveloperDAO.findDeveloperByUsername("charlie").getId(),345 , 1);
		RoleDAO.assignPageRole(DeveloperDAO.findDeveloperByUsername("alice").getId(),345 , 2);
		RoleDAO.assignPageRole(DeveloperDAO.findDeveloperByUsername("bob").getId(),345 , 3);
		
		//Preferences Roles
		RoleDAO.assignPageRole(DeveloperDAO.findDeveloperByUsername("alice").getId(),456 , 1);
		RoleDAO.assignPageRole(DeveloperDAO.findDeveloperByUsername("bob").getId(),456 , 2);
		RoleDAO.assignPageRole(DeveloperDAO.findDeveloperByUsername("charlie").getId(),456 , 3);
		
		//Profile Roles
		RoleDAO.assignPageRole(DeveloperDAO.findDeveloperByUsername("bob").getId(),567 , 1);
		RoleDAO.assignPageRole(DeveloperDAO.findDeveloperByUsername("charlie").getId(),567 , 2);
		RoleDAO.assignPageRole(DeveloperDAO.findDeveloperByUsername("alice").getId(),567 , 3);
		
		//Insert into widgets
		HeadingWidget heading = new HeadingWidget(1, "head123", 0, 0, "default", "default", "Welcome", 0, "heading", 10); 
		WidgetDAO.createWidgetForPage(123, heading);
		
		HtmlWidget html = new HtmlWidget(2, "post234", 0,0, "default", "default", "<p>Lorem</p>", 0, "html", "default");
		WidgetDAO.createWidgetForPage(234, html);
		
		HeadingWidget heading1 = new HeadingWidget(3, "head345", 0, 0, "default", "default", "Hi", 1, "heading", 10); 
		WidgetDAO.createWidgetForPage(345, heading1);
		
		HtmlWidget html1 = new HtmlWidget(4, "intro456", 0,0, "default", "default", "<h1>Hi</h1>", 2, "html", "default");
		WidgetDAO.createWidgetForPage(345, html1);
		
		ImageWidget image = new ImageWidget(5,"image345", 50, 100, "default", "default", "default", 3, "image", "/img/567.png"); 
		WidgetDAO.createWidgetForPage(345, image);
		
		YouTubeWidget video = new YouTubeWidget(6,"video456", 400,300, "default", "default","default", 0, "youtube", "https://youtu.be/h67VX51QXiQ", true, true); 
		WidgetDAO.createWidgetForPage(456, video);
		
		Phone phone2 = new Phone(1, "333-444-5555", true); 
		PhoneDAO.insertPhone(phone2, DeveloperDAO.findDeveloperByUsername("charlie").getId());
		
		
		//Update widgets
		HeadingWidget update1 = new HeadingWidget(3, "head345", 0, 0, "default", "default", "Hi", 3, "heading", 10); 
		WidgetDAO.updateWidget(3, update1); 
		
		HtmlWidget update2 = new HtmlWidget(4, "intro456", 0,0, "default", "default", "<h1>Hi</h1>", 1, "html", "default");
		WidgetDAO.updateWidget(4, update2);
		
		ImageWidget update3 = new ImageWidget(5,"image345", 50, 100, "default", "default", "default", 2, "image", "/img/567.png"); 
		WidgetDAO.updateWidget(5, update3);
	
		//Update CNET page
		Collection<Page> pages = new ArrayList<Page>();
		pages =	PageDAO.findPagesForWebsite(567); 
		for(Page page : pages)
		{
			Page updated = page; 
			page.setName("CNET-"+page.getName()); 
			PageDAO.updatePage(page.getId(), updated); 
		}
		
		//Delete old roles 
		RoleDAO.deletePageRole(DeveloperDAO.findDeveloperByUsername("bob").getId(), 123,2);
		RoleDAO.deletePageRole(DeveloperDAO.findDeveloperByUsername("charlie").getId(), 123,3);
		
		RoleDAO.assignPageRole(DeveloperDAO.findDeveloperByUsername("bob").getId(), 123, 3);
		RoleDAO.assignPageRole(DeveloperDAO.findDeveloperByUsername("charlie").getId(), 123, 2);
		 
		//Update alice's phone number
		Developer alice2 = new Developer(33, "Alice", "Wonder", "alice", "alice", "alice@wonder.com", date, phones, addresses, "4321rewq");
		DeveloperDAO.updateDeveloper(33, alice2); 
		
		//Delete max widget
		Collection<Widget> widgets = new ArrayList<Widget>(); 
		widgets = WidgetDAO.findWidgetsForPage(345); 
		
		Widget maxOrder = widgets
				.stream()
				.max(Comparator.comparing(Widget::getOrderType))
				.orElseThrow(NoSuchElementException::new);
		WidgetDAO.deleteWidget(maxOrder.getId()); 
		
		//Delete most recent page
		Collection<Page> pages2 = new ArrayList<Page>(); 
		pages2 = PageDAO.findPagesForWebsite(345); 
		
		Page mostRecent = pages
				.stream()
				.max(Comparator.comparing(Page::getUpdated))
				.orElseThrow(NoSuchElementException::new); 
		PageDAO.deletePage(mostRecent.getId()); 
		
		//Delete website
		RoleDAO.deleteWebsiteRole(23, 567,1);
		RoleDAO.deleteWebsiteRole(34, 567,2); 
		RoleDAO.deleteWebsiteRole(12, 567, 3);
		WebsiteDAO.deleteWebsite(567);
		
		
		//Stored procedures 
		java.sql.Connection connection;
		try {
		connection = Connection.getConnection();
			CallableStatement cStmt = (CallableStatement) connection.prepareCall("{call getUnansweredQuestions()}");
			System.out.println("Question with most wrong answers per module");
			boolean hadResults = cStmt.execute(); 
			while (hadResults) {
		        ResultSet rs = cStmt.getResultSet();
		        while(rs.next())
		        {
		        	String text = rs.getString("Question"); 
		        	System.out.println("Question text");
		        	System.out.println(text);
		        	int num_answers = rs.getInt("Number of Answers"); 
		        	System.out.println("Number of Answers");
		        	System.out.println(num_answers);
		        }
		        rs.close(); 
			} 
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
		
		
		try {
			connection = Connection.getConnection();
			CallableStatement cStmt = (CallableStatement) connection.prepareCall("{call endorsedUsersForWeek(?,?)}");
			cStmt.setDate(1, date);
			cStmt.setDate(1, date);
			System.out.println("Top endorsed users for the week");
			boolean hadResults = cStmt.execute(); 
			while (hadResults) {
		        ResultSet rs = cStmt.getResultSet();
		        while(rs.next())
		        {
		        	String firstname = rs.getString("p.firstname"); 
		        	System.out.println("First name");
		        	System.out.println(firstname);
		        	 
		        	String lastname = rs.getString("p.lastname"); 
		        	System.out.println("Last name");
		        	System.out.println(lastname);
		        	
		        	int answers = rs.getInt("SUM(a.correct_answer)"); 
		        	System.out.println("Number of answers");
		        	System.out.println(answers);
		        }
		        rs.close();
			} 
		 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
