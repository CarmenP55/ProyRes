package com.cloudsrcsoft.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import com.cloudsrcsoft.beans.*;

public class ProyectosResultSetExtractor {
	public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
		Proyectos proyectos= new Proyectos();
		proyectos.setNombre(rs.getString(1));
		proyectos.setTipo(rs.getString(2));
		proyectos.setDescripcion(rs.getString(3));
		proyectos.setSolicitud(rs.getString(4));
		proyectos.setModelo(rs.getString(5));
		proyectos.setEntrega(rs.getString(6));
		proyectos.setEstatus(rs.getString(7));
		proyectos.setRepositorio(rs.getString(8));
		proyectos.setTecnologia(rs.getString(9));
		proyectos.setDetalle(rs.getString(10));
		return proyectos;
	}
}

class EmpresaResultSetExtractor {
	public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
		Empresa empresa= new Empresa();
		empresa.setNombre(rs.getString(1));
		return empresa;
	}
}
	
class UserResultSetExtractor {
	public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
		User user= new User();
		user.setFirstname(rs.getString(1));
		user.setLastname(rs.getString(2));
		return user;
	}
}
