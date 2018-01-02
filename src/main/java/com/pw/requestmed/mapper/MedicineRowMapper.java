package com.pw.requestmed.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pw.requestmed.beans.Medicine;
import com.pw.requestmed.extractor.MedicineExtractor;

public class MedicineRowMapper implements RowMapper<Medicine>{
	
	public Medicine mapRow(ResultSet resultSet, int line) throws SQLException {
		MedicineExtractor medicineExtractor = new MedicineExtractor();
		return medicineExtractor.extractData(resultSet);
	}

}
