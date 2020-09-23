package com.init.employees.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.init.employees.dao.IEmployeeDAO;
import com.init.employees.dto.Employee;

@Service
public class EmployeeServiceImpl implements IEmployeeService{
	//Utilizamos los metodos de la interface IClienteDAO, es como si instaciaramos.

	@Autowired
	IEmployeeDAO iemployeeDAO;

	@Override
	public List<Employee> listEmployees() {
		// TODO Auto-generated method stub
		return iemployeeDAO.findAll();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return iemployeeDAO.save(employee);
	}

	@Override
	public Employee employeeXID(Long id) {
		// TODO Auto-generated method stub
		return iemployeeDAO.findById(id).get();
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return iemployeeDAO.save(employee);
	}

	@Override
	public void deleteEmployee(Long id) {
		// TODO Auto-generated method stub
		iemployeeDAO.deleteById(id);
		
	}
	
}
