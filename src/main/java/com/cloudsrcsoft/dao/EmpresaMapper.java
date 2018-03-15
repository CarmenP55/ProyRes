package com.cloudsrcsoft.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class EmpresaMapper implements RowMapper {	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        EmpresaResultSetExtractor extractor = new EmpresaResultSetExtractor();
        return extractor.extractData(rs);
    }
}
	
	class UserMapperM implements RowMapper {	
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
	        UserResultSetExtractor extractor = new UserResultSetExtractor();
	        return extractor.extractData(rs);
	    }
}
