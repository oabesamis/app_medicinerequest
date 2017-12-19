package com.pw.requestmed.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pw.requestmed.beans.Employee;
import com.pw.requestmed.mapper.EmpRowMapper;

@Repository("empDao")
public class EmpDaoJDBCTemplateImpl implements EmpDao {
	
	@Autowired
	DataSource dataSource;
	
	public void save(Employee emp) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "insert into Emp(id, firstname, lastname) values (?,?,?)";
		Object [] objs = new Object[]{emp.getId(), emp.getFirstName(), emp.getLastName()};
		int output = jdbcTemplate.update(sql, objs);
		if(output != 0) {
			System.out.println("Employee saved with id "+emp.getId());
		}else {
			System.out.println("Employee save failed with id "+emp.getId());
		}
	}

	public Employee getById(int id) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select * from emp where id = ?";
		Employee emp = jdbcTemplate.queryForObject(sql, new Object[]{id}, new EmpRowMapper());
		
		return emp;
	}

	public void update(Employee emp) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "UPDATE Emp SET firstname=?, lastname=? where id=?";
		Object [] objs = new Object[]{emp.getFirstName(), emp.getLastName(), emp.getId()};
		int output = jdbcTemplate.update(sql, objs);
		if(output != 0) {
			System.out.println("Employee updated with id "+emp.getId());
		}else {
			System.out.println("Employee update failed with id "+emp.getId());
		}
	}

	public void deleteById(int id) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "DELETE FROM Emp WHERE id=?";
		int output = jdbcTemplate.update(sql, id);
		if(output != 0) {
			System.out.println("Employee deleted with id "+id);
		}else {
			System.out.println("Employee deletion failed with id "+id);
		}
	}

	public List<Employee> getAll() {
		List<Employee> emps = new ArrayList<Employee>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select * from employee";
		emps = jdbcTemplate.query(sql, new EmpRowMapper());
		return emps;
	}

}
