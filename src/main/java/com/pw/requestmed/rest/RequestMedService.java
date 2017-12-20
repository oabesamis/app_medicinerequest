package com.pw.requestmed.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
	
	@Path("/deleteRequest/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteById(@PathParam("id") int id) {
		RequestMed requestMed = new RequestMed();
		requestMed.setRequestId(id);
		requestMedDao.deleteRequest(requestMed);
		return Response.status(200).build();
	}
	
	@Path("/updateRequest")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(RequestMed requestMed) {
		requestMedDao.updateRequest(requestMed);
		return Response.status(200).build();
	}
	
	@Path("/saveRequest")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response save(RequestMed requestMed) {
		requestMedDao.saveRequest(requestMed);
		return Response.status(200).build();
	}

}
