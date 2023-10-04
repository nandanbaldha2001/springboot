package com.nandan.springboot.cruddemo.dao;

import com.nandan.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaojpaimpl implements  EmployeeDAO{

  private EntityManager entityManager;

  @Autowired
  public EmployeeDaojpaimpl(EntityManager theentityManager){
    entityManager=theentityManager;
  }
  @Override
  public List<Employee> findAll() {
    TypedQuery<Employee> theQuery=entityManager.createQuery( "from Employee",Employee.class);
    List<Employee> employees=theQuery.getResultList();
    return employees;
    //return null;
  }

  @Override
  public Employee findById(int theID) {
    Employee theEmployee=entityManager.find(Employee.class,theID);
    return theEmployee;
  }

  @Override
  public Employee save(Employee theEmployee) {
    Employee dbEmployee=entityManager.merge(theEmployee);
    return dbEmployee;
  }

  @Override
  public void deleteByID(int id) {
    Employee theEmployee=entityManager.find(Employee.class, id);
    entityManager.remove(theEmployee);
  }
}
