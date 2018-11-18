package edu.northeastern.cs5200.repositories;




import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.northeastern.cs5200.models.Faculty;
import edu.northeastern.cs5200.models.Person;

public interface FacultyRepository extends CrudRepository<Faculty, Integer> {

	
	@Query("SELECT p from Faculty p WHERE p.id=:id")
	public Faculty findFacultyById(@Param("id") int id);
}
