package edu.northeastern.cs5200.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.northeastern.cs5200.models.Course;
import edu.northeastern.cs5200.models.Faculty;

public interface CourseRepository extends CrudRepository<Course, Integer>{
	
	@Query("SELECT s FROM  Course s WHERE s.author=:faculty")
	public List<Course> findCoursesForAuthor( @Param("faculty") Faculty faculty);
	
	@Query("SELECT s FROM Course s WHERE s.id=:id")
	public Course findCourseById(@Param("id") int id); 

}
