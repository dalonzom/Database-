package edu.northeastern.cs5200.daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import edu.northeastern.cs5200.models.Course;
import edu.northeastern.cs5200.models.Enrollment;
import edu.northeastern.cs5200.models.Faculty;
import edu.northeastern.cs5200.models.Person;
import edu.northeastern.cs5200.models.Section;
import edu.northeastern.cs5200.models.Student;
import edu.northeastern.cs5200.repositories.CourseRepository;
import edu.northeastern.cs5200.repositories.EnrollmentRepository;
import edu.northeastern.cs5200.repositories.FacultyRepository;
import edu.northeastern.cs5200.repositories.PersonRepository;
import edu.northeastern.cs5200.repositories.SectionRepository;
import edu.northeastern.cs5200.repositories.StudentRepository;


@Component
public class UniversityDAO {

	@Autowired
	PersonRepository personRepository; 
	@Autowired
	FacultyRepository facultyRepository; 
	@Autowired 
	StudentRepository studentRepository; 
	@Autowired
	CourseRepository courseRepository; 
	@Autowired
	SectionRepository sectionRepository; 
	@Autowired 
	EnrollmentRepository enrollmentRepository; 
	
	public void truncateDatabase() 
	{
		enrollmentRepository.deleteAll();
		sectionRepository.deleteAll();
		courseRepository.deleteAll();
		
		
		facultyRepository.deleteAll();
		studentRepository.deleteAll();
		personRepository.deleteAll();

		
	}
	
	public Faculty createFaculty(Faculty faculty)
	{
		facultyRepository.save(faculty); 
	//	personRepository.save(faculty); 
		return faculty; 
	}
	public Student createStudent(Student student)
	{
		studentRepository.save(student); 
		//personRepository.save(student); 
		return student; 
	}
	public Course createCourse(Course course)
	{
		courseRepository.save(course); 
		return course; 
	}
	public Section createSection(Section section)
	{
		sectionRepository.save(section); 
		return section; 
	}
	
	public Course addSectionToCourse(Section section, Course course)
	{
		section.setCourse(course);
		sectionRepository.save(section);
		List<Section> sections = new ArrayList(); 
		if (course.getSections() != null)
			for(Section here: course.getSections() )
				sections.add(here); 
				
		sections.add(section); 
		course.setSections(sections);
		courseRepository.save(course); 
		return course; 
	}
	public Course setAuthorForCourse(Faculty faculty, Course course)
	{
		List<Course> courses = new ArrayList(); 
		if(faculty.getAuthoredCourses() != null)
			for(Course here: faculty.getAuthoredCourses())
				courses.add(here); 
				
		courses.add(course); 
		faculty.setAuthoredCourses(courses);
		facultyRepository.save(faculty); 
		
		course.setAuthor(faculty);
		courseRepository.save(course);
		return course; 
	}
	public Boolean enrollStudentInSection(Student student, Section section) 
	{
		int seats = section.getSeats(); 
		if(seats == 0)
			return false; 
		else
		{
			section.setSeats(seats-1);
			sectionRepository.save(section); 
			
			Enrollment enrollment = new Enrollment(student, section); 
			enrollmentRepository.save(enrollment); 
			return true; 
		}
	}
	public Enrollment createEnrollment(Enrollment enrollment)
	{
		enrollmentRepository.save(enrollment); 
		return enrollment; 
	}

	public List<Person> findAllUsers()
	{ 
		List<Faculty> faculty = (List<Faculty>) facultyRepository.findAll(); 
		List<Student> student = (List<Student>) studentRepository.findAll();
		List<Person> people = new ArrayList<Person>(); 
		for (Faculty person: faculty)
		{
			people.add(person); 
		}
		for (Student person: student)
		{
			people.add(person); 
		}
		
		return people; 
	}
	
	public List<Student> findAllStudents()
	{
		List<Student> student = (List<Student>) studentRepository.findAll(); 
		return student;
	}


	public List<Faculty> findAllFaculty()
	{
		List<Faculty> faculty = (List<Faculty>) facultyRepository.findAll(); 
		return faculty; 
	}
	
	public List<Course> findAllCourses()
	{
		List<Course> courses = (List<Course>) courseRepository.findAll(); 
		return courses;
	}
	public  List<Section> findAllSections()
	{
		List<Section> sections = (List<Section>) sectionRepository.findAll(); 
		return sections; 
	}
	
	public List<Course> findCoursesForAuthor(Faculty faculty)
	{	
		return courseRepository.findCoursesForAuthor(faculty); 
	}
	public List<Section> findSectionForCourse(Course course)
	{
		return sectionRepository.findSectionForCourse(course); 
	}
	public List<Student> findStudentsInSection(Section section)
	{
		List<Enrollment> enrollments = enrollmentRepository.findStudentsBySection(section);
		List<Student> students = new ArrayList(); 
		try
		{
			for(Enrollment enrollment: enrollments)
				students.add(enrollment.getStudent()); 
		}
		catch(NullPointerException e)
		{
			System.out.println("No Enrollments Found");
		}
	
		
		return students; 
	}
	public List<Section> findSectionsForStudent(Student student)
	{
		List<Enrollment> enrollments = enrollmentRepository.findSectionsForStudent(student); 
		List<Section> sections = new ArrayList(); 
		try
		{
			for(Enrollment enrollment: enrollments)
				sections.add(enrollment.getSection()); 
		}
		catch(NullPointerException e)
		{
			System.out.println("No Enrollments found");
		}
		
		
		return sections; 
	}
	 

	
	
	
}
