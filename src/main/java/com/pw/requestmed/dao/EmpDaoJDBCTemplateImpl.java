package com.pw.requestmed.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pw.requestmed.beans.Employee;
import com.pw.requestmed.beans.RequestMed;
import com.pw.requestmed.mapper.EmpRowMapper;
import com.pw.requestmed.mapper.RequestMedRowMapper;

@Repository("empDao")
public class EmpDaoJDBCTemplateImpl implements EmpDao {

	@Autowired
	DataSource dataSource;
	
	@Value("${SELECT_REQUEST_DATA}")
	private StringBuilder RETRIEVE_REQ_MED;

	public void save(Employee emp) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "insert into Emp(id, firstname, lastname) values (?,?,?)";
		Object[] objs = new Object[] { emp.getId(), emp.getFirstName(), emp.getLastName() };
		int output = jdbcTemplate.update(sql, objs);
		if (output != 0) {
			System.out.println("Employee saved with id " + emp.getId());
		} else {
			System.out.println("Employee save failed with id " + emp.getId());
		}
	}

	public Employee getById(int id) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "SELECT emp_id, firstname, lastname, circle_name, e.mc_id mc_id "
				+ "FROM employee e, market_circle mc " + "where e.mc_id = mc.mc_id and emp_id = ?";
		Employee emp = jdbcTemplate.queryForObject(sql, new Object[] { id }, new EmpRowMapper());

		return emp;
	}

	public void update(Employee emp) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "UPDATE Emp SET firstname=?, lastname=? where id=?";
		Object[] objs = new Object[] { emp.getFirstName(), emp.getLastName(), emp.getId() };
		int output = jdbcTemplate.update(sql, objs);
		if (output != 0) {
			System.out.println("Employee updated with id " + emp.getId());
		} else {
			System.out.println("Employee update failed with id " + emp.getId());
		}
	}

	public void deleteById(int id) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "DELETE FROM Emp WHERE emp_id=?";
		int output = jdbcTemplate.update(sql, id);
		if (output != 0) {
			System.out.println("Employee deleted with id " + id);
		} else {
			System.out.println("Employee deletion failed with id " + id);
		}
	}

	public List<Employee> getAll() {
		List<Employee> emps = new ArrayList<Employee>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "SELECT emp_id, firstname, lastname, circle_name, e.mc_id mc_id "
				+ "FROM employee e, market_circle mc " + "where e.mc_id = mc.mc_id";
		emps = jdbcTemplate.query(sql, new EmpRowMapper());
		return emps;
	}

	public Employee getRequestsByEmpId(Employee employee) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		Object[] objs = new Object[] { employee.getId() };
		Employee emp = getById(employee.getId());
		List<RequestMed> reqmed = new ArrayList<RequestMed>();
		reqmed = jdbcTemplate.query(RETRIEVE_REQ_MED.toString(), objs, new RequestMedRowMapper());
		emp.setRequestMeds(reqmed);
		return emp;
	}

}
