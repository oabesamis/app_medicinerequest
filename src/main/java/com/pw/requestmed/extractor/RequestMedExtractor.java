package com.pw.requestmed.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.pw.requestmed.beans.Employee;
import com.pw.requestmed.beans.Medicine;
import com.pw.requestmed.beans.RequestMed;
import com.pw.requestmed.beans.Symptom;

public class RequestMedExtractor implements ResultSetExtractor<RequestMed>{
	
	public RequestMed extractData(ResultSet rs) throws SQLException, DataAccessException {
		RequestMed requestMed =  new RequestMed();
		
		Employee employee = new Employee();	
		employee.setId(rs.getInt("emp_id"));
		employee.setFirstName(rs.getString("firstname"));
		employee.setLastName(rs.getString("lastname"));
		employee.setMarketCircleId(rs.getInt("mc_id"));
		requestMed.setEmployee(employee);
		
		Medicine medicine = new Medicine();
		medicine.setMedicineName(rs.getString("medicine_name"));
		requestMed.setMedicine(medicine);
		
		Symptom symptom = new Symptom();
		symptom.setSymptomName(rs.getString("symptoms_name"));		
		requestMed.setSymptom(symptom);
		
		requestMed.setCreateTs(rs.getTimestamp("create_date"));
		requestMed.setLastUpdateTs(rs.getTimestamp("update_date"));
		
		return requestMed;
	}
	

}
