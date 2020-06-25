package com.stackroute.springboot.mongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.springboot.mongo.documents.Employee;
import com.stackroute.springboot.mongo.exception.EmployeeAlreadyExistsException;
import com.stackroute.springboot.mongo.exception.EmployeeNotFoundException;
import com.stackroute.springboot.mongo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee employee) throws EmployeeAlreadyExistsException {
		
		Employee createdEmployee = null;
		Optional<Employee> optional = employeeRepository.findById(employee.getId());
		
		
		if(optional.isPresent()) {
			throw new EmployeeAlreadyExistsException();
		}
		else {
			createdEmployee = employeeRepository.save(employee);
		}
		
		return createdEmployee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public List<Employee> getAllEmployeesByNameStartingWith(String name) {
		
		return employeeRepository.findByNameStartingWith(name);
	}

	@Override
	public List<Employee> getAllEmployeesFromCity(String cityName) {
		
		return employeeRepository.findAllEmployeesFromCity(cityName);
	}

	@Override
	public Employee updateEmployee(Employee employee) throws EmployeeNotFoundException {
		
		Employee updatedEmployee = null;
		Optional<Employee> optional = employeeRepository.findById(employee.getId());
		
		
		if(!optional.isPresent()) {
			throw new EmployeeNotFoundException();
		}
		else {
			updatedEmployee = employeeRepository.save(employee);
		}
		
		return updatedEmployee;
	}

	@Override
	public boolean deleteEmployee(String empId) throws EmployeeNotFoundException {
		
		Optional<Employee> optional = employeeRepository.findById(empId);
		
		
		if(!optional.isPresent()) {
			throw new EmployeeNotFoundException();
		}
		else
			employeeRepository.delete(optional.get());
		return true;
	}

	

	

}
