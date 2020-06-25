package com.stackroute.springboot.mongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.stackroute.springboot.mongo.documents.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
	//All Basic CRUD methods
	
	//findByXXX ( can be replaced with any property)
	//findByName
	//findByEmail
	//findByContactNo
	
	//QueryMethod
	public List<Employee> findByNameStartingWith(String name);
	
	@Query("{'address.city' : {$in : [?0]}}")
	public List<Employee> findAllEmployeesFromCity(String name);

	
}
