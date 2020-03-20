package cl.people.Ejercicio.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	// method that return all the students
	public List<Student> getAllStudents(String courseId) {
		List<Student> students = new ArrayList<>();
		studentRepository.findByCourseId(courseId).forEach(students::add);
		return students;
	}
	
	//method that return an specific student by the given id
	public Optional<Student> getStudent(String id){
		return studentRepository.findById(id);
	}
	
	//method that add a student
	public void addStudent(Student student) {
		studentRepository.save(student);
	}
	
	//method that update a student infos by the given id
	public void updateStudent(String id, Student student) {
		List<Student> students = new ArrayList<>();
		studentRepository.findByCourseId(id).forEach(students::add);
		
		for(int i = 0; i < students.size(); i++) {
			Student st = students.get(i);
			if(st.getRut().equals(id)) {
				students.set(i, student);
				return;
			}
		}
		
	}
	
	//method that delete a student by the given id
	public void deleteStudent(String id) {
		studentRepository.deleteById(id);
	}
	
	
	
}
