package com.codeicus.service.interfaces;

import java.util.List;

import com.codeicus.exception.TareaException;
import com.codeicus.model.dto.Tarea;

public interface TareaService {

	List<Tarea> findAll();
	Tarea findById(Integer id);
	void update(Tarea tarea) throws TareaException;
	void create(Tarea tarea) throws TareaException;
	void delete(Tarea tarea) throws TareaException;
}
