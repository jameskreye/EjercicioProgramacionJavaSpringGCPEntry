package cl.people.Ejercicio.student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import cl.people.Ejercicio.exceptions.SNotFoundException;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	// method that return all the students

	public List<Student> getAllStudents(String courseCode) {
		List<Student> students = new ArrayList<>();
		studentRepository.findByCourseCode(courseCode).forEach(students::add);
		return students;
	}

	// method that return a specific student by the given rut and will return an
	// error message if not found

	public ResponseEntity<Student> getStudent(String rut) throws SNotFoundException {
		Student studentOp = studentRepository.findById(rut)
				.orElseThrow(() -> new SNotFoundException("Student not found with rut : " + rut.toString()));
		return ResponseEntity.ok().body(studentOp);

	}

	// method that add a course to the database and returns 201 status code if
	// created

	public ResponseEntity<String> addStudent(Student student) {
		if (!student.getRut().isEmpty()) {
			studentRepository.save(student);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

	// method that update a student infos by the given id

	public ResponseEntity<Student> updateStudent(String rut, Student student) throws SNotFoundException {
		Student studentOp = studentRepository.findById(rut)
				.orElseThrow(() -> new SNotFoundException("Student not found with rut : " + rut.toString()));

		studentOp.setName(student.getName());
		studentOp.setLastName(student.getLastName());
		studentOp.setAge(studentOp.getAge());
		final Student updateStudent = studentRepository.save(studentOp);
		return ResponseEntity.ok(updateStudent);
	}

	// delete a specific student with a given rut, if the student does not exist
	// will return a message
	// otherwise a succesfull message

	public Map<String, Boolean> deleteStudent(String rut) throws SNotFoundException {
		Student studentOp = studentRepository.findById(rut)
				.orElseThrow(() -> new SNotFoundException("Student not found with rut : " + rut.toString()));

		studentRepository.delete(studentOp);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Student deleted succesfully ! ", Boolean.TRUE);
		return response;
	}

}
