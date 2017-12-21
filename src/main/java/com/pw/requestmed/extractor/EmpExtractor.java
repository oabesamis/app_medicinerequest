package com.pw.requestmed.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.pw.requestmed.beans.Employee;

public class EmpExtractor implements ResultSetExtractor<Employee>{

	public Employee extractData(ResultSet resultSet) throws SQLException, DataAccessException {
		Employee emp = new Employee();
		int id = resultSet.getInt("emp_id");
		String firstName = resultSet.getString("firstname");
		String lastName = resultSet.getString("lastname");
		int mc_id = resultSet.getInt("mc_id");
		String circleName = resultSet.getString("circle_name");
		
		emp.setId(id);
		emp.setFirstName(firstName);
		emp.setLastName(lastName);
		emp.setMarketCircleId(mc_id);
		emp.setCircleName(circleName);
		
		return emp;
	}

}
