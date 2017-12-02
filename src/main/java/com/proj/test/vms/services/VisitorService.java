/**
 * 
 */
package com.proj.test.vms.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.proj.test.vms.database.DatabaseClass;
import com.proj.test.vms.model.ErrorMessage;
import com.proj.test.vms.model.Visitor;

/**
 *
 */
public class VisitorService {
	
	private Map<String, Visitor> visitors = DatabaseClass.getVisitors();
	
	public VisitorService() {
		visitors.put("1", new Visitor("1", "Ajay", "Modi", new Date()));
		visitors.put("2", new Visitor("2", "Vijay", "Singh", new Date()));
	}

	public List<Visitor> getAllVisitor() {
		return new ArrayList<Visitor>(visitors.values());
	}
	
	public Visitor getVisitor(String id) {
		ErrorMessage errorMessage = new ErrorMessage(404, "not found.", "http://www.youtube.com");
		Response response = Response.status(Status.NOT_FOUND).entity(errorMessage).build();
		if(visitors.get(id)==null) {
			throw new WebApplicationException(response);
		}
		return visitors.get(id);
	}
	
	public Visitor addVisitor(Visitor vstr) {
		vstr.setVisitorId(String.valueOf(visitors.size()+1));
		visitors.put(vstr.getVisitorId(), vstr);
		return vstr;
	}
	
	public Visitor updateVisitor(Visitor vstr) {
		if(vstr.getVisitorId()==null) {
			return null;
		}
		visitors.put(vstr.getVisitorId(), vstr);
		return vstr;
	}
	
	public void deleteVisitor(String id) {
		visitors.remove(id);
	}
}
