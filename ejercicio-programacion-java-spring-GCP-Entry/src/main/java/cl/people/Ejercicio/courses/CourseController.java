package cl.people.Ejercicio.courses;

import java.util.List;
import java.util.Map;


import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cl.people.Ejercicio.exceptions.SNotFoundException;


@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	
	//Get verb to retrieve all the courses
	@RequestMapping("/courses")
	public List<Course> getAllCourses() {
		return courseService.getAllCourses();
	}
	
	//Get paginated courses
	@GetMapping
	public @ResponseBody Page<Course> getAllCoursesPaginated(Pageable pageable){
		return courseService.getAllCoursesPaginated(pageable);
	}
	
	
	//Get verb to retrieve a course by id
	@RequestMapping("/courses/{code}")
	public ResponseEntity<Course> getCoursebyId(@PathVariable String code) throws SNotFoundException {
		return courseService.getCoursebyId(code);
	}
	
	
	//Making a Post Request
	@RequestMapping(method = RequestMethod.POST, value = "/courses") 
		public ResponseEntity<String> addCourse(@Valid @RequestBody Course course) {
		return courseService.addCourse(course);
	}
	
	//Updating a course in the DDBB with tyhe PUT verb
	@RequestMapping(method = RequestMethod.PUT, value = "/courses/{code}")
	public ResponseEntity<Course> updateCoursebyId(@RequestBody Course course, @PathVariable String code) throws SNotFoundException {
		return courseService.updateCoursebyId(code, course);
	}
	
	//Delete a course in the DDBB with the DELETE verb
	@RequestMapping(method = RequestMethod.DELETE, value = "/courses/{code}")
	public Map<String, Boolean> deleteCoursebyId(@PathVariable String code) throws SNotFoundException {
		return courseService.deleteCoursebyId(code);
	}
}
