package com.init.employees.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.init.employees.service.EmployeeServiceImpl;



import com.init.employees.dto.Employee;
import com.init.employees.dto.JobEnum;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeServiceImpl employeeServiceImpl;

/**
 * Implementación de los metodos CRUD solicitados en el ejercicio según la URI
 * /employee/grabar 				Graba los datos del empleado
 * /employee/listar 				Lista todos los empleados existentes
 * /employee/buscar/{id}			Busca empleado por id
 * /employee/buscar/position/{enum} Busca los empleados que tengan la misma enumeración que la introducida
 * 									se espera el valor de la posición en la enumeración. Se recorre la lista
 * 									recibida y se añaden los registros que cumplan la condición en una Arraylist
 * /employee/update/{id}			Actualiza los datos del empleado
 * /employee/borrarr/{id}		
 * 
 */
	// Create /grabar
	@PostMapping("/grabar")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<>(employeeServiceImpl.saveEmployee(employee), HttpStatus.OK);
				
	}

	// Read /listar
	@GetMapping("/listar")
	public ResponseEntity<List<Employee>> listemployees() {
		return ResponseEntity.ok(employeeServiceImpl.listEmployees());

	}

	// Read by id /buscar/{id}
	@GetMapping("/buscar/{id}")
	public ResponseEntity<Employee> employeeXID(@PathVariable(name = "id") Integer id) {
		Employee employee_xid = new Employee();
		employee_xid = employeeServiceImpl.employeeXID(id);
	
		return new ResponseEntity<>(employee_xid,HttpStatus.OK);
	}

	@GetMapping("/buscar/position/{enum}")
	public ResponseEntity<List<Employee>> employeePOSITIONALL(@PathVariable(name = "enum") Integer jobenum) {
	
		ArrayList<Employee> listemployee;
		ArrayList<Employee> employeePOSITION = new ArrayList();

		listemployee = employeeServiceImpl.employeePOSITIONALL();
		for (int i = 0; i < listemployee.size(); i++) {
			// if (listemployee.get(i).getJobenum().name()==jobenum) {
			if (listemployee.get(i).getJobenum().ordinal() == jobenum) {
				employeePOSITION.add(listemployee.get(i));
			}
		}
		if (employeePOSITION.isEmpty()) {
			return new ResponseEntity<>(employeePOSITION,HttpStatus.I_AM_A_TEAPOT);//////   ;)
		}
		 else {
			 return new ResponseEntity<>(employeePOSITION,HttpStatus.OK);
		}
	}

	// Update /update/{id}
	@PutMapping("/update/{id}")
	public Employee updateEmployee(@PathVariable(name = "id") Integer id, @RequestBody Employee employee) {

		Employee employee_select = new Employee();
		Employee employee_update = new Employee();
		employee_select = employeeServiceImpl.employeeXID(id);

		employee_select.setName(employee.getName());
		employee_select.setJobenum(employee.getJobenum());
		employee_select.setSalary(employee.getSalary());

		employee_update = employeeServiceImpl.updateEmployee(employee_select);

		return employee_update;
	}

	// Delete /employee/{id}
	@DeleteMapping("/employee/borrar/{id}")
	public void deleteEmployee(@PathVariable(name = "id") Integer id) {
		employeeServiceImpl.deleteEmployee(id);
	}
}
