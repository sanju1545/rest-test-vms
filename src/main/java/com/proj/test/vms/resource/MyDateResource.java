/**
 * 
 */
package com.proj.test.vms.resource;

import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author sanjayprasad.burnwal
 *
 */
@Path("/date/{mydate}")
public class MyDateResource {

	/**
	 * 
	 */
	public MyDateResource() {
		// TODO Auto-generated constructor stub
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getDate(@PathParam("mydate") MyDate mydate) {
		return "My Date is "+mydate.toString();
	}
	
	@GET
	@Path("/dateInstance")
	@Produces("text/shortdate") //Custom Media Type
	public Date getMyDate() {
		return Calendar.getInstance().getTime();
	}
}
