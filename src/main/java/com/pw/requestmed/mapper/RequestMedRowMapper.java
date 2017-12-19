package com.pw.requestmed.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pw.requestmed.beans.RequestMed;
import com.pw.requestmed.extractor.RequestMedExtractor;

public class RequestMedRowMapper implements RowMapper<RequestMed>{

	public RequestMed mapRow(ResultSet rs, int line) throws SQLException {
		RequestMedExtractor reqMedExtractor = new RequestMedExtractor();
		return reqMedExtractor.extractData(rs);
	}
}
