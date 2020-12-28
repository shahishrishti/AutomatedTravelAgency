package com.cgtravelagency.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = {BookingNotFoundException.class})
	public ResponseEntity<ErrorMessage> handleEmployeeNotFoundException(
			BookingNotFoundException ex) {
		String error = "Booking is not found";

		ErrorMessage errorMessage = 
	      new ErrorMessage(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
	    return new ResponseEntity<ErrorMessage>(
	    		errorMessage, new HttpHeaders(), errorMessage.getStatus());
		
	}
	
	@ExceptionHandler(value = {InvalidVehicleDataException.class})
	public ResponseEntity<ErrorMessage> handleInvalidVehicleDataException(InvalidVehicleDataException ex) {
		String error = "Invalid vehicle data.";

		ErrorMessage errorMessage = 
	      new ErrorMessage(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
	    return new ResponseEntity<ErrorMessage>(
	    		errorMessage, new HttpHeaders(), errorMessage.getStatus());
		
	}
	
	@ExceptionHandler(value = {InvalidDriverDataException.class})
	public ResponseEntity<ErrorMessage> handleInvalidDriverDataException(InvalidDriverDataException ex) {
		String error = "Invalid vehicle data.";

		ErrorMessage errorMessage = 
	      new ErrorMessage(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
	    return new ResponseEntity<ErrorMessage>(
	    		errorMessage, new HttpHeaders(), errorMessage.getStatus());
		
	}
	
	@ExceptionHandler(value = {InvalidRouteDataException.class})
	public ResponseEntity<ErrorMessage> handleInvalidRouteDataException(InvalidRouteDataException ex) {
		String error = "Invalid vehicle data.";

		ErrorMessage errorMessage = 
	      new ErrorMessage(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
	    return new ResponseEntity<ErrorMessage>(
	    		errorMessage, new HttpHeaders(), errorMessage.getStatus());
		
	}
	
	@ExceptionHandler(value = {VehicleNotFoundException.class})
	public ResponseEntity<ErrorMessage> handleVehicleNotFoundException(VehicleNotFoundException ex) {
		String error = "Invalid vehicle data.";

		ErrorMessage errorMessage = 
	      new ErrorMessage(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
	    return new ResponseEntity<ErrorMessage>(
	    		errorMessage, new HttpHeaders(), errorMessage.getStatus());
		
	}
	
	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status,
            WebRequest request) {
		List<String> errors = new ArrayList<>();
		for(FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
			errors.add(fieldError.getField() + " - " + fieldError.getDefaultMessage());
		}
		for(ObjectError objectError : ex.getBindingResult().getGlobalErrors()) {
			errors.add(objectError.getObjectName() + " - " + objectError.getDefaultMessage());
		}
		ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST, 
				ex.getLocalizedMessage(), errors);
		return handleExceptionInternal(ex, errorMessage, headers, HttpStatus.BAD_REQUEST, request);
	}
}
