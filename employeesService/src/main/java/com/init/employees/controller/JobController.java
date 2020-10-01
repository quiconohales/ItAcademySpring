package com.init.employees.controller;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.init.employees.dto.Employee;
import com.init.employees.dto.Job;
import com.init.employees.service.JobServiceImpl;

@RestController
@RequestMapping("/job")
public class JobController {
	@Autowired
	JobServiceImpl jobServiceImpl;
	//Grabar
	@PostMapping("/grabar")
	public Job saveJob(@RequestBody Job job) {
		return jobServiceImpl.saveJob(job);
	}
	//listar
	@GetMapping("/listar")
	public ResponseEntity<List<Job>> listjob() {
		return ResponseEntity.ok(jobServiceImpl.listJob());

	}

	// listar by id OK
	@GetMapping("/buscar/{id}")
	public Job jobXID(@PathVariable(name = "id") Integer id) {
		Job job_xid = new Job();
		job_xid = jobServiceImpl.jobXID(id);
		System.out.println("Job XID; " + job_xid);
		return job_xid;
	}

	// Update 
	@PutMapping("/update/{id}")
	public Job updateJob(@PathVariable(name = "id") Integer id, @RequestBody Job job) {

		Job job_select = new Job();
		Job job_update = new Job();
		job_select = jobServiceImpl.jobXID(id);

		job_select.setPosition(job.getPosition());

		job_update = jobServiceImpl.updateJob(job_select);
		return job_update;
	}

	// Delete 
	@DeleteMapping("/job/{id}")
	public void deleteJob(@PathVariable(name = "id") Integer id) {
		jobServiceImpl.deleteJob(id);
	}

	@GetMapping("/prueba")
	public String prueba() {
		return "HELLO.";
	}

}