package com.init.employees.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


//import com.init.employees.dto.Employee.Jobs; 
@Entity
@Table(name="employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	//public enum Jobs {JEFE,JEFECILLO,MATAO}
	private Long id;
	@Column(name="name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="job_id")
	private Job job;
	
	@Column(name="salary")
	private Long salary;
	
	//	contructores
	public Employee() {
		
	}
	
	
	public Employee(Long id, String name, Job job, Long salary) {
		//per();
		this.id = id;
		this.name = name;
		this.job = job;
		this.salary = salary;
	}

	//Metodo impresion de datos por consola
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", job=" + job + ", salary=" + salary + "]";
	}

	public Long getId() {
		return id;
	}

	

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	


	
	
	
	
	
}
