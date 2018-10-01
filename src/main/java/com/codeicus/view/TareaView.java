package com.codeicus.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

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
	private Tarea deleteTareaSelected;
	private Tarea nuevaTarea = new Tarea();
	
	private Integer activeTab;
	
    @PostConstruct
    public void init() {
    	
    	this.updateTareas();
    }
	
    public void update(ActionEvent evt) {
    	
    	try {
    		
    		this.service.update(tareaSelected);
        	this.addMessageOk("Update realizado con exito!");     
        	this.tareaSelected = null;
        	PrimeFaces.current().executeScript("PF('tareaDialog').hide();");
        	
    	}catch(Exception e) {
    		
    		this.addMessageOk("Error al realizar el update.");
    	}
    	
    }
    
    public void create(ActionEvent evt) {
    	
    	try {
    		
    		this.service.create(nuevaTarea);
    		this.updateTareas();
    		this.activeTab = 0;
        	this.addMessageOk("Tarea creada con exito!");
        	this.nuevaTarea = new Tarea();
            PrimeFaces.current().resetInputs("tabview:altaTarea");

    	}catch(Exception e) {
    		
    		this.addMessageOk("Error al crear la tarea.");
    	}
    }
    
    public void delete() {
    	
    	try {
    		
    		this.service.delete(deleteTareaSelected);
    		this.updateTareas();
        	this.addMessageOk("Se ha cancelado la tarea con exito!");
        	this.deleteTareaSelected = null;

    	}catch(Exception e) {
    		
    		this.addMessageOk("Error al querer cancelar la tarea.");
    	}
    }
    
    public void updateTareas() {
    	
    	tareas = this.service.findAll();
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

	public Tarea getNuevaTarea() {
		return nuevaTarea;
	}

	public void setNuevaTarea(Tarea nuevaTarea) {
		this.nuevaTarea = nuevaTarea;
	}

	public Integer getActiveTab() {
		return activeTab;
	}

	public void setActiveTab(Integer activeTab) {
		this.activeTab = activeTab;
	}

	public Tarea getDeleteTareaSelected() {
		return deleteTareaSelected;
	}

	public void setDeleteTareaSelected(Tarea deleteTareaSelected) {
		this.deleteTareaSelected = deleteTareaSelected;
	}
}
