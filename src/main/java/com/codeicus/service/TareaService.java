package com.codeicus.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.codeicus.model.Tarea;

@Named("tareaService")
@ManagedBean
@ApplicationScoped
public class TareaService {

	public List<Tarea> loadTareas() {

		List<Tarea> list = new ArrayList<>();
		
		Tarea tarea = new Tarea();
		
		tarea.setDeleted(false);
		tarea.setDescripcion("esta es una descripcion");
		tarea.setEsUrgente(true);
		tarea.setFechaAlta(new Date());
		tarea.setFechaEstimadaFinalizacion(new Date());
		tarea.setId(137);
		tarea.setTitulo("Este es el titulo");
		
		list.add(tarea);
		
		return list;
	}

	
}
