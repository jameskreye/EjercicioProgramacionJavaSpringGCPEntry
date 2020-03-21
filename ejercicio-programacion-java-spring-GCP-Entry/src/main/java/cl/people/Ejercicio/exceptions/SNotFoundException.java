package cl.people.Ejercicio.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class SNotFoundException extends Exception {
	
	public static final long serialVersionUID = 1L;
	
	public SNotFoundException(String message) {
		super(message);
	}
}
