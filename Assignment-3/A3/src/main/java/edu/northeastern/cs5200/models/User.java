package edu.northeastern.cs5200.models;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class User extends Person{
	
	private boolean user_agreement = false;
	private String user_key; 
	
	@OneToMany(mappedBy="askedBy")
	private Collection<Question> questions;  
	
	@OneToMany(mappedBy="postedBy")
	private Collection<Answer> answers; 
	
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public User(int id, String firstname, String lastname, String username, String user_key) {
		super(id, firstname, lastname);
		this.user_key = user_key; 
		// TODO Auto-generated constructor stub
	}
	

	public User(int id, String firstname, String lastname, String username, String password, String email, Date dob,
			ArrayList<Phone> phone_number, ArrayList<Address> address, boolean user_agreement, String user_key) {
		super(id, firstname, lastname, username, password, email, dob, phone_number, address);
		this.user_agreement = user_agreement;
		this.user_key = user_key;
	}


	public User(int id, String firstname, String lastname, String username, String password, String email, Date dob) {
		super(id, firstname, lastname, username, password, email, dob);
		// TODO Auto-generated constructor stub
	}

	public User(boolean user_agreement, String user_key) {
		super();
		this.user_agreement = user_agreement;
		this.user_key = user_key;
	}

	public String getUser_key() {
		return user_key;
	}

	public void setUser_key(String user_key) {
		this.user_key = user_key;
	}

	public User(int id, String firstname, String lastname) {
		super(id, firstname, lastname);
		setUser_agreement(false); 
		// TODO Auto-generated constructor stub
	}

	public void setUser_agreement(boolean user_agreement) {
		this.user_agreement = user_agreement;
	}

	public boolean isUser_agreement() {
		return user_agreement;
	} 

}
