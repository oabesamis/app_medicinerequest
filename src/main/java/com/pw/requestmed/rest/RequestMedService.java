package com.pw.requestmed.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.pw.requestmed.beans.RequestMed;
import com.pw.requestmed.dao.RequestMedDao;


@Path("/requestMed")
public class RequestMedService {
	
	@Autowired
	private RequestMedDao requestMedDao;
	
	@Path("/viewRequestList/{id}")	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response viewRequestList(@PathParam("id") int id) {
		List<RequestMed> requestList = requestMedDao.retrieveRequest(id);
		return Response.status(200).entity(requestList).build();
	}

}
