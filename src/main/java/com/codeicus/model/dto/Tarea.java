package com.codeicus.model.dto;

import java.io.Serializable;
import java.util.Date;

public class Tarea implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String titulo;
	private String descripcion;
	private Boolean esUrgente;
	private Date fechaAlta;
	private Date fechaEstimadaFinalizacion;
	private Date fechaFinalizacion;
	private Date fechaUpdate;
	private Boolean deleted;
	private Date fechaDelete;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getEsUrgente() {
		return esUrgente;
	}

	public void setEsUrgente(Boolean esUrgente) {
		this.esUrgente = esUrgente;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Date getFechaEstimadaFinalizacion() {
		return fechaEstimadaFinalizacion;
	}

	public void setFechaEstimadaFinalizacion(Date fechaEstimadaFinalizacion) {
		this.fechaEstimadaFinalizacion = fechaEstimadaFinalizacion;
	}

	public Date getFechaFinalizacion() {
		return fechaFinalizacion;
	}

	public void setFechaFinalizacion(Date fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}

	public Date getFechaUpdate() {
		return fechaUpdate;
	}

	public void setFechaUpdate(Date fechaUpdate) {
		this.fechaUpdate = fechaUpdate;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public Date getFechaDelete() {
		return fechaDelete;
	}

	public void setFechaDelete(Date fechaDelete) {
		this.fechaDelete = fechaDelete;
	}

}
