package example.spring.rest.data.jpa.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.spring.rest.data.jpa.entity.Course;
import example.spring.rest.data.jpa.repo.CourseRepository;

@Service  //marks this class as a service implementation class.
public class CourseService {
	
	@Autowired  //injecting course repository into CourseService
	private CourseRepository repoObject;
	
	public Collection<Course> getAllCourses(){
		Collection<Course> allCourses = repoObject.findAll();
		return allCourses;
	}
	
	public Course getSingleCourse(String courseId)
	{
		Optional<Course> opRef = repoObject.findById(courseId);
		Course foundCourse = null;
		if(opRef.isPresent()) {
			foundCourse = opRef.get();
		}
		return foundCourse;
	}

	public void createNewCourse(Course courseObject)
	{
		repoObject.save(courseObject);
	}

}