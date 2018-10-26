package edu.northeastern.cs5200.models;
import javax.persistence.*;

@Entity
@Table(name="HeadingWidget")
public class HeadingWidget extends Widget {
	


	@Column(name="heading_size")
	private int heading_size;
	

	public HeadingWidget(int id, String name, int width, int height, String css_Class, String css_Style, String text,
			int orderType, String dtype, int heading_size) {
		super(id, name, width, height, css_Class, css_Style, text, orderType, dtype);
		this.heading_size = heading_size;
	}

	public int getheading_size() {
		return heading_size;
	}

	public void setheading_size(int heading_size) {
		this.heading_size = heading_size;
	} 
	

}
