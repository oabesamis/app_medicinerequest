package com.pw.requestmed.service;

import java.util.List;

import com.pw.requestmed.beans.Employee;
import com.pw.requestmed.beans.RequestMed;

public interface RequestMedService {

	//RequestMed
	public int saveRequest(RequestMed requestMed);
	public int deleteRequest(RequestMed requestMed);
	public List<RequestMed> retrieveRequest(int id);
	public int updateRequest(RequestMed requestMed);
	public Employee retrieveRequestMedsByEmpId(Employee employee);
	
	//Employee
	public void save(Employee emp);
	public Employee getById(int id);
	public void update(Employee employee);
	public void deleteById(int id);
	public List<Employee> getAll();
}
