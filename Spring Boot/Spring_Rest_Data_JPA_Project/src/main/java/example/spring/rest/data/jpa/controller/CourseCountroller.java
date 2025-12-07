package example.spring.rest.data.jpa.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import example.spring.rest.data.jpa.entity.Course;
import example.spring.rest.data.jpa.service.CourseService;

@RestController
public class CourseCountroller {
	@Autowired
	private CourseService serviceObject;
	
	@GetMapping("/courses")
	public Collection<Course> getAllCourses()
	{
		Collection<Course> allCourses = serviceObject.getAllCourses();
		return allCourses;
	}

	@GetMapping("/courses/{crsId}")  //crsid is called as PathVariable
	public Course getSingleCourse(@PathVariable("crsId") String courseId)
	{
		Course foundCourse = serviceObject.getSingleCourse(courseId);
		return foundCourse;
	}
	
	@PostMapping("/courses")
	public void createNewCourse(@RequestBody Course courseObject)
	//RequestBody ==> used to capture the data available in REQUEST object
	{
		serviceObject.createNewCourse(courseObject);
	}
	
}