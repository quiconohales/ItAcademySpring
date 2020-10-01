package com.init.employees.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Table(name = "job") // en caso que la tabla sea diferente

public class Job {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY) //
	private Integer id;

	@Column(name = "position")
	private String position;

	@Column(name = "salary")
	private Integer salary;

	@Override
	public String toString() {
		return "Job [id=" + id + ", position=" + position + ", salary=" + salary + "]";
	}

	// Constructores (tambien el vacio))
	public Job(Integer id, String position, Integer salary, List<Employee> employee) {
		super();
		this.id = id;
		this.position = position;
		this.salary = salary;

	}

	public Job() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

}
