package mbs.pet.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PetControllerAdvice {

	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String petNotFoundHandler(IllegalArgumentException ex) {
		return ex.getMessage();
	}
	
	@ExceptionHandler(PetValidationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	String petValidationHandler(PetValidationException ex) {
		return ex.getMessage();
	}
	
	
}
