package edu.northeastern.cs5200.models;

import javax.persistence.*;

@Entity 
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Person {
	
		@Id
		@GeneratedValue
		(strategy=GenerationType.IDENTITY)
		private int id; 
		private String username;
	    private String password;
	    private String firstName;
	    private String lastName;
	    
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
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public Person(String username, String password, String firstName, String lastName) {
			super();
			this.username = username;
			this.password = password;
			this.firstName = firstName;
			this.lastName = lastName;
		}
	    
	    public Person() {} 

}
