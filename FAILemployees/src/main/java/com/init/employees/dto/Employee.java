package com.init.employees.dto;

public class Employee {

	private Long id;
	private String name;
	private Jobs job;
	//private String job;
	private Long salary;
	
	public enum Jobs {JEFE,JEFECILLO,MATAO}

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

	public Jobs getJob() {
		return job;
	}

	public void setJob(Jobs job) {
		this.job = job;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

}
