package com.codeicus.model.dao;

import java.util.List;

import com.codeicus.exception.TareaException;
import com.codeicus.model.dto.Tarea;

public interface TareaDao {

	public static final String SERVICE_URI = "http://localhost:8081/api";
	
	List<Tarea> findAll();
	Tarea findById(Integer id);
	void update(Tarea tarea) throws TareaException;
	void create(Tarea tarea) throws TareaException;
	void delete(Tarea tarea) throws TareaException;
}
