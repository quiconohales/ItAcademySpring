package com.init.employees.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.init.employees.dto.Job;

public interface IJobDAO extends JpaRepository<Job, Long>{

}
