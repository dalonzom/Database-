package edu.northeastern.cs5200.models;
import javax.persistence.*;

@Entity
@Table(name="ImageWidget")
public class ImageWidget extends Widget {
	@Column(name="src")
	private String src;





	public ImageWidget(int id, String name, int width, int height, String css_Class, String css_Style, String text,
			int orderType, String dtype, String src) {
		super(id, name, width, height, css_Class, css_Style, text, orderType, dtype);
		this.src = src;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	} 
	
	
	
	

}
