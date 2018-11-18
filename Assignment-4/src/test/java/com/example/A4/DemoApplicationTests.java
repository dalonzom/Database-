package com.example.A4;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.northeastern.cs5200.repositories.CourseRepository;
import edu.northeastern.cs5200.repositories.FacultyRepository;
import edu.northeastern.cs5200.repositories.PersonRepository;
import edu.northeastern.cs5200.repositories.SectionRepository;
import edu.northeastern.cs5200.repositories.StudentRepository;
import edu.northeastern.cs5200.DemoApplication;
import edu.northeastern.cs5200.daos.UniversityDAO;
import edu.northeastern.cs5200.models.Course;
import edu.northeastern.cs5200.models.Enrollment;
import edu.northeastern.cs5200.models.Faculty;
import edu.northeastern.cs5200.models.Person;
import edu.northeastern.cs5200.models.Section;
import edu.northeastern.cs5200.models.Student;


@RunWith(SpringRunner.class)
@SpringBootTest(classes={DemoApplication.class})
public class DemoApplicationTests {
	
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
	UniversityDAO universityDAO;
	 

	@Test
	public void createDatabase()
	{
		
		universityDAO.truncateDatabase();
		Faculty alan = new Faculty("alan", "password", "Alan", "Turin", "123A",
				true); 
		universityDAO.createFaculty(alan); 
		
		Faculty ada = new Faculty("ada", "password", "Ada", "Lovelace", "123B", true); 
		universityDAO.createFaculty(ada); 
		
		Student alice = new Student("alice", "password", "Alice", "Wonderland", 
				2020, 12000); 
		universityDAO.createStudent(alice); 
		
		Student bob = new Student("bob", "password", "Bob", "Hope", 2021, 23000); 
		universityDAO.createStudent(bob); 
		
		Student charlie = new Student("charlie", "password", "Charlie", "Brown", 2019, 21000); 
		universityDAO.createStudent(charlie);
		
		Student dan = new Student("dan", "password", "Dan", "Craig", 2019, 0); 
		universityDAO.createStudent(dan);
		
		Student ed = new Student("edward", "password", "Edward", "Scissorhands", 2022, 11000); 
		universityDAO.createStudent(ed);
		
		Student frank = new Student("frank", "password", "Frank", "Herbert", 2018, 0); 
		universityDAO.createStudent(frank);
		
		Student greg = new Student("gregory", "password", "Gregory", "Peck", 2023, 10000); 
		universityDAO.createStudent(greg);
		
		Course one = new Course("CS1234", alan); 
		universityDAO.createCourse(one); 
		
		Course two = new Course("CS2345", alan); 
		universityDAO.createCourse(two); 
		
		
		Course three = new Course("CS3456", ada); 
		universityDAO.createCourse(three); 
		
		
		Course four = new Course("CS4567", ada); 
		universityDAO.createCourse(four); 
		
		
		Section first = new Section(50, "SEC4321", one); 
		universityDAO.createSection(first); 
		universityDAO.addSectionToCourse(first, one); 
	
		Section second = new Section(50, "SEC5432", one); 
		universityDAO.createSection(second); 
		universityDAO.addSectionToCourse(second, one); 
		
		Section third = new Section(50, "SEC6543", two); 
		universityDAO.createSection(third); 
		universityDAO.addSectionToCourse(third, two);
		
		Section fourth = new Section(50, "SEC7654", three); 
		universityDAO.createSection(fourth); 
		universityDAO.addSectionToCourse(fourth, three); 
		
	
		Enrollment alice1 = new Enrollment(alice, first); 
		universityDAO.createEnrollment(alice1); 
		
		Enrollment alice2 = new Enrollment(alice, second); 
		universityDAO.createEnrollment(alice2); 
		
		Enrollment bob1 = new Enrollment(bob, second); 
		universityDAO.createEnrollment(bob1); 
		
		Enrollment charlie1 = new Enrollment(charlie, third); 
		universityDAO.createEnrollment(charlie1); 
	
		
	}

	
	@Test 
	public void validateUsers()
	{
		List<Person> users = universityDAO.findAllUsers(); 
		System.out.println("Number of Users is " + users.size());
	}
 
	
	@Test
	public void validateFaculty()
	{
		List<Faculty> faculty = universityDAO.findAllFaculty(); 
		System.out.println("Number of Faculty is " + faculty.size());
	}

	
	@Test
	public void validateStudents()
	{
		List<Student> students = universityDAO.findAllStudents();
		System.out.println("Number of Students is " + students.size());
	}
	

	@Test
	public void validateCourses()
	{
		List<Course> courses = universityDAO.findAllCourses();
		System.out.println("Number of Courses is " + courses.size());
	}
	
	
	@Test
	public void validateSections()
	{
		List<Section> sections = universityDAO.findAllSections();
		System.out.println("Number of Sections is " + sections.size());
	}

 

	@Test
	public void validateCourseAuthorship()
	{

		List<Faculty> faculty = universityDAO.findAllFaculty(); 
		try {
			
			for(Faculty person: faculty)
			{

				List<Course> courses = universityDAO.findCoursesForAuthor(person); 
				System.out.println(person.getFirstName() + " authors " + courses.size() + " courses");	
			}
			}
		catch(NullPointerException e)
		{
			System.out.println("No faculty found");
		}
	} 

	@Test 
	public void validateSectionsPerCourse()
	{
		List<Course> courses = universityDAO.findAllCourses(); 
		try
		{
			for(Course course: courses)
			{
				List<Section> sections = universityDAO.findSectionForCourse(course); 
				System.out.println("Number of Sections for " + course.getLabel()+ " is "+ sections.size());
			}
		}
		catch(NullPointerException e)
		{
			System.out.println("No courses found" );
		}
	}

 
	
	@Test
	public void validateSectionEnrollments()
	{
		List<Section> sections = universityDAO.findAllSections(); 
		try
		{
			for(Section section: sections)
			{
				List<Student> students = universityDAO.findStudentsInSection(section); 
				System.out.println("There are " + students.size() + " Students enrolled in " + section.getTitle());
				
			}
		}
		catch(NullPointerException e)
		{
			System.out.println("No Sections Found");
		}
	}

	
	@Test
	public void validateStudentEnrollments()
	{
		List<Student> students = universityDAO.findAllStudents(); 
		try
		{
			for(Student student: students)
			{
				List<Section> sections = universityDAO.findSectionsForStudent(student); 
				System.out.println(student.getFirstName()+ " is enrolled in " + sections.size() + " sections");
				
			}
		}
		catch(NullPointerException e)
		{
			System.out.println("No Sections Found");
		}
	}
	
	@Test
	public void validateSectionSeats()
	{
		List<Section> sections = universityDAO.findAllSections(); 
		try
		{
			for(Section section: sections)
			{
				System.out.println("Section "+ section.getTitle() + " has " + section.getSeats() + "open seats");
			}
		}
		catch(NullPointerException e)
		{
			System.out.println("No sections found");
		}
	}




	
	

}
