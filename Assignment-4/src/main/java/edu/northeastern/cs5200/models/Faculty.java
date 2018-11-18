package edu.northeastern.cs5200.models;



import java.util.List;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

@Entity 
public class Faculty extends Person{
	
		private String office; 
		private boolean tenured;
		
		@OneToMany(mappedBy="author")
		 private List<Course> authoredCourses;
		 
		public String getOffice() {
			return office;
		}
		public void setOffice(String office) {
			this.office = office;
		}
		public boolean isTenured() {
			return tenured;
		}
		public void setTenured(boolean tenured) {
			this.tenured = tenured;
		}
		
		public List<Course> getAuthoredCourses() {
			return authoredCourses;
		}
		public void setAuthoredCourses(List<Course> authoredCourses) {
			this.authoredCourses = authoredCourses;
		}
		public Faculty(String username, String password, String firstName, String lastName, String office,
				boolean tenured) {
			super(username, password, firstName, lastName);
			this.office = office;
			this.tenured = tenured;
		}
		public Faculty(String username, String password, String firstName, String lastName, String office,
				boolean tenured, List<Course> authoredCourses) {
			super(username, password, firstName, lastName);
			this.office = office;
			this.tenured = tenured;
			this.authoredCourses = authoredCourses;
		}
		
		public Faculty()
		{ super();}
		
		
	

}
