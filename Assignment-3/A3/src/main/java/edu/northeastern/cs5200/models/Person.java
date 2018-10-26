package edu.northeastern.cs5200.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;


import javax.persistence.*;
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Person {
	@Id
	@GeneratedValue
    (strategy=GenerationType.IDENTITY)
    private int id;
	private String firstname; 
	private String lastname; 
	private String username; 
	private String password; 
	private String email; 
	private Date dob;
	

	@OneToMany(mappedBy="person")
	 private Collection<Phone> phone_number;
	
	
	
	public void setPhone_number(ArrayList<Phone> phone_number) {
		this.phone_number = phone_number;
	}


	public void phoneNumber(Phone number) {
	     this.phone_number.add(number);
	     if(number.getPerson() != this)
	        number.setPerson(this);
	} 

	
	@OneToMany(mappedBy="person")
	 private Collection<Address> address;
	
	
	public void address(Address address) {
	     this.address.add(address);
	     if(address.getPerson() != this)
	        address.setPerson(this);
	} 
	
	
	public Person() {
		super();
	}


	public Person(int id, String firstname, String lastname) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = null; 
		this.password = null; 
		this.email = null; 
		this.dob = null; 

	}
	
	public Person(int id, String firstname, String lastname, String username, String password, String email, Date dob) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.email = email;
		this.dob = dob;
	}
	

	public Person(int id, String firstname, String lastname, String username, String password, String email, Date dob,
			ArrayList<Phone> phone_number, ArrayList<Address> address) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.email = email;
		this.dob = dob;
		this.phone_number = phone_number;
		this.address = address;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}


	public Collection<Phone> getPhone_number() {
		return phone_number;
	}


	public void setPhone_numbe(ArrayList<Phone> phone_number) {
		this.phone_number = phone_number;
	}


	public Collection<Address> getAddress() {
		return address;
	}


	public void setAddress(ArrayList<Address> address) {
		this.address = address;
	} 
	
	
	
}
