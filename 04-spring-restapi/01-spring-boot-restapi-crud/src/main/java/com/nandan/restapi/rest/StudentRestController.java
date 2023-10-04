package com.nandan.restapi.rest;
import java.util.ArrayList;
import java.util.List;

import com.nandan.restapi.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StudentRestController {

  @GetMapping("/students")
  public List<Student> getStudents(){
    List<Student> studentList=new ArrayList<>();
    studentList.add(new Student("bhumi","patel"));
    studentList.add(new Student("disha","patel"));
    studentList.add(new Student("khushi","patel"));
    return  studentList;
  }
}
