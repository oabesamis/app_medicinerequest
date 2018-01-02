package com.pw.requestmed.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pw.requestmed.beans.Symptom;
import com.pw.requestmed.mapper.SymptomRowMapper;

@Repository("symptomDao")
public class SymptomDaoJDBCTemplateImpl implements SymptomDao{

	@Autowired
	DataSource dataSource;
	
	@Override
	public List<Symptom> getAllSymptoms() {
		List<Symptom> symptoms = new ArrayList<Symptom>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "SELECT symptoms_id, symptoms_name from symptoms;";
		symptoms = jdbcTemplate.query(sql, new SymptomRowMapper());
		return symptoms;
	}

}
