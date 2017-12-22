package com.pw.requestmed.rest.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.pw.requestmed.beans.RequestMed;
import com.pw.requestmed.service.RequestMedService;


@Path("/requestMed")
public class RequestMedController {
	
	@Autowired
	private RequestMedService requestMedService;
	
	private final Logger logger = LogManager.getLogger(RequestMedController.class);
	
	@Path("/viewRequestList/{id}")	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response viewRequestList(@PathParam("id") int id) {
		logger.info("-- START RequestMedController.viewRequestList --");
		logger.info("ID --> " + id);
		List<RequestMed> requestList = requestMedService.retrieveRequest(id);
		logger.info("Size --> " + requestList.size());
		logger.info("-- END RequestMedController.viewRequestList --");
		return Response.status(200).entity(requestList).build();
	}
	
	@Path("/deleteRequest/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteById(@PathParam("id") int id) {
		logger.info("-- START RequestMedController.deleteById --");
		logger.info("ID --> " + id);
		RequestMed requestMed = new RequestMed();
		requestMed.setRequestId(id);
		int rowsUpdated = requestMedService.deleteRequest(requestMed);
		logger.info("Rows Updated --> " + rowsUpdated);
		logger.info("-- END RequestMedController.deleteById --");
		return Response.status(200).entity(rowsUpdated).build();
	}
	
	@Path("/updateRequest")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(RequestMed requestMed) {
		logger.info("-- START RequestMedController.update --");
		int rowsUpdated = requestMedService.updateRequest(requestMed);
		logger.info("Rows Updated --> " + rowsUpdated);
		logger.info("-- END RequestMedController.update --");
		return Response.status(200).entity(rowsUpdated).build();
	}
	
	@Path("/saveRequest")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response save(RequestMed requestMed) {
		logger.info("-- START RequestMedController.update --");
		int rowsUpdated = requestMedService.saveRequest(requestMed);
		logger.info("Rows Updated --> " + rowsUpdated);
		logger.info("-- END RequestMedController.save --");
		return Response.status(200).entity(rowsUpdated).build();
	}

}
