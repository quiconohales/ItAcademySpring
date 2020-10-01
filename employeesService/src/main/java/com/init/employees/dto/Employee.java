package com.init.employees.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Required;

import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.init.employees.dto.Employee.job; 
@Entity
@Table(name="employee")

public class Employee {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@ManyToOne//   (optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="job_id")
	private Job job;
///////////////////////////////////////////////////////////////////////////
	 @Column(name="status", nullable = false, length = 8 )
	    @Enumerated(value = EnumType.STRING)
	    private Status status;
//////////////////////////////////////////////////////////////////////////	 
	//contructores
	public Employee() {
		}

	public Employee(Integer id, String name, Job job) {
		//per();
		this.id = id;
		this.name = name;
		this.job = job;
	}

	//Metodo impresion de datos por consola
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", job=" + job +  "]";
	}
	// Setter y getters
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
	public Job getJob() {
		return job;
	}
	
	public void setJob(Job job) {
		this.job = job;
	}


	


	
	
	
	
	
}
