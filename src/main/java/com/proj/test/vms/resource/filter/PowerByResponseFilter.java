package com.proj.test.vms.resource.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
@Provider
public class PowerByResponseFilter implements ContainerResponseFilter {

	public PowerByResponseFilter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {
		responseContext.getHeaders().add("PowredBy", "PSR Aster");
	}

}
