/**
 * 
 */
package com.proj.test.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.proj.test.vms.model.Owner;

/**
 * @author sanjayprasad.burnwal
 *
 */
public class RestApiClient {

	/**
	 * 
	 */
	public RestApiClient() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		//GET Request with WebTarget, Builder & Response
		WebTarget webTarget =client.target("http://localhost:8080/vms/webapi/owners/1");
		Builder builder = webTarget.request();
		Response response = builder.get();
		/*Response response = client.target("http://localhost:8080/vms/webapi/owners/1").request().get();*/ //Inline statement
		Owner owner = response.readEntity(Owner.class);
		System.out.println(owner.getFirstName()+" "+owner.getLastName());
		
		//GET Request with MediaType as JSON and GET response as Owner class
		Owner owner2 = client
				.target("http://localhost:8080/vms/webapi/owners/2")
				.request(MediaType.APPLICATION_JSON)
				.get(Owner.class);
		System.out.println(owner2.getFirstName()+" "+owner2.getLastName());
		
		//GET Request with MediaType as JSON and GET response as String class
		String owner3 = client
				.target("http://localhost:8080/vms/webapi/owners/1")
				.request(MediaType.APPLICATION_JSON)
				.get(String.class);
		System.out.println(owner3);
		
		//GET Request with MediaType as JSON with handy URL passing
		WebTarget baseTarget =client.target("http://localhost:8080/vms/webapi/");
		WebTarget ownerTarget = baseTarget.path("owners");
		WebTarget singleOwnerTarget = ownerTarget.path("{ownerId}");
		String owner4 = singleOwnerTarget
				.resolveTemplate("ownerId", "2")
				.request(MediaType.APPLICATION_JSON)
				.get(String.class);
		System.out.println(owner4);
		
		//POST Request
		Owner owner5 = new Owner("Shankar", "Gupta", "G-72", 'F');
		Response response2 = ownerTarget.request().post(Entity.json(owner5));
		Owner newOwner = response2.readEntity(Owner.class);
		System.out.println(newOwner.getFirstName()+" "+newOwner.getLastName());
	}

}
