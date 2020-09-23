package com.init.employees.service;
import java.util.List;

import com.init.employees.dto.Job;


public interface IJobService {
	
	//Metodos CRUD
	public List<Job> listJob(); //Llistar All
	public Job saveJob(Job job); //Guarda Job
	public Job jobXID(Long id); //Leer datos de un trabajo por id
	public Job updateJob(Job job); //Actualizar job
	public void deleteJob(Long id); //elimina job

}
