package edu.northeastern.cs5200.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PageRole extends Role {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id; 
	private int roleId; 
	
	public PageRole(String role, int id, int roleId, Developer developer, Page page) {
		super(role);
		this.id = id;
		this.roleId = roleId;
		this.developer = developer;
		this.page = page;
	}

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

	public PageRole(String role, int id, Developer developer, Page page) {
		super(role);
		this.id = id;
		this.developer = developer;
		this.page = page;
	}
	
	

}
