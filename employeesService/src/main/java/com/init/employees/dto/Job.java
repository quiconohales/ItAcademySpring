package com.init.employees.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
	
	@ManyToOne
	@JoinColumn(name="empl_id")
	private Employee employee;
}
