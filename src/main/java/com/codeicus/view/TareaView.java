package com.codeicus.view;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.codeicus.model.dto.Tarea;
import com.codeicus.service.interfaces.TareaService;

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
    	
    	tareas = service.findAll();
    }
	
    public void update(ActionEvent evt) {
    	
    	try {
    		
    		this.service.update(tareaSelected);
        	this.addMessageOk("Update realizado con exito!");
        	
    	}catch(Exception e) {
    		
    		this.addMessageOk("Error al realizar el update.");
    	}
    	
    }
    
    public void addMessageOk(String mex) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, mex,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public void addMessageError(String mex) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, mex,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
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
