package com.init.employees.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.init.employees.dao.IJobDAO;
import com.init.employees.dto.Job;

@Service
public class JobServiceImpl implements IJobService {
	//Utilizamos los metodos de la interface IClienteDAO, es como si instaciaramos.
	@Autowired
	IJobDAO ijobDAO;
	
	
	@Override
	public List<Job> listJob() {
		// TODO Auto-generated method stub
		return ijobDAO.findAll();
	}

	@Override
	public Job saveJob(Job job) {
		// TODO Auto-generated method stub
		return ijobDAO.save(job);
	}

	@Override
	public Job jobXID(Integer id) {
		// TODO Auto-generated method stub
		return ijobDAO.findById(id).get();
	}

	@Override
	public Job updateJob(Job job) {
		// TODO Auto-generated method stub
		return ijobDAO.save(job);
		
	}

	@Override
	public void deleteJob(Integer id) {
		// TODO Auto-generated method stub
		ijobDAO.deleteById(id); 
		
	}
	

}
