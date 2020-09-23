package com.init.employees.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.init.employees.service.EmployeeServiceImpl;
import com.init.employees.dto.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeServiceImpl employeeServiceImpl;
	
	@GetMapping("/listar")
	public List<Employee> listemployees(){
		return employeeServiceImpl.listEmployees();
	}
	
	@GetMapping("/prueba")
	public String prueba(){
		return "HELLO.";
	}
	

}
