package cl.people.Ejercicio.exceptions;

public class SNotFoundException extends RuntimeException {
	
	static final long serialVersionUID = 4L;
	
	public SNotFoundException(String error) {
		super(error);
	}
}
