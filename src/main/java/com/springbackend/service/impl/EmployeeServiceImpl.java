package com.springbackend.service.impl;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbackend.model.Employee;
import com.springbackend.repository.EmployeeRepository;
//import com.springbackend.service.EmployeeService;
 
@Service
public class EmployeeServiceImpl implements EmployeeServiceInterface {
 
    @Autowired
    private EmployeeRepository employeeRepository;
 
    
    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }


	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}
}

 
