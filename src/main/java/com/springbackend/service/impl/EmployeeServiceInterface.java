package com.springbackend.service.impl;

import java.util.List;

import com.springbackend.model.Employee;

public interface EmployeeServiceInterface {
	
	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployee();

}
