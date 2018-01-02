package com.pw.requestmed.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pw.requestmed.beans.Medicine;
import com.pw.requestmed.mapper.MedicineRowMapper;

@Repository("medicineDao")
public class MedicineDaoJDBCTemplateImpl implements MedicineDao{

	@Autowired
	DataSource dataSource;
	
	@Override
	public List<Medicine> getAllMedicines() {
		List<Medicine> medicines = new ArrayList<Medicine>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "SELECT medicine_id, medicine_name from medicine;";
		medicines = jdbcTemplate.query(sql, new MedicineRowMapper());
		return medicines;
	}

}
