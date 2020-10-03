package com.init.employees.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "employee")

public class Employee {
	// Campos de la clase
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY) // busca ultimo valor e incrementa desde id final de db
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "position", nullable = false, length = 10)
	@Enumerated(value = EnumType.STRING)
	private JobEnum jobenum;

	@Column(name = "salary")
	private Integer salary;

	/**
	 * Constructor para la clase employee
	 * 
	 * @param
	 */
	public Employee() {
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", jobenum=" + jobenum + ", salary=" + salary + "]";
	}

	// Getter y setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public JobEnum getJobenum() {
		return jobenum;
	}

	public void setJobenum(JobEnum jobenum) {
		this.jobenum = jobenum;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

}
