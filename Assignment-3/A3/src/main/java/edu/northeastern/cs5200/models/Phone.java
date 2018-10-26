package edu.northeastern.cs5200.models;
import javax.persistence.*;

@Entity
public class Phone {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id; 
	private String phone; 
	private boolean primary_number; 
	
	@ManyToOne()
	private Person person;
	

	public Phone(int id, String phone, boolean primary_number) {
		super();
		this.id = id;
		this.phone = phone;
		this.primary_number = primary_number;
	}

	public int getId() {
		return id;
	}

	public String getPhone() {
		return phone;
	}

	
	public Phone(String phone, boolean primary_number) {
		super();
		this.phone = phone;
		this.primary_number = primary_number;
	}

	public Phone(String phone, boolean primary_number, Person person) {
		super();
		this.phone = phone;
		this.primary_number = primary_number;
		this.person = person;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setPrimary_number(boolean primary_number) {
		this.primary_number = primary_number;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public boolean isPrimary_number() {
		return primary_number;
	}

	public Person getPerson() {
		return person;
	} 
	
	
}
