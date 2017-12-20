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
	
	@Value("${UPDATE_MEDICINE_REQUEST}")
	private StringBuilder UPDATE_MEDICINE_REQUEST;
	
	@Autowired
	DataSource dataSource;

	@Override
	public void saveRequest(RequestMed requestMed) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRequest(RequestMed requestMed) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "DELETE FROM epharma.med_request WHERE request_id=?";
		int output = jdbcTemplate.update(sql, requestMed.getRequestId());
		if(output != 0) {
			System.out.println("Employee deleted with id "+requestMed.getRequestId());
		}else {
			System.out.println("Employee deletion failed with id "+requestMed.getRequestId());
		}
		
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
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		Object [] objs = new Object[]{requestMed.getEmployee().getId(), requestMed.getMedicine().getMedicineId(), 
				requestMed.getEmployee().getId(), 
				requestMed.getStatus(), requestMed.getRequestId()};
		int output = jdbcTemplate.update(UPDATE_MEDICINE_REQUEST.toString(), objs);
		if(output != 0) {
			System.out.println("request updated with id "+requestMed.getRequestId());
		}else {
			System.out.println("request update failed with id "+requestMed.getRequestId());
		}
		
	}

}
