package com.employee.testscotia.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.employee.testscotia.models.ErrorMessage;

@SuppressWarnings({"unchecked","rawtypes"})
@ControllerAdvice
public class DataNotFoundExceptionMapper extends ResponseEntityExceptionHandler {
	@ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorMessage error = new ErrorMessage("Server Error", details);
        return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
 
    @ExceptionHandler(DataNotFoundExceprion.class)
    public final ResponseEntity<Object> handleDataNotFoundException(DataNotFoundExceprion ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorMessage error = new ErrorMessage("Record Not Found", details);
        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    protected ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex,
                                     WebRequest request) {
    	List<String> details = new ArrayList<>();
    	details.add(ex.getLocalizedMessage());
    	ErrorMessage error = new ErrorMessage();
    	error.setMessage(String.format("The parameter '%s' of value '%s' could not be converted to type '%s'", ex.getName(), ex.getValue(), ex.getRequiredType().getSimpleName()));
    	error.setErrorDetail(details);
    	return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }
}
