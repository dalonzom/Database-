package edu.northeastern.cs5200.models;


import java.util.Collection;

import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Widget {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
	private String name; 
	private int width; 
	private int height; 
	private String css_Class; 
	private String css_Style; 
	private String text; 
	private int orderType; 
	private String test; 
	
	public Widget(int id, String name, int width, int height, String css_Class, String css_Style, String text,
			int orderType, String dtype) {
		super();
		this.id = id;
		this.name = name;
		this.width = width;
		this.height = height;
		this.css_Class = css_Class;
		this.css_Style = css_Style;
		this.text = text;
		this.orderType = orderType;
		this.test = dtype;
	}


	
	@ManyToOne()
	private Page page;
	
	@OneToMany(mappedBy="widget")
	Collection<Question> question;
	
	
	@OneToMany(mappedBy="widget")
	Collection<Answer> answer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderType() {
		return orderType;
	}

	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}

	public String getDtype() {
		return test;
	}

	public void setDtype(String dtype) {
		this.test = dtype;
	}
 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getCss_Class() {
		return css_Class;
	}

	public void setCss_Class(String css_Class) {
		this.css_Class = css_Class;
	}

	public String getCss_Style() {
		return css_Style;
	}

	public void setCss_Style(String css_Style) {
		this.css_Style = css_Style;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getorderType() {
		return orderType;
	}

	public void setorderType(int orderType) {
		this.orderType = orderType;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}



	
	 


	
	
	
}
