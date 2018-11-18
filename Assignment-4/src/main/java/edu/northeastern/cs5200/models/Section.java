package edu.northeastern.cs5200.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Section {
	
	@Id
	@GeneratedValue
	(strategy=GenerationType.IDENTITY)
	private int id; 
	private int seats;
	private String title; 
	
	
	@ManyToOne()
	private Course course;
	
	@OneToMany(mappedBy="section")
	 private List<Enrollment> enrolledSections;
	
	
	public Section() {}
	
	
	
	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public Section(int seats, String title, Course course) {
		super();
		this.seats = seats;
		this.title = title;
		this.course = course;
	}



	public Course getCourse() {
		return course;
	}


	public void setCourse(Course course) {
		this.course = course;
	}


	public List<Enrollment> getEnrolledSections() {
		return enrolledSections;
	}


	public void setEnrolledSections(List<Enrollment> enrolledSections) {
		this.enrolledSections = enrolledSections;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public Section(int seats, Course course) {
		super();
		this.seats = seats;
		this.course = course;
	}
	public Section(int seats) {
		super();
		this.seats = seats;
	} 
	
	
	
	
	

}
