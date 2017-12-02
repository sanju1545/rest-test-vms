/**
 * 
 */
package com.proj.test.vms.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author sanjayprasad.burnwal
 *
 */
@Path("/filters")
@Produces(MediaType.TEXT_PLAIN)
public class FilterResource {

	/**
	 * 
	 */
	public FilterResource() {
		// TODO Auto-generated constructor stub
	}

	@GET
	public String getFilter() {
		return "Its working!";
	}
}
