package com.proj.test.vms.resource.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
@Provider
public class LogingFilter implements ContainerRequestFilter, ContainerResponseFilter{

	public LogingFilter() {
	}
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		System.out.println("Request Filter");
		System.out.println(requestContext.getHeaders());
	}
	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {
		System.out.println("Response Filter");
		System.out.println(responseContext.getHeaders());
	}

}
