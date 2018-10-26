package edu.northeastern.cs5200.models;

import javax.persistence.*;

@Entity
public class Address {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id; 

	private String street1; 
	private String street2; 
	private String city; 
	private String state; 
	private String zip; 
	private boolean primary_address; 
	
	@ManyToOne()
	private Person person;

	public String getStreet1() {
		return street1;
	}

	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	public String getStreet2() {
		return street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public boolean isPrimary_address() {
		return primary_address;
	}

	public void setPrimary_address(boolean primary_address) {
		this.primary_address = primary_address;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Address(String street1, String city, String state, boolean primary_address) {
		super();
		this.street1 = street1;
		this.city = city;
		this.state = state;
		this.primary_address = primary_address;
	}

	public Address(String street1, String city, String state, String zip, boolean primary_address, Person person) {
		super();
		this.street1 = street1;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.primary_address = primary_address;
		this.person = person;
	}

	public Address(int id, String street1, String city, String zip, boolean primary_address, Person person) {
		super();
		this.id = id;
		this.street1 = street1;
		this.city = city;
		this.zip = zip;
		this.primary_address = primary_address;
		this.person = person;
	} 
	
	

}
