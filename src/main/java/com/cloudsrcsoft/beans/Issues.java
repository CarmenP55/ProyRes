package com.cloudsrcsoft.beans;

import java.util.Date;

public class Issues {
	private int id;
	private int proyecto;
	private String nombre_proyecto;
	private int id_mod;
	private int id_req;
	private int id_sol;
	private String solicitante;
	private String descripcion;
	private String criticidad;
	private String comentarios;
	private String estatus_desarrollo;
	private String estatus_cliente;
	private Date alta;
	private Date cierre;
	private byte[] archivo;
	private String type;
	private String nombre;
			
	public String getNombre_proyecto() {
		return nombre_proyecto;
	}
	public void setNombre_proyecto(String nombre_proyecto) {
		this.nombre_proyecto = nombre_proyecto;
	}
	public int getId_sol() {
		return id_sol;
	}
	public void setId_sol(int id_sol) {
		this.id_sol = id_sol;
	}
	public int getId_mod() {
		return id_mod;
	}
	public void setId_mod(int id_mod) {
		this.id_mod = id_mod;
	}
	public int getId_req() {
		return id_req;
	}
	public void setId_req(int id_req) {
		this.id_req = id_req;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public byte[] getArchivo() {
		return archivo;
	}
	public void setArchivo(byte[] archivo) {
		this.archivo = archivo;
	}
	public String getEstatus_desarrollo() {
		return estatus_desarrollo;
	}
	public void setEstatus_desarrollo(String estatus_desarrollo) {
		this.estatus_desarrollo = estatus_desarrollo;
	}
	public String getEstatus_cliente() {
		return estatus_cliente;
	}
	public void setEstatus_cliente(String estatus_cliente) {
		this.estatus_cliente = estatus_cliente;
	}
	public Date getAlta() {
		alta=new Date();
		return alta;
	}
	public void setAlta(Date alta) {
		this.alta = alta;
	}
	public Date getCierre() {
		return cierre;
	}
	public void setCierre(Date cierre) {
		this.cierre = cierre;
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
	public String getSolicitante() {
		return solicitante;
	}
	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getCriticidad() {
		return criticidad;
	}
	public void setCriticidad(String criticidad) {
		this.criticidad = criticidad;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	
}
