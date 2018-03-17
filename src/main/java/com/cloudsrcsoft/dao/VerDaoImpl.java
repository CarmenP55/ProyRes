package com.cloudsrcsoft.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.cloudsrcsoft.beans.*;
import com.cloudsrcsoft.springmvc.HomeController;

public class VerDaoImpl{
	private static final Logger logger = LoggerFactory.getLogger(VerDaoImpl.class);
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

  public List<Proyectos> verProyectos() {
		String sql = "SELECT * FROM proyectos";
		List<Proyectos> listProyectos = template.query(sql, new RowMapper<Proyectos>() {
			public Proyectos mapRow(ResultSet rs, int arg1) throws SQLException {
			    Proyectos aProyectos = new Proyectos();
			    aProyectos.setId_proyecto(rs.getInt("id_proyecto"));
			    aProyectos.setNombre(rs.getString("nombre_proyecto"));
				aProyectos.setTipo(rs.getString("tipo_proyecto"));
				aProyectos.setEmpresa(rs.getInt("id_empresa"));
				aProyectos.setResponsable(rs.getInt("responsable"));
				aProyectos.setDescripcion(rs.getString("descripcion"));
				aProyectos.setSolicitud(rs.getString("fecha_solicitud"));
				aProyectos.setDesarrollador(rs.getInt("desarrollador"));
				aProyectos.setTecnologia(rs.getString("tecnologia"));
				aProyectos.setRepositorio(rs.getString("repositorio"));
				aProyectos.setDetalle(rs.getString("detalle_repo"));
				aProyectos.setModelo(rs.getString("modelo"));
				aProyectos.setEntrega(rs.getString("fecha_entrega"));
				aProyectos.setEstatus(rs.getString("estatus"));
				return aProyectos;
			  }
		});
		return listProyectos;
	}
  
public Issues find(int id) {
	logger.info("Metodo find");
      String query = "select archivo, type, nombre_archivo from issues where id_issue = ?";
      try {
          Issues file = (Issues) template.queryForObject(query, new Object[] {id},
              new RowMapper() {
                  Issues fl;
                  public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                      fl = new Issues();
                      fl.setNombre(rs.getString(3));
                      fl.setType(rs.getString(2));
                      fl.setArchivo(rs.getBytes(1));
                      return fl;
                  }
          });
          return file;
      } catch (Exception ex) {
          ex.printStackTrace();
      }
      return null;
  }

public Requerimientos findReq(int id) {
	logger.info("Metodo find");
      String query = "select archivo, tipo_archivo, nombre_archivo from requerimientos where id_req = ?";
      try {
          Requerimientos file = (Requerimientos) template.queryForObject(query, new Object[] {id},
              new RowMapper() {
                  Requerimientos fl;
                  public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                      fl = new Requerimientos();
                      fl.setNombre_archivo(rs.getString(3));
                      fl.setTipo_archivo(rs.getString(2));
                      fl.setArchivo(rs.getBytes(1));
                      return fl;
                  }
          });
          return file;
      } catch (Exception ex) {
          ex.printStackTrace();
      }
      return null;
  }
  
  public User getUserBy(String e) {
	  String sql="SELECT id_usuario from usuarios where email="+e;
	  return template.query(sql, new ResultSetExtractor<User>() {
			public User extractData(ResultSet rs) throws SQLException,
				DataAccessException {
			if (rs.next()) {
				User aUser= new User();
				  aUser.setId(rs.getInt("id_usuario"));
				  return aUser;
				  }
			return null;
		}
	});
}
  
  public List<Proyectos> verProyectosC(int id) {
		String sql = "SELECT * FROM proyectos where responsable="+id;
		List<Proyectos> listProyectos = template.query(sql, new RowMapper<Proyectos>() {
			public Proyectos mapRow(ResultSet rs, int arg1) throws SQLException {
			    Proyectos aProyectos = new Proyectos();
			    aProyectos.setId_proyecto(rs.getInt("id_proyecto"));
			    aProyectos.setNombre(rs.getString("nombre_proyecto"));
				aProyectos.setTipo(rs.getString("tipo_proyecto"));
				aProyectos.setEmpresa(rs.getInt("id_empresa"));
				aProyectos.setResponsable(rs.getInt("responsable"));
				aProyectos.setDescripcion(rs.getString("descripcion"));
				aProyectos.setSolicitud(rs.getString("fecha_solicitud"));
				aProyectos.setDesarrollador(rs.getInt("desarrollador"));
				aProyectos.setTecnologia(rs.getString("tecnologia"));
				aProyectos.setRepositorio(rs.getString("repositorio"));
				aProyectos.setDetalle(rs.getString("detalle_repo"));
				aProyectos.setModelo(rs.getString("modelo"));
				aProyectos.setEntrega(rs.getString("fecha_entrega"));
				aProyectos.setEstatus(rs.getString("estatus"));
				return aProyectos;
			  }
		});
		return listProyectos;
	}
	
  public List<Modulo> verModulos(int id) {
		String sql = "SELECT * FROM modulos where id_pro="+id;
		List<Modulo> listModulos = template.query(sql, new RowMapper<Modulo>() {
			public Modulo mapRow(ResultSet rs, int arg1) throws SQLException {
				Modulo a= new Modulo();
				a.setId(rs.getInt("id_modulo"));
				a.setProyectos(rs.getInt("id_pro"));
				a.setNombre(rs.getString("nombre"));
				a.setDescripcion(rs.getString("descripcion"));
				a.setEntrega(rs.getString("fecha_entrega"));
				a.setAlta(rs.getDate("fecha_alta"));			
				return a;
			  }
		});
		return listModulos;
	}
  
  public List<User> verUsuarios(){
	  String sql="SELECT * FROM usuarios";
	  List<User> listUsuarios=template.query(sql, new RowMapper<User>() {
		  public User mapRow(ResultSet rs, int arg1) throws SQLException {
			  User aUser= new User();
			  aUser.setId(rs.getInt("id_usuario"));
			  aUser.setEmail(rs.getString("email"));
			  aUser.setTelefono(rs.getString("telefono"));
			  aUser.setPassword(rs.getString("password"));
			  aUser.setEmpresa(rs.getInt("id_empresa"));
			  aUser.setTipo(rs.getString("tipo_usuario"));
			  aUser.setFirstname(rs.getString("nombre_usuario"));
			  aUser.setLastname(rs.getString("apellido_usuario"));
			  aUser.setEstatus(rs.getString("estatus"));
			  return aUser;
		  }
	  });
	  return listUsuarios;
  }
  
  public List<Actividades> verActividades(){
	  String sql="SELECT * FROM actividades";
	  List<Actividades> listAct=template.query(sql, new RowMapper<Actividades>() {
		  public Actividades mapRow(ResultSet rs, int arg1) throws SQLException {
			  Actividades a= new Actividades();
			  a.setId(rs.getInt("id_act"));
			  a.setNombre(rs.getString("nombre"));
			  a.setDescripcion(rs.getString("descripcion"));
			  a.setCliente(rs.getString("cliente"));
			  return a;
		  }
	  });
	  return listAct;
  }
  
  public List<Reportes> verReportes(){
	  String sql="SELECT * from reportes";
	  List<Reportes> listRep=template.query(sql, new RowMapper<Reportes>() {
		  public Reportes mapRow(ResultSet rs, int arg1) throws SQLException {
			  Reportes a= new Reportes();
			  a.setId_pro(rs.getInt("id_pro"));	
			  Proyectos e = new Proyectos();
			  e=nombre_pro(rs.getInt("id_pro"));
			  a.setNombre_proyecto(e.getNombre());
			  
			  User u= new User();
			  u=nombre_us(rs.getInt("id_usu"));
			  a.setNombre_usuario(u.getFirstname()+" "+u.getLastname());
			  
			  Actividades l=new Actividades();
			  l=nombre_act(rs.getInt("id_actividad"));
			  a.setNombre_actividad(l.getNombre());
			  
			  a.setComentarios(rs.getString("comentarios"));
			  a.setFecha_inicio(rs.getString("fecha_inicio"));
			  a.setFecha_fin(l.getCliente());
			  a.setHora_inicio(rs.getString("hora_inicio"));
			  a.setHora_fin(rs.getString("hora_fin"));		
			
			  String[] h2 = rs.getString("hora_inicio").split(":");
			  String[] h1 = rs.getString("hora_fin").split(":");
			  int resto = 0;

			  int minuto = (Integer.parseInt(h1[1])-Integer.parseInt(h2[1]));
			  if (minuto < 0){
			     minuto = 60 -(-1)*minuto;
			     resto = -1;
			  }
			  int hora = (Integer.parseInt(h1[0])-Integer.parseInt(h2[0]));			  
			  a.setTotal(hora+":"+minuto+":00"); 
			return a;
			 
		  }
	  });
	  return listRep;
  }
  
  public List<Reportes> verReportesD(int id){
	  String sql="SELECT * from reportes where id_usu="+id;
	  List<Reportes> listRep=template.query(sql, new RowMapper<Reportes>() {
		  public Reportes mapRow(ResultSet rs, int arg1) throws SQLException {
			  Reportes a= new Reportes();
			  a.setId_pro(rs.getInt("id_pro"));	
			  Proyectos e = new Proyectos();
			  e=nombre_pro(rs.getInt("id_pro"));
			  a.setNombre_proyecto(e.getNombre());
			  
			  User u= new User();
			  u=nombre_us(rs.getInt("id_usu"));
			  a.setNombre_usuario(u.getFirstname()+" "+u.getLastname());
			  
			  Actividades l=new Actividades();
			  l=nombre_act(rs.getInt("id_actividad"));
			  a.setNombre_actividad(l.getNombre());
			  
			  a.setComentarios(rs.getString("comentarios"));
			  a.setFecha_inicio(rs.getString("fecha_inicio"));
			  a.setFecha_fin(l.getCliente());
			  a.setHora_inicio(rs.getString("hora_inicio"));
			  a.setHora_fin(rs.getString("hora_fin"));		
			
			  String[] h2 = rs.getString("hora_inicio").split(":");
			  String[] h1 = rs.getString("hora_fin").split(":");
			  int resto = 0;

			  int minuto = (Integer.parseInt(h1[1])-Integer.parseInt(h2[1]));
			  if (minuto < 0){
			     minuto = 60 -(-1)*minuto;
			     resto = -1;
			  }
			  int hora = (Integer.parseInt(h1[0])-Integer.parseInt(h2[0]));			  
			  a.setTotal(hora+":"+minuto+":00"); 
			return a;
			 
		  }
	  });
	  return listRep;
  }

  
  public Proyectos nombre_pro(int id) {
	  String sql2="SELECT nombre_proyecto from proyectos where id_proyecto="+id;	  
	  return template.query(sql2, new ResultSetExtractor<Proyectos>() {
			public Proyectos extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					 Proyectos aProyectos = new Proyectos();
					 aProyectos.setNombre(rs.getString("nombre_proyecto"));
					 String n=rs.getString("nombre_proyecto");
					return aProyectos;}
				return null;}
		  });
  }
  
  public User nombre_us(int id) {
	  String sql2="SELECT nombre_usuario, apellido_usuario from usuarios where id_usuario="+id;	  
	  return template.query(sql2, new ResultSetExtractor<User>() {
			public User extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					 User aProyectos = new User();
					 aProyectos.setFirstname(rs.getString("nombre_usuario"));
					 aProyectos.setLastname(rs.getString("apellido_usuario"));
					return aProyectos;}
				return null;}
		  });
  }
  
  public Actividades nombre_act(int id) {
	  String sql2="SELECT nombre, cliente from actividades where id_act="+id;	  
	  return template.query(sql2, new ResultSetExtractor<Actividades>() {
			public Actividades extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					 Actividades aProyectos = new Actividades();
					 aProyectos.setNombre(rs.getString("nombre"));
					 aProyectos.setCliente(rs.getString("cliente"));
					return aProyectos;}
				return null;}
		  });
  }
  
  public List<Requerimientos> verRequerimientos(int id) {
		String sql = "SELECT * FROM requerimientos where id_mod="+id;
		List<Requerimientos> listRequerimientos = template.query(sql, new RowMapper<Requerimientos>() {
			public Requerimientos mapRow(ResultSet rs, int arg1) throws SQLException {
				Requerimientos aRequerimientos = new Requerimientos();
				aRequerimientos.setId_req(rs.getInt("id_req"));
				aRequerimientos.setId_pro(rs.getInt("id_pro"));
				aRequerimientos.setTipo(rs.getString("tipo_req"));
				aRequerimientos.setActividad(rs.getString("actividad"));
				aRequerimientos.setDescripcion(rs.getString("descripcion"));
				aRequerimientos.setEntrega(rs.getString("entrega"));
				aRequerimientos.setCriticidad(rs.getString("criticidad"));
				aRequerimientos.setAccion(rs.getString("accion"));
				aRequerimientos.setSolucion(rs.getString("solucion"));
				aRequerimientos.setComentarios(rs.getString("comentarios"));
				aRequerimientos.setVersion(rs.getInt("version"));
				aRequerimientos.setEstatus(rs.getString("estatus"));
				aRequerimientos.setNombre_archivo(rs.getString("nombre_archivo"));
				aRequerimientos.setTipo_archivo(rs.getString("tipo_archivo"));
				aRequerimientos.setArchivo(rs.getBytes("archivo"));
				return aRequerimientos;
			  }
		});
		return listRequerimientos;
	}
  
  public List<Requerimientos> verRequerimientosPro(int id_proyecto) {
		String sql = "SELECT * FROM requerimientos where id_pro="+id_proyecto;
		List<Requerimientos> listRequerimientos = template.query(sql, new RowMapper<Requerimientos>() {
			public Requerimientos mapRow(ResultSet rs, int arg1) throws SQLException {
				Requerimientos aRequerimientos = new Requerimientos();
				aRequerimientos.setId_req(rs.getInt("id_req"));
				aRequerimientos.setId_pro(rs.getInt("id_pro"));
				aRequerimientos.setTipo(rs.getString("tipo_req"));
				aRequerimientos.setActividad(rs.getString("actividad"));
				aRequerimientos.setDescripcion(rs.getString("descripcion"));
				aRequerimientos.setEntrega(rs.getString("entrega"));
				aRequerimientos.setCriticidad(rs.getString("criticidad"));
				aRequerimientos.setAccion(rs.getString("accion"));
				aRequerimientos.setSolucion(rs.getString("solucion"));
				aRequerimientos.setComentarios(rs.getString("comentarios"));
				aRequerimientos.setVersion(rs.getInt("version"));
				aRequerimientos.setEstatus(rs.getString("estatus"));	
				aRequerimientos.setNombre_archivo(rs.getString("nombre_archivo"));
				aRequerimientos.setTipo_archivo(rs.getString("tipo_archivo"));
				aRequerimientos.setArchivo(rs.getBytes("archivo"));
				return aRequerimientos;
			  }
		});
		return listRequerimientos;
	}
  
  public List<Diseno> verDiseno(int id) {
		String sql = "SELECT * FROM diseno where id_pro="+id;
		List<Diseno> listDiseno = template.query(sql, new RowMapper<Diseno>() {
			public Diseno mapRow(ResultSet rs, int arg1) throws SQLException {
				Diseno aDiseno = new Diseno();
				aDiseno.setId(rs.getInt("id_diseno"));
				aDiseno.setProyecto(rs.getInt("id_pro"));
				aDiseno.setRequerimiento(rs.getInt("id_req"));
				aDiseno.setActividad(rs.getString("actividad"));
				aDiseno.setDescripcion(rs.getString("descripcion"));
				aDiseno.setEntrega(rs.getString("entrega"));
				aDiseno.setCodigo(rs.getString("codigo"));
				aDiseno.setArgumentos(rs.getString("argumentos"));
				aDiseno.setSalida(rs.getString("salida"));
				aDiseno.setVersion(rs.getInt("version"));
				aDiseno.setComentarios(rs.getString("comentarios"));
				aDiseno.setEstatus(rs.getString("estatus"));
				return aDiseno;
			  }
		});

		return listDiseno;
	}
  
  public List<Diseno> verDisenoPro(int id_proyecto) {
		String sql = "SELECT * FROM diseno where id_pro="+id_proyecto;
		List<Diseno> listDiseno = template.query(sql, new RowMapper<Diseno>() {
			public Diseno mapRow(ResultSet rs, int arg1) throws SQLException {
				Diseno aDiseno = new Diseno();
				aDiseno.setProyecto(rs.getInt("id_pro"));
				aDiseno.setRequerimiento(rs.getInt("id_req"));
				aDiseno.setActividad(rs.getString("actividad"));
				aDiseno.setDescripcion(rs.getString("descripcion"));
				aDiseno.setEntrega(rs.getString("entrega"));
				aDiseno.setCodigo(rs.getString("codigo"));
				aDiseno.setArgumentos(rs.getString("argumentos"));
				aDiseno.setSalida(rs.getString("salida"));
				aDiseno.setVersion(rs.getInt("version"));
				aDiseno.setComentarios(rs.getString("comentarios"));
				aDiseno.setEstatus(rs.getString("estatus"));
				return aDiseno;
			  }
		});
		return listDiseno;
	}
  
  public List<Pruebas> verPruebas(int id) {
		String sql = "SELECT * FROM pruebas where id_pro="+id;
		List<Pruebas> listPruebas = template.query(sql, new RowMapper<Pruebas>() {
			public Pruebas mapRow(ResultSet rs, int arg1) throws SQLException {
				Pruebas aPruebas = new Pruebas();
				aPruebas.setId(rs.getInt("id_pruebas"));
				aPruebas.setProyecto(rs.getInt("id_pro"));
				aPruebas.setRequerimiento(rs.getInt("id_req"));
				aPruebas.setEntrada(rs.getString("entrada"));
				aPruebas.setProceso(rs.getString("proceso"));
				aPruebas.setSalida(rs.getString("salida"));
				aPruebas.setObservaciones(rs.getString("observaciones"));
				aPruebas.setSeveridad(rs.getString("severidad"));
				aPruebas.setResponsable(rs.getString("responsable"));
				aPruebas.setVersion(rs.getInt("version"));
				aPruebas.setEstatus(rs.getString("estatus"));
				return aPruebas;
			  }
		});
		return listPruebas;
	}
  
  public List<Pruebas> verPruebasPro(int id_proyecto) {
		String sql = "SELECT * FROM pruebas where id_pro="+id_proyecto;
		List<Pruebas> listPruebas = template.query(sql, new RowMapper<Pruebas>() {
			public Pruebas mapRow(ResultSet rs, int arg1) throws SQLException {
				Pruebas aPruebas = new Pruebas();
				aPruebas.setId(rs.getInt("id_pruebas"));
				aPruebas.setProyecto(rs.getInt("id_pro"));
				aPruebas.setRequerimiento(rs.getInt("id_req"));
				aPruebas.setEntrada(rs.getString("entrada"));
				aPruebas.setProceso(rs.getString("proceso"));
				aPruebas.setSalida(rs.getString("salida"));
				aPruebas.setObservaciones(rs.getString("observaciones"));
				aPruebas.setSeveridad(rs.getString("severidad"));
				aPruebas.setResponsable(rs.getString("responsable"));
				aPruebas.setVersion(rs.getInt("version"));
				aPruebas.setEstatus(rs.getString("estatus"));
				return aPruebas;
			  }
		});
		return listPruebas;
	}
  
  public List<Riesgos> verRiesgos(int id) {
		String sql = "SELECT * FROM riesgos where id_pro="+id;
		List<Riesgos> listRiesgos = template.query(sql, new RowMapper<Riesgos>() {
			public Riesgos mapRow(ResultSet rs, int arg1) throws SQLException {
				Riesgos aRiesgos = new Riesgos();
				aRiesgos.setId(rs.getInt("id_riesgo"));
				aRiesgos.setProyecto(rs.getInt("id_pro"));
				aRiesgos.setRiesgo(rs.getString("riesgo"));
				aRiesgos.setDescripcion(rs.getString("descripcion"));
				aRiesgos.setOcurrencia(rs.getString("probabilidad"));
				aRiesgos.setEfectos(rs.getString("efectos"));
				aRiesgos.setAccion(rs.getString("accion"));
				aRiesgos.setContingencia(rs.getString("contingencia"));
				aRiesgos.setClasificacion(rs.getString("clasificacion"));
				aRiesgos.setVersion(rs.getInt("version"));
				return aRiesgos;
			  }
		});
		return listRiesgos;
	}
  
  public List<Riesgos> verRiesgosPro(int id_proyecto) {
		String sql = "SELECT * FROM riesgos where id_pro="+id_proyecto;
		List<Riesgos> listRiesgos = template.query(sql, new RowMapper<Riesgos>() {
			public Riesgos mapRow(ResultSet rs, int arg1) throws SQLException {
				Riesgos aRiesgos = new Riesgos();
				aRiesgos.setId(rs.getInt("id_riesgo"));
				aRiesgos.setProyecto(rs.getInt("id_pro"));
				aRiesgos.setRiesgo(rs.getString("riesgo"));
				aRiesgos.setDescripcion(rs.getString("descripcion"));
				aRiesgos.setOcurrencia(rs.getString("probabilidad"));
				aRiesgos.setEfectos(rs.getString("efectos"));
				aRiesgos.setAccion(rs.getString("accion"));
				aRiesgos.setContingencia(rs.getString("contingencia"));
				aRiesgos.setClasificacion(rs.getString("clasificacion"));
				aRiesgos.setVersion(rs.getInt("version"));
				return aRiesgos;
			  }
		});
		return listRiesgos;
	}
  
  public List<Issues> verIssuesC(int e) {
		String sql = "SELECT * FROM issues join proyectos on proyectos.id_proyecto=issues.id_pro "
				+ "where id_sol ="+e;
		List<Issues> listIssues = template.query(sql, new RowMapper<Issues>() {
			public Issues mapRow(ResultSet rs, int arg1) throws SQLException {
				Issues aIssues = new Issues();
				aIssues.setId(rs.getInt("id_issue"));
				aIssues.setNombre_proyecto(rs.getString("nombre_proyecto"));
				aIssues.setProyecto(rs.getInt("id_pro"));
				aIssues.setDescripcion(rs.getString("descripcion"));
				aIssues.setCriticidad(rs.getString("criticidad"));
				aIssues.setComentarios(rs.getString("comentarios"));
				aIssues.setEstatus_desarrollo(rs.getString("estatus_desarrollo"));
				aIssues.setEstatus_cliente(rs.getString("estatus_cliente"));
				aIssues.setAlta(rs.getDate("fecha_alta"));
				aIssues.setCierre(rs.getDate("fecha_cierre"));
				
				return aIssues;
			  }
		});
		return listIssues;
	}
  
  public List<Issues> verIssues() {
		String sql = "SELECT * FROM issues join proyectos on proyectos.id_proyecto=issues.id_pro";
		List<Issues> listIssues = template.query(sql, new RowMapper<Issues>() {
			public Issues mapRow(ResultSet rs, int arg1) throws SQLException {
				Issues aIssues = new Issues();
				aIssues.setId(rs.getInt("id_issue"));
				aIssues.setNombre_proyecto(rs.getString("nombre_proyecto"));
				aIssues.setDescripcion(rs.getString("descripcion"));
				aIssues.setCriticidad(rs.getString("criticidad"));
				aIssues.setComentarios(rs.getString("comentarios"));
				User u= new User();
				u=getUser(rs.getInt("id_sol"));
				aIssues.setSolicitante(u.getFirstname()+" "+u.getLastname());
				aIssues.setEstatus_desarrollo(rs.getString("estatus_desarrollo"));
				aIssues.setEstatus_cliente(rs.getString("estatus_cliente"));
				aIssues.setAlta(rs.getDate("fecha_alta"));
				aIssues.setCierre(rs.getDate("fecha_cierre"));
				aIssues.setNombre(rs.getString("nombre_archivo"));
				aIssues.setType(rs.getString("type"));
				aIssues.setArchivo(rs.getBytes("archivo"));
				return aIssues;
			  }
		});
		return listIssues;
	}
  
  public List<Empresa> verEmpresa() {
		String sql = "SELECT * FROM empresa";
		List<Empresa> listEmpresa = template.query(sql, new RowMapper<Empresa>() {
			public Empresa mapRow(ResultSet rs, int arg1) throws SQLException {
				Empresa a = new Empresa();
				a.setId(rs.getInt("id_Empresa"));
				a.setNombre(rs.getString("nombre_empresa"));
				a.setDescripcion(rs.getString("descripcion"));
				a.setGiro(rs.getString("giro_empresa"));
				return a;
			  }
		});
		return listEmpresa;
	}
  
  public List<SubTareas> verSub(int id) {
		String sql = "SELECT * FROM subtareas";		
		List<SubTareas> listSub = template.query(sql, new RowMapper<SubTareas>() {
			public SubTareas mapRow(ResultSet rs, int arg1) throws SQLException {
				SubTareas a = new SubTareas();
				a.setId(rs.getInt("id_sub"));
				a.setNombre(rs.getString("nombre"));
				
				Tareas oñ=new Tareas();
				oñ=getT(rs.getInt("id_tarea"));
				  
				a.setNombre_tarea(oñ.getNombre());
				a.setDescripcion(rs.getString("descripcion"));
				return a;
			  }
		});
		return listSub;
	}
  
  public Tareas getT(int id) {
	  String sql2 = "SELECT * FROM tareas where id_tarea="+id;
		return template.query(sql2, new ResultSetExtractor<Tareas>(){					
			public Tareas extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
				Tareas a=new Tareas();
				a.setNombre(rs.getString("nombre"));
				return a;
			}
				return null;}
		});  
  }
  
  public List<Tareas> verTareas() {
		String sql = "SELECT * FROM tareas";
		List<Tareas> listTareas = template.query(sql, new RowMapper<Tareas>() {
			public Tareas mapRow(ResultSet rs, int arg1) throws SQLException {
				Tareas a = new Tareas();
				a.setId(rs.getInt("id_tarea"));
				a.setNombre(rs.getString("nombre"));
				a.setDescripcion(rs.getString("descripcion"));
				return a;
			  }
		});
		return listTareas;
	}


  
  public void delete(int proyectId) {
	    String sql = "DELETE FROM proyectos WHERE id_proyecto=?";
	    template.update(sql, proyectId);
	}
  
  //Obtener proyecto especifico, los datos serán enviados al formulario de update
  public Proyectos getById(int proyectoId) {
		String sql = "SELECT * FROM proyectos WHERE id_proyecto=" + proyectoId;
		return template.query(sql, new ResultSetExtractor<Proyectos>() {
				public Proyectos extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					    Proyectos aProyectos = new Proyectos();
					    aProyectos.setId_proyecto(rs.getInt("id_proyecto"));
					    aProyectos.setNombre(rs.getString("nombre_proyecto"));
						aProyectos.setTipo(rs.getString("tipo_proyecto"));
						aProyectos.setEmpresa(rs.getInt("id_empresa"));
						aProyectos.setResponsable(rs.getInt("responsable"));
						aProyectos.setDescripcion(rs.getString("descripcion"));
						aProyectos.setSolicitud(rs.getString("fecha_solicitud"));
						aProyectos.setDesarrollador(rs.getInt("desarrollador"));
						aProyectos.setTecnologia(rs.getString("tecnologia"));
						aProyectos.setRepositorio(rs.getString("repositorio"));
						aProyectos.setDetalle(rs.getString("detalle_repo"));
						aProyectos.setModelo(rs.getString("modelo"));
						aProyectos.setEntrega(rs.getString("fecha_entrega"));
						aProyectos.setEstatus(rs.getString("estatus"));
						return aProyectos;
					  }
				return null;
			}
		});
	}
  
  public Modulo getModulos(int moduloId) {
		String sql = "SELECT * FROM modulos WHERE id_modulo=" + moduloId;
		return template.query(sql, new ResultSetExtractor<Modulo>() {
				public Modulo extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					    Modulo a = new Modulo();
					    a.setId(rs.getInt("id_modulo"));
						a.setProyectos(rs.getInt("id_pro"));
						a.setNombre(rs.getString("nombre"));
						a.setDescripcion(rs.getString("descripcion"));
						a.setEntrega(rs.getString("fecha_entrega"));
						a.setAlta(rs.getDate("fecha_alta"));
						return a;
					  }
				return null;
			}
		});
	}
  
  public Requerimientos getReq(int reqId) {
		String sql = "SELECT * FROM requerimientos WHERE id_req=" + reqId;
		return template.query(sql, new ResultSetExtractor<Requerimientos>() {
				public Requerimientos extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
						Requerimientos aReq = new Requerimientos();
					    aReq.setId_req(rs.getInt("id_req"));
					    aReq.setId_pro(rs.getInt("id_pro"));
						aReq.setTipo(rs.getString("tipo_req"));
						aReq.setActividad(rs.getString("actividad"));
						aReq.setDescripcion(rs.getString("descripcion"));
						aReq.setEntrega(rs.getString("entrega"));
						aReq.setCriticidad(rs.getString("criticidad"));
						aReq.setAccion(rs.getString("accion"));
						aReq.setSolucion(rs.getString("solucion"));
						aReq.setComentarios(rs.getString("comentarios"));
						aReq.setVersion(rs.getInt("version"));
						aReq.setEstatus(rs.getString("estatus"));
						return aReq;
					  }
				return null;
			}
		});
	}
  
  //para editar un usuario en particular
  public User getUser(int userId) {
		String sql = "SELECT * FROM usuarios WHERE id_usuario=" + userId;
		return template.query(sql, new ResultSetExtractor<User>() {
				public User extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					User aUser= new User();
					  aUser.setId(rs.getInt("id_usuario"));
					  aUser.setEmail(rs.getString("email"));
					  aUser.setTelefono(rs.getString("telefono"));
					  aUser.setPassword(rs.getString("password"));
					  aUser.setEmpresa(rs.getInt("id_empresa"));
					  aUser.setFirstname(rs.getString("nombre_usuario"));
					  aUser.setLastname(rs.getString("apellido_usuario"));
					  aUser.setTipo(rs.getString("tipo_usuario"));
					  aUser.setEstatus(rs.getString("estatus"));
					  return aUser;
					  }
				return null;
			}
		});
	}
  
  public Requerimientos getReqId(int proId) {
		String sql = "SELECT * FROM requerimientos WHERE id_pro=" + proId;
		return template.query(sql, new ResultSetExtractor<Requerimientos>() {
				public Requerimientos extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
						Requerimientos aReq = new Requerimientos();
					    aReq.setId_pro(rs.getInt("id_pro"));
						aReq.setActividad(rs.getString("actividad"));
						aReq.setDescripcion(rs.getString("descripcion"));
						aReq.setEntrega(rs.getString("entrega"));
						aReq.setCriticidad(rs.getString("criticidad"));
						aReq.setAccion(rs.getString("accion"));
						aReq.setSolucion(rs.getString("solucion"));
						aReq.setComentarios(rs.getString("comentarios"));
						aReq.setVersion(rs.getInt("version"));
						aReq.setEstatus(rs.getString("estatus"));
						aReq.setNombre_archivo(rs.getString("nombre_archivo"));
						aReq.setTipo_archivo(rs.getString("tipo_archivo"));
						aReq.setArchivo(rs.getBytes("archivo"));
						return aReq;
					  }
				return null;
			}
		});
	}
  
  public Pruebas getPrue(int pruId) {
		String sql = "SELECT * FROM pruebas WHERE id_pruebas=" + pruId;
		return template.query(sql, new ResultSetExtractor<Pruebas>() {
				public Pruebas extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Pruebas aPruebas = new Pruebas();
					aPruebas.setId(rs.getInt("id_pruebas"));
					aPruebas.setProyecto(rs.getInt("id_pro"));
					aPruebas.setRequerimiento(rs.getInt("id_req"));
					aPruebas.setEntrada(rs.getString("entrada"));
					aPruebas.setProceso(rs.getString("proceso"));
					aPruebas.setSalida(rs.getString("salida"));
					aPruebas.setObservaciones(rs.getString("observaciones"));
					aPruebas.setSeveridad(rs.getString("severidad"));
					aPruebas.setResponsable(rs.getString("responsable"));
					aPruebas.setVersion(rs.getInt("version"));
					aPruebas.setEstatus(rs.getString("estatus"));
					return aPruebas;
					  }
				return null;
			}
		});
	}
  
  public Riesgos getRie(int rieId) {
		String sql = "SELECT * FROM riesgos WHERE id_riesgo=" + rieId;
		return template.query(sql, new ResultSetExtractor<Riesgos>() {
				public Riesgos extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Riesgos aRiesgos = new Riesgos();
					aRiesgos.setId(rs.getInt("id_riesgo"));
					aRiesgos.setProyecto(rs.getInt("id_pro"));
					aRiesgos.setRiesgo(rs.getString("riesgo"));
					aRiesgos.setDescripcion(rs.getString("descripcion"));
					aRiesgos.setOcurrencia(rs.getString("probabilidad"));
					aRiesgos.setEfectos(rs.getString("efectos"));
					aRiesgos.setAccion(rs.getString("accion"));
					aRiesgos.setContingencia(rs.getString("contingencia"));
					aRiesgos.setClasificacion(rs.getString("clasificacion"));
					aRiesgos.setVersion(rs.getInt("version"));
					return aRiesgos;
					  }
				return null;
			}
		});
	}
  
  public Issues getIssues(int issId) {
		String sql = "SELECT * FROM issues WHERE id_issue=" + issId;
		return template.query(sql, new ResultSetExtractor<Issues>() {
				public Issues extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Issues aIssues = new Issues();
					aIssues.setId(rs.getInt("id_issue"));
					aIssues.setProyecto(rs.getInt("id_pro"));
					aIssues.setDescripcion(rs.getString("descripcion"));
					aIssues.setCriticidad(rs.getString("criticidad"));
					aIssues.setComentarios(rs.getString("comentarios"));
					aIssues.setEstatus_desarrollo(rs.getString("estatus_desarrollo"));
					aIssues.setEstatus_cliente(rs.getString("estatus_cliente"));
					aIssues.setAlta(rs.getDate("fecha_alta"));
					aIssues.setCierre(rs.getDate("fecha_cierre"));
					
					return aIssues;
					  }
				return null;
			}
		});
	}
  
  public Diseno getDis(int disId) {
		String sql = "SELECT * FROM diseno WHERE id_diseno=" + disId;
		return template.query(sql, new ResultSetExtractor<Diseno>() {
				public Diseno extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Diseno aDiseno = new Diseno();
					aDiseno.setId(rs.getInt("id_diseno"));
					aDiseno.setProyecto(rs.getInt("id_pro"));
					aDiseno.setRequerimiento(rs.getInt("id_req"));
					aDiseno.setActividad(rs.getString("actividad"));
					aDiseno.setDescripcion(rs.getString("descripcion"));
					aDiseno.setEntrega(rs.getString("entrega"));
					aDiseno.setCodigo(rs.getString("codigo"));
					aDiseno.setArgumentos(rs.getString("argumentos"));
					aDiseno.setSalida(rs.getString("salida"));
					aDiseno.setVersion(rs.getInt("version"));
					aDiseno.setComentarios(rs.getString("comentarios"));
					aDiseno.setEstatus(rs.getString("estatus"));
					return aDiseno;
					  }
				return null;
			}
		});
	}
  
  //obtener los usuarios segun la empresa que se elija al empezar a crear un proyecto
  public List<User> getUserBy(int id) {
	  String sql="SELECT * from usuarios where id_empresa="+id;
	  List<User> listUsuarios=template.query(sql, new RowMapper<User>(){
			public User mapRow(ResultSet rs, int arg1) throws SQLException,
				DataAccessException {
				User a = new User();
				a.setId(rs.getInt("id_usuario"));
				a.setFirstname(rs.getString("nombre_usuario"));
				a.setLastname(rs.getString("apellido_usuario"));
				return a;
		}
	});
	  return listUsuarios;
  }  
  
  public List<User> getUserByType() {
	  String sql="SELECT * from usuarios where isDes="+1;
	  List<User> listUsuarios=template.query(sql, new RowMapper<User>(){
			public User mapRow(ResultSet rs, int arg1) throws SQLException,
				DataAccessException {
				User a = new User();
				a.setId(rs.getInt("id_usuario"));
				a.setFirstname(rs.getString("nombre_usuario"));
				a.setLastname(rs.getString("apellido_usuario"));
				return a;
		}
	});
	  return listUsuarios;
  }
  
  public Empresa getEmpresas(int empId) {
		String sql = "SELECT * FROM empresa WHERE id_Empresa=" + empId;
		return template.query(sql, new ResultSetExtractor<Empresa>() {
				public Empresa extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Empresa a = new Empresa();
					a.setId(rs.getInt("id_Empresa"));
					a.setNombre(rs.getString("nombre_empresa"));
					a.setDescripcion(rs.getString("descripcion"));
					a.setGiro(rs.getString("giro_empresa"));
					return a;
					  }
				return null;
			}
		});
	}
  
  
public Proyectos getDetailsPro(int proyectoId) {
	  //template = new template(this.datasource);
      String sql = "select proyectos.nombre_proyecto, proyectos.tipo_proyecto, proyectos.descripcion, proyectos.fecha_solicitud,"
      		+ "proyectos.modelo, proyectos.fecha_entrega, proyectos.estatus, proyectos.repositorio, "
      		+ "proyectos.tecnologia, proyectos.detalle_repo from proyectos"
      		+ " INNER join empresa ON proyectos.id_empresa = empresa.id_Empresa and proyectos.id_proyecto ="+proyectoId+
      		" INNER join usuarios ON proyectos.desarrollador=usuarios.id_usuario and proyectos.id_proyecto="+proyectoId;
      RowMapper mapper = (RowMapper) new ProyectosMapper();
      List traderList = template.query(sql, mapper);
      for(Object obj : traderList){
          return (Proyectos)obj;
      }
      return null;
	}

public Empresa getDetailsEmp(int proyectoId) {
	  //template = new template(this.datasource);
    String sql = "select empresa.nombre_empresa from empresa"
    		+ " INNER join proyectos ON proyectos.id_empresa = empresa.id_Empresa and proyectos.id_proyecto ="+proyectoId;
    
    RowMapper mapper = (RowMapper) new EmpresaMapper();
    List traderList2 = template.query(sql, mapper);
    for(Object obj : traderList2){
        return (Empresa)obj;
    }
    return null;
}

public User getDetailsUs(int proyectoId) {
	  //template = new template(this.datasource);
	  String sql = "select usuarios.nombre_usuario, usuarios.apellido_usuario from usuarios"+
	      		" INNER join proyectos ON proyectos.desarrollador=usuarios.id_usuario and proyectos.id_proyecto="+proyectoId;
  RowMapper mapper = (RowMapper) new UserMapperM();
  List traderList2 = template.query(sql, mapper);
  for(Object obj : traderList2){
      return (User)obj;
  }
  return null;
}

public User getDetailsRes(int proyectoId) {
	  //template = new template(this.datasource);
	  String sql = "select usuarios.nombre_usuario, usuarios.apellido_usuario from usuarios"+
	      		" INNER join proyectos ON proyectos.responsable=usuarios.id_usuario and proyectos.id_proyecto="+proyectoId;
RowMapper mapper = (RowMapper) new UserMapperM();
List traderList2 = template.query(sql, mapper);
for(Object obj : traderList2){
    return (User)obj;
}
return null;
}


}

  