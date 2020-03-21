package cl.people.Ejercicio.courses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import cl.people.Ejercicio.exceptions.SNotFoundException;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;

	// method that return all the courses
	public List<Course> getAllCourses() {
		List<Course> courses = new ArrayList<>();
		courseRepository.findAll().forEach(courses::add);
		return courses;
	}

	// return paginated courses
	public Page<Course> getAllCoursesPaginated(Pageable pageable) {
		return (Page<Course>) courseRepository.findAll();
	}

	// method that return a specific course by the given code and will return an
	// error message if not found

	public ResponseEntity<Course> getCoursebyId(String code) throws SNotFoundException {
		Course courseOp = courseRepository.findById(code)
				.orElseThrow(() -> new SNotFoundException("Course not found with code : " + code.toString()));
		return ResponseEntity.ok().body(courseOp);

	}

	// method that add a course to the database and returns 201 status code if
	// created

	public ResponseEntity<String> addCourse(Course course) {
		if (!course.getCode().isEmpty()) {
			courseRepository.save(course);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

	// method that update a course in the DDBB and notify if the update is made with
	// success, otherwhise throw an error message

	public ResponseEntity<Course> updateCoursebyId(String code, Course course) throws SNotFoundException {
		Course courseOp = courseRepository.findById(code).orElseThrow(
				() -> new SNotFoundException("Could not update the course with code : " + code.toString()));

		courseOp.setName(course.getName());
		final Course updateCoursebyId = courseRepository.save(courseOp);
		return ResponseEntity.ok(updateCoursebyId);
	}

	// delete a specific course with a given code, if the course does not exist will
	// return an error message
	// otherwise a succesfull message

	public Map<String, Boolean> deleteCoursebyId(String code) throws SNotFoundException {
		Course courseOp = courseRepository.findById(code)
				.orElseThrow(() -> new SNotFoundException("Course not found with code : " + code.toString()));

		courseRepository.delete(courseOp);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Course deleted succesfully ! ", Boolean.TRUE);
		return response;
	}

}
