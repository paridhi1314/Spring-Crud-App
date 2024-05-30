package com.springbackend.service.impl;
 
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbackend.exception.ResourcenotFoundException;
import com.springbackend.model.Employee;
import com.springbackend.repository.EmployeeRepository;
//import com.springbackend.service.EmployeeService;
 
@Service
public class EmployeeServiceImpl implements EmployeeServiceInterface {
 
    @Autowired
    private EmployeeRepository employeeRepository;
 

    
//    @Override
    public Employee saveEmployee(Employee employee) {
    	
        return employeeRepository.save(employee);
    }


	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}


	@Override
	public Employee getEmployeeById(long id) {
//		 Optional<Employee> employee = employeeRepository.findById(id);
//		if(employee.isPresent()) {
//			return employee.get();
//		} else {
//			throw new ResourcenotFoundException("Employee", "Id", id);
//		}
		
		return employeeRepository.findById(id).orElseThrow(() -> new ResourcenotFoundException("Employee", "Id", id));
		
	}

    @Override
	public Employee updateEmployee(Employee employee, long id) {
		
		//we need to check whether employee with given id is exist in DB or not
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
				()-> new ResourcenotFoundException("Employee", "Id", id));
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		
		//save existing employee to DB
		employeeRepository.save(existingEmployee);
		return existingEmployee;

	}


	@Override
	public void deleteEmployee(long id) {
		
		//check whether the employee exist in DB or not
		employeeRepository.findById(id).orElseThrow(() -> 
		                                       new ResourcenotFoundException("Employee", "Id", id));
		employeeRepository.deleteById(id);
	}


}

 
