package com.codeicus.service;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.codeicus.exception.TareaException;
import com.codeicus.model.dao.TareaDao;
import com.codeicus.model.dto.Tarea;
import com.codeicus.service.interfaces.TareaService;

@Named("tareaService")
@ManagedBean
@ApplicationScoped
public class TareaServiceImpl implements TareaService {

	@Inject
	private TareaDao dao;
	
	@Override
	public List<Tarea> findAll() {
		
		return this.dao.findAll();
	}

	@Override
	public Tarea findById(Integer id) {

		return this.dao.findById(id);
	}

	@Override
	public void update(Tarea tarea) throws TareaException {

		this.dao.update(tarea);
	}

	@Override
	public void create(Tarea tarea) throws TareaException {

		this.dao.create(tarea);
	}

	@Override
	public void delete(Tarea tarea) throws TareaException {

		this.dao.delete(tarea);
	}
}
