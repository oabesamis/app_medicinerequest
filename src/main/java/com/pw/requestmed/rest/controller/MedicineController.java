package com.pw.requestmed.rest.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.pw.requestmed.beans.Medicine;
import com.pw.requestmed.service.RequestMedService;

@Path("/med")
public class MedicineController {
	
	@Autowired
	private RequestMedService requestMedService;
	
	@Path("/getAll")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		List<Medicine> medicines = requestMedService.getAllMedicines();
		return Response.ok().entity(new GenericEntity<List<Medicine>>(medicines) {})
	            .header("Access-Control-Allow-Origin", "*")
	            .header("Content-Type", "application/json")
	            .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS, HEAD")
	            .build();				
	}

}
