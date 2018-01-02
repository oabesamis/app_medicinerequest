package com.pw.requestmed.dao;

import java.util.List;

import com.pw.requestmed.beans.Employee;

public interface EmpDao {
	//Create
	public void save(Employee emp);
	//Read
	public Employee getById(int id);
	//Update
	public void update(Employee employee);
	//Delete
	public void deleteById(int id);
	//Get All
	public List<Employee> getAll();
	
	public Employee getRequestsByEmpId(Employee employee);
}
