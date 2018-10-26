package edu.northeastern.cs5200.models;
import javax.persistence.*;

@Entity
@Table(name="YouTubeWidget")
public class YouTubeWidget  extends Widget {
	
	@Column(name="url")
	private String url; 
	@Column(name="shareable")
	private boolean shareable; 
	@Column(name="expandable")
	private boolean expandable;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public boolean isShareable() {
		return shareable;
	}
	public void setShareable(boolean shareable) {
		this.shareable = shareable;
	}
	public boolean isExpandable() {
		return expandable;
	}
	public void setExpandable(boolean expandable) {
		this.expandable = expandable;
	}
	public YouTubeWidget(int id, String name, int width, int height, String css_Class, String css_Style, String text,
			int orderType, String dtype, String url, boolean shareable, boolean expandable) {
		super(id, name, width, height, css_Class, css_Style, text, orderType, dtype);
		this.url = url;
		this.shareable = shareable;
		this.expandable = expandable;
	}




	
	

}
