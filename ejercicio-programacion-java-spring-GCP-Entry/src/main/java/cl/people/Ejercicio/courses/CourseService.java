package cl.people.Ejercicio.courses;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	//method that return all the courses
	public List<Course> getAllCourses() {
		List<Course> courses = new ArrayList<>();
		courseRepository.findAll().forEach(courses::add);
		return courses;
	}
	
	//method that return a specific course by its id from the DDBB
	public Optional<Course> getCoursebyId(String id) {
		return courseRepository.findById(id);
	}

	//method that add a course to the database
	public void addCourse(Course course) {
		courseRepository.save(course);
	}
	
	//method that update a course in the DDBB
	public void updateCoursebyId(String id, Course course) {
		List<Course> courses = new ArrayList<>();
		courseRepository.findAll().forEach(courses::add);
		
		for(int i = 0; i < courses.size(); i++) {
			Course cs = courses.get(i);
			if(cs.getCode().equals(id)) {
				courses.set(i, course);
				return;
			}
		}
	}
	
	//method that delete a course from the DDBB by its id
	public void deleteCoursebyId(String id) {
		courseRepository.deleteById(id);
	}
	
}
