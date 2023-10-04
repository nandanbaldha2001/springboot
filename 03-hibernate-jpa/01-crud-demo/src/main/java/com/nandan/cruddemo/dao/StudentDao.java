package com.nandan.cruddemo.dao;

import com.nandan.cruddemo.entity.Student;

import java.util.List;

public interface StudentDao {
  void save(Student theStudent);
  Student findById(int id);
  List<Student> allStudent();

  List<Student> findByLastName(String lastName);

  void update(Student theStudent);

  void delete(Integer id);
  int deleteAll();
}
