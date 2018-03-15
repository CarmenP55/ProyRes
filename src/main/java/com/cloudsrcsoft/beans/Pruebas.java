package com.cloudsrcsoft.beans;

import java.util.Date;

public class Pruebas {
	private int id;
	private int proyecto;
	private int modulo;
	private int requerimiento;
	private String entrada;
	private String proceso;
	private String salida;
	private String observaciones;
	private String severidad;
	private String responsable;
	private int version;
	private String estatus;
	private Date alta;
	
	public int getModulo() {
		return modulo;
	}
	public void setModulo(int modulo) {
		this.modulo = modulo;
	}
	public Date getAlta() {
		alta=new Date();
		return alta;
	}
	public void setAlta(Date alta) {
		this.alta = alta;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public int getProyecto() {
		return proyecto;
	}
	public void setProyecto(int proyecto) {
		this.proyecto = proyecto;
	}
	public int getRequerimiento() {
		return requerimiento;
	}
	public void setRequerimiento(int requerimiento) {
		this.requerimiento = requerimiento;
	}
	public String getEntrada() {
		return entrada;
	}
	public void setEntrada(String entrada) {
		this.entrada = entrada;
	}
	public String getProceso() {
		return proceso;
	}
	public void setProceso(String proceso) {
		this.proceso = proceso;
	}
	public String getSalida() {
		return salida;
	}
	public void setSalida(String salida) {
		this.salida = salida;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public String getSeveridad() {
		return severidad;
	}
	public void setSeveridad(String severidad) {
		this.severidad = severidad;
	}
	public String getResponsable() {
		return responsable;
	}
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	
	
}
