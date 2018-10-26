package edu.northeastern.cs5200.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "answer")
public class Answer {
	

	@Id
	@GeneratedValue
    (strategy=GenerationType.IDENTITY)
    private int id;
	
	private String text; 
	private Date postedOn; 
	private boolean correctAnswer; 
	private int upVotes; 
	private int downVotes; 
	
	@ManyToOne()
	private User postedBy;
	
	@ManyToOne()
	private Question question;
	
	@ManyToOne()
	private Widget widget; 
	
	

	public Answer(int id, String name, int width, int height, String css_Class, String css_Style, String text,
			int orderType, String dtype, String text2, Date postedOn, boolean correctAnswer, int upVotes, int downVotes,
			User postedBy, Question question) {
		super();
		text = text2;
		this.postedOn = postedOn;
		this.correctAnswer = correctAnswer;
		this.upVotes = upVotes;
		this.downVotes = downVotes;
		this.postedBy = postedBy;
		this.question = question;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getPostedOn() {
		return postedOn;
	}

	public void setPostedOn(Date postedOn) {
		this.postedOn = postedOn;
	}

	public boolean isCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(boolean correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public int getUpVotes() {
		return upVotes;
	}

	public void setUpVotes(int upVotes) {
		this.upVotes = upVotes;
	}

	public int getDownVotes() {
		return downVotes;
	}

	public void setDownVotes(int downVotes) {
		this.downVotes = downVotes;
	}

	public User getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(User postedBy) {
		this.postedBy = postedBy;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	} 
	
	

}
