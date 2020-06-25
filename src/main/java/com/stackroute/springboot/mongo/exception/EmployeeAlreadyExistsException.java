package com.stackroute.springboot.mongo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Employee already exists with this id")
public class EmployeeAlreadyExistsException extends Exception {

}
