package cl.people.Ejercicio.courses;

import javax.persistence.Id;
import javax.validation.constraints.Size;

public class Course {
	
	@Id
	@Size(max = 4, message = "Code must have maximum 4 characters")
	private String code;
	
	private String name;

	public Course() {
		super();
	}

	public Course(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	

}
