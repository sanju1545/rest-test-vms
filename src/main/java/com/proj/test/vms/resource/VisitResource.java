package com.proj.test.vms.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/")
public class VisitResource {

	@GET
	@Path("/{visitId}")
	public String getVisit(@PathParam("visitId") String id) {
		return "Test 2";
	}
}
