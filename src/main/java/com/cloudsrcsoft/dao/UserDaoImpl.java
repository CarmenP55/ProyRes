package com.cloudsrcsoft.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.cloudsrcsoft.beans.*;

//clase DAO que registra en la base de datos
public class UserDaoImpl{	
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
  public void register(User user) {
	  String sql = "insert into usuarios values(?,?,?,?,?,?,?,?,?,?,?)";
	  template.update(sql, new Object[] {user.getFirstname(), user.getLastname(), user.getEmpresa(), 
			  user.getEmail(), user.getTipo(), user.getPassword(), "ACTIVO", user.getTelefono(), 
			  null, 1, user.getIsDes()});
    }
    
  public User validateUser(Login login) {
      String sql = "select * from usuarios where BINARY email='" + login.getEmail() + "'  and BINARY password='" + login.getPassword()
      + "'";
      List<User> users = template.query(sql, new UserMapper());
      return users.size() > 0 ? users.get(0) : null;
    }

    
  public void proyectos (Proyectos proyectos) {
	  String sql = "insert into proyectos values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	  template.update(sql, new Object[] {null, proyectos.getNombre(), proyectos.getTipo(), proyectos.getEmpresa(), proyectos.getResponsable(), proyectos.getDescripcion(), proyectos.getSolicitud(), 
			  proyectos.getDesarrollador(), proyectos.getModelo(), proyectos.getEntrega(), "NO_INICIADO", proyectos.getRepositorio(), proyectos.getTecnologia(), proyectos.getDetalle(), proyectos.getAlta()});
  }
  
  public void requerimientos (Requerimientos requerimientos) {
	  String sql = "insert into requerimientos values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	  template.update(sql, new Object[] {null, requerimientos.getId_pro(), requerimientos.getTipo(), requerimientos.getActividad(), requerimientos.getDescripcion(), requerimientos.getEntrega(), 
			  requerimientos.getCriticidad(), requerimientos.getAccion(), requerimientos.getSolucion(), requerimientos.getComentarios(), 1, "NO_INICIADO", requerimientos.getAlta(), requerimientos.getId_mod(), 
			  requerimientos.getArchivo(), requerimientos.getNombre_archivo(), requerimientos.getTipo_archivo()});
  }  
  
  public void modulo (Modulo modulo) {
	  String sql = "insert into modulos values (?,?,?,?,?,?,?)";
	  template.update(sql, new Object[] {null, modulo.getProyectos(), modulo.getNombre(), modulo.getDescripcion(), modulo.getEntrega(), modulo.getAlta(), "NO_INICIADO"});
  }
  
  public void diseno (Diseno diseno) {
	  String sql = "insert into diseno values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	  template.update(sql, new Object[] {null, diseno.getProyecto(), diseno.getRequerimiento(), diseno.getActividad(), diseno.getDescripcion(), 
			  diseno.getEntrega(), diseno.getCodigo(), diseno.getArgumentos(), diseno.getSalida(), 1, diseno.getComentarios(), "Finalizado", 
			  diseno.getModulo(), diseno.getAlta(), diseno.getEntrega_real()});
  }
  
  public void riesgos (Riesgos riesgos) {
	  String sql = "insert into riesgos values(?,?,?,?,?,?,?,?,?,?,?,?)";
	  template.update(sql, new Object[] {null, riesgos.getProyecto(), riesgos.getRiesgo(), riesgos.getOcurrencia(), riesgos.getEfectos(), 
			  riesgos.getAccion(), riesgos.getContingencia(), riesgos.getClasificacion(), 1, riesgos.getDescripcion(), riesgos.getModulo(), riesgos.getAlta() });
  }
  
  public void issues (Issues issues) {
	  String sql = "insert into issues values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	  template.update(sql, new Object[] {null, issues.getProyecto(), null, issues.getDescripcion(), 
			  issues.getCriticidad(), issues.getComentarios(), "NO_INICIADO", "NO_RESUELTO", issues.getAlta(), null, 
			  issues.getArchivo(), issues.getType(), issues.getNombre(),1,1, issues.getId_sol()});
  }
  
  public void pruebas (Pruebas pruebas) {
	  String sql = "insert into pruebas values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	  template.update(sql, new Object[] {null, pruebas.getProyecto(), pruebas.getRequerimiento(), pruebas.getEntrada(), pruebas.getProceso(), pruebas.getSalida(), 
			  pruebas.getObservaciones(), pruebas.getSeveridad(), pruebas.getResponsable(), 1, pruebas.getEstatus(), pruebas.getAlta(), pruebas.getModulo()});
  }
  
  public void empresa (Empresa empresa) {
	  String sql = "insert into empresa values(?,?,?,?)";
	  template.update(sql, new Object[] {null, empresa.getNombre(), empresa.getDescripcion(), empresa.getGiro()});
  }
  
  public void reportes (Reportes reportes) {
	  String sql = "insert into reportes values(?,?,?,?,?,?,?,?,?)";
	  template.update(sql, new Object[] {null, reportes.getId_pro(), reportes.getId_usu(), 
			  reportes.getId_actividad(), reportes.getFecha_inicio(), reportes.getFecha_fin(), reportes.getComentarios(),
			  reportes.getHora_inicio(), reportes.getHora_fin()});
  }
  
  public void actividades (Actividades actividades) {
	  String sql = "insert into actividades values(?,?,?,?)";
	  template.update(sql, new Object[] {null, actividades.getNombre(), actividades.getDescripcion(),
			  actividades.getCliente()});
  }
  
  public void tareas (Tareas tareas) {
	  String sql = "insert into tareas values(?,?,?)";
	  template.update(sql, new Object[] {null, tareas.getNombre(), tareas.getDescripcion()});	  
  }
  
  public void subtareas (SubTareas subtareas) {
	  String sql = "insert into subtareas values(?,?,?,?)";
	  template.update(sql, new Object[] {null, subtareas.getId_tarea(), subtareas.getNombre(), subtareas.getDescripcion()});
  }

}

  class UserMapper implements RowMapper<User> {
  public User mapRow(ResultSet rs, int arg1) throws SQLException {
    User user = new User();
    user.setTelefono(rs.getString("telefono"));
    user.setFirstname(rs.getString("nombre_usuario"));
    user.setLastname(rs.getString("apellido_usuario"));
    user.setEmail(rs.getString("email"));
    user.setPassword(rs.getString("password"));
    user.setTipo(rs.getString("tipo_usuario"));
    user.setId(rs.getInt("id_usuario"));
    return user;
  }
}
  