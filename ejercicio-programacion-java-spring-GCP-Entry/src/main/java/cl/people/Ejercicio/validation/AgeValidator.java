package cl.people.Ejercicio.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<AgeConst, Integer> {
	@Override
	public void initialize(AgeConst constraintAnnotation) {
		ConstraintValidator.super.initialize(constraintAnnotation);
	}
	
	@Override
	public boolean isValid(Integer ageValue, ConstraintValidatorContext context) {
		return Validation.validateAge(ageValue);
	}

}
