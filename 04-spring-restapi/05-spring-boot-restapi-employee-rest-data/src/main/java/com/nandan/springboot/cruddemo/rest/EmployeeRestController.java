package com.nandan.springboot.cruddemo.rest;
import java.util.List;
import java.util.Optional;


//mport com.nandan.springboot.cruddemo.dao.EmployeeDAO;
import com.nandan.springboot.cruddemo.dao.EmployeeRepository;
import com.nandan.springboot.cruddemo.entity.Employee;
//import com.nandan.springboot.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
  private EmployeeRepository employeeService;

  public  EmployeeRestController(EmployeeRepository theEmployeeService){
    employeeService=theEmployeeService;
  }

  @GetMapping("/employees")
  public List<Employee> findAll(){
    return employeeService.findAll();
  }

  // to get one employee  details
  @GetMapping("/employees/{employeeId}")
  public  Employee getEmployee(@PathVariable int employeeId){
      Optional<Employee> result=employeeService.findById(employeeId);
      Employee theEmployee=null;
      if(result!=null){
        theEmployee=result.get();
      }
      else{
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
    Optional<Employee> theEmployee=employeeService.findById(employeeID);
    if(theEmployee == null){
      throw  new RuntimeException("Employee Id not found : "+employeeID);
    }
    employeeService.deleteById(employeeID);
    return  "Deleted employee : "+ employeeID;
  }
  

}
