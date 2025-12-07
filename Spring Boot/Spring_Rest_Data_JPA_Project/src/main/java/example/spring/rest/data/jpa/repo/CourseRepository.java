package example.spring.rest.data.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import example.spring.rest.data.jpa.entity.Course;

//no need of @Repository because JpaRepository is already a Managed Component
// and CourseRepository is extended from it so it slso becomes a managed component
public interface CourseRepository extends JpaRepository<Course,String>{
	//additional methods if any.
	//nothing to be added i only regular CRUD operaions are to be performed.

}