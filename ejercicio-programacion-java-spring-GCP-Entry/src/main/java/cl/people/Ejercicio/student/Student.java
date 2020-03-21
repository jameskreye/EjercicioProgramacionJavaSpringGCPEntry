package cl.people.Ejercicio.student;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import cl.people.Ejercicio.courses.Course;
import cl.people.Ejercicio.validation.AgeConst;
import cl.people.Ejercicio.validation.RutConst;

@Entity
public class Student {
	
	@Id
	@RutConst
	private String rut;
	private String name;
	private String lastName;
	@AgeConst
	private Integer age;
	
	@ManyToOne // a student can attend many courses
	private Course course;
	public Student() {

	}

	public Student(String rut, String name, String lastName, int age, String courseId) {
		super();
		this.rut = rut;
		this.name = name;
		this.lastName = lastName;
		this.age = age;
		this.course = new Course(courseId, "");
	}

	
	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
		

}
