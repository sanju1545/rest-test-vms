/**
 * 
 */
package com.proj.test.vms.resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import com.proj.test.vms.model.Owner;
import com.proj.test.vms.resource.filter.OwnerFilterBean;
import com.proj.test.vms.services.OwnerService;

/**
 *
 */
@Path("/owners")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(value= {MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
public class OwnerResource {

	private OwnerService ownerService = new OwnerService();

	@GET
	public List<Owner> getAllOwners(@QueryParam("flatNo") String flatNo, @QueryParam("start") int start,
			@QueryParam("size") int size, @MatrixParam("block") char block, @HeaderParam("customHeader") String str) {
		if(flatNo!=null) {
			return ownerService.getOwnerByFlatNo(flatNo);
		}
		if(start >=0 && size >0) {
			return ownerService.getOwnerBySize(start, size);
		}
		if(block!=0) {
			return ownerService.getOwnerByBlock(block);
		}
		return new ArrayList<>(ownerService.getAllOwner());
	}
	
	@GET
	@Path("/{ownerId}")
	public Owner getOwner(@PathParam("ownerId") String id, @Context UriInfo uriInfo) {
		Owner owner = ownerService.getOwner(id);
		owner.addLink(getURI(id, uriInfo, owner), "self");
		return owner;
	}

	/**
	 * @param id
	 * @param uriInfo
	 * @param owner
	 * @return
	 */
	private String getURI(String id, UriInfo uriInfo, Owner owner) {
		String uri = uriInfo.getAbsolutePathBuilder()
					.path(OwnerResource.class)
					.path(id)
					.build(owner)
					.toString();
		return uri;
	}
	
	@POST
	public Owner addOwner(Owner owner) {
		return ownerService.addOwner(owner);
	}
	
	@PUT
	@Path("/{ownerId}")
	public Owner updateOwner(@PathParam("ownerId") String id, Owner owner) {
		owner.setOwnerId(id);
		return ownerService.updateOwner(owner);
	}
	
	@DELETE
	@Path("/{ownerId}")
	public void daleteOwner(@PathParam("ownerId") String id) {
		ownerService.deleteOwner(id);
	}
	
	@GET
	@Path("/header")
	@Produces(MediaType.TEXT_PLAIN)
	public String getHeaderAndCookies(@HeaderParam("customHeader") String header, @CookieParam("cookie") String cookie) {
		if(header!=null) {
			return "Custom Header: "+header;
		}
		if(cookie!=null) {
			return "Cookie Value: "+cookie;
		}
		return null;
	}
	
	@GET
	@Path("/context")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public String getContextParamAndHeader(@Context UriInfo info, @Context HttpHeaders headers) {
		String absolutePath = info.getAbsolutePath().toString();
		String path = info.getPath();
		String cookie = headers.getCookies().toString();
		return "Absolute Path: "+absolutePath+" and Path: "+path+" Cookie: "+cookie;
	}
	
	@GET
	@Path("/beanfilter")
	public List<Owner> getAllOwnersUsingBeanParam(@BeanParam OwnerFilterBean ownerFilterBean) {
		if(ownerFilterBean.getFlatNo()!=null) {
			return ownerService.getOwnerByFlatNo(ownerFilterBean.getFlatNo());
		}
		if(ownerFilterBean.getStart() >=0 && ownerFilterBean.getSize() >0) {
			return ownerService.getOwnerBySize(ownerFilterBean.getStart(), ownerFilterBean.getSize());
		}
		if(ownerFilterBean.getBlock()!=0) {
			return ownerService.getOwnerByBlock(ownerFilterBean.getBlock());
		}
		return new ArrayList<>(ownerService.getAllOwner());
	}
	@POST
	@Path("/response")
	public Response getOwnerResponse(Owner owner) throws URISyntaxException {
		Owner newOwner = ownerService.addOwner(owner);
		return Response.created(new URI("/vms/webapi/owners/"+newOwner.getOwnerId()))
				.entity(newOwner)
				.build();
	}
	
	@POST
	@Path("/response1")
	public Response getOwnerResponseURI(Owner owner, @Context UriInfo uriInfo) throws URISyntaxException {
		Owner newOwner = ownerService.addOwner(owner);
		URI info = uriInfo.getAbsolutePathBuilder().path(newOwner.getOwnerId()).build();
		return Response.created(info)
				.entity(newOwner)
				.build();
	}
	
	@POST
	@Path("/response2")
	public Response getOwnerResponseStatus(Owner owner) throws URISyntaxException {
		Owner newOwner = ownerService.addOwner(owner);
		return Response.status(Status.CREATED)
				.entity(newOwner)
				.build();
	}
	
	@Path("/{ownerId}/visits")
	public VisitorResource getOwnersVisitors() {
		return new VisitorResource();
	}
}
