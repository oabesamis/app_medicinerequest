package com.pw.requestmed.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pw.requestmed.beans.RequestMed;
import com.pw.requestmed.mapper.RequestMedRowMapper;

@Repository("requestMedDao")
public class RequestMedDaoJDBCTemplateImpl implements RequestMedDao {
	
	@Value("${SELECT_REQUEST_DATA}")
	private StringBuilder RETRIEVE_REQ_MED;

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
		
		Object [] objs = new Object[]{id};
		
		List<RequestMed> reqmed = new ArrayList<RequestMed>();
		reqmed = jdbcTemplate.query(RETRIEVE_REQ_MED.toString(), objs, new RequestMedRowMapper());
		
		return reqmed;
	}

	@Override
	public void updateRequest(RequestMed requestMed) {
		// TODO Auto-generated method stub
		
	}

}
