package cl.people.Ejercicio.student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.people.Ejercicio.courses.Course;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	
	@RequestMapping("/courses/{id}/students") 
	public List<Student> getAllStudents(@PathVariable String id) {
		return studentService.getAllStudents(id);
	}
	
	@RequestMapping("/courses/{courseId}/student/{id}")
	public Optional<Student> getStudent(@PathVariable String id) {
		return studentService.getStudent(id);
	}
	
	//Post verb here to add student
	@RequestMapping(method = RequestMethod.POST, value="/courses/{courseId}/students")
	public void addStudent(@RequestBody Student student, @PathVariable String courseId) {
		student.setCourse(new Course(courseId,""));
		studentService.addStudent(student);
	}
	
	//Put verb to update a student infos
	@RequestMapping(method = RequestMethod.PUT, value="/courses/{courseId}/students/{id}")
	public void updateStudent(@RequestBody Student student, @PathVariable String courseId, @PathVariable String id) {
		studentService.updateStudent(id, student);	
	}
	
	
	//Delete verb to delete a student in the DDBB
	@RequestMapping(method = RequestMethod.DELETE, value = "/courses/{courseId}/students/{id}")
	public void deleteStudent(@PathVariable String id) {
		studentService.deleteStudent(id);
	}
	
	
	
}
