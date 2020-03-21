package cl.people.Ejercicio.courses;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	
	//Get verb to retrieve all the courses
	@RequestMapping("/courses")
	public List<Course> getAllCourses() {
		return courseService.getAllCourses();
	}
	
	//Get verb to retrieve a course by id
	@RequestMapping("/courses/{code}")
	public Optional<Course> getCoursebyId(@PathVariable String code) {
		return courseService.getCoursebyId(code);
	}
	
	//Making a Post Request 
	@RequestMapping(method = RequestMethod.POST, value = "/courses") 
		public void addCourse(@RequestBody Course course) {
		courseService.addCourse(course);
	}
	
	//Updating a course in the DDBB with tyhe PUT verb
	@RequestMapping(method = RequestMethod.PUT, value = "/courses/{code}")
	public void updateCoursebyId(@RequestBody Course course, @PathVariable String code) {
		courseService.updateCoursebyId(code, course);
	}
	
	//Delete a course in the DDBB with the DELETE verb
	@RequestMapping(method = RequestMethod.DELETE, value = "/courses/{code}")
	public void deleteCoursebyId(@PathVariable String code) {
		courseService.deleteCoursebyId(code);
	}
}
