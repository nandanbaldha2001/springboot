package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	// load employee data

	private EmployeeService employeeService;
	public EmployeeController(EmployeeService theEmployeeService){
		employeeService=theEmployeeService;
	}

	// add mapping for "/list"

	@GetMapping("/list")
	public String listEmployees(Model theModel) {

		// add to the spring model\
		List<Employee> theEmployees=employeeService.findAll();
		theModel.addAttribute("employees", theEmployees);

		return "employees/list-employees";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel){
		System.out.println("hello");
		Employee theEmployee=new Employee();
		theModel.addAttribute("employee",theEmployee);
		return  "employees/employee-form.html";

	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theID, Model theModel){
		Employee theEmployee=employeeService.findById(theID);
		theModel.addAttribute("employee",theEmployee);
		return "employees/employee-form";

	}


	@PostMapping("/save")
		public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){
		 employeeService.save(theEmployee);
		 return "redirect:/employees/list";

		}

		@GetMapping("/delete")
		public String deleteEmployee(@RequestParam("employeeId") int theID) {
			employeeService.deleteById(theID);
			return "redirect:/employees/list";
		}

}









