package cl.people.Ejercicio.student;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, String> {
	
	public List<Student> findByCourseCode(String courseCode); //retrieve all the students by the course Id
	
}
