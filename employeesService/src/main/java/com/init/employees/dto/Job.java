package com.init.employees.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity
@Table(name="job")//en caso que la tabla sea diferente

public class Job {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//
	private Long id;
	@Column (name="position")
	private String position;
	@Column (name="salary")
	private Long salary;
	
	@OneToMany
	@JoinColumn(name="id")
	private List<Employee> employee;

	
	@Override
	public String toString() {
		return "Job [id=" + id + ", position=" + position + ", salary=" + salary + ", employee=" + employee + "]";
	}
	// Constructores (tambien el vacio))
	public Job(Long id, String position, Long salary, List<Employee> employee) {
		super();
		this.id = id;
		this.position = position;
		this.salary = salary;
		this.employee = employee;
	}
	public Job() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
	
	
}

