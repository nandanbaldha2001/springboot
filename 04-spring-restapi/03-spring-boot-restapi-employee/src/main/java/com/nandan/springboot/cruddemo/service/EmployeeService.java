package com.nandan.springboot.cruddemo.service;

import com.nandan.springboot.cruddemo.entity.Employee;
import java.util.List;

public interface EmployeeService {

  List<Employee> findAll();
  Employee findById(int theID);
  Employee save(Employee theEmployee);
  void deleteByID(int theId);
}
