package com.nandan.springboot.cruddemo.service;

//import com.nandan.springboot.cruddemo.dao.EmployeeDAO;
import com.nandan.springboot.cruddemo.dao.EmployeeRepository;
import com.nandan.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements  EmployeeService {
  private EmployeeRepository employeeRepository;

  @Autowired
  public  EmployeeServiceImpl(EmployeeRepository theEmployeeRepository){
  employeeRepository =theEmployeeRepository;
  }
  @Override
  public List<Employee> findAll() {
    return employeeRepository.findAll();
  }

  @Override
  public Employee findById(int theID) {
    Optional<Employee> result = employeeRepository.findById(theID);
    Employee theEmployee=null;
    if(result.isPresent()){
      theEmployee=result.get();
    }
    else{
      throw  new RuntimeException("Employee id is not found");
    }
    return theEmployee;
  }

  @Override
  public Employee save(Employee theEmployee) {
    return employeeRepository.save(theEmployee);
  }


  @Override
  public void deleteByID(int theId) {
    employeeRepository.deleteById(theId);
  }
}
