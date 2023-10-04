package com.nandan.restapi.rest;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {
  @ExceptionHandler(StudentNotFoundException.class)
  public ResponseEntity<StudentErrorRespons> handleException(StudentNotFoundException ex){
    StudentErrorRespons error=new StudentErrorRespons();
    error.setStatus(HttpStatus.NOT_FOUND.value());
    error.setMessage(ex.getMessage());
    error.setTimeStamp(System.currentTimeMillis());
    return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
  }


  @ExceptionHandler(Exception.class)
  public ResponseEntity<StudentErrorRespons> handleAllException(Exception ec){
    StudentErrorRespons error=new StudentErrorRespons();
    error.setStatus(HttpStatus.BAD_REQUEST.value());
    error.setMessage(ec.getMessage());
    error.setTimeStamp(System.currentTimeMillis());
    return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);

  }
}
