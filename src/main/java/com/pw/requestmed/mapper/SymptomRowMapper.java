package com.pw.requestmed.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pw.requestmed.beans.Symptom;
import com.pw.requestmed.extractor.SymptomExtractor;

public class SymptomRowMapper implements RowMapper<Symptom>{

	@Override
	public Symptom mapRow(ResultSet rs, int line) throws SQLException {
		SymptomExtractor symptomExtractor = new SymptomExtractor();
		return symptomExtractor.extractData(rs);
	}

}
