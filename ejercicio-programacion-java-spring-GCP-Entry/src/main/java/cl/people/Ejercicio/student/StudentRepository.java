package cl.people.Ejercicio.student;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, String> {
	
	public List<Student> findByCourseId(String courseId); //retrieve all the students by the course Id
	
}
