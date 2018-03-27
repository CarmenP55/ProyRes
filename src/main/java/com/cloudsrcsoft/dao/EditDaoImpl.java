package com.cloudsrcsoft.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import com.cloudsrcsoft.beans.*;

public class EditDaoImpl{
  JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
  
  public void save(Proyectos proyectos) {
	  String sql = "UPDATE proyectos SET nombre_proyecto=?, descripcion=?, fecha_entrega=?, repositorio=?, tecnologia=?, detalle_repo=? WHERE id_proyecto=?";
	  template.update(sql, new Object[] {proyectos.getNombre(), proyectos.getDescripcion(), proyectos.getEntrega(), proyectos.getRepositorio(), 
			  proyectos.getTecnologia(), proyectos.getDetalle(), proyectos.getId_proyecto()});
	}
  
  public void updateMod(Modulo modulo) {
	  String sql= "UPDATE modulos SET nombre=?, descripcion=?, fecha_entrega=?, estatus=? WHERE id_modulo=?";
	  template.update(sql, new Object[] {modulo.getNombre(), modulo.getDescripcion(), modulo.getEntrega(), "NO_INICIADO", modulo.getId()});
  }
  
  public void updateReq(Requerimientos requerimientos) {
	  if (requerimientos.getEstatus().equals("FALSE")) {
		  String sql ="UPDATE requerimientos SET tipo_req=?, actividad=?, descripcion=?, entrega=?, criticidad=?, accion=?, solucion=?, comentarios=? where id_req=?";
		  template.update(sql, new Object[] {requerimientos.getTipo(), requerimientos.getActividad(), requerimientos.getDescripcion(), requerimientos.getEntrega(), requerimientos.getCriticidad(),
					requerimientos.getAccion(), requerimientos.getSolucion(), requerimientos.getComentarios(), requerimientos.getId_req()});
	  }
	  else {
		  String sql ="UPDATE requerimientos SET tipo_req=?, actividad=?, descripcion=?, entrega=?, criticidad=?, accion=?, solucion=?, comentarios=?, estatus=? where id_req=?";
		  template.update(sql, new Object[] {requerimientos.getTipo(), requerimientos.getActividad(), requerimientos.getDescripcion(), requerimientos.getEntrega(), requerimientos.getCriticidad(),
					requerimientos.getAccion(), requerimientos.getSolucion(), requerimientos.getComentarios(), requerimientos.getEstatus(), requerimientos.getId_req()});
	  }
  }
  
  public void updateReqC(Requerimientos requerimientos) {
		  String sql ="UPDATE requerimientos SET descripcion=?, entrega=?, criticidad=?, comentarios=? where id_req=?";
		  template.update(sql, new Object[] {requerimientos.getDescripcion(), requerimientos.getEntrega(), requerimientos.getCriticidad(),
					 requerimientos.getComentarios(), requerimientos.getId_req()});
  }
  
  public void updateDis(Diseno diseno) {
	  String sql ="UPDATE diseno SET actividad=?, descripcion=?, entrega=?, codigo=?, argumentos=?, salida=?, comentarios=? where id_diseno=?";
	  template.update(sql, new Object[] {diseno.getActividad(), diseno.getDescripcion(), 
			  diseno.getEntrega(), diseno.getCodigo(), diseno.getArgumentos(), diseno.getSalida(), diseno.getComentarios(), diseno.getId()});
  }
  
  public void updatePru(Pruebas pruebas) {
	  String sql ="UPDATE pruebas SET entrada=?, proceso=?, salida=?, observaciones=?, severidad=?, estatus=? where id_pruebas=?";
	  template.update(sql, new Object[] {pruebas.getEntrada(), pruebas.getProceso(), pruebas.getSalida(), 
			  pruebas.getObservaciones(), pruebas.getSeveridad(), pruebas.getEstatus(), pruebas.getId()});
  }
  
  public void updateIssues(Issues issues) {
	  if (issues.getEstatus_desarrollo().equals("FALSE")) {
	  String sql ="UPDATE issues SET descripcion=?, criticidad=?, comentarios=? where id_issue=?";
	  template.update(sql, new Object[] {issues.getDescripcion(), issues.getCriticidad(),
			   issues.getComentarios(), issues.getId()});}
	  else {
		  String sql ="UPDATE issues SET descripcion=?, criticidad=?, comentarios=?, estatus_desarrollo=? where id_issue=?";
		  template.update(sql, new Object[] {issues.getDescripcion(), issues.getCriticidad(),
				   issues.getComentarios(), issues.getEstatus_desarrollo(), issues.getId()});
	  }
  }
  
  public void updateIssuesC(Issues issues) {
	  if (issues.getEstatus_cliente().equals("FALSE")) {
	  String sql ="UPDATE issues SET descripcion=?, criticidad=?, comentarios=? where id_issue=?";
	  template.update(sql, new Object[] {issues.getDescripcion(), issues.getCriticidad(),
			   issues.getComentarios(), issues.getId()});}
	 else {
		  String sql ="UPDATE issues SET descripcion=?, criticidad=?, comentarios=?, estatus_cliente=? where id_issue=?";
		  template.update(sql, new Object[] {issues.getDescripcion(), issues.getCriticidad(),
				   issues.getComentarios(), issues.getEstatus_cliente(), issues.getId()});
	  }
  }
  
  public void updateIssuesA(Issues issues) {
	  if (issues.getProyecto()!=-1) {
	  String sql ="UPDATE issues SET id_pro=?, descripcion=?, criticidad=?, comentarios=? where id_issue=?";
	  template.update(sql, new Object[] {issues.getProyecto(), issues.getDescripcion(), issues.getCriticidad(),
			   issues.getComentarios(), issues.getId()});}
	  else {
		  String sql ="UPDATE issues SET descripcion=?, criticidad=?, comentarios=? where id_issue=?";
		  template.update(sql, new Object[] {issues.getDescripcion(), issues.getCriticidad(),
				   issues.getComentarios(), issues.getId()});
	  }
  }
  
  public void updateEmpresas(Empresa empresa) {
	  String sql ="UPDATE empresa SET nombre_empresa=?, descripcion=?, giro_empresa=? where id_Empresa=?";
	  template.update(sql, new Object[] {empresa.getNombre(), empresa.getDescripcion(), empresa.getGiro(), empresa.getId()});
  }
  
  public void updateRie(Riesgos riesgos) {
	  String sql ="UPDATE riesgos SET riesgo=?, probabilidad=?, efectos=?, accion=?, contingencia=?, clasificacion=?, descripcion=? where id_riesgo=?";
	  template.update(sql, new Object[] {riesgos.getRiesgo(), riesgos.getOcurrencia(), riesgos.getEfectos(), riesgos.getAccion(), riesgos.getContingencia(), 
			   riesgos.getClasificacion(), riesgos.getDescripcion(), riesgos.getId()});
  }
  public void updateUsuarios(User user) {
	  String sql ="UPDATE usuarios SET nombre_usuario=?, apellido_usuario=?, email=?, password=?, telefono=? where id_usuario=?";
	  template.update(sql, new Object[] {user.getFirstname(), user.getLastname(), user.getEmail(), user.getPassword(), 
			  user.getTelefono(), user.getId()});
	  if (!user.getTipo().equals("FALSE")) {
		  String sql3="UPDATE usuarios SET tipo_usuario=? where id_usuario=?";
		  template.update(sql3, new Object[] {user.getTipo(), user.getId()});
	  }
  }
  public void updateUsuariosC(User user) {
	  String sql ="UPDATE usuarios SET nombre_usuario=?, apellido_usuario=?, email=?, password=?, telefono=? where id_usuario=?";
	  template.update(sql, new Object[] {user.getFirstname(), user.getLastname(), user.getEmail(), user.getPassword(), user.getTelefono(), user.getId()});
  }  
}

  