package edu.northeastern.cs5200.models;

import java.util.Date;
import java.util.List;

import javax.persistence.*;


@Entity
public class Website {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id; 
	private String name; 
	private String description; 
	private Date created; 
	private Date updated; 
	private int visits;
	
	@ManyToOne()
	private Developer developer; 
	
	
	@OneToMany(mappedBy="website")
	 private List<Page> pages;
	

	

	
	public void pages(Page page) {
	     this.pages.add(page);
	     if(page.getWebsite() != this)
	        page.setWebsite(this);
	}  
	
	public Website(int id, String name, String description, Date created, Date updated, int visits, Developer developer) {
		super();
		this.id = id; 
		this.name = name;
		this.description = description;
		this.created = created;
		this.updated = updated;
		this.visits = visits;
		this.developer = developer;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Page> getPages() {
		return pages;
	}

	public void setPages(List<Page> pages) {
		this.pages = pages;
	}

	public Developer getDeveloper() {
		return developer;
	}
	public void setDeveloper(Developer developer) {
		this.developer = developer;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public int getVisits() {
		return visits;
	}
	public void setVisits(int visits) {
		this.visits = visits;
	} 
	
	

}
