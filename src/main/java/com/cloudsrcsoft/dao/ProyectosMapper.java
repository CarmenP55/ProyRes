package com.cloudsrcsoft.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class ProyectosMapper implements RowMapper {
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        ProyectosResultSetExtractor extractor = new ProyectosResultSetExtractor();
        return extractor.extractData(rs);
    }
	
	
}
