package edu.northeastern.cs5200.models;
import java.util.Collection;

import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Role {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id; 
	private String role;
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Role(String role) {
		super();
		this.role = role;
	} 
	
	
	

}
