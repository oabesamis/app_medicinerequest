package com.pw.requestmed.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.pw.requestmed.beans.Employee;

public class EmpExtractor implements ResultSetExtractor<Employee>{

	public Employee extractData(ResultSet resultSet) throws SQLException, DataAccessException {
		Employee emp = new Employee();
		int id = resultSet.getInt("id");
		String firstName = resultSet.getString("first_Name");
		String lastName = resultSet.getString("last_Name");
		
		emp.setId(id);
		emp.setFirstName(firstName);
		emp.setLastName(lastName);
		
		return emp;
	}

}
