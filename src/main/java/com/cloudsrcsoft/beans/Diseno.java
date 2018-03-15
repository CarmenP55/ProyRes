package com.cloudsrcsoft.beans;

import java.util.Date;

public class Diseno {
	private int id;
	private int proyecto;
	private int modulo;
	private int requerimiento;
	private String actividad;
	private String descripcion;
	private String entrega;
	private String codigo;
	private String argumentos;
	private String salida;
	private String comentarios;
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
	public String getArgumentos() {
		return argumentos;
	}
	public void setArgumentos(String argumentos) {
		this.argumentos = argumentos;
	}
	public String getSalida() {
		return salida;
	}
	public void setSalida(String salida) {
		this.salida = salida;
	}
	public int getRequerimiento() {
		return requerimiento;
	}
	public void setRequerimiento(int requerimiento) {
		this.requerimiento = requerimiento;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProyecto() {
		return proyecto;
	}
	public void setProyecto(int proyecto) {
		this.proyecto = proyecto;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getActividad() {
		return actividad;
	}
	public void setActividad(String actividad) {
		this.actividad = actividad;
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
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	
	
}
