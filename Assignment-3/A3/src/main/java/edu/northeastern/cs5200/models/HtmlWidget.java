package edu.northeastern.cs5200.models;
import javax.persistence.*;

@Entity
@Table(name="HTMLWidget")
public class HtmlWidget extends Widget {
	
	@Column(name="html")
	private String html;

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public HtmlWidget(int id, String name, int width, int height, String css_Class, String css_Style, String text,
			int orderType, String dtype, String html) {
		super(id, name, width, height, css_Class, css_Style, text, orderType, dtype);
		this.html = html;
	}






	

}
