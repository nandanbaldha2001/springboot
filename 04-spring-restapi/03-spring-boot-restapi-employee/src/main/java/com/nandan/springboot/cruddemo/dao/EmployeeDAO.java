package com.nandan.springboot.cruddemo.dao;
import java.util.List;

import com.nandan.springboot.cruddemo.entity.Employee;

public interface EmployeeDAO {
  List<Employee> findAll();
  Employee findById(int theID);
  Employee save(Employee theEmployee);
  void deleteByID(int theId);
}
