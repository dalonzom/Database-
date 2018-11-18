package edu.northeastern.cs5200.models;
import java.util.List;

import javax.persistence.*;

@Entity 
public class Course {
	
	@Id
	@GeneratedValue
	(strategy=GenerationType.IDENTITY)
	private int id; 
	private String label;
	
	@ManyToOne()
	 private Faculty author;
	
	@OneToMany(mappedBy="course")
	private List<Section> sections;
	
	public Course() {}
	
	
	
	public Faculty getAuthor() {
		return author;
	}


	public void setAuthor(Faculty author) {
		this.author = author;
	}


	public List<Section> getSections() {
		return sections;
	}


	public void setSections(List<Section> sections) {
		this.sections = sections;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Course(String label, Faculty author) {
		super();
		this.label = label;
		this.author = author;
	}
	public Course(String label) {
		super();
		this.label = label;
	} 
	
	
	
	
	

}
