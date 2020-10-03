package com.init.employees.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
public class EmployeeController  {

	@Autowired
	EmployeeServiceImpl employeeServiceImpl;

	@GetMapping("/prueba")
	public String prueba() {
		return "HELLO.";
	}

	// CRUD
	// Create   /grabar
	@PostMapping("/grabar")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeServiceImpl.saveEmployee(employee);
	}

	// Read     /listar
	@GetMapping("/listar")
	public ResponseEntity<List<Employee>> listemployees() {
		return ResponseEntity.ok(employeeServiceImpl.listEmployees());

	}

	// Read by id  /buscar/{id}
	@GetMapping("/buscar/{id}")
	public Employee employeeXID(@PathVariable(name = "id") Integer id) {
		Employee employee_xid = new Employee();
		employee_xid = employeeServiceImpl.employeeXID(id);
		System.out.println("Employee XID; " + employee_xid);
		return employee_xid;
	}
	
	
	
// ********************************************************************************************************************
	@GetMapping("/buscar/position/{enum}")
	public List<Employee> employeePOSITIONALL(@PathVariable(name="enum") Integer jobenum) {
		
		ArrayList <Employee> listemployee;
		ArrayList <Employee> employeePOSITION = new ArrayList();
		
		listemployee = employeeServiceImpl.employeePOSITIONALL( );
		for (int i = 0; i < listemployee.size(); i++) {
			//if (listemployee.get(i).getJobenum().name()!=jobenum) {
			if (listemployee.get(i).getJobenum().ordinal()==jobenum) {
					employeePOSITION.add(listemployee.get(i));
			}		
			
		}
		return employeePOSITION;
	}
	
	
//	********************************************************************************************************************
	// Read by POSTION  /buscar/{id} /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//	@GetMapping("/buscar/position/{id}")
//	public List<Employee> employeeXPOSITION(@PathVariable(name="id") Integer id) {
//		
//		List <Employee> employee_xposition;
//		Iterable<Employee> Itemployee;
//		employee_xposition = employeeServiceImpl.employeeXPOSITION(Itemployee<id> id  );
//		System.out.println("Employee XPOSITION; " + employee_xposition);
//		return employee_xposition;
//		
//		
//	}
	
//		@RequestMapping(value = "/findallbyid", method = RequestMethod.POST)
//		@ResponseBody
//		public List<Student> getAllStudents(@RequestBody List<IdContainer> idContainer) {
//			List<Integer> ids = new ArrayList();
//			for (IdContainer id : idContainer) {
//				ids.add(id.getId());
//			}
//			List<Student> studentResponse = (List<Student>) studentService.getAllStudents(ids);
//			return studentResponse;
//		}	
//	
	
	
	
	
//**********************************************************************************************************************
	
	
	
	
	
	
	
	// Update 	/update/{id}
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

	// Delete 	/employee/{id}
	@DeleteMapping("/employee/{id}")
	public void deleteEmployee(@PathVariable(name = "id") Integer id) {
		employeeServiceImpl.deleteEmployee(id);
	}
}
