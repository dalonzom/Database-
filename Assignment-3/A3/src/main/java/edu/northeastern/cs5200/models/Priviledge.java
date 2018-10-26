package edu.northeastern.cs5200.models;
import java.util.Collection;

import javax.persistence.*;

@Entity 
@Inheritance(strategy=InheritanceType.JOINED)
public class Priviledge {
	

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id; 
	private String priviledge;
	
	
	
	
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
	public Priviledge(String priviledge) {
		super();
		this.priviledge = priviledge;
	} 
	
	

}
