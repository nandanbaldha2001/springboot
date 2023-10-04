package com.nandan.springboot.cruddemo.service;

import com.nandan.springboot.cruddemo.dao.EmployeeDAO;
import com.nandan.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements  EmployeeService {
  private EmployeeDAO employeeDAO;

  @Autowired
  public  EmployeeServiceImpl(EmployeeDAO theEmployeeDao){
  employeeDAO=theEmployeeDao;
  }
  @Override
  public List<Employee> findAll() {
    return employeeDAO.findAll();
  }

  @Override
  public Employee findById(int theID) {
    return employeeDAO.findById(theID);
  }

  @Override
  @Transactional
  public Employee save(Employee theEmployee) {
    return employeeDAO.save(theEmployee);
  }

  @Transactional
  @Override
  public void deleteByID(int theId) {
    employeeDAO.deleteByID(theId);
  }
}
