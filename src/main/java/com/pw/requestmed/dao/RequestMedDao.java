package com.pw.requestmed.dao;

import java.util.List;

import com.pw.requestmed.beans.RequestMed;

public interface RequestMedDao {
	
	public int saveRequest(RequestMed requestMed);
	public int deleteRequest(RequestMed requestMed);
	public List<RequestMed> retrieveRequest(int id);
	public int updateRequest(RequestMed requestMed);
	
}
