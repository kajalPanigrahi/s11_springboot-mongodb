package com.stackroute.springboot.mongo.controller;

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

import com.stackroute.springboot.mongo.documents.Employee;
import com.stackroute.springboot.mongo.exception.EmployeeAlreadyExistsException;
import com.stackroute.springboot.mongo.exception.EmployeeNotFoundException;
import com.stackroute.springboot.mongo.service.IEmployeeService;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {
	
	@Autowired
	private IEmployeeService employeeService;
	
	private ResponseEntity responseEntity;	

	
	@PostMapping("/employees")
	public ResponseEntity<?> saveEmployee( @RequestBody Employee employee) throws EmployeeAlreadyExistsException{
		
		
		try {
			Employee createdEmployee = employeeService.saveEmployee(employee);			
			responseEntity = new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
		} catch (EmployeeAlreadyExistsException e) {
			throw e;
		} catch(Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<>("Some internal Error Occured..", HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		return responseEntity;
	}
	
	
	@GetMapping("/employees")
	public ResponseEntity<?> getAllEmployees(){
		return new ResponseEntity<>(employeeService.getAllEmployees(),HttpStatus.OK);
	}
	
	@PutMapping("/employees")
public ResponseEntity<?> updateemployee( @RequestBody Employee employee) throws EmployeeNotFoundException{
		
		
		try {
			Employee updatedEmployee = employeeService.updateEmployee(employee);			
			responseEntity = new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
		} catch (EmployeeNotFoundException e) {
			throw e;
		} catch(Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<>("Some internal Error Occured..", HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		return responseEntity;
	}
	
	@DeleteMapping("/employees/{empId}") 
	public ResponseEntity<?> deleteEmployee(@PathVariable("empId") String empId) throws EmployeeNotFoundException{
		employeeService.deleteEmployee(empId);
		return new ResponseEntity<>("employee is deleted successfully", HttpStatus.OK);
	}
	
	@GetMapping("/employees/name/{startingWith}")
	public ResponseEntity<?> getAllEmployeesNameStartingWith(@PathVariable("startingWith") String startingWith){
		return new ResponseEntity<>(employeeService.getAllEmployeesByNameStartingWith(startingWith), HttpStatus.OK);
	}
	
	@GetMapping("/employees/city/{cityName}")
	public ResponseEntity<?> getAllEmployeesFromCity(@PathVariable("cityName") String cityName){
		return new ResponseEntity<>(employeeService.getAllEmployeesFromCity(cityName), HttpStatus.OK);
	}
	
}

