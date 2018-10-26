package edu.northeastern.cs5200.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import edu.northeastern.cs5200.models.Role;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class Developer extends Person {

	private String developer_key;
	
 
	@OneToMany(mappedBy="developer")
	 private List<Website> websites;

	
	
	
	public List<Website> getWebsites() {
		return websites;
	}



	public void setWebsites(List<Website> websites) {
		this.websites = websites;
	}


	public void websiteTest(Website website) {
	     this.websites.add(website);
	     if(website.getDeveloper() != this)
	        website.setDeveloper(this);
	}  
	
  
	
	public Developer(String developer_key) {
		super();
		this.developer_key = developer_key;
	}



	public Developer(int id, String firstname, String lastname, String developer_key) {
		super(id, firstname, lastname);
		this.developer_key = developer_key; 
		// TODO Auto-generated constructor stub
	}
	

	public Developer(int id, String firstname, String lastname, String username, String password, String email,
			Date dob) {
		super(id, firstname, lastname, username, password, email, dob);
		// TODO Auto-generated constructor stub
	}


	public Developer(int id, String firstname, String lastname) {
		super(id, firstname, lastname);
		// TODO Auto-generated constructor stub
	}

	

	public Developer(int id, String firstname, String lastname, String username, String password, String email,
			Date dob, ArrayList<Phone> phone_number, ArrayList<Address> address, String developer_key) {
		super(id, firstname, lastname, username, password, email, dob, phone_number, address);
		this.developer_key = developer_key; 
		// TODO Auto-generated constructor stub
	}


	public String getDeveloper_key() {
		return developer_key;
	}

	public void setDeveloper_key(String developer_key) {
		this.developer_key = developer_key;
	} 
	
	
	
}
