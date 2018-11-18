package edu.northeastern.cs5200.repositories;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.northeastern.cs5200.models.Enrollment;
import edu.northeastern.cs5200.models.Section;
import edu.northeastern.cs5200.models.Student;

public interface EnrollmentRepository extends CrudRepository<Enrollment, Integer>{

	
	@Query("SELECT e FROM Enrollment e WHERE section=:section")
	public List<Enrollment> findStudentsBySection( @Param("section") Section section); 
	
	@Query("SELECT e FROM Enrollment e WHERE student=:student")
	public List<Enrollment> findSectionsForStudent(@Param("student") Student student); 
	
	

}

