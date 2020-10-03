package com.init.employees.service;

import java.util.ArrayList;
import java.util.List;


import com.init.employees.dto.Employee;
import com.init.employees.dto.JobEnum;

public interface IEmployeeService {
	//Metodos del CRUD
	public List<Employee> listEmployees();// Lista todos los empleados
	public ArrayList<Employee> employeePOSITIONALL();// empleados para position
	public Employee saveEmployee(Employee employee);	//Guarda un empleado CREATE
	
	public Employee employeeXID(Integer id); //Leer datos de un empleado READ
	
	
//****************************************************************************	

	
	
	public List<Employee> employeeXPOSITION(List<Integer> id); //Leer datos de un empleado por position

	
	
	
//	*********************************************************************************
	
	public Employee updateEmployee(Employee employee); //Actualiza datos del empleado UPDATE
	
	public void deleteEmployee(Integer id);// Elimina el empleado DELETE
}
