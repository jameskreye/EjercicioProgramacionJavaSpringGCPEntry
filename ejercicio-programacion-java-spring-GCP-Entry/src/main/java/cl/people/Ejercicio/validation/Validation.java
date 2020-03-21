package cl.people.Ejercicio.validation;

public class Validation {

	//This method validate a chilean rut by the dv.
	public static boolean validateRut(String rut) {
		boolean valid = false;

		try {
			rut = rut.toUpperCase();
			rut = rut.replace(".", "");
			rut = rut.replace("-", "");
			int rutFi = Integer.parseInt(rut.substring(0, rut.length() - 1));

			char dv = rut.charAt(rut.length() - 1);

			int ab = 0, ac = 1;

			for (; rutFi != 0; rutFi /= 10) {
				ac = (ac + rutFi % 10 * (9 - ab++ % 6)) % 11;
			}
			if (dv == (char) (ac != 0 ? ac + 47 : 75)) {
				valid = true;
			}

		} catch (java.lang.NumberFormatException e1) {
		} catch (Exception e) {
		}

		return valid;

	}

	// method that validates if the student age entered is bigger than 17
	public static boolean validateAge(Integer age) {

		boolean valid = false;

		try {
			if (age > 18) {
				valid = true;
			}
		} catch (java.lang.NumberFormatException e1) {
		} catch (Exception e) {
		}

		return valid;
	}
}
