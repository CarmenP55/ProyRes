package com.cloudsrcsoft.beans;

import java.util.Date;

public class Modulo {
	private int id;
	private int proyectos;
	private String nombre;
	private String descripcion;
	private String entrega;
	private Date alta;
	public Estatus estatus;
	
	public enum Estatus {
		NO_INICIADO, EN_PROGRESO, COMPLETADO, CANCELADO};
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProyectos() {
		return proyectos;
	}
	public void setProyectos(int proyectos) {
		this.proyectos = proyectos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getEntrega() {
		return entrega;
	}
	public void setEntrega(String entrega) {
		this.entrega = entrega;
	}
	public Date getAlta() {
		alta = new Date();
		return alta;
	}
	
	public void setAlta(Date alta) {
		this.alta = alta;
	}
	public Estatus getEstatus() {
		return estatus;
	}
	public void setEstatus(Estatus estatus) {
		this.estatus = estatus;
	}

}
