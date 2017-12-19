package com.pw.requestmed.dao;

import java.util.List;

import com.pw.requestmed.beans.RequestMed;

public interface RequestMedDao {
	
	public void saveRequest(RequestMed requestMed);
	public void deleteRequest(RequestMed requestMed);
	public List<RequestMed> retrieveRequest(int id);
	public void updateRequest(RequestMed requestMed);
	
}
