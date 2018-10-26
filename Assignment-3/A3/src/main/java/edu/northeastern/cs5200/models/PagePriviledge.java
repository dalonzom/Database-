package edu.northeastern.cs5200.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PagePriviledge extends Priviledge {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id; 
	private String priviledge; 
	
	
	public PagePriviledge(String priviledge, int id, String priviledge2, Developer developer, Page page) {
		super(priviledge);
		this.id = id;
		priviledge = priviledge2;
		this.developer = developer;
		this.page = page;
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

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	@ManyToOne()
	private Developer developer; 
	
	@ManyToOne()
	private Page page;

	public PagePriviledge(String priviledge, int id, Developer developer, Page page) {
		super(priviledge);
		this.id = id;
		this.developer = developer;
		this.page = page;
	}

	

}
