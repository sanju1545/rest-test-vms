package com.proj.test.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.proj.test.vms.model.Owner;

public class InvocationDemo {

	public InvocationDemo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		InvocationDemo demo = new InvocationDemo();
		Invocation invocation =demo.getOwnerBasedOnFlatNo("G-28");
		Response res =  invocation.invoke();
		System.out.println(res.getStatus());
		/*Owner owner = res.readEntity(Owner.class);
		System.out.println(owner.getFirstName());*/
	}

	public Invocation getOwnerBasedOnFlatNo(String flatNo) {
		Client client = ClientBuilder.newClient();
		WebTarget baseTarget =client.target("http://localhost:8080/vms/webapi/");
		WebTarget ownerTarget = baseTarget.path("owners");
		return ownerTarget
				.queryParam("flatNo", flatNo)
				.request(MediaType.APPLICATION_JSON)
				.buildGet();
	}

}
