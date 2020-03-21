package cl.people.Ejercicio.student;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import cl.people.Ejercicio.courses.Course;
import cl.people.Ejercicio.exceptions.SNotFoundException;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	//Return all the students available that belong to the specified course
	@RequestMapping("/courses/{rut}/students") 
	public List<Student> getAllStudents(@PathVariable String rut) {
		return studentService.getAllStudents(rut);
	}
	
	
	//Returns one studend by the Rut provided 
	@GetMapping(path = "/courses/{courseId}/student/{rut}")
	public ResponseEntity<Student> getStudent(@PathVariable String rut) throws SNotFoundException {
		return studentService.getStudent(rut);
	}
	
	//Post verb here to add a student student in the DDBB
	@RequestMapping(method = RequestMethod.POST, value="/courses/{courseId}/students")
	public ResponseEntity<String>  addStudent(@Valid @RequestBody Student student, @PathVariable String courseId) {
		student.setCourse(new Course(courseId,""));
		return studentService.addStudent(student);
	}
	
	//Put verb to update a student infos in the DDBB
	@PutMapping("/courses/{courseId}/students/{rut}")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable String courseId, @PathVariable String rut) throws SNotFoundException {
		return studentService.updateStudent(rut, student);	
	}
	
	
	//Delete verb to delete a student in the DDBB
	@RequestMapping(method = RequestMethod.DELETE, value = "/courses/{courseId}/students/{rut}")
	public Map<String, Boolean> deleteStudent(@PathVariable String rut) throws SNotFoundException {
		return studentService.deleteStudent(rut);
	}
	
	
	
}
