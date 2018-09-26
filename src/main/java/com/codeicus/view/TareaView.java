package com.codeicus.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.codeicus.model.Tarea;
import com.codeicus.service.TareaService;

@ManagedBean
@Named("tareaView")
@ViewScoped
public class TareaView implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TareaService service;
	
	private String titulo = "Codeicus - Tareas";
	private List<Tarea> tareas;
	private Tarea tareaSelected;

    @PostConstruct
    public void init() {
    	
    	tareas = service.loadTareas();
    }
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Tarea> getTareas() {
		return tareas;
	}

	public void setTareas(List<Tarea> tareas) {
		this.tareas = tareas;
	}

	public Tarea getTareaSelected() {
		return tareaSelected;
	}

	public void setTareaSelected(Tarea tareaSelected) {
		this.tareaSelected = tareaSelected;
	}
	
}
