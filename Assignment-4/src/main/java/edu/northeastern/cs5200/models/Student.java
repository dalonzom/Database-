package edu.northeastern.cs5200.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

@Entity  
public class Student extends Person{
	
	private int gradYear; 
	private long scholarship;
	
	@OneToMany(mappedBy="student")
	 private List<Enrollment> enrolledSections;
	
	public Student() {}
	public int getGradYear() {
		return gradYear;
	}
	public void setGradYear(int gradYear) {
		this.gradYear = gradYear;
	}
	public long getScholarship() {
		return scholarship;
	}
	public void setScholarship(long scholarship) {
		this.scholarship = scholarship;
	}
	
	public Student(String username, String password, String firstName, String lastName, int gradYear,
			long scholarship) {
		super(username, password, firstName, lastName);
		this.gradYear = gradYear;
		this.scholarship = scholarship;
	}
	public Student(String username, String password, String firstName, String lastName, int gradYear, long scholarship,
			List<Enrollment> enrolledSections) {
		super(username, password, firstName, lastName);
		this.gradYear = gradYear;
		this.scholarship = scholarship;
		this.enrolledSections = enrolledSections;
	} 
	
	

}
