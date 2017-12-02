package com.proj.test.vms.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import com.proj.test.vms.model.ErrorMessage;

public class GenericExceptionMapper implements ExceptionMapper<Throwable>{

	@Override
	public Response toResponse(Throwable exp) {
		ErrorMessage errorMessage = new ErrorMessage(500, exp.getMessage(), "http://www.youtube.com");
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(errorMessage).build();
	}
}
