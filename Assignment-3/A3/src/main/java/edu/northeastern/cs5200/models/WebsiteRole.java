package edu.northeastern.cs5200.models;
import javax.persistence.*;

@Entity 

public class WebsiteRole extends Role{
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id; 
	private int roleId; 
	
	@ManyToOne()
	private Developer developer; 
	
	@ManyToOne()
	private Website website;

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}




	public int getRoleId() {
		return roleId;
	}


	public void setRoleId(int roleId) {
		this.roleId = roleId;
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


	public WebsiteRole(String role, int id, String role2, Developer developer, Website website) {
		super(role);
		this.id = id;
		role = role2;
		this.developer = developer;
		this.website = website;
	}


	public WebsiteRole(String role, Developer developer, Website website) {
		super(role);
		this.developer = developer;
		this.website = website;
	} 

}
