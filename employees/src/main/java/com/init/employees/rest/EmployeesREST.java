package com.init.employees.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator.Validity;
import com.init.employees.entitys.Employee;
import com.init.employees.entitys.Employee.Jobs;

@RestController

@RequestMapping("employees")
public class EmployeesREST {
	
	
	@RequestMapping(value="alta",method = RequestMethod.GET)
	public ResponseEntity<Employee> getEmployee(){
		Employee empleado1= new Employee();
		empleado1.setId(1L);
		empleado1.setJob(Jobs.JEFE);
		empleado1.setName("Empleado 1 ");
		empleado1.setSalary(1L);
		return ResponseEntity.ok(empleado1);
		
	}
	@RequestMapping(value="baja",method = RequestMethod.GET)
	public ResponseEntity<Employee> putEmployee(){
		return ResponseEntity.ok(employee);
	}
	
	//@GetMapping se utiliza igual que el RequestMapping sin poder poner la url
//	@RequestMapping(value="hello",method = RequestMethod.GET)
//	public String hello() {
//		return "Hello World";
		
//	}
}
