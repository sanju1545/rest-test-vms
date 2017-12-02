package com.proj.test.vms.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.proj.test.vms.model.Visitor;
import com.proj.test.vms.services.VisitorService;

@Path("/visitors")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class VisitorResource {
	
	VisitorService  vstrService = new VisitorService();

	@GET
	public List<Visitor> getVisitors() {
		return vstrService.getAllVisitor();
	}
	
	@GET
	@Path("/{visitorId}")
	public Visitor getVisitor(@PathParam("visitorId") String vistId) {
		return vstrService.getVisitor(vistId);
	}
	
	@POST
	public Visitor addVisitor(Visitor vstr) {
		return vstrService.addVisitor(vstr);
	}
	
	@PUT
	@Path("/{visitorId}")
	public Visitor updateVisitor(@PathParam("visitorId") String vistId, Visitor vstr) {
		vstr.setVisitorId(vistId);
		return vstrService.updateVisitor(vstr);
	}
	
	@DELETE
	@Path("/{visitorId}")
	public void deleteVisitor(@PathParam("visitorId") String vistId) {
		vstrService.deleteVisitor(vistId);
	}
	
	@Path("/{visitorId}/visits")
	public VisitResource getVisitResource() {
		return new VisitResource();
	} 
}
