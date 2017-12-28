package com.pw.requestmed.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pw.requestmed.beans.Employee;
import com.pw.requestmed.beans.RequestMed;
import com.pw.requestmed.dao.EmpDao;
import com.pw.requestmed.dao.RequestMedDao;

@Service("requestMedService")
public class RequestMedServiceImpl implements RequestMedService {

	@Autowired
	private RequestMedDao requestMedDao;
	
	@Autowired
	private EmpDao empDao;
			
	@Override
	public int saveRequest(RequestMed requestMed) {
		int rowsUpdated = requestMedDao.saveRequest(requestMed);
		return rowsUpdated;
	}

	@Override
	public int deleteRequest(RequestMed requestMed) {
		int rowsUpdated = requestMedDao.deleteRequest(requestMed);
		return rowsUpdated;
	}

	@Override
	public List<RequestMed> retrieveRequest(int id) {
		List<RequestMed> requestList = requestMedDao.retrieveRequest(id);
		return requestList;
	}

	@Override
	public int updateRequest(RequestMed requestMed) {
		int rowsUpdated = requestMedDao.updateRequest(requestMed);
		return rowsUpdated;
	}

	@Override
	public void save(Employee emp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employee getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Employee retrieveRequestMedsByEmpId(Employee employee){
		Employee emp = empDao.getRequestsByEmpId(employee);
		return emp;
	}
	

}
