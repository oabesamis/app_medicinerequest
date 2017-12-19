package com.pw.requestmed.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pw.requestmed.beans.Employee;
import com.pw.requestmed.extractor.EmpExtractor;

public class EmpRowMapper implements RowMapper<Employee>{

	public Employee mapRow(ResultSet resultSet, int line) throws SQLException {
		EmpExtractor empExtractor = new EmpExtractor();
		return empExtractor.extractData(resultSet);
	}

}
