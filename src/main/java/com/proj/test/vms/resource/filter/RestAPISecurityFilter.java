/**
 * 
 */
package com.proj.test.vms.resource.filter;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.internal.util.Base64;

/**
 * @author sanjayprasad.burnwal
 *
 */
@Provider
public class RestAPISecurityFilter implements ContainerRequestFilter{

	private static String SECURED_URI_PREFIX = "secured";
	private static String AUTHORIZATION_HEADER_KEY = "Authorization";
	private static String AUTH_TOKEN_PREFIX = "Basic ";
	/**
	 * 
	 */
	public RestAPISecurityFilter() {
		// TODO Auto-generated constructor stub
	}

	public void filter(ContainerRequestContext requestContext) throws IOException {
		if(requestContext.getUriInfo().getPath().contains(SECURED_URI_PREFIX)) {
			List<String> authHeader = requestContext.getHeaders().get(AUTHORIZATION_HEADER_KEY);
			if(authHeader != null && !authHeader.isEmpty()) {
				String authToken = authHeader.get(0);
				authToken = authToken.replaceFirst(AUTH_TOKEN_PREFIX, "");
				String decodeString = Base64.decodeAsString(authToken);
				StringTokenizer stringToken = new StringTokenizer(decodeString, ":");
				String userName = stringToken.nextToken();
				String password = stringToken.nextToken();
				if(userName.equals("user") && password.equals("password")) {
					return;
				}
			}
			Response unauthorizeResp = Response
					.status(Response.Status.UNAUTHORIZED)
					.entity("User is not authorized to access API.")
					.build();
			requestContext.abortWith(unauthorizeResp);
		}
		
	}

}
