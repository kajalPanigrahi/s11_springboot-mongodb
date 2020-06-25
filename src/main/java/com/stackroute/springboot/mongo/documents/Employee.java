package com.stackroute.springboot.mongo.documents;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Employee {

	@Id
	private String id;
	
	private String name;
	private String email;
	private int contactNo;
	
	private Address address;
	private List<Hobby> hobbiesList;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getContactNo() {
		return contactNo;
	}
	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Hobby> getHobbiesList() {
		return hobbiesList;
	}
	public void setHobbiesList(List<Hobby> hobbiesList) {
		this.hobbiesList = hobbiesList;
	}
	
	
	
}
