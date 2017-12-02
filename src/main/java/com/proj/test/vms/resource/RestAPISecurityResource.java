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
@Path("/secured")
public class RestAPISecurityResource {

	/**
	 * 
	 */
	public RestAPISecurityResource() {
		// TODO Auto-generated constructor stub
	}
	
	@GET
	@Path("/message")
	@Produces(MediaType.TEXT_PLAIN)
	public String getSecureMessage() {
		return "This API is secured.";
	}

}
