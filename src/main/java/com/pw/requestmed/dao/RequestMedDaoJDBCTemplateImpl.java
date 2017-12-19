package com.pw.requestmed.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pw.requestmed.beans.RequestMed;
import com.pw.requestmed.mapper.RequestMedRowMapper;

@Repository("requestMedDao")
public class RequestMedDaoJDBCTemplateImpl implements RequestMedDao {
	

	@Autowired
	DataSource dataSource;

	@Override
	public void saveRequest(RequestMed requestMed) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRequest(RequestMed requestMed) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<RequestMed> retrieveRequest(int id) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		StringBuilder sql = new StringBuilder("select employee.emp_id, employee.firstname, employee.lastname, employee.mc_id, ");
		sql.append("medicine.medicine_id, medicine.medicine_name, symptoms.symptoms_id, symptoms.symptoms_name, medrequest.request_id, medrequest.create_date, medrequest.update_date ");
		sql.append("from epharma.employee employee, ");
		sql.append("epharma.med_request medrequest, "); 
		sql.append(" epharma.medicine medicine, ");
		sql.append("epharma.symptoms symptoms ");
		sql.append("where employee.emp_id = medrequest.emp_id and ");
		sql.append("medicine.medicine_id = medrequest.med_id and ");
		sql.append("symptoms.symptoms_id = medrequest.symptoms_id and "); 
		sql.append("medrequest.emp_id = ? ");
		
		Object [] objs = new Object[]{id};
		
		List<RequestMed> reqmed = new ArrayList<RequestMed>();
		reqmed = jdbcTemplate.query(sql.toString(), objs, new RequestMedRowMapper());
		
		return reqmed;
	}

	@Override
	public void updateRequest(RequestMed requestMed) {
		// TODO Auto-generated method stub
		
	}

}
