package com.cloudsrcsoft.beans;
import java.util.Date;

public class Riesgos {
	private int id;
	private int proyecto;
	private int modulo;
	private String riesgo;
	private String descripcion;
	private String ocurrencia;
	private String efectos;
	private String accion;
	private String contingencia;
	private String clasificacion;
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
	public String getRiesgo() {
		return riesgo;
	}
	public void setRiesgo(String riesgo) {
		this.riesgo = riesgo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getOcurrencia() {
		return ocurrencia;
	}
	public void setOcurrencia(String ocurrencia) {
		this.ocurrencia = ocurrencia;
	}
	public String getEfectos() {
		return efectos;
	}
	public void setEfectos(String efectos) {
		this.efectos = efectos;
	}
	public String getAccion() {
		return accion;
	}
	public void setAccion(String accion) {
		this.accion = accion;
	}
	public String getContingencia() {
		return contingencia;
	}
	public void setContingencia(String contingencia) {
		this.contingencia = contingencia;
	}
	public String getClasificacion() {
		return clasificacion;
	}
	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	
	
	

	

}
