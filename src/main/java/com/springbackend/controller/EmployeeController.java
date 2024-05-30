package com.springbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbackend.model.Employee;
import com.springbackend.service.impl.EmployeeServiceImpl;

@RestController
//@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeService;
	
//	public EmployeeController(EmployeeServiceImpl employeeService) {
//		super();
//		this.employeeService = employeeService;
//	}

	@PostMapping("/api/employees")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
	}

	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return employeeService.getAllEmployee();
	}
	
	//build get employee by id REST API
	@GetMapping("/employee/{id}")
    public ResponseEntity<Employee>  getEmployeeById(@PathVariable("id") long employeeId){
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);
	}
	
	
	//build update employee REST API 
    @PutMapping("/employee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id , @RequestBody Employee employee ){
    	return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
  
	}
    
    //build delete employee rest api
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
    	//delete employee from db
    	employeeService.deleteEmployee(id);
    	
    	return new ResponseEntity<String>("Employee deleted successfully " , HttpStatus.OK);
    	
    }
}
