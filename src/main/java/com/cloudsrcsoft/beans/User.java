package com.cloudsrcsoft.beans;
public class User {
  private boolean isDes;
  private String email;
  private String password;
  private String firstname;
  private String lastname;
  private String tipo;
  private String estatus;
  private String telefono;
  private int empresa;
  private int id;
  
  
  
  public boolean getIsDes() {
	return isDes;
  }
  public void setIsDes(boolean isDes) {
	this.isDes = isDes;
  }
  public String getEstatus() {
	return estatus;
  }
  public void setEstatus(String estatus) {
	this.estatus = estatus;
  }
  public int getId() {
	return id;
  }
  public void setId(int id) {
	this.id = id;
  }
  public String getTelefono() {
	return telefono;
  }
  public void setTelefono(String telefono) {
	this.telefono = telefono;
  }
  public int getEmpresa() {
	return empresa;
  }
  public void setEmpresa(int empresa) {
	this.empresa = empresa;
  }
  public String getTipo() {
	return tipo;
  }
  public void setTipo(String tipo) {
	this.tipo = tipo;
  }	
  public String getEmail() {
  return email;
  }
  public void setEmail(String email) {
  this.email = email;
  }
  public String getPassword() {
  return password;
  }
  public void setPassword(String password) {
  this.password = password;
  }
  public String getFirstname() {
  return firstname;
  }
  public void setFirstname(String firstname) {
  this.firstname = firstname;
  }
  public String getLastname() {
  return lastname;
  }
  public void setLastname(String lastname) {
  this.lastname = lastname;
  }
}