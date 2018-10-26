package edu.northeastern.cs5200.models;

import java.sql.Date;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity 
@Table(name= "question")
public class Question {
	
	@Id
	@GeneratedValue
    (strategy=GenerationType.IDENTITY)
    private int id;
	private String text; 
	 
	private Date postedOn; 
	private int length; 
	private int views; 
	private boolean endorsedByInstructor; 
	private String module;
	
	@ManyToOne()
	private User askedBy;
	
	@OneToMany(mappedBy="question")
	Collection<Answer> answers; 
	
	@ManyToOne()
	private Widget widget; 
	
	

	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public User getAskedBy() {
		return askedBy;
	}
	public void setAskedBy(User askedBy) {
		this.askedBy = askedBy;
	}
	public Date getPostedOn() {
		return postedOn;
	}
	public void setPostedOn(Date postedOn) {
		this.postedOn = postedOn;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public boolean isEndorsedByInstructor() {
		return endorsedByInstructor;
	}
	public void setEndorsedByInstructor(boolean endorsedByInstructor) {
		this.endorsedByInstructor = endorsedByInstructor;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	} 
	
	
}
