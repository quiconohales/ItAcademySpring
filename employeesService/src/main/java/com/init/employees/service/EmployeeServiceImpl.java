package com.init.employees.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.init.employees.dao.IEmployeeDAO;
import com.init.employees.dto.Employee;
import com.init.employees.dto.JobEnum;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	// Utilizamos los metodos de la interface IClienteDAO, es como instanciar.

	@Autowired
	IEmployeeDAO iemployeeDAO;

	@Override
	public List<Employee> listEmployees() {
		// TODO Auto-generated method stub
		return iemployeeDAO.findAll();
	}

	@Override
	public Employee saveEmployee(@RequestBody Employee employee) {
		switch (employee.getJobenum().ordinal()) {
		case 1:
			employee.setSalary(3000);
		case 2:
			employee.setSalary(1000);
		}

		return iemployeeDAO.save(employee);
	}

	@Override
	public Employee employeeXID(Integer id) {
		// TODO Auto-generated method stub
		// return iemployeeDAO.findById(id).get();
		return iemployeeDAO.findById(id).get();
	}

	@Override
	public ArrayList<Employee> employeePOSITIONALL() {

		// List<Employee> listeployee=(List<Employee>)iemployeeDAO.findAll();
		return (ArrayList<Employee>) iemployeeDAO.findAll();
	}

	@Override
	public Employee updateEmployee(@RequestBody Employee employee) {

		switch (employee.getJobenum().ordinal()) {
		case 1:
			employee.setSalary(3000);
		case 2:
			employee.setSalary(1000);
		}
		return iemployeeDAO.save(employee);
	}

	@Override
	public void deleteEmployee(Integer id) {
		// TODO Auto-generated method stub
		iemployeeDAO.deleteById(id);

	}

}
