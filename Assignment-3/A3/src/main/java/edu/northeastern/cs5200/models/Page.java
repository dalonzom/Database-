package edu.northeastern.cs5200.models;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Page {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id; 
	private String name; 
	private String description; 
	private Date created; 
	private Date updated; 
	private int views;
	
	@ManyToOne()
	private Website website;
	

	
	@OneToMany(mappedBy="page")
	 private List<Widget> widgets;
	
	public void widgets(Widget widget) {
	     this.widgets.add(widget);
	     if(widget.getPage() != this)
	        widget.setPage(this);
	}  

	
	
	public Page(int id, String name, String description, Date created, Date updated, int views) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.created = created;
		this.updated = updated;
		this.views = views;
	}
	public Website getWebsite() {
		return website;
	}
	public void setWebsite(Website website) {
		this.website = website;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	
}
