package com.cloudsrcsoft.beans;

import java.util.Date;
import java.util.List;

public class Proyectos {
	private int id_proyecto;
	private int desarrollador;
	private int responsable;
	private String nombre;
	private String tipo;
	private int empresa;
	private String descripcion;
	private String solicitud;
	private String modelo;
	private String entrega;
	private String estatus;
	private String repositorio;
	private String tecnologia;
	private String detalle;
	private Date alta;
	
	public Date getAlta() {
		alta=new Date();
		return alta;
	}
	public void setAlta(Date alta) {
		this.alta = alta;
	}
	public String getRepositorio() {
		return repositorio;
	}
	public void setRepositorio(String repositorio) {
		this.repositorio = repositorio;
	}
	public String getTecnologia() {
		return tecnologia;
	}
	public void setTecnologia(String tecnologia) {
		this.tecnologia = tecnologia;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public int getId_proyecto() {
		return id_proyecto;
	}
	public void setId_proyecto(int id_proyecto) {
		this.id_proyecto = id_proyecto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getEmpresa() {
		return empresa;
	}
	public void setEmpresa(int empresa) {
		this.empresa = empresa;
	}
	public int getResponsable() {
		return responsable;
	}
	public void setResponsable(int responsable) {
		this.responsable = responsable;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getSolicitud() {
		return solicitud;
	}
	public void setSolicitud(String solicitud) {
		this.solicitud = solicitud;
	}
	public int getDesarrollador() {
		return desarrollador;
	}
	public void setDesarrollador(int desarrollador) {
		this.desarrollador = desarrollador;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getEntrega() {
		return entrega;
	}
	public void setEntrega(String entrega) {
		this.entrega = entrega;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	
}
