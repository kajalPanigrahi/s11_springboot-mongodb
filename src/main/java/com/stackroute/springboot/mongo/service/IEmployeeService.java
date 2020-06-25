package com.stackroute.springboot.mongo.service;

import java.util.List;

import com.stackroute.springboot.mongo.documents.Employee;
import com.stackroute.springboot.mongo.exception.EmployeeAlreadyExistsException;
import com.stackroute.springboot.mongo.exception.EmployeeNotFoundException;

public interface IEmployeeService {
	
	public Employee saveEmployee(Employee employee) throws EmployeeAlreadyExistsException;
	public List<Employee> getAllEmployees();
	public List<Employee> getAllEmployeesByNameStartingWith(String name);
	public List<Employee> getAllEmployeesFromCity(String cityName);
	
	
	public Employee updateEmployee(Employee employee) throws EmployeeNotFoundException;
	public boolean deleteEmployee(String empId) throws EmployeeNotFoundException;
}
