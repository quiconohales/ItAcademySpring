package com.init.employees.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.init.employees.dto.Employee;

public interface IEmployeeDAO extends JpaRepository<Employee, Long>{

}