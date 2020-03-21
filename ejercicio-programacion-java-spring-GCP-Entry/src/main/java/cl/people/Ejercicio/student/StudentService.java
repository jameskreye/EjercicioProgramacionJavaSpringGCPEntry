package cl.people.Ejercicio.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
	
	//return paginated students
	public Page<Student> getAllSttudentsPaginated(Pageable pageable){
		return (Page<Student>) studentRepository.findAll();
	}
	
	//method that return an specific student by the given id
	public Optional<Student> getStudent(String rut){
		return studentRepository.findById(rut);
	}
	
	//method that add a student
	public void addStudent(Student student) {
		studentRepository.save(student);
	}
	
	//method that update a student infos by the given id
	public void updateStudent(String rut, Student student) {
		List<Student> students = new ArrayList<>();
		studentRepository.findByCourseCode(rut).forEach(students::add);
		
		for(int i = 0; i < students.size(); i++) {
			Student st = students.get(i);
			if(st.getRut().equals(rut)) {
				students.set(i, student);
				return;
			}
		}
		
	}
	
	//method that delete a student by the given id
	public void deleteStudent(String rut) {
		studentRepository.deleteById(rut);
	}
	
	
	
}
