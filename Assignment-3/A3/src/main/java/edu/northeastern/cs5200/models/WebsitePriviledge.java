package edu.northeastern.cs5200.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class WebsitePriviledge  extends Priviledge{

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id; 
	private String priviledge; 
	
	public WebsitePriviledge(String priviledge, int id, String priviledge2, Developer developer, Website website) {
		super(priviledge);
		this.id = id;
		priviledge = priviledge2;
		this.developer = developer;
		this.website = website;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPriviledge() {
		return priviledge;
	}

	public void setPriviledge(String priviledge) {
		this.priviledge = priviledge;
	}

	public Developer getDeveloper() {
		return developer;
	}

	public void setDeveloper(Developer developer) {
		this.developer = developer;
	}

	public Website getWebsite() {
		return website;
	}

	public void setWebsite(Website website) {
		this.website = website;
	}

	@ManyToOne()
	private Developer developer; 
	
	@ManyToOne()
	private Website website;

	public WebsitePriviledge(String priviledge, int id, Developer developer, Website website) {
		super(priviledge);
		this.id = id;
		this.developer = developer;
		this.website = website;
	}

	
	
	
}
