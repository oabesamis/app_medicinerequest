package com.pw.requestmed.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.pw.requestmed.beans.Symptom;

public class SymptomExtractor implements ResultSetExtractor<Symptom>{

	@Override
	public Symptom extractData(ResultSet rs) throws SQLException, DataAccessException {
		Symptom symptom = new Symptom();
		symptom.setSymptomId(rs.getInt("symptoms_id"));
		symptom.setSymptomName(rs.getString("symptoms_name"));
		return symptom;	}

}
