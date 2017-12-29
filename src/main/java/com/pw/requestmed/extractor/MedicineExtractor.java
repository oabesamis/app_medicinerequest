package com.pw.requestmed.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.pw.requestmed.beans.Medicine;

public class MedicineExtractor implements ResultSetExtractor<Medicine>{

	@Override
	public Medicine extractData(ResultSet rs) throws SQLException, DataAccessException {
		Medicine medicine = new Medicine();
		medicine.setMedicineId(rs.getInt("medicine_id"));
		medicine.setMedicineName(rs.getString("medicine_name"));
		return medicine;
	}

}
