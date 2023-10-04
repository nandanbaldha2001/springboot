package com.nandan.restapi.rest;
import java.util.ArrayList;
import java.util.List;

import com.nandan.restapi.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class StudentRestController {

  private List<Student> theStudent;

  @PostConstruct
  public void Data(){
    theStudent=new ArrayList<>();
    theStudent.add(new Student("bhumi","patel"));
    theStudent.add(new Student("disha","patel"));
    theStudent.add(new Student("khushi","patel"));

  }


  @GetMapping("/students")
  public List<Student> getStudents(){
  return theStudent;
  }


  // add endpoint for student/{studentId}
  @GetMapping("/students/{studentId}")
  public Student getStudent(@PathVariable int studentId){
    if(studentId<0 || studentId>=theStudent.size()){
      throw  new StudentNotFoundException("Student Id is not found");
    }
    return  theStudent.get(studentId);
  }



}
