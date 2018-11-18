package edu.northeastern.cs5200.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.northeastern.cs5200.models.Course;
import edu.northeastern.cs5200.models.Section;

public interface SectionRepository extends CrudRepository<Section, Integer>{

	@Query("SELECT s FROM Section s WHERE course=:course")
	public List<Section> findSectionForCourse(@Param("course") Course course); 
	
	@Query("SELECT s FROM Section s WHERE id=:id")
	public Section findSectionById( @Param("id") int id); 
}
