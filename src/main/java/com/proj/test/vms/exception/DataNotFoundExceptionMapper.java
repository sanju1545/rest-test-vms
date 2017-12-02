package com.proj.test.vms.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.proj.test.vms.model.ErrorMessage;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>{

	@Override
	public Response toResponse(DataNotFoundException exp) {
		ErrorMessage errorMessage = new ErrorMessage(404, exp.getMessage(), "http://www.youtube.com");
		return Response.status(Status.NOT_FOUND).entity(errorMessage).build();
	}

}
