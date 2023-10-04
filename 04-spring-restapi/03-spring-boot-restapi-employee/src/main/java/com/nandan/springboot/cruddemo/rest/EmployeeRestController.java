package com.nandan.springboot.cruddemo.rest;
import java.util.List;


import com.nandan.springboot.cruddemo.dao.EmployeeDAO;
import com.nandan.springboot.cruddemo.entity.Employee;
import com.nandan.springboot.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
  private EmployeeService employeeService;

  public  EmployeeRestController(EmployeeService theEmployeeService){
    employeeService=theEmployeeService;
  }

  @GetMapping("/employees")
  public List<Employee> findAll(){
    return employeeService.findAll();
  }

  // to get one employee  details
  @GetMapping("/employees/{employeeId}")
  public  Employee getEmployee(@PathVariable int employeeId){
      Employee theEmployee=employeeService.findById(employeeId);
      if(theEmployee==null){
        throw new RuntimeException("Employee is not found ::  "+employeeId);

      }
      return  theEmployee;
  }
  @PostMapping("/employees")
  public  Employee addEmployee(@RequestBody Employee theEmployee){
    theEmployee.setId(0);
    Employee dbEmployee=employeeService.save(theEmployee);
    return  dbEmployee;
  }

  @PutMapping("/employees")
  public  Employee updateEmployee(@RequestBody Employee theEmployee){
    Employee dbEmployee=employeeService.save(theEmployee);
    return dbEmployee;
  }

  @DeleteMapping("employees/{employeeID}")
  public  String deleteEmployee(@PathVariable int employeeID){
    Employee theEmployee=employeeService.findById(employeeID);
    if(theEmployee == null){
      throw  new RuntimeException("Employee Id not found : "+employeeID);
    }
    employeeService.deleteByID(employeeID);
    return  "Deleted employee : "+ employeeID;
  }
  

}
