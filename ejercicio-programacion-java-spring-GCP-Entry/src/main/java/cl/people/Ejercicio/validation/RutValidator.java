package cl.people.Ejercicio.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RutValidator implements ConstraintValidator<RutConst, String>{

	@Override
	public void initialize(RutConst constraintAnnotation) {
		ConstraintValidator.super.initialize(constraintAnnotation);
	}
	
	@Override
	public boolean isValid(String rutValue, ConstraintValidatorContext context) {
		return  Validation.validateRut(rutValue);
	}
	
}
